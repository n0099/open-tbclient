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
    public ab f6994a;

    /* renamed from: b  reason: collision with root package name */
    public double f6995b;
    public final LatLngBounds bound;

    /* renamed from: c  reason: collision with root package name */
    public double f6996c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public float f6997a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f6998b;

        /* renamed from: c  reason: collision with root package name */
        public float f6999c;

        /* renamed from: d  reason: collision with root package name */
        public float f7000d;

        /* renamed from: e  reason: collision with root package name */
        public Point f7001e;

        /* renamed from: f  reason: collision with root package name */
        public LatLngBounds f7002f;

        /* renamed from: g  reason: collision with root package name */
        public double f7003g;

        /* renamed from: h  reason: collision with root package name */
        public double f7004h;

        /* renamed from: i  reason: collision with root package name */
        public final float f7005i;

        public Builder() {
            this.f6997a = -2.1474836E9f;
            this.f6998b = null;
            this.f6999c = -2.1474836E9f;
            this.f7000d = -2.1474836E9f;
            this.f7001e = null;
            this.f7002f = null;
            this.f7003g = 0.0d;
            this.f7004h = 0.0d;
            this.f7005i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            this.f6997a = -2.1474836E9f;
            this.f6998b = null;
            this.f6999c = -2.1474836E9f;
            this.f7000d = -2.1474836E9f;
            this.f7001e = null;
            this.f7002f = null;
            this.f7003g = 0.0d;
            this.f7004h = 0.0d;
            this.f7005i = 15.0f;
            this.f6997a = mapStatus.rotate;
            this.f6998b = mapStatus.target;
            this.f6999c = mapStatus.overlook;
            this.f7000d = mapStatus.zoom;
            this.f7001e = mapStatus.targetScreen;
            this.f7003g = mapStatus.a();
            this.f7004h = mapStatus.b();
        }

        private float a(float f2) {
            if (15.0f == f2) {
                return 15.5f;
            }
            return f2;
        }

        public MapStatus build() {
            return new MapStatus(this.f6997a, this.f6998b, this.f6999c, this.f7000d, this.f7001e, this.f7002f);
        }

        public Builder overlook(float f2) {
            this.f6999c = f2;
            return this;
        }

        public Builder rotate(float f2) {
            this.f6997a = f2;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.f6998b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.f7001e = point;
            return this;
        }

        public Builder zoom(float f2) {
            this.f7000d = a(f2);
            return this;
        }
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, double d2, double d3, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6995b = d2;
        this.f6996c = d3;
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        if (latLng != null) {
            this.f6995b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f6996c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, ab abVar, double d2, double d3, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6994a = abVar;
        this.f6995b = d2;
        this.f6996c = d3;
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
        this.f6995b = parcel.readDouble();
        this.f6996c = parcel.readDouble();
    }

    public static MapStatus a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = abVar.f7672b;
        double d2 = abVar.f7675e;
        double d3 = abVar.f7674d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d2, d3));
        float f3 = abVar.f7673c;
        float f4 = abVar.f7671a;
        Point point = new Point(abVar.f7676f, abVar.f7677g);
        com.baidu.mapapi.model.inner.Point point2 = abVar.k.f7684e;
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(point2.y, point2.x));
        com.baidu.mapapi.model.inner.Point point3 = abVar.k.f7685f;
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(point3.y, point3.x));
        com.baidu.mapapi.model.inner.Point point4 = abVar.k.f7687h;
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(point4.y, point4.x));
        com.baidu.mapapi.model.inner.Point point5 = abVar.k.f7686g;
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(point5.y, point5.x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f2, mc2ll, f3, f4, point, abVar, d3, d2, builder.build(), abVar.j);
    }

    public double a() {
        return this.f6995b;
    }

    public double b() {
        return this.f6996c;
    }

    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = this.rotate;
        if (f2 != -2.1474836E9f) {
            abVar.f7672b = (int) f2;
        }
        float f3 = this.zoom;
        if (f3 != -2.1474836E9f) {
            abVar.f7671a = f3;
        }
        float f4 = this.overlook;
        if (f4 != -2.1474836E9f) {
            abVar.f7673c = (int) f4;
        }
        if (this.target != null) {
            abVar.f7674d = this.f6995b;
            abVar.f7675e = this.f6996c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            abVar.f7676f = point.x;
            abVar.f7677g = point.y;
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
        parcel.writeDouble(this.f6995b);
        parcel.writeDouble(this.f6996c);
    }
}
