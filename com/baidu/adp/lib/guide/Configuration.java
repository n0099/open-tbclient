package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> k = new c();
    View a = null;
    int b = MotionEventCompat.ACTION_MASK;
    int c = -1;
    int d = -1;
    int e = 17170444;
    boolean f = true;
    boolean g = false;
    boolean h = false;
    int i = -1;
    int j = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeByte((byte) (this.f ? 1 : 0));
        parcel.writeByte((byte) (this.g ? 1 : 0));
    }

    public String toString() {
        return "Configuration{mAlpha=" + this.b + ", mFullingViewId=" + this.c + ", mTargetViewId=" + this.d + ", mFullingColorId=" + this.e + ", mAutoDismiss=" + this.f + ", mOverlayTarget=" + this.g + '}';
    }
}
