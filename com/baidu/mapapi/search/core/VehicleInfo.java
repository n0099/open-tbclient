package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7234a;

    /* renamed from: b  reason: collision with root package name */
    public int f7235b;

    /* renamed from: c  reason: collision with root package name */
    public String f7236c;

    /* renamed from: d  reason: collision with root package name */
    public int f7237d;

    /* renamed from: e  reason: collision with root package name */
    public int f7238e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7234a = parcel.readString();
        this.f7235b = parcel.readInt();
        this.f7236c = parcel.readString();
        this.f7237d = parcel.readInt();
        this.f7238e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7235b;
    }

    public String getTitle() {
        return this.f7236c;
    }

    public int getTotalPrice() {
        return this.f7238e;
    }

    public String getUid() {
        return this.f7234a;
    }

    public int getZonePrice() {
        return this.f7237d;
    }

    public void setPassStationNum(int i2) {
        this.f7235b = i2;
    }

    public void setTitle(String str) {
        this.f7236c = str;
    }

    public void setTotalPrice(int i2) {
        this.f7238e = i2;
    }

    public void setUid(String str) {
        this.f7234a = str;
    }

    public void setZonePrice(int i2) {
        this.f7237d = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7234a);
        parcel.writeInt(this.f7235b);
        parcel.writeString(this.f7236c);
        parcel.writeInt(this.f7237d);
        parcel.writeInt(this.f7238e);
    }
}
