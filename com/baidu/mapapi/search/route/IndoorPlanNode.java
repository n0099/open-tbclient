package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7266a;

    /* renamed from: b  reason: collision with root package name */
    public String f7267b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7266a = null;
        this.f7267b = null;
        this.f7266a = latLng;
        this.f7267b = str;
    }

    public String getFloor() {
        return this.f7267b;
    }

    public LatLng getLocation() {
        return this.f7266a;
    }
}
