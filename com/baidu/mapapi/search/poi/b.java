package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<PoiDetailSearchResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailSearchResult createFromParcel(Parcel parcel) {
        return new PoiDetailSearchResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailSearchResult[] newArray(int i) {
        return new PoiDetailSearchResult[i];
    }
}
