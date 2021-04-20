package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7440a;

    /* renamed from: b  reason: collision with root package name */
    public String f7441b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7442c;

    /* renamed from: d  reason: collision with root package name */
    public int f7443d;

    public PoiParaOption center(LatLng latLng) {
        this.f7442c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7442c;
    }

    public String getKey() {
        return this.f7441b;
    }

    public int getRadius() {
        return this.f7443d;
    }

    public String getUid() {
        return this.f7440a;
    }

    public PoiParaOption key(String str) {
        this.f7441b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.f7443d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7440a = str;
        return this;
    }
}
