package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class r implements Parcelable.Creator<WalkingRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkingRouteLine createFromParcel(Parcel parcel) {
        return new WalkingRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkingRouteLine[] newArray(int i) {
        return new WalkingRouteLine[i];
    }
}
