package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes2.dex */
public final class Dot extends Overlay {
    public LatLng a;
    public int b;
    public int c;

    public Dot() {
        this.type = com.baidu.mapsdkplatform.comapi.map.i.g;
    }

    public LatLng getCenter() {
        return this.a;
    }

    public int getColor() {
        return this.b;
    }

    public int getRadius() {
        return this.c;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc(this.a);
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("radius", this.c);
        Overlay.a(this.b, bundle);
        return bundle;
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.a = latLng;
            this.listener.c(this);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
    }

    public void setColor(int i) {
        this.b = i;
        this.listener.c(this);
    }

    public void setRadius(int i) {
        if (i > 0) {
            this.c = i;
            this.listener.c(this);
        }
    }
}
