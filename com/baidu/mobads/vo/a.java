package com.baidu.mobads.vo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes20.dex */
final class a implements Parcelable.Creator<XAdInstanceInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public XAdInstanceInfo createFromParcel(Parcel parcel) {
        return new XAdInstanceInfo(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public XAdInstanceInfo[] newArray(int i) {
        return new XAdInstanceInfo[i];
    }
}
