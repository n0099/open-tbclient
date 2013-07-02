package com.baidu.mapapi;
/* loaded from: classes.dex */
public class Bounds {
    public GeoPoint leftBottom;
    public GeoPoint rightTop;

    public Bounds(int i, int i2, int i3, int i4) {
        this.leftBottom = new GeoPoint(i, i2);
        this.rightTop = new GeoPoint(i3, i4);
    }
}
