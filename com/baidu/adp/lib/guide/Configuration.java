package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean na;
    View bL = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int nb = -1;
    int nc = -1;
    int nd = 17170444;
    boolean ne = true;
    boolean nf = false;
    boolean ng = false;
    int nh = -1;
    int ni = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.nb);
        parcel.writeInt(this.nc);
        parcel.writeInt(this.nd);
        parcel.writeByte((byte) (this.ne ? 1 : 0));
        parcel.writeByte((byte) (this.nf ? 1 : 0));
    }
}
