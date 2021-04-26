package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7560a;

    /* renamed from: b  reason: collision with root package name */
    public String f7561b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7560a = null;
        this.f7561b = null;
        this.f7560a = latLng;
        this.f7561b = str;
    }

    public String getFloor() {
        return this.f7561b;
    }

    public LatLng getLocation() {
        return this.f7560a;
    }
}
