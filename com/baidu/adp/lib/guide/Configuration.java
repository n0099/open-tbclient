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
            configuration.BB = parcel.readInt();
            configuration.BC = parcel.readInt();
            configuration.BD = parcel.readInt();
            configuration.BE = parcel.readByte() == 1;
            configuration.BF = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ad */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean BA;
    View mTargetView = null;
    int mAlpha = 255;
    int BB = -1;
    int BC = -1;
    int BD = 17170444;
    boolean BE = true;
    boolean BF = false;
    boolean BG = false;
    int BH = -1;
    int BI = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.BB);
        parcel.writeInt(this.BC);
        parcel.writeInt(this.BD);
        parcel.writeByte((byte) (this.BE ? 1 : 0));
        parcel.writeByte((byte) (this.BF ? 1 : 0));
    }
}
