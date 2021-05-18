package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7252a;

    /* renamed from: b  reason: collision with root package name */
    public String f7253b;

    /* renamed from: c  reason: collision with root package name */
    public double f7254c;

    /* renamed from: d  reason: collision with root package name */
    public String f7255d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7252a = parcel.readDouble();
        this.f7253b = parcel.readString();
        this.f7254c = parcel.readDouble();
        this.f7255d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7253b;
    }

    public String getBooking() {
        return this.f7255d;
    }

    public double getDiscount() {
        return this.f7252a;
    }

    public double getPrice() {
        return this.f7254c;
    }

    public void setAirlines(String str) {
        this.f7253b = str;
    }

    public void setBooking(String str) {
        this.f7255d = str;
    }

    public void setDiscount(double d2) {
        this.f7252a = d2;
    }

    public void setPrice(double d2) {
        this.f7254c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7252a);
        parcel.writeString(this.f7253b);
        parcel.writeDouble(this.f7254c);
        parcel.writeString(this.f7255d);
    }
}
