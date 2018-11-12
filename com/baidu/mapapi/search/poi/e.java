package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
final class e implements Parcelable.Creator<PoiResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiResult createFromParcel(Parcel parcel) {
        return new PoiResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiResult[] newArray(int i) {
        return new PoiResult[i];
    }
}
