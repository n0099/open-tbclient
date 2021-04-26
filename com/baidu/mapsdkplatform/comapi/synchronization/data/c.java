package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<RouteLineInfo.RouteSectionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteLineInfo.RouteSectionInfo createFromParcel(Parcel parcel) {
        return new RouteLineInfo.RouteSectionInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteLineInfo.RouteSectionInfo[] newArray(int i2) {
        return new RouteLineInfo.RouteSectionInfo[i2];
    }
}
