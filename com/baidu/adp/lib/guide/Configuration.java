package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class Configuration implements Parcelable {
    public static Parcelable.Creator j = new a();

    /* renamed from: a  reason: collision with root package name */
    int f424a = Util.MASK_8BIT;
    int b = -1;
    int c = -1;
    int d = 17170444;
    boolean e = true;
    boolean f = false;
    boolean g = false;
    int h = -1;
    int i = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f424a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByte((byte) (this.e ? 1 : 0));
        parcel.writeByte((byte) (this.f ? 1 : 0));
    }

    public String toString() {
        return "Configuration{mAlpha=" + this.f424a + ", mFullingViewId=" + this.b + ", mTargetViewId=" + this.c + ", mFullingColorId=" + this.d + ", mAutoDismiss=" + this.e + ", mOverlayTarget=" + this.f + '}';
    }
}
