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
            configuration.aic = parcel.readInt();
            configuration.aid = parcel.readInt();
            configuration.aie = parcel.readInt();
            configuration.aif = parcel.readByte() == 1;
            configuration.aig = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cV */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean aib;
    View yH = null;
    int mAlpha = 255;
    int aic = -1;
    int aid = -1;
    int aie = 17170444;
    boolean aif = true;
    boolean aig = false;
    boolean aih = false;
    int aii = -1;
    int aij = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.aic);
        parcel.writeInt(this.aid);
        parcel.writeInt(this.aie);
        parcel.writeByte((byte) (this.aif ? 1 : 0));
        parcel.writeByte((byte) (this.aig ? 1 : 0));
    }
}
