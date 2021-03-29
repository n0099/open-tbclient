package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
/* loaded from: classes2.dex */
public class WalkNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7446a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7447b;

    /* renamed from: c  reason: collision with root package name */
    public int f7448c;

    /* renamed from: d  reason: collision with root package name */
    public int f7449d;

    /* renamed from: e  reason: collision with root package name */
    public int f7450e;

    public static c create() {
        return new d();
    }

    public WalkNaviLaunchParam endCityCode(int i) {
        this.f7449d = i;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.f7447b = latLng;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i) {
        this.f7450e = i;
        return this;
    }

    public int getEndCityCode() {
        return this.f7449d;
    }

    public LatLng getEndPt() {
        return this.f7447b;
    }

    public int getExtraNaviMode() {
        return this.f7450e;
    }

    public int getStartCityCode() {
        return this.f7448c;
    }

    public LatLng getStartPt() {
        return this.f7446a;
    }

    public WalkNaviLaunchParam stCityCode(int i) {
        this.f7448c = i;
        return this;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f7446a = latLng;
        return this;
    }
}
