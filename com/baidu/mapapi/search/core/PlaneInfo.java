package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7195a;

    /* renamed from: b  reason: collision with root package name */
    public String f7196b;

    /* renamed from: c  reason: collision with root package name */
    public double f7197c;

    /* renamed from: d  reason: collision with root package name */
    public String f7198d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7195a = parcel.readDouble();
        this.f7196b = parcel.readString();
        this.f7197c = parcel.readDouble();
        this.f7198d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7196b;
    }

    public String getBooking() {
        return this.f7198d;
    }

    public double getDiscount() {
        return this.f7195a;
    }

    public double getPrice() {
        return this.f7197c;
    }

    public void setAirlines(String str) {
        this.f7196b = str;
    }

    public void setBooking(String str) {
        this.f7198d = str;
    }

    public void setDiscount(double d2) {
        this.f7195a = d2;
    }

    public void setPrice(double d2) {
        this.f7197c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7195a);
        parcel.writeString(this.f7196b);
        parcel.writeDouble(this.f7197c);
        parcel.writeString(this.f7198d);
    }
}
