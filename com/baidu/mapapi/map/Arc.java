package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class Arc extends Overlay {

    /* renamed from: f  reason: collision with root package name */
    public static final String f7064f = "Arc";

    /* renamed from: a  reason: collision with root package name */
    public int f7065a;

    /* renamed from: b  reason: collision with root package name */
    public int f7066b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7067c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7068d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7069e;

    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.arc;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.f7067c);
        arrayList.add(this.f7068d);
        arrayList.add(this.f7069e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f7066b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.f7065a, bundle);
        return bundle;
    }

    public int getColor() {
        return this.f7065a;
    }

    public LatLng getEndPoint() {
        return this.f7069e;
    }

    public LatLng getMiddlePoint() {
        return this.f7068d;
    }

    public LatLng getStartPoint() {
        return this.f7067c;
    }

    public int getWidth() {
        return this.f7066b;
    }

    public void setColor(int i2) {
        this.f7065a = i2;
        this.listener.b(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f7067c = latLng;
        this.f7068d = latLng2;
        this.f7069e = latLng3;
        this.listener.b(this);
    }

    public void setWidth(int i2) {
        if (i2 > 0) {
            this.f7066b = i2;
            this.listener.b(this);
        }
    }
}
