package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean ud;
    View lJ = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int ue = -1;
    int uf = -1;
    int ug = 17170444;
    boolean uh = true;
    boolean ui = false;
    boolean uj = false;
    int uk = -1;
    int ul = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.ue);
        parcel.writeInt(this.uf);
        parcel.writeInt(this.ug);
        parcel.writeByte((byte) (this.uh ? 1 : 0));
        parcel.writeByte((byte) (this.ui ? 1 : 0));
    }
}
