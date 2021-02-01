package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
/* loaded from: classes4.dex */
public class WalkNaviLaunchParam {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f2987a;

    /* renamed from: b  reason: collision with root package name */
    private LatLng f2988b;
    private int c;
    private int d;
    private int e;

    public int getEndCityCode() {
        return this.d;
    }

    public LatLng getStartPt() {
        return this.f2987a;
    }

    public LatLng getEndPt() {
        return this.f2988b;
    }

    public int getStartCityCode() {
        return this.c;
    }

    public int getExtraNaviMode() {
        return this.e;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.f2987a = latLng;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.f2988b = latLng;
        return this;
    }

    public WalkNaviLaunchParam stCityCode(int i) {
        this.c = i;
        return this;
    }

    public WalkNaviLaunchParam endCityCode(int i) {
        this.d = i;
        return this;
    }

    public WalkNaviLaunchParam extraNaviMode(int i) {
        this.e = i;
        return this;
    }

    public static c create() {
        switch (1) {
            case 1:
                return new d();
            default:
                return null;
        }
    }
}
