package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
final class o implements Parcelable.Creator<TransitBaseInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitBaseInfo createFromParcel(Parcel parcel) {
        return new TransitBaseInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitBaseInfo[] newArray(int i) {
        return new TransitBaseInfo[i];
    }
}
