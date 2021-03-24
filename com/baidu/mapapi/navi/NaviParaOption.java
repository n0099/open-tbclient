package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7123a;

    /* renamed from: b  reason: collision with root package name */
    public String f7124b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7125c;

    /* renamed from: d  reason: collision with root package name */
    public String f7126d;

    public NaviParaOption endName(String str) {
        this.f7126d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7125c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7126d;
    }

    public LatLng getEndPoint() {
        return this.f7125c;
    }

    public String getStartName() {
        return this.f7124b;
    }

    public LatLng getStartPoint() {
        return this.f7123a;
    }

    public NaviParaOption startName(String str) {
        this.f7124b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7123a = latLng;
        return this;
    }
}
