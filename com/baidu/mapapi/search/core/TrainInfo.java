package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    public double f7207a;

    /* renamed from: b  reason: collision with root package name */
    public String f7208b;

    public TrainInfo() {
    }

    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f7207a = parcel.readDouble();
        this.f7208b = parcel.readString();
    }

    public void a(double d2) {
        this.f7207a = d2;
    }

    public void a(String str) {
        this.f7208b = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f7207a);
        parcel.writeString(this.f7208b);
    }
}
