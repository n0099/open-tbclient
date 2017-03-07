package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean uJ;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int uK = -1;
    int uL = -1;
    int uM = 17170444;
    boolean uN = true;
    boolean uO = false;
    boolean uP = false;
    int uQ = -1;
    int uR = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.uK);
        parcel.writeInt(this.uL);
        parcel.writeInt(this.uM);
        parcel.writeByte((byte) (this.uN ? 1 : 0));
        parcel.writeByte((byte) (this.uO ? 1 : 0));
    }
}
