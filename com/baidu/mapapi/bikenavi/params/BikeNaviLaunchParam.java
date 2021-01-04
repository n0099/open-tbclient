package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes15.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2767a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f2768b;
    private BikeRouteNodeInfo c;
    private BikeRouteNodeInfo d;
    private int e = 0;

    public LatLng getStartPt() {
        return this.f2767a;
    }

    public LatLng getEndPt() {
        return this.f2768b;
    }

    public BikeRouteNodeInfo getStartNodeInfo() {
        return this.c;
    }

    public BikeRouteNodeInfo getEndNodeInfo() {
        return this.d;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f2767a = latLng;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f2768b = latLng;
        return this;
    }

    public BikeNaviLaunchParam startNodeInfo(BikeRouteNodeInfo bikeRouteNodeInfo) {
        this.c = bikeRouteNodeInfo;
        return this;
    }

    public BikeNaviLaunchParam endNodeInfo(BikeRouteNodeInfo bikeRouteNodeInfo) {
        this.d = bikeRouteNodeInfo;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.e = i;
        return this;
    }

    public int getVehicle() {
        return this.e;
    }

    public static a create() {
        switch (1) {
            case 1:
                return new b();
            default:
                return null;
        }
    }
}
