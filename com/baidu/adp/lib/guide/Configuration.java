package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean ul;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int um = -1;
    int uo = -1;
    int up = 17170444;
    boolean uq = true;
    boolean ur = false;
    boolean us = false;
    int ut = -1;
    int uu = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.um);
        parcel.writeInt(this.uo);
        parcel.writeInt(this.up);
        parcel.writeByte((byte) (this.uq ? 1 : 0));
        parcel.writeByte((byte) (this.ur ? 1 : 0));
    }
}
