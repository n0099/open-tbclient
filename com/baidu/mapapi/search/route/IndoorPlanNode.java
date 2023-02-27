package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {
    public LatLng a;
    public String b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.a = null;
        this.b = null;
        this.a = latLng;
        this.b = str;
    }

    public String getFloor() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.a;
    }
}
