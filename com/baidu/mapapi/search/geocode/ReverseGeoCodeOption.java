package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    private int f2868a = 10;

    /* renamed from: b  reason: collision with root package name */
    private int f2869b = 0;
    private LatLng c = null;
    private int d = 0;
    private int e = 1000;

    public int getLatestAdmin() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public int getPageNum() {
        return this.f2869b;
    }

    public int getPageSize() {
        return this.f2868a;
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
        this.f2869b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            this.f2868a = 10;
        } else if (i > 100) {
            this.f2868a = 100;
        } else {
            this.f2868a = i;
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
