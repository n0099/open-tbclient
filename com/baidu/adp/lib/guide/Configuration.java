package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean ur;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int us = -1;
    int ut = -1;
    int uu = 17170444;
    boolean uv = true;
    boolean uw = false;
    boolean ux = false;
    int uy = -1;
    int uz = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.us);
        parcel.writeInt(this.ut);
        parcel.writeInt(this.uu);
        parcel.writeByte((byte) (this.uv ? 1 : 0));
        parcel.writeByte((byte) (this.uw ? 1 : 0));
    }
}
