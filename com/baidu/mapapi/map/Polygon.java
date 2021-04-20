package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polygon extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public Stroke f7001a;

    /* renamed from: b  reason: collision with root package name */
    public int f7002b;

    /* renamed from: c  reason: collision with root package name */
    public List<LatLng> f7003c;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polygon;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7003c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.a(this.f7003c, bundle);
        Overlay.a(this.f7002b, bundle);
        if (this.f7001a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f7001a.a(new Bundle()));
        }
        return bundle;
    }

    public int getFillColor() {
        return this.f7002b;
    }

    public List<LatLng> getPoints() {
        return this.f7003c;
    }

    public Stroke getStroke() {
        return this.f7001a;
    }

    public void setFillColor(int i) {
        this.f7002b = i;
        this.listener.b(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        }
        int i = 0;
        while (i < list.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < list.size(); i3++) {
                if (list.get(i) == list.get(i3)) {
                    throw new IllegalArgumentException("points list can not has same points");
                }
            }
            i = i2;
        }
        this.f7003c = list;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.f7001a = stroke;
        this.listener.b(this);
    }
}
