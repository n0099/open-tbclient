package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class CircleOptions extends OverlayOptions {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6830d = "CircleOptions";

    /* renamed from: a  reason: collision with root package name */
    public int f6831a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6833c;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6834e;

    /* renamed from: g  reason: collision with root package name */
    public int f6836g;

    /* renamed from: h  reason: collision with root package name */
    public Stroke f6837h;

    /* renamed from: f  reason: collision with root package name */
    public int f6835f = -16777216;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6832b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Circle circle = new Circle();
        circle.x = this.f6832b;
        circle.w = this.f6831a;
        circle.y = this.f6833c;
        circle.f6827b = this.f6835f;
        circle.f6826a = this.f6834e;
        circle.f6828c = this.f6836g;
        circle.f6829d = this.f6837h;
        return circle;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng != null) {
            this.f6834e = latLng;
            return this;
        }
        throw new IllegalArgumentException("circle center can not be null");
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.f6833c = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f6835f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f6834e;
    }

    public Bundle getExtraInfo() {
        return this.f6833c;
    }

    public int getFillColor() {
        return this.f6835f;
    }

    public int getRadius() {
        return this.f6836g;
    }

    public Stroke getStroke() {
        return this.f6837h;
    }

    public int getZIndex() {
        return this.f6831a;
    }

    public boolean isVisible() {
        return this.f6832b;
    }

    public CircleOptions radius(int i) {
        this.f6836g = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.f6837h = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f6832b = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.f6831a = i;
        return this;
    }
}
