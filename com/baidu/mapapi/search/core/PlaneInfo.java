package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7143a;

    /* renamed from: b  reason: collision with root package name */
    public String f7144b;

    /* renamed from: c  reason: collision with root package name */
    public double f7145c;

    /* renamed from: d  reason: collision with root package name */
    public String f7146d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7143a = parcel.readDouble();
        this.f7144b = parcel.readString();
        this.f7145c = parcel.readDouble();
        this.f7146d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7144b;
    }

    public String getBooking() {
        return this.f7146d;
    }

    public double getDiscount() {
        return this.f7143a;
    }

    public double getPrice() {
        return this.f7145c;
    }

    public void setAirlines(String str) {
        this.f7144b = str;
    }

    public void setBooking(String str) {
        this.f7146d = str;
    }

    public void setDiscount(double d2) {
        this.f7143a = d2;
    }

    public void setPrice(double d2) {
        this.f7145c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7143a);
        parcel.writeString(this.f7144b);
        parcel.writeDouble(this.f7145c);
        parcel.writeString(this.f7146d);
    }
}
