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
    public int f6853a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6854b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6855c;

    /* renamed from: d  reason: collision with root package name */
    public double f6856d;

    /* renamed from: e  reason: collision with root package name */
    public double f6857e;

    /* renamed from: f  reason: collision with root package name */
    public float f6858f;

    /* renamed from: g  reason: collision with root package name */
    public float f6859g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f6860h;
    public float i;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        double d2;
        super.a(bundle);
        bundle.putBundle("image_info", this.f6854b.b());
        if (this.f6853a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f6860h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6860h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d3 = longitudeE62 - longitudeE6;
            this.f6856d = d3;
            double d4 = latitudeE62 - latitudeE6;
            this.f6857e = d4;
            this.f6855c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d4 / 2.0d), longitudeE6 + (d3 / 2.0d)));
            this.f6858f = 0.5f;
            this.f6859g = 0.5f;
        }
        double d5 = this.f6856d;
        if (d5 <= 0.0d || this.f6857e <= 0.0d) {
            throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d5);
        if (this.f6857e == 2.147483647E9d) {
            double d6 = this.f6856d;
            double height = this.f6854b.f6822a.getHeight();
            Double.isNaN(height);
            double d7 = d6 * height;
            Double.isNaN(this.f6854b.f6822a.getWidth());
            this.f6857e = (int) (d7 / d2);
        }
        bundle.putDouble("y_distance", this.f6857e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f6855c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f6858f);
        bundle.putFloat("anchor_y", this.f6859g);
        bundle.putFloat("transparency", this.i);
        return bundle;
    }

    public float getAnchorX() {
        return this.f6858f;
    }

    public float getAnchorY() {
        return this.f6859g;
    }

    public LatLngBounds getBounds() {
        return this.f6860h;
    }

    public double getHeight() {
        return this.f6857e;
    }

    public BitmapDescriptor getImage() {
        return this.f6854b;
    }

    public LatLng getPosition() {
        return this.f6855c;
    }

    public float getTransparency() {
        return this.i;
    }

    public double getWidth() {
        return this.f6856d;
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6858f = f2;
        this.f6859g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i) {
        this.f6856d = i;
        this.f6857e = 2.147483647E9d;
        this.listener.b(this);
    }

    public void setDimensions(int i, int i2) {
        this.f6856d = i;
        this.f6857e = i2;
        this.listener.b(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("image can not be null");
        }
        this.f6854b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f6853a = 2;
        this.f6855c = latLng;
        this.listener.b(this);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("bounds can not be null");
        }
        this.f6853a = 1;
        this.f6860h = latLngBounds;
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
