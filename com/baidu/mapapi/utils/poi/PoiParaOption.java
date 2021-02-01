package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    String f2966a;

    /* renamed from: b  reason: collision with root package name */
    String f2967b;
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
        return this.f2967b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.f2966a;
    }

    public PoiParaOption key(String str) {
        this.f2967b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f2966a = str;
        return this;
    }
}
