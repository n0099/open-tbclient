package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class IndoorPlanNode {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7320a;

    /* renamed from: b  reason: collision with root package name */
    public String f7321b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f7320a = null;
        this.f7321b = null;
        this.f7320a = latLng;
        this.f7321b = str;
    }

    public String getFloor() {
        return this.f7321b;
    }

    public LatLng getLocation() {
        return this.f7320a;
    }
}
