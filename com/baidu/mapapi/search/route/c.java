package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
final class c implements Parcelable.Creator<BikingRouteResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteResult createFromParcel(Parcel parcel) {
        return new BikingRouteResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteResult[] newArray(int i) {
        return new BikingRouteResult[i];
    }
}
