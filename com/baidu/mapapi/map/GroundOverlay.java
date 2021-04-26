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
    public int f7128a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f7129b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7130c;

    /* renamed from: d  reason: collision with root package name */
    public double f7131d;

    /* renamed from: e  reason: collision with root package name */
    public double f7132e;

    /* renamed from: f  reason: collision with root package name */
    public float f7133f;

    /* renamed from: g  reason: collision with root package name */
    public float f7134g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f7135h;

    /* renamed from: i  reason: collision with root package name */
    public float f7136i;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.f7129b.b());
        if (this.f7128a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f7135h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f7135h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d2 = longitudeE62 - longitudeE6;
            this.f7131d = d2;
            double d3 = latitudeE62 - latitudeE6;
            this.f7132e = d3;
            this.f7130c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
            this.f7133f = 0.5f;
            this.f7134g = 0.5f;
        }
        double d4 = this.f7131d;
        if (d4 <= 0.0d || this.f7132e <= 0.0d) {
            throw new IllegalStateException("when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d4);
        if (this.f7132e == 2.147483647E9d) {
            this.f7132e = (int) ((this.f7131d * this.f7129b.f7097a.getHeight()) / this.f7129b.f7097a.getWidth());
        }
        bundle.putDouble("y_distance", this.f7132e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f7130c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f7133f);
        bundle.putFloat("anchor_y", this.f7134g);
        bundle.putFloat("transparency", this.f7136i);
        return bundle;
    }

    public float getAnchorX() {
        return this.f7133f;
    }

    public float getAnchorY() {
        return this.f7134g;
    }

    public LatLngBounds getBounds() {
        return this.f7135h;
    }

    public double getHeight() {
        return this.f7132e;
    }

    public BitmapDescriptor getImage() {
        return this.f7129b;
    }

    public LatLng getPosition() {
        return this.f7130c;
    }

    public float getTransparency() {
        return this.f7136i;
    }

    public double getWidth() {
        return this.f7131d;
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f7133f = f2;
        this.f7134g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i2) {
        this.f7131d = i2;
        this.f7132e = 2.147483647E9d;
        this.listener.b(this);
    }

    public void setDimensions(int i2, int i3) {
        this.f7131d = i2;
        this.f7132e = i3;
        this.listener.b(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("image can not be null");
        }
        this.f7129b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("position can not be null");
        }
        this.f7128a = 2;
        this.f7130c = latLng;
        this.listener.b(this);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("bounds can not be null");
        }
        this.f7128a = 1;
        this.f7135h = latLngBounds;
        this.listener.b(this);
    }

    public void setTransparency(float f2) {
        if (f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.f7136i = f2;
        this.listener.b(this);
    }
}
