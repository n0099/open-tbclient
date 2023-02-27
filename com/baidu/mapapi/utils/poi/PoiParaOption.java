package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class PoiParaOption {
    public String a;
    public String b;
    public LatLng c;
    public int d;

    public LatLng getCenter() {
        return this.c;
    }

    public String getKey() {
        return this.b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.a;
    }

    public PoiParaOption center(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public PoiParaOption key(String str) {
        this.b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.a = str;
        return this;
    }
}
