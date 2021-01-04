package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2954a;

    /* renamed from: b  reason: collision with root package name */
    private int f2955b;

    public BusInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f2954a = parcel.readInt();
        this.f2955b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f2955b;
    }

    public int getType() {
        return this.f2954a;
    }

    public void setStopNum(int i) {
        this.f2955b = i;
    }

    public void setType(int i) {
        this.f2954a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2954a);
        parcel.writeInt(this.f2955b);
    }
}
