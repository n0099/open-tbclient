package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6916d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6917a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6919c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6920e;

    /* renamed from: g  reason: collision with root package name */
    public int f6922g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f6923h;

    /* renamed from: f  reason: collision with root package name */
    public int f6921f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6918b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.A = this.f6918b;
        circle.z = this.f6917a;
        circle.B = this.f6919c;
        circle.f6913b = this.f6921f;
        circle.f6912a = this.f6920e;
        circle.f6914c = this.f6922g;
        circle.f6915d = this.f6923h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6920e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6919c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i2) {
        this.f6921f = i2;
        return this;
    }

    public LatLng getCenter() {
        return this.f6920e;
    }

    public Bundle getExtraInfo() {
        return this.f6919c;
    }

    public int getFillColor() {
        return this.f6921f;
    }

    public int getRadius() {
        return this.f6922g;
    }

    public Stroke getStroke() {
        return this.f6923h;
    }

    public int getZIndex() {
        return this.f6917a;
    }

    public boolean isVisible() {
        return this.f6918b;
    }

    public CircleOptions radius(int i2) {
        this.f6922g = i2;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6923h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6918b = z;
        return this;
    }

    public CircleOptions zIndex(int i2) {
        this.f6917a = i2;
        return this;
    }
}
