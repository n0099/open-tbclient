package com.baidu.sapi2.share;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class d implements Parcelable.Creator<ShareModel> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareModel createFromParcel(Parcel parcel) {
        return new ShareModel(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ShareModel[] newArray(int i) {
        return new ShareModel[i];
    }
}
