package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.TransitRouteLine;
/* loaded from: classes26.dex */
final class p implements Parcelable.Creator<TransitRouteLine.TransitStep> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitRouteLine.TransitStep createFromParcel(Parcel parcel) {
        return new TransitRouteLine.TransitStep(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public TransitRouteLine.TransitStep[] newArray(int i) {
        return new TransitRouteLine.TransitStep[i];
    }
}
