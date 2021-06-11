package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7225a;

    /* renamed from: b  reason: collision with root package name */
    public String f7226b;

    /* renamed from: c  reason: collision with root package name */
    public String f7227c;

    /* renamed from: d  reason: collision with root package name */
    public String f7228d;

    /* renamed from: e  reason: collision with root package name */
    public String f7229e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7225a = parcel.readString();
        this.f7226b = parcel.readString();
        this.f7227c = parcel.readString();
        this.f7228d = parcel.readString();
        this.f7229e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7227c;
    }

    public String getArriveTime() {
        return this.f7229e;
    }

    public String getDepartureStation() {
        return this.f7226b;
    }

    public String getDepartureTime() {
        return this.f7228d;
    }

    public String getName() {
        return this.f7225a;
    }

    public void setArriveStation(String str) {
        this.f7227c = str;
    }

    public void setArriveTime(String str) {
        this.f7229e = str;
    }

    public void setDepartureStation(String str) {
        this.f7226b = str;
    }

    public void setDepartureTime(String str) {
        this.f7228d = str;
    }

    public void setName(String str) {
        this.f7225a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7225a);
        parcel.writeString(this.f7226b);
        parcel.writeString(this.f7227c);
        parcel.writeString(this.f7228d);
        parcel.writeString(this.f7229e);
    }
}
