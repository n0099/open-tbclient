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
            configuration.yA = parcel.readInt();
            configuration.yB = parcel.readInt();
            configuration.yC = parcel.readInt();
            configuration.yD = parcel.readByte() == 1;
            configuration.yE = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean yz;
    View mTargetView = null;
    int mAlpha = 255;
    int yA = -1;
    int yB = -1;
    int yC = 17170444;
    boolean yD = true;
    boolean yE = false;
    boolean yF = false;
    int yG = -1;
    int yH = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.yA);
        parcel.writeInt(this.yB);
        parcel.writeInt(this.yC);
        parcel.writeByte((byte) (this.yD ? 1 : 0));
        parcel.writeByte((byte) (this.yE ? 1 : 0));
    }
}
