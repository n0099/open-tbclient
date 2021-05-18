package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7282a;

    /* renamed from: b  reason: collision with root package name */
    public String f7283b;

    /* renamed from: c  reason: collision with root package name */
    public String f7284c;

    /* renamed from: d  reason: collision with root package name */
    public String f7285d;

    /* renamed from: e  reason: collision with root package name */
    public String f7286e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7282a = parcel.readString();
        this.f7283b = parcel.readString();
        this.f7284c = parcel.readString();
        this.f7285d = parcel.readString();
        this.f7286e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7284c;
    }

    public String getArriveTime() {
        return this.f7286e;
    }

    public String getDepartureStation() {
        return this.f7283b;
    }

    public String getDepartureTime() {
        return this.f7285d;
    }

    public String getName() {
        return this.f7282a;
    }

    public void setArriveStation(String str) {
        this.f7284c = str;
    }

    public void setArriveTime(String str) {
        this.f7286e = str;
    }

    public void setDepartureStation(String str) {
        this.f7283b = str;
    }

    public void setDepartureTime(String str) {
        this.f7285d = str;
    }

    public void setName(String str) {
        this.f7282a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7282a);
        parcel.writeString(this.f7283b);
        parcel.writeString(this.f7284c);
        parcel.writeString(this.f7285d);
        parcel.writeString(this.f7286e);
    }
}
