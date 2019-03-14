package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
final class k implements Parcelable.Creator<RouteStep> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteStep createFromParcel(Parcel parcel) {
        return new RouteStep(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteStep[] newArray(int i) {
        return new RouteStep[i];
    }
}
