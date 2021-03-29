package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7405a;

    /* renamed from: b  reason: collision with root package name */
    public String f7406b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7407c;

    /* renamed from: d  reason: collision with root package name */
    public int f7408d;

    public PoiParaOption center(LatLng latLng) {
        this.f7407c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7407c;
    }

    public String getKey() {
        return this.f7406b;
    }

    public int getRadius() {
        return this.f7408d;
    }

    public String getUid() {
        return this.f7405a;
    }

    public PoiParaOption key(String str) {
        this.f7406b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.f7408d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7405a = str;
        return this;
    }
}
