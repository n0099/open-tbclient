package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<RecommendStopResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RecommendStopResult createFromParcel(Parcel parcel) {
        return new RecommendStopResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RecommendStopResult[] newArray(int i) {
        return new RecommendStopResult[i];
    }
}
