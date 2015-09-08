package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean tM;
    View lJ = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tN = -1;
    int tO = -1;
    int tP = 17170444;
    boolean tQ = true;
    boolean tR = false;
    boolean tS = false;
    int tT = -1;
    int tU = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tN);
        parcel.writeInt(this.tO);
        parcel.writeInt(this.tP);
        parcel.writeByte((byte) (this.tQ ? 1 : 0));
        parcel.writeByte((byte) (this.tR ? 1 : 0));
    }
}
