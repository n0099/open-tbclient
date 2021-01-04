package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes15.dex */
final class a implements Parcelable.Creator<BusLineResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusLineResult createFromParcel(Parcel parcel) {
        return new BusLineResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusLineResult[] newArray(int i) {
        return new BusLineResult[i];
    }
}
