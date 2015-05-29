package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean tP;
    View lI = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tQ = -1;
    int tR = -1;
    int tS = 17170444;
    boolean tT = true;
    boolean tU = false;
    boolean tV = false;
    int tW = -1;
    int tX = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tQ);
        parcel.writeInt(this.tR);
        parcel.writeInt(this.tS);
        parcel.writeByte((byte) (this.tT ? 1 : 0));
        parcel.writeByte((byte) (this.tU ? 1 : 0));
    }
}
