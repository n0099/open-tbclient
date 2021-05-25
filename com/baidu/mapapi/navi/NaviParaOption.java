package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7131a;

    /* renamed from: b  reason: collision with root package name */
    public String f7132b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7133c;

    /* renamed from: d  reason: collision with root package name */
    public String f7134d;

    public NaviParaOption endName(String str) {
        this.f7134d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7133c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7134d;
    }

    public LatLng getEndPoint() {
        return this.f7133c;
    }

    public String getStartName() {
        return this.f7132b;
    }

    public LatLng getStartPoint() {
        return this.f7131a;
    }

    public NaviParaOption startName(String str) {
        this.f7132b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7131a = latLng;
        return this;
    }
}
