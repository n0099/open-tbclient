package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<XAdLandingPageExtraInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public XAdLandingPageExtraInfo createFromParcel(Parcel parcel) {
        return new XAdLandingPageExtraInfo(parcel, (c) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public XAdLandingPageExtraInfo[] newArray(int i) {
        return new XAdLandingPageExtraInfo[i];
    }
}
