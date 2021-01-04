package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    String f3071a;

    /* renamed from: b  reason: collision with root package name */
    String f3072b;
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
        return this.f3072b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.f3071a;
    }

    public PoiParaOption key(String str) {
        this.f3072b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f3071a = str;
        return this;
    }
}
