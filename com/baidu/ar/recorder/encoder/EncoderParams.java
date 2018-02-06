package com.baidu.ar.recorder.encoder;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class EncoderParams implements Parcelable {
    public static final Parcelable.Creator<EncoderParams> CREATOR = new Parcelable.Creator<EncoderParams>() { // from class: com.baidu.ar.recorder.encoder.EncoderParams.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EncoderParams createFromParcel(Parcel parcel) {
            return new EncoderParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public EncoderParams[] newArray(int i) {
            return new EncoderParams[i];
        }
    };
    private String a;
    private int b;
    private long c;
    private boolean d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private String l;
    private int m;
    private int n;
    private int o;
    private int p;

    public EncoderParams() {
        this.a = "/sdcard/AR/arvideo/video/arvideo.mp4";
        this.b = 0;
        this.c = 0L;
        this.d = true;
        this.e = 720;
        this.f = 1280;
        this.g = "video/avc";
        this.h = 3145728;
        this.i = 30;
        this.j = 1;
        this.k = true;
        this.l = "audio/mp4a-latm";
        this.m = 1;
        this.n = 128000;
        this.o = 44100;
        this.p = 10240;
    }

    protected EncoderParams(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readLong();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readByte() != 0;
        this.l = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.f = i;
    }

    public long c() {
        return this.c;
    }

    public void c(int i) {
        this.o = i;
    }

    public void d(int i) {
        this.p = i;
    }

    public boolean d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }

    public String l() {
        return this.l;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        return this.n;
    }

    public int o() {
        return this.o;
    }

    public int p() {
        return this.p;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeString(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
    }
}
