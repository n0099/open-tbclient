package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* loaded from: classes.dex */
public class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new a();

    /* renamed from: f  reason: collision with root package name */
    public boolean f2159f;

    /* renamed from: e  reason: collision with root package name */
    public View f2158e = null;

    /* renamed from: g  reason: collision with root package name */
    public int f2160g = 255;

    /* renamed from: h  reason: collision with root package name */
    public int f2161h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f2162i = -1;
    public int j = 17170444;
    public boolean k = true;
    public boolean l = false;
    public int m = -1;
    public int n = -1;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<Configuration> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.f2160g = parcel.readInt();
            configuration.f2161h = parcel.readInt();
            configuration.f2162i = parcel.readInt();
            configuration.j = parcel.readInt();
            configuration.k = parcel.readByte() == 1;
            configuration.l = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Configuration[] newArray(int i2) {
            return new Configuration[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2160g);
        parcel.writeInt(this.f2161h);
        parcel.writeInt(this.f2162i);
        parcel.writeInt(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }
}
