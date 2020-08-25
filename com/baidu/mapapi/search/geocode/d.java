package com.baidu.mapapi.search.geocode;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
/* loaded from: classes20.dex */
final class d implements Parcelable.Creator<ReverseGeoCodeResult.PoiRegionsInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ReverseGeoCodeResult.PoiRegionsInfo createFromParcel(Parcel parcel) {
        return new ReverseGeoCodeResult.PoiRegionsInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ReverseGeoCodeResult.PoiRegionsInfo[] newArray(int i) {
        return new ReverseGeoCodeResult.PoiRegionsInfo[i];
    }
}
