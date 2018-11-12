package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class ReverseGeoCodeOption {
    private int a = 10;
    private int b = 0;
    private LatLng c = null;
    private int d = 0;

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

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        this.b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        this.a = i;
        return this;
    }
}
