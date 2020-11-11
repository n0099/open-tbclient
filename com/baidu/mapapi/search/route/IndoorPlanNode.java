package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes7.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2136a;
    private String b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f2136a = null;
        this.b = null;
        this.f2136a = latLng;
        this.b = str;
    }

    public String getFloor() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.f2136a;
    }
}
