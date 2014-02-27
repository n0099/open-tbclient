package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class a implements Parcelable.Creator<SapiAccount> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public final SapiAccount createFromParcel(Parcel parcel) {
        return new SapiAccount(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public final SapiAccount[] newArray(int i) {
        return new SapiAccount[i];
    }
}
