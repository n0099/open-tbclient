package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    String f3072a;

    /* renamed from: b  reason: collision with root package name */
    String f3073b;
    LatLng c;
    int d;

    public PoiParaOption center(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.c;
    }

    public String getKey() {
        return this.f3073b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.f3072a;
    }

    public PoiParaOption key(String str) {
        this.f3073b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f3072a = str;
        return this;
    }
}
