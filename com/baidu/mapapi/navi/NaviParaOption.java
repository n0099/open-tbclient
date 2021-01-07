package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2949a;

    /* renamed from: b  reason: collision with root package name */
    String f2950b;
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
        return this.f2950b;
    }

    public LatLng getStartPoint() {
        return this.f2949a;
    }

    public NaviParaOption startName(String str) {
        this.f2950b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f2949a = latLng;
        return this;
    }
}
