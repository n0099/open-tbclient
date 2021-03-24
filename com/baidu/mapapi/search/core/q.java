package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<VehicleInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public VehicleInfo createFromParcel(Parcel parcel) {
        return new VehicleInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public VehicleInfo[] newArray(int i) {
        return new VehicleInfo[i];
    }
}
