package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7191a;

    /* renamed from: b  reason: collision with root package name */
    public int f7192b;

    /* renamed from: c  reason: collision with root package name */
    public String f7193c;

    /* renamed from: d  reason: collision with root package name */
    public int f7194d;

    /* renamed from: e  reason: collision with root package name */
    public int f7195e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7191a = parcel.readString();
        this.f7192b = parcel.readInt();
        this.f7193c = parcel.readString();
        this.f7194d = parcel.readInt();
        this.f7195e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7192b;
    }

    public String getTitle() {
        return this.f7193c;
    }

    public int getTotalPrice() {
        return this.f7195e;
    }

    public String getUid() {
        return this.f7191a;
    }

    public int getZonePrice() {
        return this.f7194d;
    }

    public void setPassStationNum(int i2) {
        this.f7192b = i2;
    }

    public void setTitle(String str) {
        this.f7193c = str;
    }

    public void setTotalPrice(int i2) {
        this.f7195e = i2;
    }

    public void setUid(String str) {
        this.f7191a = str;
    }

    public void setZonePrice(int i2) {
        this.f7194d = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7191a);
        parcel.writeInt(this.f7192b);
        parcel.writeString(this.f7193c);
        parcel.writeInt(this.f7194d);
        parcel.writeInt(this.f7195e);
    }
}
