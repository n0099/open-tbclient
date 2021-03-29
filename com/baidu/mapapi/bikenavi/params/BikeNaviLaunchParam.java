package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes2.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6751a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6752b;

    /* renamed from: c  reason: collision with root package name */
    public int f6753c;

    /* renamed from: d  reason: collision with root package name */
    public int f6754d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f6755e;

    public static a create() {
        return new b();
    }

    public BikeNaviLaunchParam endCityCode(int i) {
        this.f6755e = i;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f6752b = latLng;
        return this;
    }

    public int getEndCityCode() {
        return this.f6755e;
    }

    public LatLng getEndPt() {
        return this.f6752b;
    }

    public int getStartCityCode() {
        return this.f6753c;
    }

    public LatLng getStartPt() {
        return this.f6751a;
    }

    public int getVehicle() {
        return this.f6754d;
    }

    public BikeNaviLaunchParam stCityCode(int i) {
        this.f6753c = i;
        return this;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f6751a = latLng;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i) {
        this.f6754d = i;
        return this;
    }
}
