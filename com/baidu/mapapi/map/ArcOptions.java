package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6834d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6835a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6837c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6840g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6841h;
    public LatLng i;

    /* renamed from: e  reason: collision with root package name */
    public int f6838e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6839f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6836b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.x = this.f6836b;
        arc.w = this.f6835a;
        arc.y = this.f6837c;
        arc.f6829a = this.f6838e;
        arc.f6830b = this.f6839f;
        arc.f6831c = this.f6840g;
        arc.f6832d = this.f6841h;
        arc.f6833e = this.i;
        return arc;
    }

    public ArcOptions color(int i) {
        this.f6838e = i;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6837c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6838e;
    }

    public LatLng getEndPoint() {
        return this.i;
    }

    public Bundle getExtraInfo() {
        return this.f6837c;
    }

    public LatLng getMiddlePoint() {
        return this.f6841h;
    }

    public LatLng getStartPoint() {
        return this.f6840g;
    }

    public int getWidth() {
        return this.f6839f;
    }

    public int getZIndex() {
        return this.f6835a;
    }

    public boolean isVisible() {
        return this.f6836b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f6840g = latLng;
        this.f6841h = latLng2;
        this.i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6836b = z;
        return this;
    }

    public ArcOptions width(int i) {
        if (i > 0) {
            this.f6839f = i;
        }
        return this;
    }

    public ArcOptions zIndex(int i) {
        this.f6835a = i;
        return this;
    }
}
