package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7139a;

    /* renamed from: b  reason: collision with root package name */
    public String f7140b;

    /* renamed from: c  reason: collision with root package name */
    public String f7141c;

    /* renamed from: d  reason: collision with root package name */
    public String f7142d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7139a = parcel.readDouble();
        this.f7140b = parcel.readString();
        this.f7141c = parcel.readString();
        this.f7142d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7140b;
    }

    public double getPrice() {
        return this.f7139a;
    }

    public String getProviderName() {
        return this.f7141c;
    }

    public String getProviderUrl() {
        return this.f7142d;
    }

    public void setBooking(String str) {
        this.f7140b = str;
    }

    public void setPrice(double d2) {
        this.f7139a = d2;
    }

    public void setProviderName(String str) {
        this.f7141c = str;
    }

    public void setProviderUrl(String str) {
        this.f7142d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7139a);
        parcel.writeString(this.f7140b);
        parcel.writeString(this.f7141c);
        parcel.writeString(this.f7142d);
    }
}
