package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7174a;

    /* renamed from: b  reason: collision with root package name */
    public String f7175b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7176c;

    /* renamed from: d  reason: collision with root package name */
    public String f7177d;

    public NaviParaOption endName(String str) {
        this.f7177d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7176c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7177d;
    }

    public LatLng getEndPoint() {
        return this.f7176c;
    }

    public String getStartName() {
        return this.f7175b;
    }

    public LatLng getStartPoint() {
        return this.f7174a;
    }

    public NaviParaOption startName(String str) {
        this.f7175b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7174a = latLng;
        return this;
    }
}
