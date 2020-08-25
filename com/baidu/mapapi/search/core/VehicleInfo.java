package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes20.dex */
public class VehicleInfo implements Parcelable {
    public static final Parcelable.Creator<VehicleInfo> CREATOR = new q();
    private String a;
    private int b;
    private String c;
    private int d;
    private int e;

    public VehicleInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VehicleInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPassStationNum() {
        return this.b;
    }

    public String getTitle() {
        return this.c;
    }

    public int getTotalPrice() {
        return this.e;
    }

    public String getUid() {
        return this.a;
    }

    public int getZonePrice() {
        return this.d;
    }

    public void setPassStationNum(int i) {
        this.b = i;
    }

    public void setTitle(String str) {
        this.c = str;
    }

    public void setTotalPrice(int i) {
        this.e = i;
    }

    public void setUid(String str) {
        this.a = str;
    }

    public void setZonePrice(int i) {
        this.d = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
