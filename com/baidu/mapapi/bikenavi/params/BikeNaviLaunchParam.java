package com.baidu.mapapi.bikenavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.a;
import com.baidu.platform.comapi.walknavi.e.b;
/* loaded from: classes2.dex */
public class BikeNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7022a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7023b;

    /* renamed from: c  reason: collision with root package name */
    public int f7024c;

    /* renamed from: d  reason: collision with root package name */
    public int f7025d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7026e;

    public static a create() {
        return new b();
    }

    public BikeNaviLaunchParam endCityCode(int i2) {
        this.f7026e = i2;
        return this;
    }

    public BikeNaviLaunchParam endPt(LatLng latLng) {
        this.f7023b = latLng;
        return this;
    }

    public int getEndCityCode() {
        return this.f7026e;
    }

    public LatLng getEndPt() {
        return this.f7023b;
    }

    public int getStartCityCode() {
        return this.f7024c;
    }

    public LatLng getStartPt() {
        return this.f7022a;
    }

    public int getVehicle() {
        return this.f7025d;
    }

    public BikeNaviLaunchParam stCityCode(int i2) {
        this.f7024c = i2;
        return this;
    }

    public BikeNaviLaunchParam stPt(LatLng latLng) {
        this.f7022a = latLng;
        return this;
    }

    public BikeNaviLaunchParam vehicle(int i2) {
        this.f7025d = i2;
        return this;
    }
}
