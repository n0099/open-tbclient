package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes2.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new p();
    public com.baidu.mapsdkplatform.comapi.map.x a;
    public double b;
    public final LatLngBounds bound;
    public double c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public float a;
        public LatLng b;
        public float c;
        public float d;
        public Point e;
        public LatLngBounds f;
        public double g;
        public double h;
        public final float i;

        private float a(float f) {
            if (15.0f == f) {
                return 15.5f;
            }
            return f;
        }

        public Builder() {
            this.a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
        }

        public MapStatus build() {
            return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder(MapStatus mapStatus) {
            this.a = -2.1474836E9f;
            this.b = null;
            this.c = -2.1474836E9f;
            this.d = -2.1474836E9f;
            this.e = null;
            this.f = null;
            this.g = 0.0d;
            this.h = 0.0d;
            this.i = 15.0f;
            this.a = mapStatus.rotate;
            this.b = mapStatus.target;
            this.c = mapStatus.overlook;
            this.d = mapStatus.zoom;
            this.e = mapStatus.targetScreen;
            this.g = mapStatus.a();
            this.h = mapStatus.b();
        }

        public Builder overlook(float f) {
            this.c = f;
            return this;
        }

        public Builder rotate(float f) {
            this.a = f;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.e = point;
            return this;
        }

        public Builder zoom(float f) {
            this.d = a(f);
            return this;
        }
    }

    public double a() {
        return this.b;
    }

    public double b() {
        return this.c;
    }

    public com.baidu.mapsdkplatform.comapi.map.x c() {
        return b(new com.baidu.mapsdkplatform.comapi.map.x());
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, double d, double d2, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        if (latLng != null) {
            this.b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, com.baidu.mapsdkplatform.comapi.map.x xVar, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.a = xVar;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    public MapStatus(Parcel parcel) {
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
    }

    public static MapStatus a(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        if (xVar == null) {
            return null;
        }
        float f = xVar.b;
        double d = xVar.e;
        double d2 = xVar.d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
        float f2 = xVar.c;
        float f3 = xVar.a;
        Point point = new Point(xVar.f, xVar.g);
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(xVar.k.e.getDoubleY(), xVar.k.e.getDoubleX()));
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(xVar.k.f.getDoubleY(), xVar.k.f.getDoubleX()));
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(xVar.k.h.getDoubleY(), xVar.k.h.getDoubleX()));
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(xVar.k.g.getDoubleY(), xVar.k.g.getDoubleX()));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f, mc2ll, f2, f3, point, xVar, d2, d, builder.build(), xVar.j);
    }

    public com.baidu.mapsdkplatform.comapi.map.x b(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        if (xVar == null) {
            return null;
        }
        float f = this.rotate;
        if (f != -2.1474836E9f) {
            xVar.b = (int) f;
        }
        float f2 = this.zoom;
        if (f2 != -2.1474836E9f) {
            xVar.a = f2;
        }
        float f3 = this.overlook;
        if (f3 != -2.1474836E9f) {
            xVar.c = (int) f3;
        }
        if (this.target != null) {
            xVar.d = this.b;
            xVar.e = this.c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            xVar.f = point.x;
            xVar.g = point.y;
        }
        return xVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.target != null) {
            sb.append("target lat: " + this.target.latitude + "\n");
            sb.append("target lng: " + this.target.longitude + "\n");
        }
        if (this.targetScreen != null) {
            sb.append("target screen x: " + this.targetScreen.x + "\n");
            sb.append("target screen y: " + this.targetScreen.y + "\n");
        }
        sb.append("zoom: " + this.zoom + "\n");
        sb.append("rotate: " + this.rotate + "\n");
        sb.append("overlook: " + this.overlook + "\n");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i);
        parcel.writeParcelable(this.bound, i);
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
    }
}
