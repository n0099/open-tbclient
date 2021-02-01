package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
/* loaded from: classes4.dex */
final class b implements Parcelable.Creator<HistoryTraceData.HistoryTracePoint> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public HistoryTraceData.HistoryTracePoint createFromParcel(Parcel parcel) {
        return new HistoryTraceData.HistoryTracePoint(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public HistoryTraceData.HistoryTracePoint[] newArray(int i) {
        return new HistoryTraceData.HistoryTracePoint[i];
    }
}
