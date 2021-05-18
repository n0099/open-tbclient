package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Circle extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6912a;

    /* renamed from: b  reason: collision with root package name */
    public int f6913b;

    /* renamed from: c  reason: collision with root package name */
    public int f6914c;

    /* renamed from: d  reason: collision with root package name */
    public Stroke f6915d;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.circle;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6912a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f6912a, this.f6914c));
        Overlay.a(this.f6913b, bundle);
        if (this.f6915d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f6915d.a(new Bundle()));
        }
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6912a;
    }

    public int getFillColor() {
        return this.f6913b;
    }

    public int getRadius() {
        return this.f6914c;
    }

    public Stroke getStroke() {
        return this.f6915d;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.f6912a = latLng;
        this.listener.b(this);
    }

    public void setFillColor(int i2) {
        this.f6913b = i2;
        this.listener.b(this);
    }

    public void setRadius(int i2) {
        this.f6914c = i2;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.f6915d = stroke;
        this.listener.b(this);
    }
}
