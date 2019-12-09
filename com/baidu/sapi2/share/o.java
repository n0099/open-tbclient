package com.baidu.sapi2.share;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
class o implements Parcelable.Creator<ShareModel> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ShareModel createFromParcel(Parcel parcel) {
        return new ShareModel(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ShareModel[] newArray(int i) {
        return new ShareModel[i];
    }
}
