package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public String f7474a;

    /* renamed from: b  reason: collision with root package name */
    public int f7475b;

    /* renamed from: c  reason: collision with root package name */
    public String f7476c;

    /* renamed from: d  reason: collision with root package name */
    public int f7477d;

    /* renamed from: e  reason: collision with root package name */
    public int f7478e;

    public VehicleInfo() {
    }

    public VehicleInfo(Parcel parcel) {
        this.f7474a = parcel.readString();
        this.f7475b = parcel.readInt();
        this.f7476c = parcel.readString();
        this.f7477d = parcel.readInt();
        this.f7478e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.f7475b;
    }

    public String getTitle() {
        return this.f7476c;
    }

    public int getTotalPrice() {
        return this.f7478e;
    }

    public String getUid() {
        return this.f7474a;
    }

    public int getZonePrice() {
        return this.f7477d;
    }

    public void setPassStationNum(int i2) {
        this.f7475b = i2;
    }

    public void setTitle(String str) {
        this.f7476c = str;
    }

    public void setTotalPrice(int i2) {
        this.f7478e = i2;
    }

    public void setUid(String str) {
        this.f7474a = str;
    }

    public void setZonePrice(int i2) {
        this.f7477d = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f7474a);
        parcel.writeInt(this.f7475b);
        parcel.writeString(this.f7476c);
        parcel.writeInt(this.f7477d);
        parcel.writeInt(this.f7478e);
    }
}
