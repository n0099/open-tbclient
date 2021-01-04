package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f3022a;

    /* renamed from: b  reason: collision with root package name */
    private String f3023b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f3022a = null;
        this.f3023b = null;
        this.f3022a = latLng;
        this.f3023b = str;
    }

    public String getFloor() {
        return this.f3023b;
    }

    public LatLng getLocation() {
        return this.f3022a;
    }
}
