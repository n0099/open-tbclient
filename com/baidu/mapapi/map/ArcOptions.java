package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6781d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6782a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6784c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6787g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6788h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f6789i;

    /* renamed from: e  reason: collision with root package name */
    public int f6785e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6786f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6783b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.A = this.f6783b;
        arc.z = this.f6782a;
        arc.B = this.f6784c;
        arc.f6776a = this.f6785e;
        arc.f6777b = this.f6786f;
        arc.f6778c = this.f6787g;
        arc.f6779d = this.f6788h;
        arc.f6780e = this.f6789i;
        return arc;
    }

    public ArcOptions color(int i2) {
        this.f6785e = i2;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6784c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6785e;
    }

    public LatLng getEndPoint() {
        return this.f6789i;
    }

    public Bundle getExtraInfo() {
        return this.f6784c;
    }

    public LatLng getMiddlePoint() {
        return this.f6788h;
    }

    public LatLng getStartPoint() {
        return this.f6787g;
    }

    public int getWidth() {
        return this.f6786f;
    }

    public int getZIndex() {
        return this.f6782a;
    }

    public boolean isVisible() {
        return this.f6783b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.f6787g = latLng;
        this.f6788h = latLng2;
        this.f6789i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6783b = z;
        return this;
    }

    public ArcOptions width(int i2) {
        if (i2 > 0) {
            this.f6786f = i2;
        }
        return this;
    }

    public ArcOptions zIndex(int i2) {
        this.f6782a = i2;
        return this;
    }
}
