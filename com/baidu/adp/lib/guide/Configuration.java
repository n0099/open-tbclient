package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new c();
    boolean us;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int ut = -1;
    int uu = -1;
    int uv = 17170444;
    boolean uw = true;
    boolean ux = false;
    boolean uy = false;
    int uz = -1;
    int uA = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.ut);
        parcel.writeInt(this.uu);
        parcel.writeInt(this.uv);
        parcel.writeByte((byte) (this.uw ? 1 : 0));
        parcel.writeByte((byte) (this.ux ? 1 : 0));
    }
}
