package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes8.dex */
final class a implements Parcelable.Creator<LinkPointPolyLineInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LinkPointPolyLineInfo createFromParcel(Parcel parcel) {
        return new LinkPointPolyLineInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LinkPointPolyLineInfo[] newArray(int i) {
        return new LinkPointPolyLineInfo[i];
    }
}
