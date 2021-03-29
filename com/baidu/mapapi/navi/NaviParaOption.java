package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7124a;

    /* renamed from: b  reason: collision with root package name */
    public String f7125b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7126c;

    /* renamed from: d  reason: collision with root package name */
    public String f7127d;

    public NaviParaOption endName(String str) {
        this.f7127d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7126c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7127d;
    }

    public LatLng getEndPoint() {
        return this.f7126c;
    }

    public String getStartName() {
        return this.f7125b;
    }

    public LatLng getStartPoint() {
        return this.f7124a;
    }

    public NaviParaOption startName(String str) {
        this.f7125b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7124a = latLng;
        return this;
    }
}
