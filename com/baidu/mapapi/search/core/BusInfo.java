package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f7137a;

    /* renamed from: b  reason: collision with root package name */
    public int f7138b;

    public BusInfo() {
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f7137a = parcel.readInt();
        this.f7138b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f7138b;
    }

    public int getType() {
        return this.f7137a;
    }

    public void setStopNum(int i) {
        this.f7138b = i;
    }

    public void setType(int i) {
        this.f7137a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7137a);
        parcel.writeInt(this.f7138b);
    }
}
