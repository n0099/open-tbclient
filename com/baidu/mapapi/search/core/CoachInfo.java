package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7248a;

    /* renamed from: b  reason: collision with root package name */
    public String f7249b;

    /* renamed from: c  reason: collision with root package name */
    public String f7250c;

    /* renamed from: d  reason: collision with root package name */
    public String f7251d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7248a = parcel.readDouble();
        this.f7249b = parcel.readString();
        this.f7250c = parcel.readString();
        this.f7251d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7249b;
    }

    public double getPrice() {
        return this.f7248a;
    }

    public String getProviderName() {
        return this.f7250c;
    }

    public String getProviderUrl() {
        return this.f7251d;
    }

    public void setBooking(String str) {
        this.f7249b = str;
    }

    public void setPrice(double d2) {
        this.f7248a = d2;
    }

    public void setProviderName(String str) {
        this.f7250c = str;
    }

    public void setProviderUrl(String str) {
        this.f7251d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7248a);
        parcel.writeString(this.f7249b);
        parcel.writeString(this.f7250c);
        parcel.writeString(this.f7251d);
    }
}
