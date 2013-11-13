package com.baidu.android.pushservice.message;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class h implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PublicMsg createFromParcel(Parcel parcel) {
        return new PublicMsg(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PublicMsg[] newArray(int i) {
        return new PublicMsg[i];
    }
}
