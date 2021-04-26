package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<DrivingRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteLine createFromParcel(Parcel parcel) {
        return new DrivingRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteLine[] newArray(int i2) {
        return new DrivingRouteLine[i2];
    }
}
