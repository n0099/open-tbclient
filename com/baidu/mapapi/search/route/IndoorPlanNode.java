package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7377a;

    /* renamed from: b  reason: collision with root package name */
    public String f7378b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7377a = null;
        this.f7378b = null;
        this.f7377a = latLng;
        this.f7378b = str;
    }

    public String getFloor() {
        return this.f7378b;
    }

    public LatLng getLocation() {
        return this.f7377a;
    }
}
