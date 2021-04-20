package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f7173a;

    /* renamed from: b  reason: collision with root package name */
    public int f7174b;

    public BusInfo() {
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f7173a = parcel.readInt();
        this.f7174b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f7174b;
    }

    public int getType() {
        return this.f7173a;
    }

    public void setStopNum(int i) {
        this.f7174b = i;
    }

    public void setType(int i) {
        this.f7173a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7173a);
        parcel.writeInt(this.f7174b);
    }
}
