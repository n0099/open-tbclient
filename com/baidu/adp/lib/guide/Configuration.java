package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean kF;
    View bL = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int kG = -1;
    int kH = -1;
    int kI = 17170444;
    boolean kJ = true;
    boolean kK = false;
    boolean kL = false;
    int kM = -1;
    int kN = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.kG);
        parcel.writeInt(this.kH);
        parcel.writeInt(this.kI);
        parcel.writeByte((byte) (this.kJ ? 1 : 0));
        parcel.writeByte((byte) (this.kK ? 1 : 0));
    }
}
