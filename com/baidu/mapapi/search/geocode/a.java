package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<GeoCodeResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GeoCodeResult createFromParcel(Parcel parcel) {
        return new GeoCodeResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GeoCodeResult[] newArray(int i) {
        return new GeoCodeResult[i];
    }
}
