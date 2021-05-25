package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7424a;

    /* renamed from: b  reason: collision with root package name */
    public String f7425b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7426c;

    /* renamed from: d  reason: collision with root package name */
    public int f7427d;

    public PoiParaOption center(LatLng latLng) {
        this.f7426c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7426c;
    }

    public String getKey() {
        return this.f7425b;
    }

    public int getRadius() {
        return this.f7427d;
    }

    public String getUid() {
        return this.f7424a;
    }

    public PoiParaOption key(String str) {
        this.f7425b = str;
        return this;
    }

    public PoiParaOption radius(int i2) {
        this.f7427d = i2;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7424a = str;
        return this;
    }
}
