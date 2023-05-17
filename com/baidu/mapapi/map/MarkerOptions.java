package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class MarkerOptions extends OverlayOptions {
    public int a;
    public Bundle c;
    public LatLng d;
    public BitmapDescriptor e;
    public float j;
    public String k;
    public int l;
    public ArrayList<BitmapDescriptor> n;
    public Point v;
    public InfoWindow x;
    public float f = 0.5f;
    public float g = 1.0f;
    public boolean h = true;
    public boolean i = false;
    public boolean m = false;
    public int o = 20;
    public float p = 1.0f;
    public float q = 1.0f;
    public float r = 1.0f;
    public int s = 0;
    public int t = MarkerAnimateType.none.ordinal();
    public boolean u = false;
    public boolean w = true;
    public int y = Integer.MAX_VALUE;
    public boolean z = false;
    public int A = 4;
    public int B = 22;
    public boolean C = false;
    public boolean b = true;

    /* loaded from: classes3.dex */
    public enum MarkerAnimateType {
        none,
        drop,
        grow,
        jump
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Marker marker = new Marker();
        marker.H = this.b;
        marker.G = this.a;
        marker.I = this.c;
        LatLng latLng = this.d;
        if (latLng != null) {
            marker.a = latLng;
            if (this.e == null && this.n == null) {
                throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the icon or icons");
            }
            marker.b = this.e;
            marker.c = this.f;
            marker.d = this.g;
            marker.e = this.h;
            marker.f = this.i;
            marker.g = this.j;
            marker.h = this.k;
            marker.i = this.l;
            marker.j = this.m;
            marker.s = this.n;
            marker.t = this.o;
            marker.l = this.r;
            marker.r = this.s;
            marker.v = this.p;
            marker.w = this.q;
            marker.m = this.t;
            marker.n = this.u;
            marker.z = this.x;
            marker.o = this.w;
            marker.C = this.y;
            marker.q = this.z;
            marker.D = this.A;
            marker.E = this.B;
            marker.p = this.C;
            Point point = this.v;
            if (point != null) {
                marker.y = point;
            }
            return marker;
        }
        throw new IllegalStateException("BDMapSDKException: when you add marker, you must set the position");
    }

    public MarkerOptions alpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.r = f;
            return this;
        }
        this.r = 1.0f;
        return this;
    }

    public MarkerOptions animateType(MarkerAnimateType markerAnimateType) {
        if (markerAnimateType == null) {
            markerAnimateType = MarkerAnimateType.none;
        }
        this.t = markerAnimateType.ordinal();
        return this;
    }

    public MarkerOptions clickable(boolean z) {
        this.w = z;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.i = z;
        return this;
    }

    public MarkerOptions endLevel(int i) {
        this.B = i;
        return this;
    }

    public MarkerOptions extraInfo(Bundle bundle) {
        this.c = bundle;
        return this;
    }

    public MarkerOptions fixedScreenPosition(Point point) {
        this.v = point;
        this.u = true;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.m = z;
        return this;
    }

    public MarkerOptions height(int i) {
        if (i < 0) {
            this.s = 0;
            return this;
        }
        this.s = i;
        return this;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.e = bitmapDescriptor;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                return this;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) == null || arrayList.get(i).a == null) {
                    return this;
                }
            }
            this.n = arrayList;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
    }

    public MarkerOptions infoWindow(InfoWindow infoWindow) {
        this.x = infoWindow;
        return this;
    }

    public MarkerOptions isForceDisPlay(boolean z) {
        this.z = z;
        return this;
    }

    public MarkerOptions isJoinCollision(boolean z) {
        this.C = z;
        return this;
    }

    public MarkerOptions period(int i) {
        if (i > 0) {
            this.o = i;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
    }

    public MarkerOptions perspective(boolean z) {
        this.h = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng != null) {
            this.d = latLng;
            return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
    }

    public MarkerOptions priority(int i) {
        this.y = i;
        return this;
    }

    public MarkerOptions rotate(float f) {
        while (f < 0.0f) {
            f += 360.0f;
        }
        this.j = f % 360.0f;
        return this;
    }

    public MarkerOptions scaleX(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.p = f;
        return this;
    }

    public MarkerOptions scaleY(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.q = f;
        return this;
    }

    public MarkerOptions startLevel(int i) {
        this.A = i;
        return this;
    }

    @Deprecated
    public MarkerOptions title(String str) {
        this.k = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.b = z;
        return this;
    }

    public MarkerOptions yOffset(int i) {
        this.l = i;
        return this;
    }

    public MarkerOptions zIndex(int i) {
        this.a = i;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.f = f;
            this.g = f2;
        }
        return this;
    }

    public float getAlpha() {
        return this.r;
    }

    public float getAnchorX() {
        return this.f;
    }

    public float getAnchorY() {
        return this.g;
    }

    public MarkerAnimateType getAnimateType() {
        int i = this.t;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return MarkerAnimateType.none;
                }
                return MarkerAnimateType.jump;
            }
            return MarkerAnimateType.grow;
        }
        return MarkerAnimateType.drop;
    }

    public int getEndLevel() {
        return this.B;
    }

    public Bundle getExtraInfo() {
        return this.c;
    }

    public boolean getForceDisPlay() {
        return this.z;
    }

    public int getHeight() {
        return this.s;
    }

    public BitmapDescriptor getIcon() {
        return this.e;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.n;
    }

    public boolean getIsClickable() {
        return this.w;
    }

    public boolean getJoinCollision() {
        return this.C;
    }

    public int getPeriod() {
        return this.o;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public int getPriority() {
        return this.y;
    }

    public float getRotate() {
        return this.j;
    }

    public int getStartLevel() {
        return this.A;
    }

    @Deprecated
    public String getTitle() {
        return this.k;
    }

    public int getZIndex() {
        return this.a;
    }

    public boolean isDraggable() {
        return this.i;
    }

    public boolean isFlat() {
        return this.m;
    }

    public boolean isPerspective() {
        return this.h;
    }

    public boolean isVisible() {
        return this.b;
    }
}
