package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes10.dex */
final class e implements Parcelable.Creator<PoiChildrenInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiChildrenInfo createFromParcel(Parcel parcel) {
        return new PoiChildrenInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiChildrenInfo[] newArray(int i) {
        return new PoiChildrenInfo[i];
    }
}
