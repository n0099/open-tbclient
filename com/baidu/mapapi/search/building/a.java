package com.baidu.mapapi.search.building;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class a implements Parcelable.Creator<BuildingResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BuildingResult createFromParcel(Parcel parcel) {
        return new BuildingResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BuildingResult[] newArray(int i) {
        return new BuildingResult[i];
    }
}
