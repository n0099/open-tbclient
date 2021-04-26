package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<MassTransitRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine createFromParcel(Parcel parcel) {
        return new MassTransitRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine[] newArray(int i2) {
        return new MassTransitRouteLine[i2];
    }
}
