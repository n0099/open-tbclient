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
        configuration.na = parcel.readInt();
        configuration.nb = parcel.readInt();
        configuration.nc = parcel.readInt();
        configuration.nd = parcel.readByte() == 1;
        configuration.ne = parcel.readByte() == 1;
        return configuration;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: ac */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
