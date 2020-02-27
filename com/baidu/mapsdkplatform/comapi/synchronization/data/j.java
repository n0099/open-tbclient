package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes8.dex */
final class j implements Parcelable.Creator<SyncResponseResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SyncResponseResult createFromParcel(Parcel parcel) {
        return new SyncResponseResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SyncResponseResult[] newArray(int i) {
        return new SyncResponseResult[i];
    }
}
