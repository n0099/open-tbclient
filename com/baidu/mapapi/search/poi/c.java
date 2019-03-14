package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
final class c implements Parcelable.Creator<PoiFilter> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiFilter createFromParcel(Parcel parcel) {
        return new PoiFilter(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiFilter[] newArray(int i) {
        return new PoiFilter[i];
    }
}
