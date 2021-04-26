package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Dot extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7112a;

    /* renamed from: b  reason: collision with root package name */
    public int f7113b;

    /* renamed from: c  reason: collision with root package name */
    public int f7114c;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7112a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.f7114c);
        Overlay.a(this.f7113b, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f7112a;
    }

    public int getColor() {
        return this.f7113b;
    }

    public int getRadius() {
        return this.f7114c;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.f7112a = latLng;
        this.listener.b(this);
    }

    public void setColor(int i2) {
        this.f7113b = i2;
        this.listener.b(this);
    }

    public void setRadius(int i2) {
        if (i2 > 0) {
            this.f7114c = i2;
            this.listener.b(this);
        }
    }
}
