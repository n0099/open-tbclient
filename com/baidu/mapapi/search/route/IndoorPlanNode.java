package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7277a;

    /* renamed from: b  reason: collision with root package name */
    public String f7278b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7277a = null;
        this.f7278b = null;
        this.f7277a = latLng;
        this.f7278b = str;
    }

    public String getFloor() {
        return this.f7278b;
    }

    public LatLng getLocation() {
        return this.f7277a;
    }
}
