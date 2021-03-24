package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7404a;

    /* renamed from: b  reason: collision with root package name */
    public String f7405b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7406c;

    /* renamed from: d  reason: collision with root package name */
    public int f7407d;

    public PoiParaOption center(LatLng latLng) {
        this.f7406c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7406c;
    }

    public String getKey() {
        return this.f7405b;
    }

    public int getRadius() {
        return this.f7407d;
    }

    public String getUid() {
        return this.f7404a;
    }

    public PoiParaOption key(String str) {
        this.f7405b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.f7407d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7404a = str;
        return this;
    }
}
