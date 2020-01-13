package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes6.dex */
public class IndoorPlanNode {
    private LatLng a;
    private String b;

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
