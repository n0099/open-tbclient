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
            configuration.tM = parcel.readInt();
            configuration.tN = parcel.readInt();
            configuration.tO = parcel.readInt();
            configuration.tP = parcel.readByte() == 1;
            configuration.tQ = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ac */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean tL;
    View ju = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int tM = -1;
    int tN = -1;
    int tO = 17170444;
    boolean tP = true;
    boolean tQ = false;
    boolean tR = false;
    int tS = -1;
    int tT = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.tM);
        parcel.writeInt(this.tN);
        parcel.writeInt(this.tO);
        parcel.writeByte((byte) (this.tP ? 1 : 0));
        parcel.writeByte((byte) (this.tQ ? 1 : 0));
    }
}
