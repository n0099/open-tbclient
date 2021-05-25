package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6849a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6851c;

    /* renamed from: d  reason: collision with root package name */
    public BitmapDescriptor f6852d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f6853e;

    /* renamed from: f  reason: collision with root package name */
    public int f6854f;

    /* renamed from: g  reason: collision with root package name */
    public int f6855g;
    public LatLngBounds j;

    /* renamed from: h  reason: collision with root package name */
    public float f6856h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    public float f6857i = 0.5f;
    public float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6850b = true;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        LatLngBounds latLngBounds;
        int i2;
        LatLng latLng;
        int i3;
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.A = this.f6850b;
        groundOverlay.z = this.f6849a;
        groundOverlay.B = this.f6851c;
        BitmapDescriptor bitmapDescriptor = this.f6852d;
        if (bitmapDescriptor != null) {
            groundOverlay.f6841b = bitmapDescriptor;
            if (this.j == null && (latLng = this.f6853e) != null) {
                int i4 = this.f6854f;
                if (i4 <= 0 || (i3 = this.f6855g) <= 0) {
                    throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
                }
                groundOverlay.f6842c = latLng;
                groundOverlay.f6845f = this.f6856h;
                groundOverlay.f6846g = this.f6857i;
                groundOverlay.f6843d = i4;
                groundOverlay.f6844e = i3;
                i2 = 2;
            } else if (this.f6853e != null || (latLngBounds = this.j) == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            } else {
                groundOverlay.f6847h = latLngBounds;
                i2 = 1;
            }
            groundOverlay.f6840a = i2;
            groundOverlay.f6848i = this.k;
            return groundOverlay;
        }
        throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
    }

    public GroundOverlayOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f6856h = f2;
            this.f6857i = f3;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i2) {
        this.f6854f = i2;
        this.f6855g = Integer.MAX_VALUE;
        return this;
    }

    public GroundOverlayOptions dimensions(int i2, int i3) {
        this.f6854f = i2;
        this.f6855g = i3;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.f6851c = bundle;
        return this;
    }

    public float getAnchorX() {
        return this.f6856h;
    }

    public float getAnchorY() {
        return this.f6857i;
    }

    public LatLngBounds getBounds() {
        return this.j;
    }

    public Bundle getExtraInfo() {
        return this.f6851c;
    }

    public int getHeight() {
        int i2 = this.f6855g;
        return i2 == Integer.MAX_VALUE ? (int) ((this.f6854f * this.f6852d.f6808a.getHeight()) / this.f6852d.f6808a.getWidth()) : i2;
    }

    public BitmapDescriptor getImage() {
        return this.f6852d;
    }

    public LatLng getPosition() {
        return this.f6853e;
    }

    public float getTransparency() {
        return this.k;
    }

    public int getWidth() {
        return this.f6854f;
    }

    public int getZIndex() {
        return this.f6849a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f6852d = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: image can not be null");
    }

    public boolean isVisible() {
        return this.f6850b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f6853e = latLng;
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
        this.f6850b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i2) {
        this.f6849a = i2;
        return this;
    }
}
