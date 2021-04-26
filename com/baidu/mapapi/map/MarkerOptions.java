package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f7231a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f7233c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f7234d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapDescriptor f7235e;
    public float j;
    public String k;
    public int l;
    public ArrayList<BitmapDescriptor> n;
    public Point u;

    /* renamed from: f  reason: collision with root package name */
    public float f7236f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f7237g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7238h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7239i = false;
    public boolean m = false;
    public int o = 20;
    public float p = 1.0f;
    public float q = 1.0f;
    public float r = 1.0f;
    public int s = MarkerAnimateType.none.ordinal();
    public boolean t = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7232b = true;

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
        marker.x = this.f7232b;
        marker.w = this.f7231a;
        marker.y = this.f7233c;
        LatLng latLng = this.f7234d;
        if (latLng != null) {
            marker.f7222a = latLng;
            if (this.f7235e == null && this.n == null) {
                throw new IllegalStateException("when you add marker, you must set the icon or icons");
            }
            marker.f7223b = this.f7235e;
            marker.f7224c = this.f7236f;
            marker.f7225d = this.f7237g;
            marker.f7226e = this.f7238h;
            marker.f7227f = this.f7239i;
            marker.f7228g = this.j;
            marker.f7229h = this.k;
            marker.f7230i = this.l;
            marker.j = this.m;
            marker.o = this.n;
            marker.p = this.o;
            marker.l = this.r;
            marker.r = this.p;
            marker.s = this.q;
            marker.m = this.s;
            marker.n = this.t;
            Point point = this.u;
            if (point != null) {
                marker.u = point;
            }
            return marker;
        }
        throw new IllegalStateException("when you add marker, you must set the position");
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
            this.f7236f = f2;
            this.f7237g = f3;
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
        this.f7239i = z;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.f7233c = bundle;
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
        return this.f7236f;
    }

    public float getAnchorY() {
        return this.f7237g;
    }

    public MarkerAnimateType getAnimateType() {
        int i2 = this.s;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
    }

    public Bundle getExtraInfo() {
        return this.f7233c;
    }

    public BitmapDescriptor getIcon() {
        return this.f7235e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.n;
    }

    public int getPeriod() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.f7234d;
    }

    public float getRotate() {
        return this.j;
    }

    public String getTitle() {
        return this.k;
    }

    public int getZIndex() {
        return this.f7231a;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f7235e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) == null || arrayList.get(i2).f7097a == null) {
                    return this;
                }
            }
            this.n = arrayList;
            return this;
        }
        throw new IllegalArgumentException("marker's icons can not be null");
    }

    public boolean isDraggable() {
        return this.f7239i;
    }

    public boolean isFlat() {
        return this.m;
    }

    public boolean isPerspective() {
        return this.f7238h;
    }

    public boolean isVisible() {
        return this.f7232b;
    }

    public MarkerOptions period(int i2) {
        if (i2 > 0) {
            this.o = i2;
            return this;
        }
        throw new IllegalArgumentException("marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean z) {
        this.f7238h = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f7234d = latLng;
            return this;
        }
        throw new IllegalArgumentException("marker's position can not be null");
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

    public MarkerOptions title(String str) {
        this.k = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f7232b = z;
        return this;
    }

    public MarkerOptions yOffset(int i2) {
        this.l = i2;
        return this;
    }

    public MarkerOptions zIndex(int i2) {
        this.f7231a = i2;
        return this;
    }
}
