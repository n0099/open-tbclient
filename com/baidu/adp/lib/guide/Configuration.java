package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean mZ;
    View bL = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int na = -1;
    int nb = -1;
    int nc = 17170444;
    boolean nd = true;
    boolean ne = false;
    boolean nf = false;
    int ng = -1;
    int nh = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.na);
        parcel.writeInt(this.nb);
        parcel.writeInt(this.nc);
        parcel.writeByte((byte) (this.nd ? 1 : 0));
        parcel.writeByte((byte) (this.ne ? 1 : 0));
    }
}
