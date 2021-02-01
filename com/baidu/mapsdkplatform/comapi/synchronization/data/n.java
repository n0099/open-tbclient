package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
final class n implements Parcelable.Creator<TrafficInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TrafficInfo createFromParcel(Parcel parcel) {
        return new TrafficInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TrafficInfo[] newArray(int i) {
        return new TrafficInfo[i];
    }
}
