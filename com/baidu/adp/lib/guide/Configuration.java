package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() { // from class: com.baidu.adp.lib.guide.Configuration.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: s */
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.mAlpha = parcel.readInt();
            configuration.aid = parcel.readInt();
            configuration.aie = parcel.readInt();
            configuration.aif = parcel.readInt();
            configuration.aig = parcel.readByte() == 1;
            configuration.aih = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cV */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean aic;
    View yG = null;
    int mAlpha = 255;
    int aid = -1;
    int aie = -1;
    int aif = 17170444;
    boolean aig = true;
    boolean aih = false;
    boolean aii = false;
    int aij = -1;
    int aik = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.aid);
        parcel.writeInt(this.aie);
        parcel.writeInt(this.aif);
        parcel.writeByte((byte) (this.aig ? 1 : 0));
        parcel.writeByte((byte) (this.aih ? 1 : 0));
    }
}
