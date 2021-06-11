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
    public int f6883a;

    /* renamed from: b  reason: collision with root package name */
    public BitmapDescriptor f6884b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6885c;

    /* renamed from: d  reason: collision with root package name */
    public double f6886d;

    /* renamed from: e  reason: collision with root package name */
    public double f6887e;

    /* renamed from: f  reason: collision with root package name */
    public float f6888f;

    /* renamed from: g  reason: collision with root package name */
    public float f6889g;

    /* renamed from: h  reason: collision with root package name */
    public LatLngBounds f6890h;

    /* renamed from: i  reason: collision with root package name */
    public float f6891i;

    public GroundOverlay() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.ground;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        bundle.putBundle("image_info", this.f6884b.b());
        if (this.f6883a == 1) {
            GeoPoint ll2mc = CoordUtil.ll2mc(this.f6890h.southwest);
            double longitudeE6 = ll2mc.getLongitudeE6();
            double latitudeE6 = ll2mc.getLatitudeE6();
            GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6890h.northeast);
            double longitudeE62 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double d2 = longitudeE62 - longitudeE6;
            this.f6886d = d2;
            double d3 = latitudeE62 - latitudeE6;
            this.f6887e = d3;
            this.f6885c = CoordUtil.mc2ll(new GeoPoint(latitudeE6 + (d3 / 2.0d), longitudeE6 + (d2 / 2.0d)));
            this.f6888f = 0.5f;
            this.f6889g = 0.5f;
        }
        double d4 = this.f6886d;
        if (d4 <= 0.0d || this.f6887e <= 0.0d) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
        }
        bundle.putDouble("x_distance", d4);
        if (this.f6887e == 2.147483647E9d) {
            this.f6887e = (int) ((this.f6886d * this.f6884b.f6851a.getHeight()) / this.f6884b.f6851a.getWidth());
        }
        bundle.putDouble("y_distance", this.f6887e);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(this.f6885c);
        bundle.putDouble("location_x", ll2mc3.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc3.getLatitudeE6());
        bundle.putFloat("anchor_x", this.f6888f);
        bundle.putFloat("anchor_y", this.f6889g);
        bundle.putFloat("transparency", this.f6891i);
        return bundle;
    }

    public float getAnchorX() {
        return this.f6888f;
    }

    public float getAnchorY() {
        return this.f6889g;
    }

    public LatLngBounds getBounds() {
        return this.f6890h;
    }

    public double getHeight() {
        return this.f6887e;
    }

    public BitmapDescriptor getImage() {
        return this.f6884b;
    }

    public LatLng getPosition() {
        return this.f6885c;
    }

    public float getTransparency() {
        return this.f6891i;
    }

    public double getWidth() {
        return this.f6886d;
    }

    public void setAnchor(float f2, float f3) {
        if (f2 < 0.0f || f2 > 1.0f || f3 < 0.0f || f3 > 1.0f) {
            return;
        }
        this.f6888f = f2;
        this.f6889g = f3;
        this.listener.b(this);
    }

    public void setDimensions(int i2) {
        this.f6886d = i2;
        this.f6887e = 2.147483647E9d;
        this.listener.b(this);
    }

    public void setDimensions(int i2, int i3) {
        this.f6886d = i2;
        this.f6887e = i3;
        this.listener.b(this);
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.f6884b = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.f6883a = 2;
        this.f6885c = latLng;
        this.listener.b(this);
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.f6883a = 1;
        this.f6890h = latLngBounds;
        this.listener.b(this);
    }

    public void setTransparency(float f2) {
        if (f2 > 1.0f || f2 < 0.0f) {
            return;
        }
        this.f6891i = f2;
        this.listener.b(this);
    }
}
