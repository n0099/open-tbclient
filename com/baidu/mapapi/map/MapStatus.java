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
    public ab f6901a;

    /* renamed from: b  reason: collision with root package name */
    public double f6902b;
    public final LatLngBounds bound;

    /* renamed from: c  reason: collision with root package name */
    public double f6903c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public float f6904a;

        /* renamed from: b  reason: collision with root package name */
        public LatLng f6905b;

        /* renamed from: c  reason: collision with root package name */
        public float f6906c;

        /* renamed from: d  reason: collision with root package name */
        public float f6907d;

        /* renamed from: e  reason: collision with root package name */
        public Point f6908e;

        /* renamed from: f  reason: collision with root package name */
        public LatLngBounds f6909f;

        /* renamed from: g  reason: collision with root package name */
        public double f6910g;

        /* renamed from: h  reason: collision with root package name */
        public double f6911h;
        public final float i;

        public Builder() {
            this.f6904a = -2.1474836E9f;
            this.f6905b = null;
            this.f6906c = -2.1474836E9f;
            this.f6907d = -2.1474836E9f;
            this.f6908e = null;
            this.f6909f = null;
            this.f6910g = 0.0d;
            this.f6911h = 0.0d;
            this.i = 15.0f;
        }

        public Builder(MapStatus mapStatus) {
            this.f6904a = -2.1474836E9f;
            this.f6905b = null;
            this.f6906c = -2.1474836E9f;
            this.f6907d = -2.1474836E9f;
            this.f6908e = null;
            this.f6909f = null;
            this.f6910g = 0.0d;
            this.f6911h = 0.0d;
            this.i = 15.0f;
            this.f6904a = mapStatus.rotate;
            this.f6905b = mapStatus.target;
            this.f6906c = mapStatus.overlook;
            this.f6907d = mapStatus.zoom;
            this.f6908e = mapStatus.targetScreen;
            this.f6910g = mapStatus.a();
            this.f6911h = mapStatus.b();
        }

        private float a(float f2) {
            if (15.0f == f2) {
                return 15.5f;
            }
            return f2;
        }

        public MapStatus build() {
            return new MapStatus(this.f6904a, this.f6905b, this.f6906c, this.f6907d, this.f6908e, this.f6909f);
        }

        public Builder overlook(float f2) {
            this.f6906c = f2;
            return this;
        }

        public Builder rotate(float f2) {
            this.f6904a = f2;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.f6905b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.f6908e = point;
            return this;
        }

        public Builder zoom(float f2) {
            this.f6907d = a(f2);
            return this;
        }
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, double d2, double d3, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6902b = d2;
        this.f6903c = d3;
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, LatLngBounds latLngBounds) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        if (latLng != null) {
            this.f6902b = CoordUtil.ll2mc(latLng).getLongitudeE6();
            this.f6903c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    public MapStatus(float f2, LatLng latLng, float f3, float f4, Point point, ab abVar, double d2, double d3, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f2;
        this.target = latLng;
        this.overlook = f3;
        this.zoom = f4;
        this.targetScreen = point;
        this.f6901a = abVar;
        this.f6902b = d2;
        this.f6903c = d3;
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
        this.f6902b = parcel.readDouble();
        this.f6903c = parcel.readDouble();
    }

    public static MapStatus a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = abVar.f7571b;
        double d2 = abVar.f7574e;
        double d3 = abVar.f7573d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d2, d3));
        float f3 = abVar.f7572c;
        float f4 = abVar.f7570a;
        Point point = new Point(abVar.f7575f, abVar.f7576g);
        com.baidu.mapapi.model.inner.Point point2 = abVar.k.f7582e;
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(point2.y, point2.x));
        com.baidu.mapapi.model.inner.Point point3 = abVar.k.f7583f;
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(point3.y, point3.x));
        com.baidu.mapapi.model.inner.Point point4 = abVar.k.f7585h;
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(point4.y, point4.x));
        com.baidu.mapapi.model.inner.Point point5 = abVar.k.f7584g;
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(point5.y, point5.x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f2, mc2ll, f3, f4, point, abVar, d3, d2, builder.build(), abVar.j);
    }

    public double a() {
        return this.f6902b;
    }

    public double b() {
        return this.f6903c;
    }

    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f2 = this.rotate;
        if (f2 != -2.1474836E9f) {
            abVar.f7571b = (int) f2;
        }
        float f3 = this.zoom;
        if (f3 != -2.1474836E9f) {
            abVar.f7570a = f3;
        }
        float f4 = this.overlook;
        if (f4 != -2.1474836E9f) {
            abVar.f7572c = (int) f4;
        }
        LatLng latLng = this.target;
        if (latLng != null) {
            CoordUtil.ll2mc(latLng);
            abVar.f7573d = this.f6902b;
            abVar.f7574e = this.f6903c;
        }
        Point point = this.targetScreen;
        if (point != null) {
            abVar.f7575f = point.x;
            abVar.f7576g = point.y;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i);
        parcel.writeParcelable(this.bound, i);
        parcel.writeDouble(this.f6902b);
        parcel.writeDouble(this.f6903c);
    }
}
