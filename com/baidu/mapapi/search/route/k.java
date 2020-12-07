package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.route.MassTransitRouteLine;
/* loaded from: classes26.dex */
final class k implements Parcelable.Creator<MassTransitRouteLine.TransitStep.TrafficCondition> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine.TransitStep.TrafficCondition createFromParcel(Parcel parcel) {
        return new MassTransitRouteLine.TransitStep.TrafficCondition(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public MassTransitRouteLine.TransitStep.TrafficCondition[] newArray(int i) {
        return new MassTransitRouteLine.TransitStep.TrafficCondition[i];
    }
}
