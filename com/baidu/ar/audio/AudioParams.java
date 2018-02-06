package com.baidu.ar.audio;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class AudioParams implements Parcelable {
    public static final Parcelable.Creator<AudioParams> CREATOR = new Parcelable.Creator<AudioParams>() { // from class: com.baidu.ar.audio.AudioParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AudioParams createFromParcel(Parcel parcel) {
            return new AudioParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AudioParams[] newArray(int i) {
            return new AudioParams[i];
        }
    };
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;

    public AudioParams() {
        this.a = 1;
        this.b = 44100;
        this.c = 16;
        this.d = 2;
        this.e = 10240;
    }

    protected AudioParams(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.e = i;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
