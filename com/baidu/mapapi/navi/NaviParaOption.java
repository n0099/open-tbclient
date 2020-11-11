package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes7.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2095a;
    String b;
    LatLng c;
    String d;

    public NaviParaOption endName(String str) {
        this.d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public String getEndName() {
        return this.d;
    }

    public LatLng getEndPoint() {
        return this.c;
    }

    public String getStartName() {
        return this.b;
    }

    public LatLng getStartPoint() {
        return this.f2095a;
    }

    public NaviParaOption startName(String str) {
        this.b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f2095a = latLng;
        return this;
    }
}
