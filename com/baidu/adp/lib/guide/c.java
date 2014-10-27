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
        configuration.jh = parcel.readInt();
        configuration.ji = parcel.readInt();
        configuration.jj = parcel.readInt();
        configuration.jk = parcel.readInt();
        configuration.jl = parcel.readByte() == 1;
        configuration.jm = parcel.readByte() == 1;
        return configuration;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: z */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
