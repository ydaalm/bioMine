/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engine.biomine;

import com.engine.biomine.common.Configs;
import com.engine.biomine.swagger.ServletFilter;
import com.engine.biomine.swagger.SwaggerConfig;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author ludovic
 */

@EnableAutoConfiguration(exclude = {SolrAutoConfiguration.class})
@ComponentScan(basePackageClasses = BiomineController.class)
public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
            	//load properties
        Configs config = new Configs();

        ArrayList<Object> sources = new ArrayList<>();

        sources.add(Application.class);
        sources.add(SwaggerConfig.class);
        sources.add(ServletFilter.class);

        SpringApplication.run(sources.toArray(new Object[0]), args);
    }

}
