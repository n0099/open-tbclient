package com.baidu.mapapi.map;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<BaiduMapOptions> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BaiduMapOptions createFromParcel(Parcel parcel) {
        return new BaiduMapOptions(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BaiduMapOptions[] newArray(int i2) {
        return new BaiduMapOptions[i2];
    }
}
