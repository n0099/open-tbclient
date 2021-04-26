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
    public static final Parcelable.Creator<MapStatus> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public ab f7178a;

    /* renamed from: b  reason: collision with root package name */
    public double f7179b;
    public final LatLngBounds bound;

    /* renamed from: c  reason: collision with root package name */
    public double f7180c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public float f7181a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f7182b;

        /* renamed from: c  reason: collision with root package name */
        public float f7183c;

        /* renamed from: d  reason: collision with root package name */
        public float f7184d;

        /* renamed from: e  reason: collision with root package name */
        public Point f7185e;

        /* renamed from: f  reason: collision with root package name */
        public LatLngBounds f7186f;

        /* renamed from: g  reason: collision with root package name */
        public double f7187g;

        /* renamed from: h  reason: collision with root package name */
        public double f7188h;

        /* renamed from: i  reason: collision with root package name */
        public final float f7189i;

        public Builder() {
            this.f7181a = -2.1474836E9f;
            this.f7182b = null;
            this.f7183c = -2.1474836E9f;
            this.f7184d = -2.1474836E9f;
            this.f7185e = null;
            this.f7186f = null;
            this.f7187g = 0.0d;
            this.f7188h = 0.0d;
            this.f7189i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            this.f7181a = -2.1474836E9f;
            this.f7182b = null;
            this.f7183c = -2.1474836E9f;
            this.f7184d = -2.1474836E9f;
            this.f7185e = null;
            this.f7186f = null;
            this.f7187g = 0.0d;
            this.f7188h = 0.0d;
            this.f7189i = 15.0f;
            this.f7181a = mapStatus.rotate;
            this.f7182b = mapStatus.target;
            this.f7183c = mapStatus.overlook;
            this.f7184d = mapStatus.zoom;
            this.f7185e = mapStatus.targetScreen;
            this.f7187g = mapStatus.a();
            this.f7188h = mapStatus.b();
        }

        private float a(float f2) {
            if (15.0f == f2) {
                return 15.5f;
            }
            return f2;
        }

        public MapStatus build() {
            return new MapStatus(this.f7181a, this.f7182b, this.f7183c, this.f7184d, this.f7185e, this.f7186f);
        }

        public Builder overlook(float f2) {
            this.f7183c = f2;
            return this;
        }

        public Builder rotate(float f2) {
            this.f7181a = f2;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.f7182b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.f7185e = point;
            return this;
        }

        public Builder zoom(float f2) {
            this.f7184d = a(f2);
            return this;
        }
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, double d2, double d3, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f7179b = d2;
        this.f7180c = d3;
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        if (latLng != null) {
            this.f7179b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f7180c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, ab abVar, double d2, double d3, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f7178a = abVar;
        this.f7179b = d2;
        this.f7180c = d3;
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
        this.f7179b = parcel.readDouble();
        this.f7180c = parcel.readDouble();
    }

    public static MapStatus a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = abVar.f7875b;
        double d2 = abVar.f7878e;
        double d3 = abVar.f7877d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d2, d3));
        float f3 = abVar.f7876c;
        float f4 = abVar.f7874a;
        Point point = new Point(abVar.f7879f, abVar.f7880g);
        com.baidu.mapapi.model.inner.Point point2 = abVar.k.f7887e;
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(point2.y, point2.x));
        com.baidu.mapapi.model.inner.Point point3 = abVar.k.f7888f;
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(point3.y, point3.x));
        com.baidu.mapapi.model.inner.Point point4 = abVar.k.f7890h;
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(point4.y, point4.x));
        com.baidu.mapapi.model.inner.Point point5 = abVar.k.f7889g;
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(point5.y, point5.x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f2, mc2ll, f3, f4, point, abVar, d3, d2, builder.build(), abVar.j);
    }

    public double a() {
        return this.f7179b;
    }

    public double b() {
        return this.f7180c;
    }

    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = this.rotate;
        if (f2 != -2.1474836E9f) {
            abVar.f7875b = (int) f2;
        }
        float f3 = this.zoom;
        if (f3 != -2.1474836E9f) {
            abVar.f7874a = f3;
        }
        float f4 = this.overlook;
        if (f4 != -2.1474836E9f) {
            abVar.f7876c = (int) f4;
        }
        LatLng latLng = this.target;
        if (latLng != null) {
            CoordUtil.ll2mc(latLng);
            abVar.f7877d = this.f7179b;
            abVar.f7878e = this.f7180c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            abVar.f7879f = point.x;
            abVar.f7880g = point.y;
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
        parcel.writeDouble(this.f7179b);
        parcel.writeDouble(this.f7180c);
    }
}
