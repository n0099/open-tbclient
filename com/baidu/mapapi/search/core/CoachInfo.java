package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7175a;

    /* renamed from: b  reason: collision with root package name */
    public String f7176b;

    /* renamed from: c  reason: collision with root package name */
    public String f7177c;

    /* renamed from: d  reason: collision with root package name */
    public String f7178d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7175a = parcel.readDouble();
        this.f7176b = parcel.readString();
        this.f7177c = parcel.readString();
        this.f7178d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7176b;
    }

    public double getPrice() {
        return this.f7175a;
    }

    public String getProviderName() {
        return this.f7177c;
    }

    public String getProviderUrl() {
        return this.f7178d;
    }

    public void setBooking(String str) {
        this.f7176b = str;
    }

    public void setPrice(double d2) {
        this.f7175a = d2;
    }

    public void setProviderName(String str) {
        this.f7177c = str;
    }

    public void setProviderUrl(String str) {
        this.f7178d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7175a);
        parcel.writeString(this.f7176b);
        parcel.writeString(this.f7177c);
        parcel.writeString(this.f7178d);
    }
}
