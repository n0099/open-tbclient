package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7218a;

    /* renamed from: b  reason: collision with root package name */
    public int f7219b;

    /* renamed from: c  reason: collision with root package name */
    public String f7220c;

    /* renamed from: d  reason: collision with root package name */
    public int f7221d;

    /* renamed from: e  reason: collision with root package name */
    public int f7222e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7218a = parcel.readString();
        this.f7219b = parcel.readInt();
        this.f7220c = parcel.readString();
        this.f7221d = parcel.readInt();
        this.f7222e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7219b;
    }

    public String getTitle() {
        return this.f7220c;
    }

    public int getTotalPrice() {
        return this.f7222e;
    }

    public String getUid() {
        return this.f7218a;
    }

    public int getZonePrice() {
        return this.f7221d;
    }

    public void setPassStationNum(int i) {
        this.f7219b = i;
    }

    public void setTitle(String str) {
        this.f7220c = str;
    }

    public void setTotalPrice(int i) {
        this.f7222e = i;
    }

    public void setUid(String str) {
        this.f7218a = str;
    }

    public void setZonePrice(int i) {
        this.f7221d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7218a);
        parcel.writeInt(this.f7219b);
        parcel.writeString(this.f7220c);
        parcel.writeInt(this.f7221d);
        parcel.writeInt(this.f7222e);
    }
}
