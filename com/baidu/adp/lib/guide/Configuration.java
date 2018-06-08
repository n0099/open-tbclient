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
            configuration.yC = parcel.readInt();
            configuration.yD = parcel.readInt();
            configuration.yE = parcel.readInt();
            configuration.yF = parcel.readByte() == 1;
            configuration.yG = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean yB;
    View mTargetView = null;
    int mAlpha = 255;
    int yC = -1;
    int yD = -1;
    int yE = 17170444;
    boolean yF = true;
    boolean yG = false;
    boolean yH = false;
    int yI = -1;
    int yJ = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.yC);
        parcel.writeInt(this.yD);
        parcel.writeInt(this.yE);
        parcel.writeByte((byte) (this.yF ? 1 : 0));
        parcel.writeByte((byte) (this.yG ? 1 : 0));
    }
}
