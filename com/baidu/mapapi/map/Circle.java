package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes4.dex */
public final class Circle extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2699a;

    /* renamed from: b  reason: collision with root package name */
    int f2700b;
    int c;
    Stroke d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.circle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f2699a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.f2699a, this.c));
        Overlay.a(this.f2700b, bundle);
        if (this.d == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.d.a(new Bundle()));
        }
        return bundle;
    }

    public LatLng getCenter() {
        return this.f2699a;
    }

    public int getFillColor() {
        return this.f2700b;
    }

    public int getRadius() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("circle center can not be null");
        }
        this.f2699a = latLng;
        this.listener.b(this);
    }

    public void setFillColor(int i) {
        this.f2700b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        this.c = i;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.d = stroke;
        this.listener.b(this);
    }
}
