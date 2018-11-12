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
            configuration.BC = parcel.readInt();
            configuration.BD = parcel.readInt();
            configuration.BE = parcel.readInt();
            configuration.BF = parcel.readByte() == 1;
            configuration.BG = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: av */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean mOutsideTouchable;
    View mTargetView = null;
    int mAlpha = 255;
    int BC = -1;
    int BD = -1;
    int BE = 17170444;
    boolean BF = true;
    boolean BG = false;
    boolean BH = false;
    int BI = -1;
    int BJ = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.BC);
        parcel.writeInt(this.BD);
        parcel.writeInt(this.BE);
        parcel.writeByte((byte) (this.BF ? 1 : 0));
        parcel.writeByte((byte) (this.BG ? 1 : 0));
    }
}
