package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean jZ;
    View bL = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int kb = -1;
    int kc = -1;
    int kd = 17170444;
    boolean ke = true;
    boolean kf = false;
    boolean kg = false;
    int kh = -1;
    int ki = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.kb);
        parcel.writeInt(this.kc);
        parcel.writeInt(this.kd);
        parcel.writeByte((byte) (this.ke ? 1 : 0));
        parcel.writeByte((byte) (this.kf ? 1 : 0));
    }
}
