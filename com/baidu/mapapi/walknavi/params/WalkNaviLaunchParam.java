package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
/* loaded from: classes4.dex */
public class WalkNaviLaunchParam {
    private LatLng a;
    private LatLng b;
    private int c;
    private int d;

    public int getEndCityCode() {
        return this.d;
    }

    public LatLng getStartPt() {
        return this.a;
    }

    public LatLng getEndPt() {
        return this.b;
    }

    public int getStartCityCode() {
        return this.c;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.b = latLng;
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

    public static c create() {
        switch (1) {
            case 1:
                return new d();
            default:
                return null;
        }
    }
}
