package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<BikingRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteLine createFromParcel(Parcel parcel) {
        return new BikingRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteLine[] newArray(int i2) {
        return new BikingRouteLine[i2];
    }
}
