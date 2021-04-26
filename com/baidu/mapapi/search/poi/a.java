package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<PoiDetailResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailResult createFromParcel(Parcel parcel) {
        return new PoiDetailResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailResult[] newArray(int i2) {
        return new PoiDetailResult[i2];
    }
}
