package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public class WalkRouteNodeInfo extends a {
    @Override // com.baidu.mapapi.walknavi.params.a
    public String getBuildingID() {
        return this.f;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public void setBuildingID(String str) {
        this.f = str;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public RouteNodeType getType() {
        return this.f3108a;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public void setType(RouteNodeType routeNodeType) {
        this.f3108a = routeNodeType;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public String getKeyword() {
        return this.f3109b;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public void setKeyword(String str) {
        this.f3109b = str;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public LatLng getLocation() {
        return this.c;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public void setLocation(LatLng latLng) {
        this.c = latLng;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public String getFloorID() {
        return this.e;
    }

    @Override // com.baidu.mapapi.walknavi.params.a
    public void setFloorID(String str) {
        this.e = str;
    }
}
