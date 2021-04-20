package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
import java.util.LinkedHashMap;
import java.util.Map;
@JSONType(orders = {"type", "id", "bbox", "coordinates", "properties"}, typeName = "Feature")
/* loaded from: classes.dex */
public class Feature extends Geometry {
    public Geometry geometry;
    public String id;
    public Map<String, String> properties;

    public Feature() {
        super("Feature");
        this.properties = new LinkedHashMap();
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }
}
