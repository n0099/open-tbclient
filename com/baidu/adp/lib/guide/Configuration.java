package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean um;
    View lK = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int uo = -1;
    int up = -1;
    int uq = 17170444;
    boolean ur = true;
    boolean us = false;
    boolean ut = false;
    int uu = -1;
    int uv = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.uo);
        parcel.writeInt(this.up);
        parcel.writeInt(this.uq);
        parcel.writeByte((byte) (this.ur ? 1 : 0));
        parcel.writeByte((byte) (this.us ? 1 : 0));
    }
}
