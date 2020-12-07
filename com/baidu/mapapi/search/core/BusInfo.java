package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes26.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2100a;
    private int b;

    public BusInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f2100a = parcel.readInt();
        this.b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.b;
    }

    public int getType() {
        return this.f2100a;
    }

    public void setStopNum(int i) {
        this.b = i;
    }

    public void setType(int i) {
        this.f2100a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2100a);
        parcel.writeInt(this.b);
    }
}
