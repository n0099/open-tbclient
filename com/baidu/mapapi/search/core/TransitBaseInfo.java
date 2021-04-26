package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TransitBaseInfo implements Parcelable {
    public static final Parcelable.Creator<TransitBaseInfo> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public String f7465a;

    /* renamed from: b  reason: collision with root package name */
    public String f7466b;

    /* renamed from: c  reason: collision with root package name */
    public String f7467c;

    /* renamed from: d  reason: collision with root package name */
    public String f7468d;

    /* renamed from: e  reason: collision with root package name */
    public String f7469e;

    public TransitBaseInfo() {
    }

    public TransitBaseInfo(Parcel parcel) {
        this.f7465a = parcel.readString();
        this.f7466b = parcel.readString();
        this.f7467c = parcel.readString();
        this.f7468d = parcel.readString();
        this.f7469e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArriveStation() {
        return this.f7467c;
    }

    public String getArriveTime() {
        return this.f7469e;
    }

    public String getDepartureStation() {
        return this.f7466b;
    }

    public String getDepartureTime() {
        return this.f7468d;
    }

    public String getName() {
        return this.f7465a;
    }

    public void setArriveStation(String str) {
        this.f7467c = str;
    }

    public void setArriveTime(String str) {
        this.f7469e = str;
    }

    public void setDepartureStation(String str) {
        this.f7466b = str;
    }

    public void setDepartureTime(String str) {
        this.f7468d = str;
    }

    public void setName(String str) {
        this.f7465a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7465a);
        parcel.writeString(this.f7466b);
        parcel.writeString(this.f7467c);
        parcel.writeString(this.f7468d);
        parcel.writeString(this.f7469e);
    }
}
