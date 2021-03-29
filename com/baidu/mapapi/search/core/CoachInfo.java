package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7140a;

    /* renamed from: b  reason: collision with root package name */
    public String f7141b;

    /* renamed from: c  reason: collision with root package name */
    public String f7142c;

    /* renamed from: d  reason: collision with root package name */
    public String f7143d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7140a = parcel.readDouble();
        this.f7141b = parcel.readString();
        this.f7142c = parcel.readString();
        this.f7143d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7141b;
    }

    public double getPrice() {
        return this.f7140a;
    }

    public String getProviderName() {
        return this.f7142c;
    }

    public String getProviderUrl() {
        return this.f7143d;
    }

    public void setBooking(String str) {
        this.f7141b = str;
    }

    public void setPrice(double d2) {
        this.f7140a = d2;
    }

    public void setProviderName(String str) {
        this.f7142c = str;
    }

    public void setProviderUrl(String str) {
        this.f7143d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7140a);
        parcel.writeString(this.f7141b);
        parcel.writeString(this.f7142c);
        parcel.writeString(this.f7143d);
    }
}
