package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes6.dex */
public final class Dot extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    LatLng f2705a;

    /* renamed from: b  reason: collision with root package name */
    int f2706b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.dot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f2705a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.c);
        Overlay.a(this.f2706b, bundle);
        return bundle;
    }

    public LatLng getCenter() {
        return this.f2705a;
    }

    public int getColor() {
        return this.f2706b;
    }

    public int getRadius() {
        return this.c;
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("dot center can not be null");
        }
        this.f2705a = latLng;
        this.listener.b(this);
    }

    public void setColor(int i) {
        this.f2706b = i;
        this.listener.b(this);
    }

    public void setRadius(int i) {
        if (i > 0) {
            this.c = i;
            this.listener.b(this);
        }
    }
}
