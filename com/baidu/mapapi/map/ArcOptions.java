package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6881d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6882a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6884c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6887g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6888h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f6889i;

    /* renamed from: e  reason: collision with root package name */
    public int f6885e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6886f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6883b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.A = this.f6883b;
        arc.z = this.f6882a;
        arc.B = this.f6884c;
        arc.f6876a = this.f6885e;
        arc.f6877b = this.f6886f;
        arc.f6878c = this.f6887g;
        arc.f6879d = this.f6888h;
        arc.f6880e = this.f6889i;
        return arc;
    }

    public ArcOptions color(int i2) {
        this.f6885e = i2;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6884c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6885e;
    }

    public LatLng getEndPoint() {
        return this.f6889i;
    }

    public Bundle getExtraInfo() {
        return this.f6884c;
    }

    public LatLng getMiddlePoint() {
        return this.f6888h;
    }

    public LatLng getStartPoint() {
        return this.f6887g;
    }

    public int getWidth() {
        return this.f6886f;
    }

    public int getZIndex() {
        return this.f6882a;
    }

    public boolean isVisible() {
        return this.f6883b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.f6887g = latLng;
        this.f6888h = latLng2;
        this.f6889i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6883b = z;
        return this;
    }

    public ArcOptions width(int i2) {
        if (i2 > 0) {
            this.f6886f = i2;
        }
        return this;
    }

    public ArcOptions zIndex(int i2) {
        this.f6882a = i2;
        return this;
    }
}
