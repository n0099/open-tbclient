package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;
@JSONType(seeAlso = {GeometryCollection.class, LineString.class, MultiLineString.class, Point.class, MultiPoint.class, Polygon.class, MultiPolygon.class, Feature.class, FeatureCollection.class}, typeKey = "type")
/* loaded from: classes.dex */
public abstract class Geometry {
    public double[] bbox;
    public final String type;

    public Geometry(String str) {
        this.type = str;
    }

    public double[] getBbox() {
        return this.bbox;
    }

    public String getType() {
        return this.type;
    }

    public void setBbox(double[] dArr) {
        this.bbox = dArr;
    }
}
