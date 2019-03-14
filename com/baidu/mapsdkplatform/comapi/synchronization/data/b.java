package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
final class b implements Parcelable.Creator<RouteLineInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteLineInfo createFromParcel(Parcel parcel) {
        return new RouteLineInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteLineInfo[] newArray(int i) {
        return new RouteLineInfo[i];
    }
}
