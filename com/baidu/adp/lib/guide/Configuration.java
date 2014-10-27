package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean jg;
    View jf = null;
    int jh = MotionEventCompat.ACTION_MASK;
    int ji = -1;
    int jj = -1;
    int jk = 17170444;
    boolean jl = true;
    boolean jm = false;
    boolean jn = false;
    int jo = -1;
    int jp = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jh);
        parcel.writeInt(this.ji);
        parcel.writeInt(this.jj);
        parcel.writeInt(this.jk);
        parcel.writeByte((byte) (this.jl ? 1 : 0));
        parcel.writeByte((byte) (this.jm ? 1 : 0));
    }
}
