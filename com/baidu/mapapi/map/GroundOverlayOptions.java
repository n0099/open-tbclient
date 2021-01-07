package com.baidu.mapapi.map;

import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
/* loaded from: classes3.dex */
public final class GroundOverlayOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    int f2819a;
    Bundle c;
    private BitmapDescriptor d;
    private LatLng e;
    private int f;
    private int g;
    private LatLngBounds j;
    private float h = 0.5f;
    private float i = 0.5f;
    private float k = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    boolean f2820b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        GroundOverlay groundOverlay = new GroundOverlay();
        groundOverlay.B = this.f2820b;
        groundOverlay.A = this.f2819a;
        groundOverlay.C = this.c;
        if (this.d == null) {
            throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
        }
        groundOverlay.f2818b = this.d;
        if (this.j != null || this.e == null) {
            if (this.e != null || this.j == null) {
                throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
            }
            groundOverlay.h = this.j;
            groundOverlay.f2817a = 1;
        } else if (this.f <= 0 || this.g <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
        } else {
            groundOverlay.c = this.e;
            groundOverlay.f = this.h;
            groundOverlay.g = this.i;
            groundOverlay.d = this.f;
            groundOverlay.e = this.g;
            groundOverlay.f2817a = 2;
        }
        groundOverlay.i = this.k;
        return groundOverlay;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.h = f;
            this.i = f2;
        }
        return this;
    }

    public GroundOverlayOptions dimensions(int i) {
        this.f = i;
        this.g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        return this;
    }

    public GroundOverlayOptions dimensions(int i, int i2) {
        this.f = i;
        this.g = i2;
        return this;
    }

    public GroundOverlayOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

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
        return this.g == Integer.MAX_VALUE ? (int) ((this.f * this.d.f2798a.getHeight()) / this.d.f2798a.getWidth()) : this.g;
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
        return this.f2819a;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: image can not be null");
        }
        this.d = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.f2820b;
    }

    public GroundOverlayOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.e = latLng;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
        }
        this.j = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        if (f <= 1.0f && f >= 0.0f) {
            this.k = f;
        }
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f2820b = z;
        return this;
    }

    public GroundOverlayOptions zIndex(int i) {
        this.f2819a = i;
        return this;
    }
}
