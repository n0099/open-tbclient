package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7104d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f7105a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7107c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7108e;

    /* renamed from: g  reason: collision with root package name */
    public int f7110g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f7111h;

    /* renamed from: f  reason: collision with root package name */
    public int f7109f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7106b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.f7106b;
        circle.w = this.f7105a;
        circle.y = this.f7107c;
        circle.f7101b = this.f7109f;
        circle.f7100a = this.f7108e;
        circle.f7102c = this.f7110g;
        circle.f7103d = this.f7111h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f7108e = latLng;
            return this;
        }
        throw new IllegalArgumentException("circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f7107c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i2) {
        this.f7109f = i2;
        return this;
    }

    public LatLng getCenter() {
        return this.f7108e;
    }

    public Bundle getExtraInfo() {
        return this.f7107c;
    }

    public int getFillColor() {
        return this.f7109f;
    }

    public int getRadius() {
        return this.f7110g;
    }

    public Stroke getStroke() {
        return this.f7111h;
    }

    public int getZIndex() {
        return this.f7105a;
    }

    public boolean isVisible() {
        return this.f7106b;
    }

    public CircleOptions radius(int i2) {
        this.f7110g = i2;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f7111h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f7106b = z;
        return this;
    }

    public CircleOptions zIndex(int i2) {
        this.f7105a = i2;
        return this;
    }
}
