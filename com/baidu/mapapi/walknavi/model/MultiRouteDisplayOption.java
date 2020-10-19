package com.baidu.mapapi.walknavi.model;

import com.baidu.mapapi.map.BitmapDescriptor;
/* loaded from: classes7.dex */
public class MultiRouteDisplayOption {

    /* renamed from: a  reason: collision with root package name */
    private BitmapDescriptor f2174a;
    private BitmapDescriptor b;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public BitmapDescriptor getFocusRouteBitmapDescriptor() {
        return this.f2174a;
    }

    public void setFocusRouteBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.f2174a = bitmapDescriptor;
    }

    public BitmapDescriptor getNoFocusRouteBitmapDescriptor() {
        return this.b;
    }

    public void setNoFocusRouteBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.b = bitmapDescriptor;
    }

    public int getFocusRouteWidth() {
        return this.c;
    }

    public void setFocusRouteWidth(int i) {
        this.c = i;
    }

    public int getNoFocusRouteWidth() {
        return this.d;
    }

    public void setNoFocusRouteWidth(int i) {
        this.d = i;
    }

    public int getFocusColor() {
        return this.e;
    }

    public void setFocusColor(int i) {
        this.e = i;
    }

    public int getNoFocusColor() {
        return this.f;
    }

    public void setNoFocusColor(int i) {
        this.f = i;
    }
}
