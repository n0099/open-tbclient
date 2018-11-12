package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.MassTransitRouteLine;
/* loaded from: classes4.dex */
final class j implements Parcelable.Creator<MassTransitRouteLine.TransitStep> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine.TransitStep createFromParcel(Parcel parcel) {
        return new MassTransitRouteLine.TransitStep(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine.TransitStep[] newArray(int i) {
        return new MassTransitRouteLine.TransitStep[i];
    }
}
