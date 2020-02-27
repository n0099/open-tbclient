package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes8.dex */
final class a implements Parcelable.Creator<DriverPosition> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriverPosition createFromParcel(Parcel parcel) {
        return new DriverPosition(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriverPosition[] newArray(int i) {
        return new DriverPosition[i];
    }
}
