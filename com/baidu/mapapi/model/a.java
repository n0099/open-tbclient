package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<LatLng> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLng createFromParcel(Parcel parcel) {
        return new LatLng(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLng[] newArray(int i2) {
        return new LatLng[i2];
    }
}
