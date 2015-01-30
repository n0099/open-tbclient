package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean jn;
    View aE = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int jo = -1;
    int jp = -1;
    int jq = 17170444;
    boolean jr = true;
    boolean js = false;
    boolean jt = false;
    int ju = -1;
    int jv = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.jo);
        parcel.writeInt(this.jp);
        parcel.writeInt(this.jq);
        parcel.writeByte((byte) (this.jr ? 1 : 0));
        parcel.writeByte((byte) (this.js ? 1 : 0));
    }
}
