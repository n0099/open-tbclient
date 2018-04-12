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
        /* renamed from: c */
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.mAlpha = parcel.readInt();
            configuration.ss = parcel.readInt();
            configuration.su = parcel.readInt();
            configuration.sv = parcel.readInt();
            configuration.sw = parcel.readByte() == 1;
            configuration.sx = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: V */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean sr;
    View mTargetView = null;
    int mAlpha = 255;
    int ss = -1;
    int su = -1;
    int sv = 17170444;
    boolean sw = true;
    boolean sx = false;
    boolean sy = false;
    int sz = -1;
    int sA = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.ss);
        parcel.writeInt(this.su);
        parcel.writeInt(this.sv);
        parcel.writeByte((byte) (this.sw ? 1 : 0));
        parcel.writeByte((byte) (this.sx ? 1 : 0));
    }
}
