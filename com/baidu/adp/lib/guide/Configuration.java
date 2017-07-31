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
            configuration.vV = parcel.readInt();
            configuration.vW = parcel.readInt();
            configuration.vX = parcel.readInt();
            configuration.vY = parcel.readByte() == 1;
            configuration.vZ = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: af */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean vU;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int vV = -1;
    int vW = -1;
    int vX = 17170444;
    boolean vY = true;
    boolean vZ = false;
    boolean wa = false;
    int wb = -1;
    int wc = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.vV);
        parcel.writeInt(this.vW);
        parcel.writeInt(this.vX);
        parcel.writeByte((byte) (this.vY ? 1 : 0));
        parcel.writeByte((byte) (this.vZ ? 1 : 0));
    }
}
