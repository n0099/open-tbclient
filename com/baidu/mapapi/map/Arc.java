package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class Arc extends Overlay {

    /* renamed from: f  reason: collision with root package name */
    public static final String f6792f = "Arc";

    /* renamed from: a  reason: collision with root package name */
    public int f6793a;

    /* renamed from: b  reason: collision with root package name */
    public int f6794b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6795c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6796d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6797e;

    public Arc() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.arc;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.f6795c);
        arrayList.add(this.f6796d);
        arrayList.add(this.f6797e);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) arrayList.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.f6794b);
        Overlay.a(arrayList, bundle);
        Overlay.a(this.f6793a, bundle);
        return bundle;
    }

    public int getColor() {
        return this.f6793a;
    }

    public LatLng getEndPoint() {
        return this.f6797e;
    }

    public LatLng getMiddlePoint() {
        return this.f6796d;
    }

    public LatLng getStartPoint() {
        return this.f6795c;
    }

    public int getWidth() {
        return this.f6794b;
    }

    public void setColor(int i) {
        this.f6793a = i;
        this.listener.b(this);
    }

    public void setPoints(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("start and middle and end points can not be same");
        }
        this.f6795c = latLng;
        this.f6796d = latLng2;
        this.f6797e = latLng3;
        this.listener.b(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.f6794b = i;
            this.listener.b(this);
        }
    }
}
