package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7305a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7306b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7307c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7308d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7309e = 1000;

    public int getLatestAdmin() {
        return this.f7308d;
    }

    public LatLng getLocation() {
        return this.f7307c;
    }

    public int getPageNum() {
        return this.f7306b;
    }

    public int getPageSize() {
        return this.f7305a;
    }

    public int getRadius() {
        return this.f7309e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7307c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i2) {
        this.f7308d = i2;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f7306b = i2;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i2) {
        if (i2 <= 0) {
            i2 = 10;
        } else if (i2 > 100) {
            this.f7305a = 100;
            return this;
        }
        this.f7305a = i2;
        return this;
    }

    public ReverseGeoCodeOption radius(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 1000) {
            this.f7309e = 1000;
            return this;
        }
        this.f7309e = i2;
        return this;
    }
}
