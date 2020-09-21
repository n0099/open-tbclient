package com.baidu.mapapi.walknavi.params;

import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.walknavi.e.d;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class WalkNaviLaunchParam {
    private LatLng a;
    private LatLng b;
    private a c;
    private a d;
    private List<a> e = new LinkedList();
    private int f;

    public LatLng getStartPt() {
        return this.a;
    }

    public LatLng getEndPt() {
        return this.b;
    }

    public a getStartNodeInfo() {
        return this.c;
    }

    public a getEndNodeInfo() {
        return this.d;
    }

    public List<a> getViaNodes() {
        return this.e;
    }

    public int getExtraNaviMode() {
        return this.f;
    }

    public WalkNaviLaunchParam stPt(LatLng latLng) {
        this.a = latLng;
        return this;
    }

    public WalkNaviLaunchParam endPt(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public WalkNaviLaunchParam startNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.c = walkRouteNodeInfo;
        return this;
    }

    public WalkNaviLaunchParam endNodeInfo(WalkRouteNodeInfo walkRouteNodeInfo) {
        this.d = walkRouteNodeInfo;
        return this;
    }

    public void setViaNodes(List<a> list) {
        this.e.addAll(list);
    }

    public WalkNaviLaunchParam extraNaviMode(int i) {
        this.f = i;
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
