package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
final class h implements Parcelable.Creator<IndoorRouteResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public IndoorRouteResult createFromParcel(Parcel parcel) {
        return new IndoorRouteResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public IndoorRouteResult[] newArray(int i) {
        return new IndoorRouteResult[i];
    }
}
