package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7047a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7049c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7050d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapDescriptor f7051e;
    public float j;
    public String k;
    public int l;
    public ArrayList<BitmapDescriptor> n;
    public Point u;
    public InfoWindow v;

    /* renamed from: f  reason: collision with root package name */
    public float f7052f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f7053g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7054h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7055i = false;
    public boolean m = false;
    public int o = 20;
    public float p = 1.0f;
    public float q = 1.0f;
    public float r = 1.0f;
    public int s = MarkerAnimateType.none.ordinal();
    public boolean t = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7048b = true;

    /* loaded from: classes2.dex */
    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Marker marker = new Marker();
        marker.A = this.f7048b;
        marker.z = this.f7047a;
        marker.B = this.f7049c;
        LatLng latLng = this.f7050d;
        if (latLng != null) {
            marker.f7038a = latLng;
            if (this.f7051e == null && this.n == null) {
                throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
            }
            marker.f7039b = this.f7051e;
            marker.f7040c = this.f7052f;
            marker.f7041d = this.f7053g;
            marker.f7042e = this.f7054h;
            marker.f7043f = this.f7055i;
            marker.f7044g = this.j;
            marker.f7045h = this.k;
            marker.f7046i = this.l;
            marker.j = this.m;
            marker.o = this.n;
            marker.p = this.o;
            marker.l = this.r;
            marker.r = this.p;
            marker.s = this.q;
            marker.m = this.s;
            marker.n = this.t;
            marker.v = this.v;
            Point point = this.u;
            if (point != null) {
                marker.u = point;
            }
            return marker;
        }
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
    }

    public MarkerOptions alpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            this.r = 1.0f;
            return this;
        }
        this.r = f2;
        return this;
    }

    public MarkerOptions anchor(float f2, float f3) {
        if (f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f) {
            this.f7052f = f2;
            this.f7053g = f3;
        }
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.s = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f7055i = z;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.f7049c = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.u = point;
        this.t = true;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.m = z;
        return this;
    }

    public float getAlpha() {
        return this.r;
    }

    public float getAnchorX() {
        return this.f7052f;
    }

    public float getAnchorY() {
        return this.f7053g;
    }

    public MarkerAnimateType getAnimateType() {
        int i2 = this.s;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
    }

    public Bundle getExtraInfo() {
        return this.f7049c;
    }

    public BitmapDescriptor getIcon() {
        return this.f7051e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.n;
    }

    public int getPeriod() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.f7050d;
    }

    public float getRotate() {
        return this.j;
    }

    @Deprecated
    public String getTitle() {
        return this.k;
    }

    public int getZIndex() {
        return this.f7047a;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7051e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) == null || arrayList.get(i2).f6908a == null) {
                    return this;
                }
            }
            this.n = arrayList;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        this.v = infoWindow;
        return this;
    }

    public boolean isDraggable() {
        return this.f7055i;
    }

    public boolean isFlat() {
        return this.m;
    }

    public boolean isPerspective() {
        return this.f7054h;
    }

    public boolean isVisible() {
        return this.f7048b;
    }

    public MarkerOptions period(int i2) {
        if (i2 > 0) {
            this.o = i2;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean z) {
        this.f7054h = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7050d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public MarkerOptions rotate(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        this.j = f2 % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f2) {
        if (f2 < 0.0f) {
            return this;
        }
        this.p = f2;
        return this;
    }

    public MarkerOptions scaleY(float f2) {
        if (f2 < 0.0f) {
            return this;
        }
        this.q = f2;
        return this;
    }

    @Deprecated
    public MarkerOptions title(String str) {
        this.k = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f7048b = z;
        return this;
    }

    public MarkerOptions yOffset(int i2) {
        this.l = i2;
        return this;
    }

    public MarkerOptions zIndex(int i2) {
        this.f7047a = i2;
        return this;
    }
}
