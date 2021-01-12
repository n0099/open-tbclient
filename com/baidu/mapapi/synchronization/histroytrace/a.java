package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
final class a implements Parcelable.Creator<HistoryTraceData> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public HistoryTraceData createFromParcel(Parcel parcel) {
        return new HistoryTraceData(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public HistoryTraceData[] newArray(int i) {
        return new HistoryTraceData[i];
    }
}
