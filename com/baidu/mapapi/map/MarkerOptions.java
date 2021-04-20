package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class MarkerOptions extends OverlayOptions {

    /* renamed from: a  reason: collision with root package name */
    public int f6985a;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f6987c;

    /* renamed from: d  reason: collision with root package name */
    public LatLng f6988d;

    /* renamed from: e  reason: collision with root package name */
    public BitmapDescriptor f6989e;
    public float j;
    public String k;
    public int l;
    public ArrayList<BitmapDescriptor> n;
    public Point u;

    /* renamed from: f  reason: collision with root package name */
    public float f6990f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f6991g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6992h = true;
    public boolean i = false;
    public boolean m = false;
    public int o = 20;
    public float p = 1.0f;
    public float q = 1.0f;
    public float r = 1.0f;
    public int s = MarkerAnimateType.none.ordinal();
    public boolean t = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6986b = true;

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
        marker.x = this.f6986b;
        marker.w = this.f6985a;
        marker.y = this.f6987c;
        LatLng latLng = this.f6988d;
        if (latLng != null) {
            marker.f6977a = latLng;
            if (this.f6989e == null && this.n == null) {
                throw new IllegalStateException("when you add marker, you must set the icon or icons");
            }
            marker.f6978b = this.f6989e;
            marker.f6979c = this.f6990f;
            marker.f6980d = this.f6991g;
            marker.f6981e = this.f6992h;
            marker.f6982f = this.i;
            marker.f6983g = this.j;
            marker.f6984h = this.k;
            marker.i = this.l;
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
            this.f6990f = f2;
            this.f6991g = f3;
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
        this.i = z;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.f6987c = bundle;
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
        return this.f6990f;
    }

    public float getAnchorY() {
        return this.f6991g;
    }

    public MarkerAnimateType getAnimateType() {
        int i = this.s;
        return i != 1 ? i != 2 ? i != 3 ? MarkerAnimateType.none : MarkerAnimateType.jump : MarkerAnimateType.grow : MarkerAnimateType.drop;
    }

    public Bundle getExtraInfo() {
        return this.f6987c;
    }

    public BitmapDescriptor getIcon() {
        return this.f6989e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.n;
    }

    public int getPeriod() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.f6988d;
    }

    public float getRotate() {
        return this.j;
    }

    public String getTitle() {
        return this.k;
    }

    public int getZIndex() {
        return this.f6985a;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f6989e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).f6858a == null) {
                    return this;
                }
            }
            this.n = arrayList;
            return this;
        }
        throw new IllegalArgumentException("marker's icons can not be null");
    }

    public boolean isDraggable() {
        return this.i;
    }

    public boolean isFlat() {
        return this.m;
    }

    public boolean isPerspective() {
        return this.f6992h;
    }

    public boolean isVisible() {
        return this.f6986b;
    }

    public MarkerOptions period(int i) {
        if (i > 0) {
            this.o = i;
            return this;
        }
        throw new IllegalArgumentException("marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean z) {
        this.f6992h = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.f6988d = latLng;
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
        this.f6986b = z;
        return this;
    }

    public MarkerOptions yOffset(int i) {
        this.l = i;
        return this;
    }

    public MarkerOptions zIndex(int i) {
        this.f6985a = i;
        return this;
    }
}
