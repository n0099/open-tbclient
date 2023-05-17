package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
/* loaded from: classes3.dex */
public final class e implements Parcelable.Creator<ReverseGeoCodeResult.RoadInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ReverseGeoCodeResult.RoadInfo createFromParcel(Parcel parcel) {
        return new ReverseGeoCodeResult.RoadInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ReverseGeoCodeResult.RoadInfo[] newArray(int i) {
        return new ReverseGeoCodeResult.RoadInfo[i];
    }
}
