package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class ReverseGeoCodeOption {

    /* renamed from: a  reason: collision with root package name */
    public int f7196a = 10;

    /* renamed from: b  reason: collision with root package name */
    public int f7197b = 0;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7198c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7199d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7200e = 1000;

    public int getLatestAdmin() {
        return this.f7199d;
    }

    public LatLng getLocation() {
        return this.f7198c;
    }

    public int getPageNum() {
        return this.f7197b;
    }

    public int getPageSize() {
        return this.f7196a;
    }

    public int getRadius() {
        return this.f7200e;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.f7198c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.f7199d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f7197b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            i = 10;
        } else if (i > 100) {
            this.f7196a = 100;
            return this;
        }
        this.f7196a = i;
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 1000) {
            this.f7200e = 1000;
            return this;
        }
        this.f7200e = i;
        return this;
    }
}
