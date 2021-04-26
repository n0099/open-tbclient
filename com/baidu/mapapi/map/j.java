package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<MapStatus> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MapStatus createFromParcel(Parcel parcel) {
        return new MapStatus(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MapStatus[] newArray(int i2) {
        return new MapStatus[i2];
    }
}
