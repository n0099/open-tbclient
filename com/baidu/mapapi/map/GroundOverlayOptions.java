package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6861a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6863c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f6864d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6865e;

    /* renamed from: f  reason: collision with root package name */
    public int f6866f;

    /* renamed from: g  reason: collision with root package name */
    public int f6867g;
    public LatLngBounds j;

    /* renamed from: h  reason: collision with root package name */
    public float f6868h = 0.5f;
    public float i = 0.5f;
    public float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6862b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        int i;
        LatLng latLng;
        int i2;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.x = this.f6862b;
        groundOverlay.w = this.f6861a;
        groundOverlay.y = this.f6863c;
        BitmapDescriptor bitmapDescriptor = this.f6864d;
        if (bitmapDescriptor != null) {
            groundOverlay.f6854b = bitmapDescriptor;
            if (this.j == null && (latLng = this.f6865e) != null) {
                int i3 = this.f6866f;
                if (i3 <= 0 || (i2 = this.f6867g) <= 0) {
                    throw new IllegalArgumentException("when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f6855c = latLng;
                groundOverlay.f6858f = this.f6868h;
                groundOverlay.f6859g = this.i;
                groundOverlay.f6856d = i3;
                groundOverlay.f6857e = i2;
                i = 2;
            } else if (this.f6865e != null || (latLngBounds = this.j) == null) {
                throw new IllegalStateException("when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f6860h = latLngBounds;
                i = 1;
            }
            groundOverlay.f6853a = i;
            groundOverlay.i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f6868h = f2;
            this.i = f3;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i) {
        this.f6866f = i;
        this.f6867g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions dimensions(int i, int i2) {
        this.f6866f = i;
        this.f6867g = i2;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f6863c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f6868h;
    }

    public float getAnchorY() {
        return this.i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f6863c;
    }

    public int getHeight() {
        int i = this.f6867g;
        return i == Integer.MAX_VALUE ? (int) ((this.f6866f * this.f6864d.f6822a.getHeight()) / this.f6864d.f6822a.getWidth()) : i;
    }

    public BitmapDescriptor getImage() {
        return this.f6864d;
    }

    public LatLng getPosition() {
        return this.f6865e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f6866f;
    }

    public int getZIndex() {
        return this.f6861a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f6864d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("image can not be null");
    }

    public boolean isVisible() {
        return this.f6862b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f6865e = latLng;
            return this;
        }
        throw new IllegalArgumentException("position can not be null");
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.j = latLngBounds;
            return this;
        }
        throw new IllegalArgumentException("bounds can not be null");
    }

    public GroundOverlayOptions transparency(float f2) {
        if (f2 <= 1.0f && f2 >= 0.0f) {
            this.k = f2;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f6862b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.f6861a = i;
        return this;
    }
}
