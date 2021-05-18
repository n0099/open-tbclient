package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class NaviParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7231a;

    /* renamed from: b  reason: collision with root package name */
    public String f7232b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7233c;

    /* renamed from: d  reason: collision with root package name */
    public String f7234d;

    public NaviParaOption endName(String str) {
        this.f7234d = str;
        return this;
    }

    public NaviParaOption endPoint(LatLng latLng) {
        this.f7233c = latLng;
        return this;
    }

    public String getEndName() {
        return this.f7234d;
    }

    public LatLng getEndPoint() {
        return this.f7233c;
    }

    public String getStartName() {
        return this.f7232b;
    }

    public LatLng getStartPoint() {
        return this.f7231a;
    }

    public NaviParaOption startName(String str) {
        this.f7232b = str;
        return this;
    }

    public NaviParaOption startPoint(LatLng latLng) {
        this.f7231a = latLng;
        return this;
    }
}
