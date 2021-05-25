package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7182a;

    /* renamed from: b  reason: collision with root package name */
    public String f7183b;

    /* renamed from: c  reason: collision with root package name */
    public String f7184c;

    /* renamed from: d  reason: collision with root package name */
    public String f7185d;

    /* renamed from: e  reason: collision with root package name */
    public String f7186e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7182a = parcel.readString();
        this.f7183b = parcel.readString();
        this.f7184c = parcel.readString();
        this.f7185d = parcel.readString();
        this.f7186e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7184c;
    }

    public String getArriveTime() {
        return this.f7186e;
    }

    public String getDepartureStation() {
        return this.f7183b;
    }

    public String getDepartureTime() {
        return this.f7185d;
    }

    public String getName() {
        return this.f7182a;
    }

    public void setArriveStation(String str) {
        this.f7184c = str;
    }

    public void setArriveTime(String str) {
        this.f7186e = str;
    }

    public void setDepartureStation(String str) {
        this.f7183b = str;
    }

    public void setDepartureTime(String str) {
        this.f7185d = str;
    }

    public void setName(String str) {
        this.f7182a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7182a);
        parcel.writeString(this.f7183b);
        parcel.writeString(this.f7184c);
        parcel.writeString(this.f7185d);
        parcel.writeString(this.f7186e);
    }
}
