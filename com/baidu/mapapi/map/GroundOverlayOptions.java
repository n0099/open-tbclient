package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6892a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6894c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f6895d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6896e;

    /* renamed from: f  reason: collision with root package name */
    public int f6897f;

    /* renamed from: g  reason: collision with root package name */
    public int f6898g;
    public LatLngBounds j;

    /* renamed from: h  reason: collision with root package name */
    public float f6899h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public float f6900i = 0.5f;
    public float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6893b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        int i2;
        LatLng latLng;
        int i3;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.A = this.f6893b;
        groundOverlay.z = this.f6892a;
        groundOverlay.B = this.f6894c;
        BitmapDescriptor bitmapDescriptor = this.f6895d;
        if (bitmapDescriptor != null) {
            groundOverlay.f6884b = bitmapDescriptor;
            if (this.j == null && (latLng = this.f6896e) != null) {
                int i4 = this.f6897f;
                if (i4 <= 0 || (i3 = this.f6898g) <= 0) {
                    throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f6885c = latLng;
                groundOverlay.f6888f = this.f6899h;
                groundOverlay.f6889g = this.f6900i;
                groundOverlay.f6886d = i4;
                groundOverlay.f6887e = i3;
                i2 = 2;
            } else if (this.f6896e != null || (latLngBounds = this.j) == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f6890h = latLngBounds;
                i2 = 1;
            }
            groundOverlay.f6883a = i2;
            groundOverlay.f6891i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f6899h = f2;
            this.f6900i = f3;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i2) {
        this.f6897f = i2;
        this.f6898g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        this.f6897f = i2;
        this.f6898g = i3;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f6894c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f6899h;
    }

    public float getAnchorY() {
        return this.f6900i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f6894c;
    }

    public int getHeight() {
        int i2 = this.f6898g;
        return i2 == Integer.MAX_VALUE ? (int) ((this.f6897f * this.f6895d.f6851a.getHeight()) / this.f6895d.f6851a.getWidth()) : i2;
    }

    public BitmapDescriptor getImage() {
        return this.f6895d;
    }

    public LatLng getPosition() {
        return this.f6896e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f6897f;
    }

    public int getZIndex() {
        return this.f6892a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f6895d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public boolean isVisible() {
        return this.f6893b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f6896e = latLng;
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
        this.f6893b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i2) {
        this.f6892a = i2;
        return this;
    }
}
