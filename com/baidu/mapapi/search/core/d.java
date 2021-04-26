package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<PlaneInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlaneInfo createFromParcel(Parcel parcel) {
        return new PlaneInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlaneInfo[] newArray(int i2) {
        return new PlaneInfo[i2];
    }
}
