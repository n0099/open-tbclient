package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes2.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6786a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6787b;

    /* renamed from: c  reason: collision with root package name */
    public int f6788c;

    /* renamed from: d  reason: collision with root package name */
    public int f6789d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6790e;

    public static a create() {
        return new b();
    }

    public BikeNaviLaunchParam endCityCode(int i) {
        this.f6790e = i;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f6787b = latLng;
        return this;
    }

    public int getEndCityCode() {
        return this.f6790e;
    }

    public LatLng getEndPt() {
        return this.f6787b;
    }

    public int getStartCityCode() {
        return this.f6788c;
    }

    public LatLng getStartPt() {
        return this.f6786a;
    }

    public int getVehicle() {
        return this.f6789d;
    }

    public BikeNaviLaunchParam stCityCode(int i) {
        this.f6788c = i;
        return this;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f6786a = latLng;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.f6789d = i;
        return this;
    }
}
