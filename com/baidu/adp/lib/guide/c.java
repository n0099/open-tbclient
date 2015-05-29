package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class c implements Parcelable.Creator<Configuration> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: c */
    public Configuration createFromParcel(Parcel parcel) {
        Configuration configuration = new Configuration();
        configuration.mAlpha = parcel.readInt();
        configuration.tQ = parcel.readInt();
        configuration.tR = parcel.readInt();
        configuration.tS = parcel.readInt();
        configuration.tT = parcel.readByte() == 1;
        configuration.tU = parcel.readByte() == 1;
        return configuration;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: L */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
