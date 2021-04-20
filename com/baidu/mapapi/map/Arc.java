package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class Arc extends Overlay {

    /* renamed from: f  reason: collision with root package name */
    public static final String f6828f = "Arc";

    /* renamed from: a  reason: collision with root package name */
    public int f6829a;

    /* renamed from: b  reason: collision with root package name */
    public int f6830b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6831c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6832d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6833e;

    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.arc;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.f6831c);
        arrayList.add(this.f6832d);
        arrayList.add(this.f6833e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f6830b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.f6829a, bundle);
        return bundle;
    }

    public int getColor() {
        return this.f6829a;
    }

    public LatLng getEndPoint() {
        return this.f6833e;
    }

    public LatLng getMiddlePoint() {
        return this.f6832d;
    }

    public LatLng getStartPoint() {
        return this.f6831c;
    }

    public int getWidth() {
        return this.f6830b;
    }

    public void setColor(int i) {
        this.f6829a = i;
        this.listener.b(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f6831c = latLng;
        this.f6832d = latLng2;
        this.f6833e = latLng3;
        this.listener.b(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.f6830b = i;
            this.listener.b(this);
        }
    }
}
