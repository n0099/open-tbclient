package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public double f7463a;

    /* renamed from: b  reason: collision with root package name */
    public String f7464b;

    public TrainInfo() {
    }

    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f7463a = parcel.readDouble();
        this.f7464b = parcel.readString();
    }

    public void a(double d2) {
        this.f7463a = d2;
    }

    public void a(String str) {
        this.f7464b = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeDouble(this.f7463a);
        parcel.writeString(this.f7464b);
    }
}
