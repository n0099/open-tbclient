package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.DrivingRouteLine;
/* loaded from: classes4.dex */
final class e implements Parcelable.Creator<DrivingRouteLine.DrivingStep> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteLine.DrivingStep createFromParcel(Parcel parcel) {
        return new DrivingRouteLine.DrivingStep(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivingRouteLine.DrivingStep[] newArray(int i) {
        return new DrivingRouteLine.DrivingStep[i];
    }
}
