package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2901a;

    /* renamed from: b  reason: collision with root package name */
    private String f2902b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f2901a = null;
        this.f2902b = null;
        this.f2901a = latLng;
        this.f2902b = str;
    }

    public String getFloor() {
        return this.f2902b;
    }

    public LatLng getLocation() {
        return this.f2901a;
    }
}
