package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new e();
    public double a;
    public String b;
    public double c;
    public String d;

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlaneInfo() {
    }

    public String getAirlines() {
        return this.b;
    }

    public String getBooking() {
        return this.d;
    }

    public double getDiscount() {
        return this.a;
    }

    public double getPrice() {
        return this.c;
    }

    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.a = parcel.readDouble();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readString();
    }

    public void setAirlines(String str) {
        this.b = str;
    }

    public void setBooking(String str) {
        this.d = str;
    }

    public void setDiscount(double d) {
        this.a = d;
    }

    public void setPrice(double d) {
        this.c = d;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.a);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeString(this.d);
    }
}
