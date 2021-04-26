package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7070d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f7071a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7073c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f7076g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f7077h;

    /* renamed from: i  reason: collision with root package name */
    public LatLng f7078i;

    /* renamed from: e  reason: collision with root package name */
    public int f7074e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f7075f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7072b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.x = this.f7072b;
        arc.w = this.f7071a;
        arc.y = this.f7073c;
        arc.f7065a = this.f7074e;
        arc.f7066b = this.f7075f;
        arc.f7067c = this.f7076g;
        arc.f7068d = this.f7077h;
        arc.f7069e = this.f7078i;
        return arc;
    }

    public ArcOptions color(int i2) {
        this.f7074e = i2;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f7073c = bundle;
        return this;
    }

    public int getColor() {
        return this.f7074e;
    }

    public LatLng getEndPoint() {
        return this.f7078i;
    }

    public Bundle getExtraInfo() {
        return this.f7073c;
    }

    public LatLng getMiddlePoint() {
        return this.f7077h;
    }

    public LatLng getStartPoint() {
        return this.f7076g;
    }

    public int getWidth() {
        return this.f7075f;
    }

    public int getZIndex() {
        return this.f7071a;
    }

    public boolean isVisible() {
        return this.f7072b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f7076g = latLng;
        this.f7077h = latLng2;
        this.f7078i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f7072b = z;
        return this;
    }

    public ArcOptions width(int i2) {
        if (i2 > 0) {
            this.f7075f = i2;
        }
        return this;
    }

    public ArcOptions zIndex(int i2) {
        this.f7071a = i2;
        return this;
    }
}
