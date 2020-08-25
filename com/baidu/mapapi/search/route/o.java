package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes20.dex */
final class o implements Parcelable.Creator<TransitRouteLine> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitRouteLine createFromParcel(Parcel parcel) {
        return new TransitRouteLine(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitRouteLine[] newArray(int i) {
        return new TransitRouteLine[i];
    }
}
