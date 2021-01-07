package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class PlaneInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<PlaneInfo> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private double f2959a;

    /* renamed from: b  reason: collision with root package name */
    private String f2960b;
    private double c;
    private String d;

    public PlaneInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PlaneInfo(Parcel parcel) {
        super(parcel);
        this.f2959a = parcel.readDouble();
        this.f2960b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAirlines() {
        return this.f2960b;
    }

    public String getBooking() {
        return this.d;
    }

    public double getDiscount() {
        return this.f2959a;
    }

    public double getPrice() {
        return this.c;
    }

    public void setAirlines(String str) {
        this.f2960b = str;
    }

    public void setBooking(String str) {
        this.d = str;
    }

    public void setDiscount(double d) {
        this.f2959a = d;
    }

    public void setPrice(double d) {
        this.c = d;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f2959a);
        parcel.writeString(this.f2960b);
        parcel.writeDouble(this.c);
        parcel.writeString(this.d);
    }
}
