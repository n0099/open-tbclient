package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2131a;
    private String b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f2131a = null;
        this.b = null;
        this.f2131a = latLng;
        this.b = str;
    }

    public String getFloor() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.f2131a;
    }
}
