package com.baidu.sapi2;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
class n implements Parcelable.Creator<SapiAccount> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public SapiAccount createFromParcel(Parcel parcel) {
        return new SapiAccount(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public SapiAccount[] newArray(int i) {
        return new SapiAccount[i];
    }
}
