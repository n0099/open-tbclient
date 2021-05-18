package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class Dot extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f6924a;

    /* renamed from: b  reason: collision with root package name */
    public int f6925b;

    /* renamed from: c  reason: collision with root package name */
    public int f6926c;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.dot;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f6924a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.f6926c);
        Overlay.a(this.f6925b, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f6924a;
    }

    public int getColor() {
        return this.f6925b;
    }

    public int getRadius() {
        return this.f6926c;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
        }
        this.f6924a = latLng;
        this.listener.b(this);
    }

    public void setColor(int i2) {
        this.f6925b = i2;
        this.listener.b(this);
    }

    public void setRadius(int i2) {
        if (i2 > 0) {
            this.f6926c = i2;
            this.listener.b(this);
        }
    }
}
