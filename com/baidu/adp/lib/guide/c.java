package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class c implements Parcelable.Creator<Configuration> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Configuration createFromParcel(Parcel parcel) {
        Configuration configuration = new Configuration();
        configuration.b = parcel.readInt();
        configuration.c = parcel.readInt();
        configuration.d = parcel.readInt();
        configuration.e = parcel.readInt();
        configuration.f = parcel.readByte() == 1;
        configuration.g = parcel.readByte() == 1;
        return configuration;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
