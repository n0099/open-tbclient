package com.baidu.tbadk.core.voice.service;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
/* loaded from: classes3.dex */
public class Voice implements Parcelable {
    public static final Parcelable.Creator<Voice> CREATOR = new a();
    public Date createDate;
    public int duration;
    public int id;
    public String name;
    public long sob;
    public int stas;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<Voice> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Voice createFromParcel(Parcel parcel) {
            Voice voice = new Voice();
            voice.c((int) parcel.readLong());
            voice.d(parcel.readString());
            return voice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Voice[] newArray(int i2) {
            return new Voice[i2];
        }
    }

    public int a() {
        return this.duration;
    }

    public String b() {
        return this.name;
    }

    public void c(int i2) {
        this.duration = i2;
    }

    public void d(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.duration);
        parcel.writeString(this.name);
    }
}
