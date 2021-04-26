package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7488a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7489b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7490c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7491d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7492e = 1000;

    public int getLatestAdmin() {
        return this.f7491d;
    }

    public LatLng getLocation() {
        return this.f7490c;
    }

    public int getPageNum() {
        return this.f7489b;
    }

    public int getPageSize() {
        return this.f7488a;
    }

    public int getRadius() {
        return this.f7492e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7490c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        this.f7491d = i2;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f7489b = i2;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i2) {
        if (i2 <= 0) {
            i2 = 10;
        } else if (i2 > 100) {
            this.f7488a = 100;
            return this;
        }
        this.f7488a = i2;
        return this;
    }

    public ReverseGeoCodeOption radius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 1000) {
            this.f7492e = 1000;
            return this;
        }
        this.f7492e = i2;
        return this;
    }
}
