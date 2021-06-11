package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public ab f6937a;

    /* renamed from: b  reason: collision with root package name */
    public double f6938b;
    public final LatLngBounds bound;

    /* renamed from: c  reason: collision with root package name */
    public double f6939c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public float f6940a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f6941b;

        /* renamed from: c  reason: collision with root package name */
        public float f6942c;

        /* renamed from: d  reason: collision with root package name */
        public float f6943d;

        /* renamed from: e  reason: collision with root package name */
        public Point f6944e;

        /* renamed from: f  reason: collision with root package name */
        public LatLngBounds f6945f;

        /* renamed from: g  reason: collision with root package name */
        public double f6946g;

        /* renamed from: h  reason: collision with root package name */
        public double f6947h;

        /* renamed from: i  reason: collision with root package name */
        public final float f6948i;

        public Builder() {
            this.f6940a = -2.1474836E9f;
            this.f6941b = null;
            this.f6942c = -2.1474836E9f;
            this.f6943d = -2.1474836E9f;
            this.f6944e = null;
            this.f6945f = null;
            this.f6946g = 0.0d;
            this.f6947h = 0.0d;
            this.f6948i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            this.f6940a = -2.1474836E9f;
            this.f6941b = null;
            this.f6942c = -2.1474836E9f;
            this.f6943d = -2.1474836E9f;
            this.f6944e = null;
            this.f6945f = null;
            this.f6946g = 0.0d;
            this.f6947h = 0.0d;
            this.f6948i = 15.0f;
            this.f6940a = mapStatus.rotate;
            this.f6941b = mapStatus.target;
            this.f6942c = mapStatus.overlook;
            this.f6943d = mapStatus.zoom;
            this.f6944e = mapStatus.targetScreen;
            this.f6946g = mapStatus.a();
            this.f6947h = mapStatus.b();
        }

        private float a(float f2) {
            if (15.0f == f2) {
                return 15.5f;
            }
            return f2;
        }

        public MapStatus build() {
            return new MapStatus(this.f6940a, this.f6941b, this.f6942c, this.f6943d, this.f6944e, this.f6945f);
        }

        public Builder overlook(float f2) {
            this.f6942c = f2;
            return this;
        }

        public Builder rotate(float f2) {
            this.f6940a = f2;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.f6941b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.f6944e = point;
            return this;
        }

        public Builder zoom(float f2) {
            this.f6943d = a(f2);
            return this;
        }
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, double d2, double d3, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6938b = d2;
        this.f6939c = d3;
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        if (latLng != null) {
            this.f6938b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f6939c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, ab abVar, double d2, double d3, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6937a = abVar;
        this.f6938b = d2;
        this.f6939c = d3;
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
        this.f6938b = parcel.readDouble();
        this.f6939c = parcel.readDouble();
    }

    public static MapStatus a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = abVar.f7615b;
        double d2 = abVar.f7618e;
        double d3 = abVar.f7617d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d2, d3));
        float f3 = abVar.f7616c;
        float f4 = abVar.f7614a;
        Point point = new Point(abVar.f7619f, abVar.f7620g);
        com.baidu.mapapi.model.inner.Point point2 = abVar.k.f7627e;
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(point2.y, point2.x));
        com.baidu.mapapi.model.inner.Point point3 = abVar.k.f7628f;
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(point3.y, point3.x));
        com.baidu.mapapi.model.inner.Point point4 = abVar.k.f7630h;
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(point4.y, point4.x));
        com.baidu.mapapi.model.inner.Point point5 = abVar.k.f7629g;
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(point5.y, point5.x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f2, mc2ll, f3, f4, point, abVar, d3, d2, builder.build(), abVar.j);
    }

    public double a() {
        return this.f6938b;
    }

    public double b() {
        return this.f6939c;
    }

    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = this.rotate;
        if (f2 != -2.1474836E9f) {
            abVar.f7615b = (int) f2;
        }
        float f3 = this.zoom;
        if (f3 != -2.1474836E9f) {
            abVar.f7614a = f3;
        }
        float f4 = this.overlook;
        if (f4 != -2.1474836E9f) {
            abVar.f7616c = (int) f4;
        }
        if (this.target != null) {
            abVar.f7617d = this.f6938b;
            abVar.f7618e = this.f6939c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            abVar.f7619f = point.x;
            abVar.f7620g = point.y;
        }
        return abVar;
    }

    public ab c() {
        return b(new ab());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i2);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i2);
        parcel.writeParcelable(this.bound, i2);
        parcel.writeDouble(this.f6938b);
        parcel.writeDouble(this.f6939c);
    }
}
