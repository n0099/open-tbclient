package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class TrainInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<TrainInfo> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private double f2105a;
    private String b;

    public TrainInfo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TrainInfo(Parcel parcel) {
        super(parcel);
        this.f2105a = parcel.readDouble();
        this.b = parcel.readString();
    }

    public void a(double d) {
        this.f2105a = d;
    }

    public void a(String str) {
        this.b = str;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f2105a);
        parcel.writeString(this.b);
    }
}
