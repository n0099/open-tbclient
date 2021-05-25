package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7205a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7206b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7207c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7208d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7209e = 1000;

    public int getLatestAdmin() {
        return this.f7208d;
    }

    public LatLng getLocation() {
        return this.f7207c;
    }

    public int getPageNum() {
        return this.f7206b;
    }

    public int getPageSize() {
        return this.f7205a;
    }

    public int getRadius() {
        return this.f7209e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7207c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        this.f7208d = i2;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f7206b = i2;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i2) {
        if (i2 <= 0) {
            i2 = 10;
        } else if (i2 > 100) {
            this.f7205a = 100;
            return this;
        }
        this.f7205a = i2;
        return this;
    }

    public ReverseGeoCodeOption radius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 1000) {
            this.f7209e = 1000;
            return this;
        }
        this.f7209e = i2;
        return this;
    }
}
