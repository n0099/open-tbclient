package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f2837a;

    /* renamed from: b  reason: collision with root package name */
    private int f2838b;

    public BusInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f2837a = parcel.readInt();
        this.f2838b = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getStopNum() {
        return this.f2838b;
    }

    public int getType() {
        return this.f2837a;
    }

    public void setStopNum(int i) {
        this.f2838b = i;
    }

    public void setType(int i) {
        this.f2837a = i;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f2837a);
        parcel.writeInt(this.f2838b);
    }
}
