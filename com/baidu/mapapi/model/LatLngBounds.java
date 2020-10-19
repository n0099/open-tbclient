package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes7.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new b();
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double f2090a;
        private double b;
        private double c;
        private double d;
        private boolean e = true;

        private void a(LatLng latLng) {
            if (latLng == null) {
                return;
            }
            double d = latLng.latitude;
            double d2 = latLng.longitude;
            if (d < this.f2090a) {
                this.f2090a = d;
            }
            if (d > this.b) {
                this.b = d;
            }
            if (d2 < this.c) {
                this.c = d2;
            }
            if (d2 > this.d) {
                this.d = d2;
            }
        }

        public LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.f2090a, this.c));
        }

        public Builder include(LatLng latLng) {
            if (latLng != null) {
                if (this.e) {
                    this.e = false;
                    double d = latLng.latitude;
                    this.f2090a = d;
                    this.b = d;
                    double d2 = latLng.longitude;
                    this.c = d2;
                    this.d = d2;
                }
                a(latLng);
            }
            return this;
        }

        public Builder include(List<LatLng> list) {
            if (list != null && list.size() != 0) {
                if (list.get(0) != null && this.e) {
                    this.e = false;
                    double d = list.get(0).latitude;
                    this.f2090a = d;
                    this.b = d;
                    double d2 = list.get(0).longitude;
                    this.c = d2;
                    this.d = d2;
                }
                for (LatLng latLng : list) {
                    a(latLng);
                }
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        double d = this.southwest.latitude;
        double d2 = this.northeast.latitude;
        double d3 = this.southwest.longitude;
        double d4 = this.northeast.longitude;
        double d5 = latLng.latitude;
        double d6 = latLng.longitude;
        return d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return new LatLng(((this.northeast.latitude - this.southwest.latitude) / 2.0d) + this.southwest.latitude, ((this.northeast.longitude - this.southwest.longitude) / 2.0d) + this.southwest.longitude);
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.northeast, i);
        parcel.writeParcelable(this.southwest, i);
    }
}
