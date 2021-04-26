package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7431a;

    /* renamed from: b  reason: collision with root package name */
    public String f7432b;

    /* renamed from: c  reason: collision with root package name */
    public String f7433c;

    /* renamed from: d  reason: collision with root package name */
    public String f7434d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7431a = parcel.readDouble();
        this.f7432b = parcel.readString();
        this.f7433c = parcel.readString();
        this.f7434d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7432b;
    }

    public double getPrice() {
        return this.f7431a;
    }

    public String getProviderName() {
        return this.f7433c;
    }

    public String getProviderUrl() {
        return this.f7434d;
    }

    public void setBooking(String str) {
        this.f7432b = str;
    }

    public void setPrice(double d2) {
        this.f7431a = d2;
    }

    public void setProviderName(String str) {
        this.f7433c = str;
    }

    public void setProviderUrl(String str) {
        this.f7434d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7431a);
        parcel.writeString(this.f7432b);
        parcel.writeString(this.f7433c);
        parcel.writeString(this.f7434d);
    }
}
