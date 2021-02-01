package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2829a;

    /* renamed from: b  reason: collision with root package name */
    String f2830b;
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
        return this.f2830b;
    }

    public LatLng getStartPoint() {
        return this.f2829a;
    }

    public NaviParaOption startName(String str) {
        this.f2830b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f2829a = latLng;
        return this;
    }
}
