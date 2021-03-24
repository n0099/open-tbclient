package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes2.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6750a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6751b;

    /* renamed from: c  reason: collision with root package name */
    public int f6752c;

    /* renamed from: d  reason: collision with root package name */
    public int f6753d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6754e;

    public static a create() {
        return new b();
    }

    public BikeNaviLaunchParam endCityCode(int i) {
        this.f6754e = i;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f6751b = latLng;
        return this;
    }

    public int getEndCityCode() {
        return this.f6754e;
    }

    public LatLng getEndPt() {
        return this.f6751b;
    }

    public int getStartCityCode() {
        return this.f6752c;
    }

    public LatLng getStartPt() {
        return this.f6750a;
    }

    public int getVehicle() {
        return this.f6753d;
    }

    public BikeNaviLaunchParam stCityCode(int i) {
        this.f6752c = i;
        return this;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f6750a = latLng;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.f6753d = i;
        return this;
    }
}
