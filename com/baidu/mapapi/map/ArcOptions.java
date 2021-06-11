package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6824d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6825a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6827c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6830g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6831h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f6832i;

    /* renamed from: e  reason: collision with root package name */
    public int f6828e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6829f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6826b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.A = this.f6826b;
        arc.z = this.f6825a;
        arc.B = this.f6827c;
        arc.f6819a = this.f6828e;
        arc.f6820b = this.f6829f;
        arc.f6821c = this.f6830g;
        arc.f6822d = this.f6831h;
        arc.f6823e = this.f6832i;
        return arc;
    }

    public ArcOptions color(int i2) {
        this.f6828e = i2;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6827c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6828e;
    }

    public LatLng getEndPoint() {
        return this.f6832i;
    }

    public Bundle getExtraInfo() {
        return this.f6827c;
    }

    public LatLng getMiddlePoint() {
        return this.f6831h;
    }

    public LatLng getStartPoint() {
        return this.f6830g;
    }

    public int getWidth() {
        return this.f6829f;
    }

    public int getZIndex() {
        return this.f6825a;
    }

    public boolean isVisible() {
        return this.f6826b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.f6830g = latLng;
        this.f6831h = latLng2;
        this.f6832i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6826b = z;
        return this;
    }

    public ArcOptions width(int i2) {
        if (i2 > 0) {
            this.f6829f = i2;
        }
        return this;
    }

    public ArcOptions zIndex(int i2) {
        this.f6825a = i2;
        return this;
    }
}
