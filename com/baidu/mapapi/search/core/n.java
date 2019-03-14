package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
final class n implements Parcelable.Creator<TrainInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TrainInfo createFromParcel(Parcel parcel) {
        return new TrainInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TrainInfo[] newArray(int i) {
        return new TrainInfo[i];
    }
}
