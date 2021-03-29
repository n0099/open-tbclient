package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7174a;

    /* renamed from: b  reason: collision with root package name */
    public String f7175b;

    /* renamed from: c  reason: collision with root package name */
    public String f7176c;

    /* renamed from: d  reason: collision with root package name */
    public String f7177d;

    /* renamed from: e  reason: collision with root package name */
    public String f7178e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7174a = parcel.readString();
        this.f7175b = parcel.readString();
        this.f7176c = parcel.readString();
        this.f7177d = parcel.readString();
        this.f7178e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7176c;
    }

    public String getArriveTime() {
        return this.f7178e;
    }

    public String getDepartureStation() {
        return this.f7175b;
    }

    public String getDepartureTime() {
        return this.f7177d;
    }

    public String getName() {
        return this.f7174a;
    }

    public void setArriveStation(String str) {
        this.f7176c = str;
    }

    public void setArriveTime(String str) {
        this.f7178e = str;
    }

    public void setDepartureStation(String str) {
        this.f7175b = str;
    }

    public void setDepartureTime(String str) {
        this.f7177d = str;
    }

    public void setName(String str) {
        this.f7174a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7174a);
        parcel.writeString(this.f7175b);
        parcel.writeString(this.f7176c);
        parcel.writeString(this.f7177d);
        parcel.writeString(this.f7178e);
    }
}
