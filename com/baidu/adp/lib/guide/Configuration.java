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
        /* renamed from: d */
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.mAlpha = parcel.readInt();
            configuration.Bz = parcel.readInt();
            configuration.BA = parcel.readInt();
            configuration.BB = parcel.readInt();
            configuration.BC = parcel.readByte() == 1;
            configuration.BD = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ae */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean mOutsideTouchable;
    View mTargetView = null;
    int mAlpha = 255;
    int Bz = -1;
    int BA = -1;
    int BB = 17170444;
    boolean BC = true;
    boolean BD = false;
    boolean BE = false;
    int BF = -1;
    int BG = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.Bz);
        parcel.writeInt(this.BA);
        parcel.writeInt(this.BB);
        parcel.writeByte((byte) (this.BC ? 1 : 0));
        parcel.writeByte((byte) (this.BD ? 1 : 0));
    }
}
