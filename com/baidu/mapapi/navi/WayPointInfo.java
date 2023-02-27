package com.baidu.mapapi.navi;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class WayPointInfo {
    public String a;
    public LatLng b;

    public LatLng getLatLng() {
        return this.b;
    }

    public String getWayPointName() {
        return this.a;
    }

    public WayPointInfo setLatLng(LatLng latLng) {
        if (latLng != null) {
            this.b = latLng;
            return this;
        }
        throw new IllegalStateException("BDMapSDKException: The latitude and longitude of the waypoint cannot be null");
    }

    public WayPointInfo setWayPointName(String str) {
        this.a = str;
        return this;
    }
}
