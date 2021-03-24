package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6798d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6799a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6801c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6804g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6805h;
    public LatLng i;

    /* renamed from: e  reason: collision with root package name */
    public int f6802e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6803f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6800b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.x = this.f6800b;
        arc.w = this.f6799a;
        arc.y = this.f6801c;
        arc.f6793a = this.f6802e;
        arc.f6794b = this.f6803f;
        arc.f6795c = this.f6804g;
        arc.f6796d = this.f6805h;
        arc.f6797e = this.i;
        return arc;
    }

    public ArcOptions color(int i) {
        this.f6802e = i;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6801c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6802e;
    }

    public LatLng getEndPoint() {
        return this.i;
    }

    public Bundle getExtraInfo() {
        return this.f6801c;
    }

    public LatLng getMiddlePoint() {
        return this.f6805h;
    }

    public LatLng getStartPoint() {
        return this.f6804g;
    }

    public int getWidth() {
        return this.f6803f;
    }

    public int getZIndex() {
        return this.f6799a;
    }

    public boolean isVisible() {
        return this.f6800b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f6804g = latLng;
        this.f6805h = latLng2;
        this.i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6800b = z;
        return this;
    }

    public ArcOptions width(int i) {
        if (i > 0) {
            this.f6803f = i;
        }
        return this;
    }

    public ArcOptions zIndex(int i) {
        this.f6799a = i;
        return this;
    }
}
