package com.baidu.platform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes7.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private Bundle f3190a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.f3190a;
    }

    public void setBundle(Bundle bundle) {
        this.f3190a = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f3190a);
    }
}
