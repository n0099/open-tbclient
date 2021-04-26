package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7707a;

    /* renamed from: b  reason: collision with root package name */
    public String f7708b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7709c;

    /* renamed from: d  reason: collision with root package name */
    public int f7710d;

    public PoiParaOption center(LatLng latLng) {
        this.f7709c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7709c;
    }

    public String getKey() {
        return this.f7708b;
    }

    public int getRadius() {
        return this.f7710d;
    }

    public String getUid() {
        return this.f7707a;
    }

    public PoiParaOption key(String str) {
        this.f7708b = str;
        return this;
    }

    public PoiParaOption radius(int i2) {
        this.f7710d = i2;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7707a = str;
        return this;
    }
}
