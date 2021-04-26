package com.baidu.mapapi.search.district;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<DistrictResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictResult createFromParcel(Parcel parcel) {
        return new DistrictResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictResult[] newArray(int i2) {
        return new DistrictResult[i2];
    }
}
