package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7182a;

    /* renamed from: b  reason: collision with root package name */
    public int f7183b;

    /* renamed from: c  reason: collision with root package name */
    public String f7184c;

    /* renamed from: d  reason: collision with root package name */
    public int f7185d;

    /* renamed from: e  reason: collision with root package name */
    public int f7186e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7182a = parcel.readString();
        this.f7183b = parcel.readInt();
        this.f7184c = parcel.readString();
        this.f7185d = parcel.readInt();
        this.f7186e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7183b;
    }

    public String getTitle() {
        return this.f7184c;
    }

    public int getTotalPrice() {
        return this.f7186e;
    }

    public String getUid() {
        return this.f7182a;
    }

    public int getZonePrice() {
        return this.f7185d;
    }

    public void setPassStationNum(int i) {
        this.f7183b = i;
    }

    public void setTitle(String str) {
        this.f7184c = str;
    }

    public void setTotalPrice(int i) {
        this.f7186e = i;
    }

    public void setUid(String str) {
        this.f7182a = str;
    }

    public void setZonePrice(int i) {
        this.f7185d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7182a);
        parcel.writeInt(this.f7183b);
        parcel.writeString(this.f7184c);
        parcel.writeInt(this.f7185d);
        parcel.writeInt(this.f7186e);
    }
}
