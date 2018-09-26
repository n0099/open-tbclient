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
            configuration.AQ = parcel.readInt();
            configuration.AR = parcel.readInt();
            configuration.AT = parcel.readInt();
            configuration.AU = parcel.readByte() == 1;
            configuration.AV = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ae */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean AP;
    View mTargetView = null;
    int mAlpha = 255;
    int AQ = -1;
    int AR = -1;
    int AT = 17170444;
    boolean AU = true;
    boolean AV = false;
    boolean AW = false;
    int AX = -1;
    int AY = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.AQ);
        parcel.writeInt(this.AR);
        parcel.writeInt(this.AT);
        parcel.writeByte((byte) (this.AU ? 1 : 0));
        parcel.writeByte((byte) (this.AV ? 1 : 0));
    }
}
