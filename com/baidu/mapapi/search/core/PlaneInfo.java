package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7144a;

    /* renamed from: b  reason: collision with root package name */
    public String f7145b;

    /* renamed from: c  reason: collision with root package name */
    public double f7146c;

    /* renamed from: d  reason: collision with root package name */
    public String f7147d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7144a = parcel.readDouble();
        this.f7145b = parcel.readString();
        this.f7146c = parcel.readDouble();
        this.f7147d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7145b;
    }

    public String getBooking() {
        return this.f7147d;
    }

    public double getDiscount() {
        return this.f7144a;
    }

    public double getPrice() {
        return this.f7146c;
    }

    public void setAirlines(String str) {
        this.f7145b = str;
    }

    public void setBooking(String str) {
        this.f7147d = str;
    }

    public void setDiscount(double d2) {
        this.f7144a = d2;
    }

    public void setPrice(double d2) {
        this.f7146c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7144a);
        parcel.writeString(this.f7145b);
        parcel.writeDouble(this.f7146c);
        parcel.writeString(this.f7147d);
    }
}
