package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes2.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new b();
    public final LatLng northeast;
    public final LatLng southwest;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public double f7118a;

        /* renamed from: b  reason: collision with root package name */
        public double f7119b;

        /* renamed from: c  reason: collision with root package name */
        public double f7120c;

        /* renamed from: d  reason: collision with root package name */
        public double f7121d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7122e = true;

        public LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.f7119b, this.f7121d), new LatLng(this.f7118a, this.f7120c));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            if (this.f7122e) {
                this.f7122e = false;
                double d2 = latLng.latitude;
                this.f7118a = d2;
                this.f7119b = d2;
                double d3 = latLng.longitude;
                this.f7120c = d3;
                this.f7121d = d3;
            }
            double d4 = latLng.latitude;
            double d5 = latLng.longitude;
            if (d4 < this.f7118a) {
                this.f7118a = d4;
            }
            if (d4 > this.f7119b) {
                this.f7119b = d4;
            }
            if (d5 < this.f7120c) {
                this.f7120c = d5;
            }
            if (d5 > this.f7121d) {
                this.f7121d = d5;
            }
            return this;
        }
    }

    public LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        LatLng latLng2 = this.southwest;
        double d2 = latLng2.latitude;
        LatLng latLng3 = this.northeast;
        double d3 = latLng3.latitude;
        double d4 = latLng2.longitude;
        double d5 = latLng3.longitude;
        double d6 = latLng.latitude;
        double d7 = latLng.longitude;
        return d6 >= d2 && d6 <= d3 && d7 >= d4 && d7 <= d5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        LatLng latLng = this.northeast;
        double d2 = latLng.latitude;
        LatLng latLng2 = this.southwest;
        double d3 = latLng2.latitude;
        double d4 = ((d2 - d3) / 2.0d) + d3;
        double d5 = latLng.longitude;
        double d6 = latLng2.longitude;
        return new LatLng(d4, ((d5 - d6) / 2.0d) + d6);
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.northeast, i2);
        parcel.writeParcelable(this.southwest, i2);
    }
}
