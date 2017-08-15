package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() { // from class: com.baidu.adp.lib.guide.Configuration.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.mAlpha = parcel.readInt();
            configuration.vX = parcel.readInt();
            configuration.vY = parcel.readInt();
            configuration.vZ = parcel.readInt();
            configuration.wa = parcel.readByte() == 1;
            configuration.wb = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: af */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean vW;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int vX = -1;
    int vY = -1;
    int vZ = 17170444;
    boolean wa = true;
    boolean wb = false;
    boolean wc = false;
    int wd = -1;
    int we = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.vX);
        parcel.writeInt(this.vY);
        parcel.writeInt(this.vZ);
        parcel.writeByte((byte) (this.wa ? 1 : 0));
        parcel.writeByte((byte) (this.wb ? 1 : 0));
    }
}
