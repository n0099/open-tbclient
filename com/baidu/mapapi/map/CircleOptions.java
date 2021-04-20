package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6865d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6866a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6868c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6869e;

    /* renamed from: g  reason: collision with root package name */
    public int f6871g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f6872h;

    /* renamed from: f  reason: collision with root package name */
    public int f6870f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6867b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.f6867b;
        circle.w = this.f6866a;
        circle.y = this.f6868c;
        circle.f6862b = this.f6870f;
        circle.f6861a = this.f6869e;
        circle.f6863c = this.f6871g;
        circle.f6864d = this.f6872h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6869e = latLng;
            return this;
        }
        throw new IllegalArgumentException("circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6868c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f6870f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f6869e;
    }

    public Bundle getExtraInfo() {
        return this.f6868c;
    }

    public int getFillColor() {
        return this.f6870f;
    }

    public int getRadius() {
        return this.f6871g;
    }

    public Stroke getStroke() {
        return this.f6872h;
    }

    public int getZIndex() {
        return this.f6866a;
    }

    public boolean isVisible() {
        return this.f6867b;
    }

    public CircleOptions radius(int i) {
        this.f6871g = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6872h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6867b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.f6866a = i;
        return this;
    }
}
