package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> a = new b();
    private Bundle b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.b;
    }

    public void setBundle(Bundle bundle) {
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.b);
    }
}
