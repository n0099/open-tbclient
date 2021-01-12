package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.PoiInfo;
/* loaded from: classes6.dex */
final class h implements Parcelable.Creator<PoiInfo.ParentPoiInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiInfo.ParentPoiInfo createFromParcel(Parcel parcel) {
        return new PoiInfo.ParentPoiInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiInfo.ParentPoiInfo[] newArray(int i) {
        return new PoiInfo.ParentPoiInfo[i];
    }
}
