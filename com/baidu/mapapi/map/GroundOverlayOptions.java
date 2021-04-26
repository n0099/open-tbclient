package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7137a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7139c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f7140d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f7141e;

    /* renamed from: f  reason: collision with root package name */
    public int f7142f;

    /* renamed from: g  reason: collision with root package name */
    public int f7143g;
    public LatLngBounds j;

    /* renamed from: h  reason: collision with root package name */
    public float f7144h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public float f7145i = 0.5f;
    public float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7138b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        int i2;
        LatLng latLng;
        int i3;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.x = this.f7138b;
        groundOverlay.w = this.f7137a;
        groundOverlay.y = this.f7139c;
        BitmapDescriptor bitmapDescriptor = this.f7140d;
        if (bitmapDescriptor != null) {
            groundOverlay.f7129b = bitmapDescriptor;
            if (this.j == null && (latLng = this.f7141e) != null) {
                int i4 = this.f7142f;
                if (i4 <= 0 || (i3 = this.f7143g) <= 0) {
                    throw new IllegalArgumentException("when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f7130c = latLng;
                groundOverlay.f7133f = this.f7144h;
                groundOverlay.f7134g = this.f7145i;
                groundOverlay.f7131d = i4;
                groundOverlay.f7132e = i3;
                i2 = 2;
            } else if (this.f7141e != null || (latLngBounds = this.j) == null) {
                throw new IllegalStateException("when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f7135h = latLngBounds;
                i2 = 1;
            }
            groundOverlay.f7128a = i2;
            groundOverlay.f7136i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f7144h = f2;
            this.f7145i = f3;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i2) {
        this.f7142f = i2;
        this.f7143g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        this.f7142f = i2;
        this.f7143g = i3;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f7139c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f7144h;
    }

    public float getAnchorY() {
        return this.f7145i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f7139c;
    }

    public int getHeight() {
        int i2 = this.f7143g;
        return i2 == Integer.MAX_VALUE ? (int) ((this.f7142f * this.f7140d.f7097a.getHeight()) / this.f7140d.f7097a.getWidth()) : i2;
    }

    public BitmapDescriptor getImage() {
        return this.f7140d;
    }

    public LatLng getPosition() {
        return this.f7141e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f7142f;
    }

    public int getZIndex() {
        return this.f7137a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7140d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("image can not be null");
    }

    public boolean isVisible() {
        return this.f7138b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7141e = latLng;
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
        this.f7138b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i2) {
        this.f7137a = i2;
        return this;
    }
}
