package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes10.dex */
final class g implements Parcelable.Creator<PoiInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiInfo createFromParcel(Parcel parcel) {
        return new PoiInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiInfo[] newArray(int i) {
        return new PoiInfo[i];
    }
}
