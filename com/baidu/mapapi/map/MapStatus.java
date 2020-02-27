package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes8.dex */
public final class MapStatus implements Parcelable {
    public static final Parcelable.Creator<MapStatus> CREATOR = new j();
    ab a;
    private double b;
    public final LatLngBounds bound;
    private double c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    /* loaded from: classes8.dex */
    public static final class Builder {
        private float a;
        private LatLng b;
        private float c;
        private float d;
        private Point e;
        private LatLngBounds f;
        private double g;
        private double h;
        private final float i;

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

        private float a(float f) {
            if (15.0f == f) {
                return 15.5f;
            }
            return f;
        }

        public MapStatus build() {
            return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
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

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        if (this.target != null) {
            this.b = CoordUtil.ll2mc(this.target).getLongitudeE6();
            this.c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    MapStatus(float f, LatLng latLng, float f2, float f3, Point point, ab abVar, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.a = abVar;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapStatus a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        float f = abVar.b;
        double d = abVar.e;
        double d2 = abVar.d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
        float f2 = abVar.c;
        float f3 = abVar.a;
        Point point = new Point(abVar.f, abVar.g);
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint(abVar.k.e.y, abVar.k.e.x));
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint(abVar.k.f.y, abVar.k.f.x));
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint(abVar.k.h.y, abVar.k.h.x));
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint(abVar.k.g.y, abVar.k.g.x));
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f, mc2ll, f2, f3, point, abVar, d2, d, builder.build(), abVar.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        if (this.rotate != -2.1474836E9f) {
            abVar.b = (int) this.rotate;
        }
        if (this.zoom != -2.1474836E9f) {
            abVar.a = this.zoom;
        }
        if (this.overlook != -2.1474836E9f) {
            abVar.c = (int) this.overlook;
        }
        if (this.target != null) {
            CoordUtil.ll2mc(this.target);
            abVar.d = this.b;
            abVar.e = this.c;
        }
        if (this.targetScreen != null) {
            abVar.f = this.targetScreen.x;
            abVar.g = this.targetScreen.y;
            return abVar;
        }
        return abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
    }
}
