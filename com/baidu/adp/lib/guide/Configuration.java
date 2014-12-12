package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean jl;
    View aD = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int jm = -1;
    int jn = -1;
    int jo = 17170444;
    boolean jp = true;
    boolean jq = false;
    boolean jr = false;
    int js = -1;
    int jt = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.jm);
        parcel.writeInt(this.jn);
        parcel.writeInt(this.jo);
        parcel.writeByte((byte) (this.jp ? 1 : 0));
        parcel.writeByte((byte) (this.jq ? 1 : 0));
    }
}
