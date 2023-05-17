package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class l implements Parcelable.Creator<RouteNode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteNode createFromParcel(Parcel parcel) {
        return new RouteNode(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteNode[] newArray(int i) {
        return new RouteNode[i];
    }
}
