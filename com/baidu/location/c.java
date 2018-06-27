package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
final class c implements Parcelable.Creator<Poi> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi createFromParcel(Parcel parcel) {
        return new Poi(parcel.readString(), parcel.readString(), parcel.readDouble());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public Poi[] newArray(int i) {
        return new Poi[i];
    }
}
