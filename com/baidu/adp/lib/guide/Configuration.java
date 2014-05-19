package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> l = new c();
    boolean b;
    View a = null;
    int c = MotionEventCompat.ACTION_MASK;
    int d = -1;
    int e = -1;
    int f = 17170444;
    boolean g = true;
    boolean h = false;
    boolean i = false;
    int j = -1;
    int k = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeByte((byte) (this.g ? 1 : 0));
        parcel.writeByte((byte) (this.h ? 1 : 0));
    }

    public String toString() {
        return "Configuration{mAlpha=" + this.c + ", mFullingViewId=" + this.d + ", mTargetViewId=" + this.e + ", mFullingColorId=" + this.f + ", mAutoDismiss=" + this.g + ", mOverlayTarget=" + this.h + '}';
    }
}
