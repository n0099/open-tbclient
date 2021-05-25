package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public double f7180a;

    /* renamed from: b  reason: collision with root package name */
    public String f7181b;

    public TrainInfo() {
    }

    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f7180a = parcel.readDouble();
        this.f7181b = parcel.readString();
    }

    public void a(double d2) {
        this.f7180a = d2;
    }

    public void a(String str) {
        this.f7181b = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7180a);
        parcel.writeString(this.f7181b);
    }
}
