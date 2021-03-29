package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Dot extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6838a;

    /* renamed from: b  reason: collision with root package name */
    public int f6839b;

    /* renamed from: c  reason: collision with root package name */
    public int f6840c;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6838a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.f6840c);
        Overlay.a(this.f6839b, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6838a;
    }

    public int getColor() {
        return this.f6839b;
    }

    public int getRadius() {
        return this.f6840c;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.f6838a = latLng;
        this.listener.b(this);
    }

    public void setColor(int i) {
        this.f6839b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        if (i > 0) {
            this.f6840c = i;
            this.listener.b(this);
        }
    }
}
