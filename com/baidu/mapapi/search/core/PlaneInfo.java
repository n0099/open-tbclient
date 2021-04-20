package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    public double f7179a;

    /* renamed from: b  reason: collision with root package name */
    public String f7180b;

    /* renamed from: c  reason: collision with root package name */
    public double f7181c;

    /* renamed from: d  reason: collision with root package name */
    public String f7182d;

    public PlaneInfo() {
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f7179a = parcel.readDouble();
        this.f7180b = parcel.readString();
        this.f7181c = parcel.readDouble();
        this.f7182d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f7180b;
    }

    public String getBooking() {
        return this.f7182d;
    }

    public double getDiscount() {
        return this.f7179a;
    }

    public double getPrice() {
        return this.f7181c;
    }

    public void setAirlines(String str) {
        this.f7180b = str;
    }

    public void setBooking(String str) {
        this.f7182d = str;
    }

    public void setDiscount(double d2) {
        this.f7179a = d2;
    }

    public void setPrice(double d2) {
        this.f7181c = d2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7179a);
        parcel.writeString(this.f7180b);
        parcel.writeDouble(this.f7181c);
        parcel.writeString(this.f7182d);
    }
}
