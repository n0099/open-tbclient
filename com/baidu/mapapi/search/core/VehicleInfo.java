package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7183a;

    /* renamed from: b  reason: collision with root package name */
    public int f7184b;

    /* renamed from: c  reason: collision with root package name */
    public String f7185c;

    /* renamed from: d  reason: collision with root package name */
    public int f7186d;

    /* renamed from: e  reason: collision with root package name */
    public int f7187e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7183a = parcel.readString();
        this.f7184b = parcel.readInt();
        this.f7185c = parcel.readString();
        this.f7186d = parcel.readInt();
        this.f7187e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7184b;
    }

    public String getTitle() {
        return this.f7185c;
    }

    public int getTotalPrice() {
        return this.f7187e;
    }

    public String getUid() {
        return this.f7183a;
    }

    public int getZonePrice() {
        return this.f7186d;
    }

    public void setPassStationNum(int i) {
        this.f7184b = i;
    }

    public void setTitle(String str) {
        this.f7185c = str;
    }

    public void setTotalPrice(int i) {
        this.f7187e = i;
    }

    public void setUid(String str) {
        this.f7183a = str;
    }

    public void setZonePrice(int i) {
        this.f7186d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7183a);
        parcel.writeInt(this.f7184b);
        parcel.writeString(this.f7185c);
        parcel.writeInt(this.f7186d);
        parcel.writeInt(this.f7187e);
    }
}
