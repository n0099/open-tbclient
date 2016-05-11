package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean kc;
    View bL = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int kd = -1;
    int ke = -1;
    int kf = 17170444;
    boolean kg = true;
    boolean kh = false;
    boolean ki = false;
    int kj = -1;
    int kk = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.kd);
        parcel.writeInt(this.ke);
        parcel.writeInt(this.kf);
        parcel.writeByte((byte) (this.kg ? 1 : 0));
        parcel.writeByte((byte) (this.kh ? 1 : 0));
    }
}
