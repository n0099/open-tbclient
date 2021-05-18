package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7291a;

    /* renamed from: b  reason: collision with root package name */
    public int f7292b;

    /* renamed from: c  reason: collision with root package name */
    public String f7293c;

    /* renamed from: d  reason: collision with root package name */
    public int f7294d;

    /* renamed from: e  reason: collision with root package name */
    public int f7295e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7291a = parcel.readString();
        this.f7292b = parcel.readInt();
        this.f7293c = parcel.readString();
        this.f7294d = parcel.readInt();
        this.f7295e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7292b;
    }

    public String getTitle() {
        return this.f7293c;
    }

    public int getTotalPrice() {
        return this.f7295e;
    }

    public String getUid() {
        return this.f7291a;
    }

    public int getZonePrice() {
        return this.f7294d;
    }

    public void setPassStationNum(int i2) {
        this.f7292b = i2;
    }

    public void setTitle(String str) {
        this.f7293c = str;
    }

    public void setTotalPrice(int i2) {
        this.f7295e = i2;
    }

    public void setUid(String str) {
        this.f7291a = str;
    }

    public void setZonePrice(int i2) {
        this.f7294d = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7291a);
        parcel.writeInt(this.f7292b);
        parcel.writeString(this.f7293c);
        parcel.writeInt(this.f7294d);
        parcel.writeInt(this.f7295e);
    }
}
