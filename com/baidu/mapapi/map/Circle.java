package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Circle extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7100a;

    /* renamed from: b  reason: collision with root package name */
    public int f7101b;

    /* renamed from: c  reason: collision with root package name */
    public int f7102c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f7103d;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.circle;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7100a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f7100a, this.f7102c));
        Overlay.a(this.f7101b, bundle);
        if (this.f7103d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f7103d.a(new Bundle()));
        }
        return bundle;
    }

    public LatLng getCenter() {
        return this.f7100a;
    }

    public int getFillColor() {
        return this.f7101b;
    }

    public int getRadius() {
        return this.f7102c;
    }

    public Stroke getStroke() {
        return this.f7103d;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.f7100a = latLng;
        this.listener.b(this);
    }

    public void setFillColor(int i2) {
        this.f7101b = i2;
        this.listener.b(this);
    }

    public void setRadius(int i2) {
        this.f7102c = i2;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.f7103d = stroke;
        this.listener.b(this);
    }
}
