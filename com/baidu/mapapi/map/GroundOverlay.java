package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class GroundOverlay extends Overlay {
    public static final String j = "GroundOverlay";

    /* renamed from: a  reason: collision with root package name */
    public int f6854a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6855b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6856c;

    /* renamed from: d  reason: collision with root package name */
    public double f6857d;

    /* renamed from: e  reason: collision with root package name */
    public double f6858e;

    /* renamed from: f  reason: collision with root package name */
    public float f6859f;

    /* renamed from: g  reason: collision with root package name */
    public float f6860g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f6861h;
    public float i;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.f6855b.b());
        if (this.f6854a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f6861h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6861h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d2 = longitudeE62 - longitudeE6;
            this.f6857d = d2;
            double d3 = latitudeE62 - latitudeE6;
            this.f6858e = d3;
            this.f6856c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
            this.f6859f = 0.5f;
            this.f6860g = 0.5f;
        }
        double d4 = this.f6857d;
        if (d4 <= 0.0d || this.f6858e <= 0.0d) {
            throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d4);
        if (this.f6858e == 2.147483647E9d) {
            this.f6858e = (int) ((this.f6857d * this.f6855b.f6823a.getHeight()) / this.f6855b.f6823a.getWidth());
        }
        bundle.putDouble("y_distance", this.f6858e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f6856c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f6859f);
        bundle.putFloat("anchor_y", this.f6860g);
        bundle.putFloat("transparency", this.i);
        return bundle;
    }

    public float getAnchorX() {
        return this.f6859f;
    }

    public float getAnchorY() {
        return this.f6860g;
    }

    public LatLngBounds getBounds() {
        return this.f6861h;
    }

    public double getHeight() {
        return this.f6858e;
    }

    public BitmapDescriptor getImage() {
        return this.f6855b;
    }

    public LatLng getPosition() {
        return this.f6856c;
    }

    public float getTransparency() {
        return this.i;
    }

    public double getWidth() {
        return this.f6857d;
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6859f = f2;
        this.f6860g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i) {
        this.f6857d = i;
        this.f6858e = 2.147483647E9d;
        this.listener.b(this);
    }

    public void setDimensions(int i, int i2) {
        this.f6857d = i;
        this.f6858e = i2;
        this.listener.b(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("image can not be null");
        }
        this.f6855b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f6854a = 2;
        this.f6856c = latLng;
        this.listener.b(this);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("bounds can not be null");
        }
        this.f6854a = 1;
        this.f6861h = latLngBounds;
        this.listener.b(this);
    }

    public void setTransparency(float f2) {
        if (f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.i = f2;
        this.listener.b(this);
    }
}
