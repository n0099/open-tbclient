package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean uE;
    View lI = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int uF = -1;
    int uG = -1;
    int uH = 17170444;
    boolean uI = true;
    boolean uJ = false;
    boolean uK = false;
    int uL = -1;
    int uM = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.uF);
        parcel.writeInt(this.uG);
        parcel.writeInt(this.uH);
        parcel.writeByte((byte) (this.uI ? 1 : 0));
        parcel.writeByte((byte) (this.uJ ? 1 : 0));
    }
}
