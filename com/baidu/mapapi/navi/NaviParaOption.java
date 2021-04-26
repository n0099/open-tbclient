package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7414a;

    /* renamed from: b  reason: collision with root package name */
    public String f7415b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7416c;

    /* renamed from: d  reason: collision with root package name */
    public String f7417d;

    public NaviParaOption endName(String str) {
        this.f7417d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7416c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7417d;
    }

    public LatLng getEndPoint() {
        return this.f7416c;
    }

    public String getStartName() {
        return this.f7415b;
    }

    public LatLng getStartPoint() {
        return this.f7414a;
    }

    public NaviParaOption startName(String str) {
        this.f7415b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7414a = latLng;
        return this;
    }
}
