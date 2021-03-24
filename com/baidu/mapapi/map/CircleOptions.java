package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6829d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6830a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6832c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6833e;

    /* renamed from: g  reason: collision with root package name */
    public int f6835g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f6836h;

    /* renamed from: f  reason: collision with root package name */
    public int f6834f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6831b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.f6831b;
        circle.w = this.f6830a;
        circle.y = this.f6832c;
        circle.f6826b = this.f6834f;
        circle.f6825a = this.f6833e;
        circle.f6827c = this.f6835g;
        circle.f6828d = this.f6836h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6833e = latLng;
            return this;
        }
        throw new IllegalArgumentException("circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6832c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f6834f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f6833e;
    }

    public Bundle getExtraInfo() {
        return this.f6832c;
    }

    public int getFillColor() {
        return this.f6834f;
    }

    public int getRadius() {
        return this.f6835g;
    }

    public Stroke getStroke() {
        return this.f6836h;
    }

    public int getZIndex() {
        return this.f6830a;
    }

    public boolean isVisible() {
        return this.f6831b;
    }

    public CircleOptions radius(int i) {
        this.f6835g = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6836h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6831b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.f6830a = i;
        return this;
    }
}
