package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7152a;

    /* renamed from: b  reason: collision with root package name */
    public String f7153b;

    /* renamed from: c  reason: collision with root package name */
    public double f7154c;

    /* renamed from: d  reason: collision with root package name */
    public String f7155d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7152a = parcel.readDouble();
        this.f7153b = parcel.readString();
        this.f7154c = parcel.readDouble();
        this.f7155d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7153b;
    }

    public String getBooking() {
        return this.f7155d;
    }

    public double getDiscount() {
        return this.f7152a;
    }

    public double getPrice() {
        return this.f7154c;
    }

    public void setAirlines(String str) {
        this.f7153b = str;
    }

    public void setBooking(String str) {
        this.f7155d = str;
    }

    public void setDiscount(double d2) {
        this.f7152a = d2;
    }

    public void setPrice(double d2) {
        this.f7154c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7152a);
        parcel.writeString(this.f7153b);
        parcel.writeDouble(this.f7154c);
        parcel.writeString(this.f7155d);
    }
}
