package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes26.dex */
final class m implements Parcelable.Creator<PlanNode> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlanNode createFromParcel(Parcel parcel) {
        return new PlanNode(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PlanNode[] newArray(int i) {
        return new PlanNode[i];
    }
}
