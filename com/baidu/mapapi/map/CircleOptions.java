package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6859d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6860a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6862c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6863e;

    /* renamed from: g  reason: collision with root package name */
    public int f6865g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f6866h;

    /* renamed from: f  reason: collision with root package name */
    public int f6864f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6861b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.A = this.f6861b;
        circle.z = this.f6860a;
        circle.B = this.f6862c;
        circle.f6856b = this.f6864f;
        circle.f6855a = this.f6863e;
        circle.f6857c = this.f6865g;
        circle.f6858d = this.f6866h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6863e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6862c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i2) {
        this.f6864f = i2;
        return this;
    }

    public LatLng getCenter() {
        return this.f6863e;
    }

    public Bundle getExtraInfo() {
        return this.f6862c;
    }

    public int getFillColor() {
        return this.f6864f;
    }

    public int getRadius() {
        return this.f6865g;
    }

    public Stroke getStroke() {
        return this.f6866h;
    }

    public int getZIndex() {
        return this.f6860a;
    }

    public boolean isVisible() {
        return this.f6861b;
    }

    public CircleOptions radius(int i2) {
        this.f6865g = i2;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6866h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6861b = z;
        return this;
    }

    public CircleOptions zIndex(int i2) {
        this.f6860a = i2;
        return this;
    }
}
