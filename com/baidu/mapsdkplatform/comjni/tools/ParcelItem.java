package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class ParcelItem implements Parcelable {
    public static final Parcelable.Creator<ParcelItem> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public Bundle f7943a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        return this.f7943a;
    }

    public void setBundle(Bundle bundle) {
        this.f7943a = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f7943a);
    }
}
