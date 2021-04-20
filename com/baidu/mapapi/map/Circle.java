package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Circle extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6861a;

    /* renamed from: b  reason: collision with root package name */
    public int f6862b;

    /* renamed from: c  reason: collision with root package name */
    public int f6863c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f6864d;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.circle;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6861a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f6861a, this.f6863c));
        Overlay.a(this.f6862b, bundle);
        if (this.f6864d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f6864d.a(new Bundle()));
        }
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6861a;
    }

    public int getFillColor() {
        return this.f6862b;
    }

    public int getRadius() {
        return this.f6863c;
    }

    public Stroke getStroke() {
        return this.f6864d;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.f6861a = latLng;
        this.listener.b(this);
    }

    public void setFillColor(int i) {
        this.f6862b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        this.f6863c = i;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.f6864d = stroke;
        this.listener.b(this);
    }
}
