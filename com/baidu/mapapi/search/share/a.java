package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes10.dex */
final class a implements Parcelable.Creator<ShareUrlResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareUrlResult createFromParcel(Parcel parcel) {
        return new ShareUrlResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareUrlResult[] newArray(int i) {
        return new ShareUrlResult[i];
    }
}
