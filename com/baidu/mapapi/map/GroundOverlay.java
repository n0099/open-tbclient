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
    public int f6889a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6890b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6891c;

    /* renamed from: d  reason: collision with root package name */
    public double f6892d;

    /* renamed from: e  reason: collision with root package name */
    public double f6893e;

    /* renamed from: f  reason: collision with root package name */
    public float f6894f;

    /* renamed from: g  reason: collision with root package name */
    public float f6895g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f6896h;
    public float i;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.f6890b.b());
        if (this.f6889a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f6896h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6896h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d2 = longitudeE62 - longitudeE6;
            this.f6892d = d2;
            double d3 = latitudeE62 - latitudeE6;
            this.f6893e = d3;
            this.f6891c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
            this.f6894f = 0.5f;
            this.f6895g = 0.5f;
        }
        double d4 = this.f6892d;
        if (d4 <= 0.0d || this.f6893e <= 0.0d) {
            throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d4);
        if (this.f6893e == 2.147483647E9d) {
            this.f6893e = (int) ((this.f6892d * this.f6890b.f6858a.getHeight()) / this.f6890b.f6858a.getWidth());
        }
        bundle.putDouble("y_distance", this.f6893e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f6891c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f6894f);
        bundle.putFloat("anchor_y", this.f6895g);
        bundle.putFloat("transparency", this.i);
        return bundle;
    }

    public float getAnchorX() {
        return this.f6894f;
    }

    public float getAnchorY() {
        return this.f6895g;
    }

    public LatLngBounds getBounds() {
        return this.f6896h;
    }

    public double getHeight() {
        return this.f6893e;
    }

    public BitmapDescriptor getImage() {
        return this.f6890b;
    }

    public LatLng getPosition() {
        return this.f6891c;
    }

    public float getTransparency() {
        return this.i;
    }

    public double getWidth() {
        return this.f6892d;
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6894f = f2;
        this.f6895g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i) {
        this.f6892d = i;
        this.f6893e = 2.147483647E9d;
        this.listener.b(this);
    }

    public void setDimensions(int i, int i2) {
        this.f6892d = i;
        this.f6893e = i2;
        this.listener.b(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("image can not be null");
        }
        this.f6890b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f6889a = 2;
        this.f6891c = latLng;
        this.listener.b(this);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("bounds can not be null");
        }
        this.f6889a = 1;
        this.f6896h = latLngBounds;
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
