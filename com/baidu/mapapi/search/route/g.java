package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public final class g implements Parcelable.Creator<IndoorRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public IndoorRouteLine createFromParcel(Parcel parcel) {
        return new IndoorRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public IndoorRouteLine[] newArray(int i) {
        return new IndoorRouteLine[i];
    }
}
