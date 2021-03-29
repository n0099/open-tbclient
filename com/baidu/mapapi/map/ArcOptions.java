package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class ArcOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6799d = "ArcOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6800a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6802c;

    /* renamed from: g  reason: collision with root package name */
    public LatLng f6805g;

    /* renamed from: h  reason: collision with root package name */
    public LatLng f6806h;
    public LatLng i;

    /* renamed from: e  reason: collision with root package name */
    public int f6803e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    public int f6804f = 5;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6801b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Arc arc = new Arc();
        arc.x = this.f6801b;
        arc.w = this.f6800a;
        arc.y = this.f6802c;
        arc.f6794a = this.f6803e;
        arc.f6795b = this.f6804f;
        arc.f6796c = this.f6805g;
        arc.f6797d = this.f6806h;
        arc.f6798e = this.i;
        return arc;
    }

    public ArcOptions color(int i) {
        this.f6803e = i;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.f6802c = bundle;
        return this;
    }

    public int getColor() {
        return this.f6803e;
    }

    public LatLng getEndPoint() {
        return this.i;
    }

    public Bundle getExtraInfo() {
        return this.f6802c;
    }

    public LatLng getMiddlePoint() {
        return this.f6806h;
    }

    public LatLng getStartPoint() {
        return this.f6805g;
    }

    public int getWidth() {
        return this.f6804f;
    }

    public int getZIndex() {
        return this.f6800a;
    }

    public boolean isVisible() {
        return this.f6801b;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f6805g = latLng;
        this.f6806h = latLng2;
        this.i = latLng3;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f6801b = z;
        return this;
    }

    public ArcOptions width(int i) {
        if (i > 0) {
            this.f6804f = i;
        }
        return this;
    }

    public ArcOptions zIndex(int i) {
        this.f6800a = i;
        return this;
    }
}
