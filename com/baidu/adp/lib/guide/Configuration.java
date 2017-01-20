package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean mQ;
    View bK = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int mS = -1;
    int mT = -1;
    int mU = 17170444;
    boolean mV = true;
    boolean mW = false;
    boolean mZ = false;
    int na = -1;
    int nb = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.mS);
        parcel.writeInt(this.mT);
        parcel.writeInt(this.mU);
        parcel.writeByte((byte) (this.mV ? 1 : 0));
        parcel.writeByte((byte) (this.mW ? 1 : 0));
    }
}
