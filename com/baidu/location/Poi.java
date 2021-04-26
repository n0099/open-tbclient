package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class Poi implements Parcelable {
    public static final Parcelable.Creator<Poi> CREATOR = new d();
    public final String mId;
    public final String mName;
    public final double mRank;

    public Poi(String str, String str2, double d2) {
        this.mId = str;
        this.mName = str2;
        this.mRank = d2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public double getRank() {
        return this.mRank;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeDouble(this.mRank);
    }
}
