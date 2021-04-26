package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7435a;

    /* renamed from: b  reason: collision with root package name */
    public String f7436b;

    /* renamed from: c  reason: collision with root package name */
    public double f7437c;

    /* renamed from: d  reason: collision with root package name */
    public String f7438d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7435a = parcel.readDouble();
        this.f7436b = parcel.readString();
        this.f7437c = parcel.readDouble();
        this.f7438d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7436b;
    }

    public String getBooking() {
        return this.f7438d;
    }

    public double getDiscount() {
        return this.f7435a;
    }

    public double getPrice() {
        return this.f7437c;
    }

    public void setAirlines(String str) {
        this.f7436b = str;
    }

    public void setBooking(String str) {
        this.f7438d = str;
    }

    public void setDiscount(double d2) {
        this.f7435a = d2;
    }

    public void setPrice(double d2) {
        this.f7437c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7435a);
        parcel.writeString(this.f7436b);
        parcel.writeDouble(this.f7437c);
        parcel.writeString(this.f7438d);
    }
}
