package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f7189a;

    /* renamed from: b  reason: collision with root package name */
    public int f7190b;

    public BusInfo() {
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f7189a = parcel.readInt();
        this.f7190b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f7190b;
    }

    public int getType() {
        return this.f7189a;
    }

    public void setStopNum(int i2) {
        this.f7190b = i2;
    }

    public void setType(int i2) {
        this.f7189a = i2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7189a);
        parcel.writeInt(this.f7190b);
    }
}
