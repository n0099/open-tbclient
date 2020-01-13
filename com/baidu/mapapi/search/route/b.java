package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.BikingRouteLine;
/* loaded from: classes6.dex */
final class b implements Parcelable.Creator<BikingRouteLine.BikingStep> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteLine.BikingStep createFromParcel(Parcel parcel) {
        return new BikingRouteLine.BikingStep(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BikingRouteLine.BikingStep[] newArray(int i) {
        return new BikingRouteLine.BikingStep[i];
    }
}
