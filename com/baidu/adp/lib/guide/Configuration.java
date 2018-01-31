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
            configuration.aif = parcel.readInt();
            configuration.aig = parcel.readInt();
            configuration.aih = parcel.readInt();
            configuration.aii = parcel.readByte() == 1;
            configuration.aij = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cV */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean aie;
    View yH = null;
    int mAlpha = 255;
    int aif = -1;
    int aig = -1;
    int aih = 17170444;
    boolean aii = true;
    boolean aij = false;
    boolean aik = false;
    int ail = -1;
    int aim = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.aif);
        parcel.writeInt(this.aig);
        parcel.writeInt(this.aih);
        parcel.writeByte((byte) (this.aii ? 1 : 0));
        parcel.writeByte((byte) (this.aij ? 1 : 0));
    }
}
