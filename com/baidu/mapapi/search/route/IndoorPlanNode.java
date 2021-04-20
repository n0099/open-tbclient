package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7302a;

    /* renamed from: b  reason: collision with root package name */
    public String f7303b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7302a = null;
        this.f7303b = null;
        this.f7302a = latLng;
        this.f7303b = str;
    }

    public String getFloor() {
        return this.f7303b;
    }

    public LatLng getLocation() {
        return this.f7302a;
    }
}
