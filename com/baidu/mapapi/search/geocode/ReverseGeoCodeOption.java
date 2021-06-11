package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7248a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7249b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7250c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7251d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7252e = 1000;

    public int getLatestAdmin() {
        return this.f7251d;
    }

    public LatLng getLocation() {
        return this.f7250c;
    }

    public int getPageNum() {
        return this.f7249b;
    }

    public int getPageSize() {
        return this.f7248a;
    }

    public int getRadius() {
        return this.f7252e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7250c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        this.f7251d = i2;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f7249b = i2;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i2) {
        if (i2 <= 0) {
            i2 = 10;
        } else if (i2 > 100) {
            this.f7248a = 100;
            return this;
        }
        this.f7248a = i2;
        return this;
    }

    public ReverseGeoCodeOption radius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 1000) {
            this.f7252e = 1000;
            return this;
        }
        this.f7252e = i2;
        return this;
    }
}
