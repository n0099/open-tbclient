package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7191a;

    /* renamed from: b  reason: collision with root package name */
    public String f7192b;

    /* renamed from: c  reason: collision with root package name */
    public String f7193c;

    /* renamed from: d  reason: collision with root package name */
    public String f7194d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7191a = parcel.readDouble();
        this.f7192b = parcel.readString();
        this.f7193c = parcel.readString();
        this.f7194d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7192b;
    }

    public double getPrice() {
        return this.f7191a;
    }

    public String getProviderName() {
        return this.f7193c;
    }

    public String getProviderUrl() {
        return this.f7194d;
    }

    public void setBooking(String str) {
        this.f7192b = str;
    }

    public void setPrice(double d2) {
        this.f7191a = d2;
    }

    public void setProviderName(String str) {
        this.f7193c = str;
    }

    public void setProviderUrl(String str) {
        this.f7194d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7191a);
        parcel.writeString(this.f7192b);
        parcel.writeString(this.f7193c);
        parcel.writeString(this.f7194d);
    }
}
