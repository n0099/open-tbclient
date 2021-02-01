package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes4.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2667a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f2668b;
    private int c;
    private int d = 0;
    private int e;

    public int getEndCityCode() {
        return this.e;
    }

    public LatLng getStartPt() {
        return this.f2667a;
    }

    public LatLng getEndPt() {
        return this.f2668b;
    }

    public int getStartCityCode() {
        return this.c;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f2667a = latLng;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f2668b = latLng;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.d = i;
        return this;
    }

    public int getVehicle() {
        return this.d;
    }

    public BikeNaviLaunchParam stCityCode(int i) {
        this.c = i;
        return this;
    }

    public BikeNaviLaunchParam endCityCode(int i) {
        this.e = i;
        return this;
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
