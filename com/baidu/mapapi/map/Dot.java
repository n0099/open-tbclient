package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Dot extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6837a;

    /* renamed from: b  reason: collision with root package name */
    public int f6838b;

    /* renamed from: c  reason: collision with root package name */
    public int f6839c;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6837a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.f6839c);
        Overlay.a(this.f6838b, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6837a;
    }

    public int getColor() {
        return this.f6838b;
    }

    public int getRadius() {
        return this.f6839c;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.f6837a = latLng;
        this.listener.b(this);
    }

    public void setColor(int i) {
        this.f6838b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        if (i > 0) {
            this.f6839c = i;
            this.listener.b(this);
        }
    }
}
