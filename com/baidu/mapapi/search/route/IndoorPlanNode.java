package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7267a;

    /* renamed from: b  reason: collision with root package name */
    public String f7268b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7267a = null;
        this.f7268b = null;
        this.f7267a = latLng;
        this.f7268b = str;
    }

    public String getFloor() {
        return this.f7268b;
    }

    public LatLng getLocation() {
        return this.f7267a;
    }
}
