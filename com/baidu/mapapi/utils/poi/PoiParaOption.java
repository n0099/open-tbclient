package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7524a;

    /* renamed from: b  reason: collision with root package name */
    public String f7525b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7526c;

    /* renamed from: d  reason: collision with root package name */
    public int f7527d;

    public PoiParaOption center(LatLng latLng) {
        this.f7526c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7526c;
    }

    public String getKey() {
        return this.f7525b;
    }

    public int getRadius() {
        return this.f7527d;
    }

    public String getUid() {
        return this.f7524a;
    }

    public PoiParaOption key(String str) {
        this.f7525b = str;
        return this;
    }

    public PoiParaOption radius(int i2) {
        this.f7527d = i2;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7524a = str;
        return this;
    }
}
