package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2899a;

    /* renamed from: b  reason: collision with root package name */
    private String f2900b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f2899a = null;
        this.f2900b = null;
        this.f2899a = latLng;
        this.f2900b = str;
    }

    public String getFloor() {
        return this.f2900b;
    }

    public LatLng getLocation() {
        return this.f2899a;
    }
}
