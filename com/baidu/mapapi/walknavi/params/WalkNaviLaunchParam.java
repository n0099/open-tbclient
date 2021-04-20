package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
/* loaded from: classes2.dex */
public class WalkNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7481a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7482b;

    /* renamed from: c  reason: collision with root package name */
    public int f7483c;

    /* renamed from: d  reason: collision with root package name */
    public int f7484d;

    /* renamed from: e  reason: collision with root package name */
    public int f7485e;

    public static c create() {
        return new d();
    }

    public WalkNaviLaunchParam endCityCode(int i) {
        this.f7484d = i;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.f7482b = latLng;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i) {
        this.f7485e = i;
        return this;
    }

    public int getEndCityCode() {
        return this.f7484d;
    }

    public LatLng getEndPt() {
        return this.f7482b;
    }

    public int getExtraNaviMode() {
        return this.f7485e;
    }

    public int getStartCityCode() {
        return this.f7483c;
    }

    public LatLng getStartPt() {
        return this.f7481a;
    }

    public WalkNaviLaunchParam stCityCode(int i) {
        this.f7483c = i;
        return this;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f7481a = latLng;
        return this;
    }
}
