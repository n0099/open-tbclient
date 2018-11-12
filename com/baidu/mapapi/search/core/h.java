package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
final class h implements Parcelable.Creator<PriceInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PriceInfo createFromParcel(Parcel parcel) {
        return new PriceInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PriceInfo[] newArray(int i) {
        return new PriceInfo[i];
    }
}
