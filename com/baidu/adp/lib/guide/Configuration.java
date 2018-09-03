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
            configuration.yw = parcel.readInt();
            configuration.yx = parcel.readInt();
            configuration.yy = parcel.readInt();
            configuration.yz = parcel.readByte() == 1;
            configuration.yA = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean yv;
    View mTargetView = null;
    int mAlpha = 255;
    int yw = -1;
    int yx = -1;
    int yy = 17170444;
    boolean yz = true;
    boolean yA = false;
    boolean yB = false;
    int yC = -1;
    int yD = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.yw);
        parcel.writeInt(this.yx);
        parcel.writeInt(this.yy);
        parcel.writeByte((byte) (this.yz ? 1 : 0));
        parcel.writeByte((byte) (this.yA ? 1 : 0));
    }
}
