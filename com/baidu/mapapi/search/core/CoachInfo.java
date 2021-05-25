package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class CoachInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<CoachInfo> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public double f7148a;

    /* renamed from: b  reason: collision with root package name */
    public String f7149b;

    /* renamed from: c  reason: collision with root package name */
    public String f7150c;

    /* renamed from: d  reason: collision with root package name */
    public String f7151d;

    public CoachInfo() {
    }

    public CoachInfo(Parcel parcel) {
        super(parcel);
        this.f7148a = parcel.readDouble();
        this.f7149b = parcel.readString();
        this.f7150c = parcel.readString();
        this.f7151d = parcel.readString();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBooking() {
        return this.f7149b;
    }

    public double getPrice() {
        return this.f7148a;
    }

    public String getProviderName() {
        return this.f7150c;
    }

    public String getProviderUrl() {
        return this.f7151d;
    }

    public void setBooking(String str) {
        this.f7149b = str;
    }

    public void setPrice(double d2) {
        this.f7148a = d2;
    }

    public void setProviderName(String str) {
        this.f7150c = str;
    }

    public void setProviderUrl(String str) {
        this.f7151d = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7148a);
        parcel.writeString(this.f7149b);
        parcel.writeString(this.f7150c);
        parcel.writeString(this.f7151d);
    }
}
