package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7232a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7233b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7234c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7235d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7236e = 1000;

    public int getLatestAdmin() {
        return this.f7235d;
    }

    public LatLng getLocation() {
        return this.f7234c;
    }

    public int getPageNum() {
        return this.f7233b;
    }

    public int getPageSize() {
        return this.f7232a;
    }

    public int getRadius() {
        return this.f7236e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7234c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.f7235d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f7233b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            i = 10;
        } else if (i > 100) {
            this.f7232a = 100;
            return this;
        }
        this.f7232a = i;
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 1000) {
            this.f7236e = 1000;
            return this;
        }
        this.f7236e = i;
        return this;
    }
}
