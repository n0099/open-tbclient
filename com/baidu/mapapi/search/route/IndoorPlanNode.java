package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f3023a;

    /* renamed from: b  reason: collision with root package name */
    private String f3024b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f3023a = null;
        this.f3024b = null;
        this.f3023a = latLng;
        this.f3024b = str;
    }

    public String getFloor() {
        return this.f3024b;
    }

    public LatLng getLocation() {
        return this.f3023a;
    }
}
