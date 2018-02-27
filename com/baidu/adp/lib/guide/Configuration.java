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
            configuration.ahX = parcel.readInt();
            configuration.ahY = parcel.readInt();
            configuration.ahZ = parcel.readInt();
            configuration.aia = parcel.readByte() == 1;
            configuration.aib = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: cV */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean ahW;
    View yB = null;
    int mAlpha = 255;
    int ahX = -1;
    int ahY = -1;
    int ahZ = 17170444;
    boolean aia = true;
    boolean aib = false;
    boolean aic = false;
    int aid = -1;
    int aie = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.ahX);
        parcel.writeInt(this.ahY);
        parcel.writeInt(this.ahZ);
        parcel.writeByte((byte) (this.aia ? 1 : 0));
        parcel.writeByte((byte) (this.aib ? 1 : 0));
    }
}
