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
            configuration.tP = parcel.readInt();
            configuration.tQ = parcel.readInt();
            configuration.tR = parcel.readInt();
            configuration.tS = parcel.readByte() == 1;
            configuration.tT = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ac */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean tO;
    View ju = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tP = -1;
    int tQ = -1;
    int tR = 17170444;
    boolean tS = true;
    boolean tT = false;
    boolean tU = false;
    int tV = -1;
    int tW = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tP);
        parcel.writeInt(this.tQ);
        parcel.writeInt(this.tR);
        parcel.writeByte((byte) (this.tS ? 1 : 0));
        parcel.writeByte((byte) (this.tT ? 1 : 0));
    }
}
