package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean tU;
    View lJ = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tV = -1;
    int tW = -1;
    int tX = 17170444;
    boolean tY = true;
    boolean tZ = false;
    boolean ua = false;
    int ub = -1;
    int uc = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tV);
        parcel.writeInt(this.tW);
        parcel.writeInt(this.tX);
        parcel.writeByte((byte) (this.tY ? 1 : 0));
        parcel.writeByte((byte) (this.tZ ? 1 : 0));
    }
}
