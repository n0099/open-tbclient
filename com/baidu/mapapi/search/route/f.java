package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
final class f implements Parcelable.Creator<DrivingRouteResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteResult createFromParcel(Parcel parcel) {
        return new DrivingRouteResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteResult[] newArray(int i) {
        return new DrivingRouteResult[i];
    }
}
