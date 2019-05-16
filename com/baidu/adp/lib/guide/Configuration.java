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
            configuration.zk = parcel.readInt();
            configuration.zl = parcel.readInt();
            configuration.zm = parcel.readInt();
            configuration.zn = parcel.readByte() == 1;
            configuration.zo = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean zj;
    View mTargetView = null;
    int mAlpha = 255;
    int zk = -1;
    int zl = -1;
    int zm = 17170444;
    boolean zn = true;
    boolean zo = false;
    boolean zp = false;
    int zq = -1;
    int zr = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.zk);
        parcel.writeInt(this.zl);
        parcel.writeInt(this.zm);
        parcel.writeByte((byte) (this.zn ? 1 : 0));
        parcel.writeByte((byte) (this.zo ? 1 : 0));
    }
}
