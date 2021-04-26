package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;
/* loaded from: classes2.dex */
public final class Polygon extends Overlay {

    /* renamed from: a  reason: collision with root package name */
    public Stroke f7248a;

    /* renamed from: b  reason: collision with root package name */
    public int f7249b;

    /* renamed from: c  reason: collision with root package name */
    public List<LatLng> f7250c;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polygon;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.f7250c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.a(this.f7250c, bundle);
        Overlay.a(this.f7249b, bundle);
        if (this.f7248a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.f7248a.a(new Bundle()));
        }
        return bundle;
    }

    public int getFillColor() {
        return this.f7249b;
    }

    public List<LatLng> getPoints() {
        return this.f7250c;
    }

    public Stroke getStroke() {
        return this.f7248a;
    }

    public void setFillColor(int i2) {
        this.f7249b = i2;
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
        int i2 = 0;
        while (i2 < list.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < list.size(); i4++) {
                if (list.get(i2) == list.get(i4)) {
                    throw new IllegalArgumentException("points list can not has same points");
                }
            }
            i2 = i3;
        }
        this.f7250c = list;
        this.listener.b(this);
    }

    public void setStroke(Stroke stroke) {
        this.f7248a = stroke;
        this.listener.b(this);
    }
}
