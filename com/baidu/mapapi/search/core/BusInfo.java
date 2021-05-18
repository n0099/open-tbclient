package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f7246a;

    /* renamed from: b  reason: collision with root package name */
    public int f7247b;

    public BusInfo() {
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f7246a = parcel.readInt();
        this.f7247b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f7247b;
    }

    public int getType() {
        return this.f7246a;
    }

    public void setStopNum(int i2) {
        this.f7247b = i2;
    }

    public void setType(int i2) {
        this.f7246a = i2;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.f7246a);
        parcel.writeInt(this.f7247b);
    }
}
