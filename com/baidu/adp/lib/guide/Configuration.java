package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
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
            configuration.ut = parcel.readInt();
            configuration.uu = parcel.readInt();
            configuration.uv = parcel.readInt();
            configuration.uw = parcel.readByte() == 1;
            configuration.ux = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ac */
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean us;
    View jv = null;
    int mAlpha = MotionEventCompat.ACTION_MASK;
    int ut = -1;
    int uu = -1;
    int uv = 17170444;
    boolean uw = true;
    boolean ux = false;
    boolean uy = false;
    int uz = -1;
    int uA = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.ut);
        parcel.writeInt(this.uu);
        parcel.writeInt(this.uv);
        parcel.writeByte((byte) (this.uw ? 1 : 0));
        parcel.writeByte((byte) (this.ux ? 1 : 0));
    }
}
