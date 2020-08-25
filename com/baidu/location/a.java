package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes20.dex */
final class a implements Parcelable.Creator<BDLocation> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BDLocation createFromParcel(Parcel parcel) {
        return new BDLocation(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BDLocation[] newArray(int i) {
        return new BDLocation[i];
    }
}
