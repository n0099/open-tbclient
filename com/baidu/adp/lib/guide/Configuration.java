package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean tO;
    View lJ = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tP = -1;
    int tQ = -1;
    int tR = 17170444;
    boolean tS = true;
    boolean tT = false;
    boolean tU = false;
    int tV = -1;
    int tW = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tP);
        parcel.writeInt(this.tQ);
        parcel.writeInt(this.tR);
        parcel.writeByte((byte) (this.tS ? 1 : 0));
        parcel.writeByte((byte) (this.tT ? 1 : 0));
    }
}
