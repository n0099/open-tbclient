package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6949a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6951c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f6952d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6953e;

    /* renamed from: f  reason: collision with root package name */
    public int f6954f;

    /* renamed from: g  reason: collision with root package name */
    public int f6955g;
    public LatLngBounds j;

    /* renamed from: h  reason: collision with root package name */
    public float f6956h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public float f6957i = 0.5f;
    public float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6950b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        int i2;
        LatLng latLng;
        int i3;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.A = this.f6950b;
        groundOverlay.z = this.f6949a;
        groundOverlay.B = this.f6951c;
        BitmapDescriptor bitmapDescriptor = this.f6952d;
        if (bitmapDescriptor != null) {
            groundOverlay.f6941b = bitmapDescriptor;
            if (this.j == null && (latLng = this.f6953e) != null) {
                int i4 = this.f6954f;
                if (i4 <= 0 || (i3 = this.f6955g) <= 0) {
                    throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f6942c = latLng;
                groundOverlay.f6945f = this.f6956h;
                groundOverlay.f6946g = this.f6957i;
                groundOverlay.f6943d = i4;
                groundOverlay.f6944e = i3;
                i2 = 2;
            } else if (this.f6953e != null || (latLngBounds = this.j) == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f6947h = latLngBounds;
                i2 = 1;
            }
            groundOverlay.f6940a = i2;
            groundOverlay.f6948i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f6956h = f2;
            this.f6957i = f3;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i2) {
        this.f6954f = i2;
        this.f6955g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        this.f6954f = i2;
        this.f6955g = i3;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f6951c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f6956h;
    }

    public float getAnchorY() {
        return this.f6957i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f6951c;
    }

    public int getHeight() {
        int i2 = this.f6955g;
        return i2 == Integer.MAX_VALUE ? (int) ((this.f6954f * this.f6952d.f6908a.getHeight()) / this.f6952d.f6908a.getWidth()) : i2;
    }

    public BitmapDescriptor getImage() {
        return this.f6952d;
    }

    public LatLng getPosition() {
        return this.f6953e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f6954f;
    }

    public int getZIndex() {
        return this.f6949a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f6952d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public boolean isVisible() {
        return this.f6950b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f6953e = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: position can not be null");
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.j = latLngBounds;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
    }

    public GroundOverlayOptions transparency(float f2) {
        if (f2 <= 1.0f && f2 >= 0.0f) {
            this.k = f2;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f6950b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i2) {
        this.f6949a = i2;
        return this;
    }
}
