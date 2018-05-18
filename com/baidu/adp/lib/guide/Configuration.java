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
            configuration.sr = parcel.readInt();
            configuration.ss = parcel.readInt();
            configuration.su = parcel.readInt();
            configuration.sv = parcel.readByte() == 1;
            configuration.sw = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: V */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean sq;
    View mTargetView = null;
    int mAlpha = 255;
    int sr = -1;
    int ss = -1;
    int su = 17170444;
    boolean sv = true;
    boolean sw = false;
    boolean sx = false;
    int sy = -1;
    int sz = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.sr);
        parcel.writeInt(this.ss);
        parcel.writeInt(this.su);
        parcel.writeByte((byte) (this.sv ? 1 : 0));
        parcel.writeByte((byte) (this.sw ? 1 : 0));
    }
}
