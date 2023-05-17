package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class k implements Parcelable.Creator<RecommendStopInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RecommendStopInfo createFromParcel(Parcel parcel) {
        return new RecommendStopInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RecommendStopInfo[] newArray(int i) {
        return new RecommendStopInfo[i];
    }
}
