package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes10.dex */
final class c implements Parcelable.Creator<CoachInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CoachInfo createFromParcel(Parcel parcel) {
        return new CoachInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public CoachInfo[] newArray(int i) {
        return new CoachInfo[i];
    }
}
