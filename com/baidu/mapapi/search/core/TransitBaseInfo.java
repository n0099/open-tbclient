package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7209a;

    /* renamed from: b  reason: collision with root package name */
    public String f7210b;

    /* renamed from: c  reason: collision with root package name */
    public String f7211c;

    /* renamed from: d  reason: collision with root package name */
    public String f7212d;

    /* renamed from: e  reason: collision with root package name */
    public String f7213e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7209a = parcel.readString();
        this.f7210b = parcel.readString();
        this.f7211c = parcel.readString();
        this.f7212d = parcel.readString();
        this.f7213e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7211c;
    }

    public String getArriveTime() {
        return this.f7213e;
    }

    public String getDepartureStation() {
        return this.f7210b;
    }

    public String getDepartureTime() {
        return this.f7212d;
    }

    public String getName() {
        return this.f7209a;
    }

    public void setArriveStation(String str) {
        this.f7211c = str;
    }

    public void setArriveTime(String str) {
        this.f7213e = str;
    }

    public void setDepartureStation(String str) {
        this.f7210b = str;
    }

    public void setDepartureTime(String str) {
        this.f7212d = str;
    }

    public void setName(String str) {
        this.f7209a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7209a);
        parcel.writeString(this.f7210b);
        parcel.writeString(this.f7211c);
        parcel.writeString(this.f7212d);
        parcel.writeString(this.f7213e);
    }
}
