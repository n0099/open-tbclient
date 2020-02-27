package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes8.dex */
final class f implements Parcelable.Creator<PoiDetailInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailInfo createFromParcel(Parcel parcel) {
        return new PoiDetailInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiDetailInfo[] newArray(int i) {
        return new PoiDetailInfo[i];
    }
}
