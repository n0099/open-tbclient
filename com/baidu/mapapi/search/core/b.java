package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
final class b implements Parcelable.Creator<CityInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CityInfo createFromParcel(Parcel parcel) {
        return new CityInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CityInfo[] newArray(int i) {
        return new CityInfo[i];
    }
}
