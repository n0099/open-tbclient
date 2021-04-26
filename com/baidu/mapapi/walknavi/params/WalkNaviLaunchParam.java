package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
/* loaded from: classes2.dex */
public class WalkNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7748a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7749b;

    /* renamed from: c  reason: collision with root package name */
    public int f7750c;

    /* renamed from: d  reason: collision with root package name */
    public int f7751d;

    /* renamed from: e  reason: collision with root package name */
    public int f7752e;

    public static c create() {
        return new d();
    }

    public WalkNaviLaunchParam endCityCode(int i2) {
        this.f7751d = i2;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.f7749b = latLng;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i2) {
        this.f7752e = i2;
        return this;
    }

    public int getEndCityCode() {
        return this.f7751d;
    }

    public LatLng getEndPt() {
        return this.f7749b;
    }

    public int getExtraNaviMode() {
        return this.f7752e;
    }

    public int getStartCityCode() {
        return this.f7750c;
    }

    public LatLng getStartPt() {
        return this.f7748a;
    }

    public WalkNaviLaunchParam stCityCode(int i2) {
        this.f7750c = i2;
        return this;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f7748a = latLng;
        return this;
    }
}
