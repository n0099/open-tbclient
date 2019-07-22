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
            configuration.zp = parcel.readInt();
            configuration.zq = parcel.readInt();
            configuration.zr = parcel.readInt();
            configuration.zs = parcel.readByte() == 1;
            configuration.zt = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean zo;
    View mTargetView = null;
    int mAlpha = 255;
    int zp = -1;
    int zq = -1;
    int zr = 17170444;
    boolean zs = true;
    boolean zt = false;
    boolean zu = false;
    int zv = -1;
    int zw = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.zp);
        parcel.writeInt(this.zq);
        parcel.writeInt(this.zr);
        parcel.writeByte((byte) (this.zs ? 1 : 0));
        parcel.writeByte((byte) (this.zt ? 1 : 0));
    }
}
