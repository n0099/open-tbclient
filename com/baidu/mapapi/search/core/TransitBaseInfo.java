package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7173a;

    /* renamed from: b  reason: collision with root package name */
    public String f7174b;

    /* renamed from: c  reason: collision with root package name */
    public String f7175c;

    /* renamed from: d  reason: collision with root package name */
    public String f7176d;

    /* renamed from: e  reason: collision with root package name */
    public String f7177e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7173a = parcel.readString();
        this.f7174b = parcel.readString();
        this.f7175c = parcel.readString();
        this.f7176d = parcel.readString();
        this.f7177e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7175c;
    }

    public String getArriveTime() {
        return this.f7177e;
    }

    public String getDepartureStation() {
        return this.f7174b;
    }

    public String getDepartureTime() {
        return this.f7176d;
    }

    public String getName() {
        return this.f7173a;
    }

    public void setArriveStation(String str) {
        this.f7175c = str;
    }

    public void setArriveTime(String str) {
        this.f7177e = str;
    }

    public void setDepartureStation(String str) {
        this.f7174b = str;
    }

    public void setDepartureTime(String str) {
        this.f7176d = str;
    }

    public void setName(String str) {
        this.f7173a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7173a);
        parcel.writeString(this.f7174b);
        parcel.writeString(this.f7175c);
        parcel.writeString(this.f7176d);
        parcel.writeString(this.f7177e);
    }
}
