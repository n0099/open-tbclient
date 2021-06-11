package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {

    /* renamed from: a  reason: collision with root package name */
    public String f7467a;

    /* renamed from: b  reason: collision with root package name */
    public String f7468b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7469c;

    /* renamed from: d  reason: collision with root package name */
    public int f7470d;

    public PoiParaOption center(LatLng latLng) {
        this.f7469c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.f7469c;
    }

    public String getKey() {
        return this.f7468b;
    }

    public int getRadius() {
        return this.f7470d;
    }

    public String getUid() {
        return this.f7467a;
    }

    public PoiParaOption key(String str) {
        this.f7468b = str;
        return this;
    }

    public PoiParaOption radius(int i2) {
        this.f7470d = i2;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.f7467a = str;
        return this;
    }
}
