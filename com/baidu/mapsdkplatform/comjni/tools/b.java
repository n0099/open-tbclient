package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<ParcelItem> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ParcelItem createFromParcel(Parcel parcel) {
        ParcelItem parcelItem = new ParcelItem();
        parcelItem.setBundle(parcel.readBundle());
        return parcelItem;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ParcelItem[] newArray(int i2) {
        return new ParcelItem[i2];
    }
}
