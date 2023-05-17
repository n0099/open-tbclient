package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes3.dex */
public final class GroundOverlayOptions extends OverlayOptions {
    public int a;
    public Bundle c;
    public BitmapDescriptor d;
    public LatLng e;
    public int f;
    public int g;
    public LatLngBounds j;
    public float h = 0.5f;
    public float i = 0.5f;
    public float k = 1.0f;
    public boolean b = true;

    public float getAnchorX() {
        return this.h;
    }

    public float getAnchorY() {
        return this.i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public int getHeight() {
        int i = this.g;
        if (i == Integer.MAX_VALUE) {
            return (int) ((this.f * this.d.a.getHeight()) / this.d.a.getWidth());
        }
        return i;
    }

    public BitmapDescriptor getImage() {
        return this.d;
    }

    public LatLng getPosition() {
        return this.e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isVisible() {
        return this.b;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        LatLng latLng;
        int i;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.H = this.b;
        groundOverlay.G = this.a;
        groundOverlay.I = this.c;
        BitmapDescriptor bitmapDescriptor = this.d;
        if (bitmapDescriptor != null) {
            groundOverlay.b = bitmapDescriptor;
            if (this.j == null && (latLng = this.e) != null) {
                int i2 = this.f;
                if (i2 > 0 && (i = this.g) > 0) {
                    groundOverlay.c = latLng;
                    groundOverlay.f = this.h;
                    groundOverlay.g = this.i;
                    groundOverlay.d = i2;
                    groundOverlay.e = i;
                    groundOverlay.a = 2;
                } else {
                    throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                }
            } else if (this.e == null && (latLngBounds = this.j) != null) {
                groundOverlay.h = latLngBounds;
                groundOverlay.a = 1;
            } else {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            }
            groundOverlay.i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.h = f;
            this.i = f2;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i, int i2) {
        this.f = i;
        this.g = i2;
        return this;
    }

    public GroundOverlayOptions dimensions(int i) {
        this.f = i;
        this.g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.e = latLng;
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

    public GroundOverlayOptions transparency(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.k = f;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.a = i;
        return this;
    }
}
