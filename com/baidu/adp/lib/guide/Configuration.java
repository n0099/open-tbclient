package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean tS;
    View lJ = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tT = -1;
    int tU = -1;
    int tV = 17170444;
    boolean tW = true;
    boolean tX = false;
    boolean tY = false;
    int tZ = -1;
    int ua = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tT);
        parcel.writeInt(this.tU);
        parcel.writeInt(this.tV);
        parcel.writeByte((byte) (this.tW ? 1 : 0));
        parcel.writeByte((byte) (this.tX ? 1 : 0));
    }
}
