package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes20.dex */
public class ReverseGeoCodeOption {
    private int a = 10;
    private int b = 0;
    private LatLng c = null;
    private int d = 1;
    private int e = 1000;

    public int getLatestAdmin() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public int getPageNum() {
        return this.b;
    }

    public int getPageSize() {
        return this.a;
    }

    public int getRadius() {
        return this.e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            this.a = 10;
        } else if (i > 100) {
            this.a = 100;
        } else {
            this.a = i;
        }
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            this.e = 0;
        } else if (i > 1000) {
            this.e = 1000;
        } else {
            this.e = i;
        }
        return this;
    }
}
