package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7159a;

    /* renamed from: b  reason: collision with root package name */
    public String f7160b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7161c;

    /* renamed from: d  reason: collision with root package name */
    public String f7162d;

    public NaviParaOption endName(String str) {
        this.f7162d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7161c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7162d;
    }

    public LatLng getEndPoint() {
        return this.f7161c;
    }

    public String getStartName() {
        return this.f7160b;
    }

    public LatLng getStartPoint() {
        return this.f7159a;
    }

    public NaviParaOption startName(String str) {
        this.f7160b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7159a = latLng;
        return this;
    }
}
