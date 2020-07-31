package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;
/* loaded from: classes10.dex */
public final class Polygon extends Overlay {
    Stroke a;
    int b;
    List<LatLng> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.polygon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.c.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        Overlay.a(this.c, bundle);
        Overlay.a(this.b, bundle);
        if (this.a == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.a.a(new Bundle()));
        }
        return bundle;
    }

    public int getFillColor() {
        return this.b;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.a;
    }

    public void setFillColor(int i) {
        this.b = i;
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
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.c = list;
                this.listener.b(this);
                return;
            }
            int i3 = i2 + 1;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    if (list.get(i2) == list.get(i4)) {
                        throw new IllegalArgumentException("points list can not has same points");
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public void setStroke(Stroke stroke) {
        this.a = stroke;
        this.listener.b(this);
    }
}
