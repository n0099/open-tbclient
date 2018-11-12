package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> a = new k();
    private b b;
    private o c;
    private DriverPosition d;
    private float e;
    private long f;
    private float g;
    private long h;
    private int i;
    private String j;
    private String k;

    public j() {
        this.b = new b();
        this.c = new o();
        this.d = new DriverPosition();
        this.e = 0.0f;
        this.f = 0L;
        this.g = 0.0f;
        this.h = 0L;
        this.i = 0;
        this.j = null;
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Parcel parcel) {
        this.b = (b) parcel.readParcelable(b.class.getClassLoader());
        this.c = (o) parcel.readParcelable(o.class.getClassLoader());
        this.d = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.e = (float) parcel.readLong();
        this.f = parcel.readLong();
        this.g = (float) parcel.readLong();
        this.h = parcel.readLong();
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.readString();
    }

    public b a() {
        return this.b;
    }

    public void a(float f) {
        this.e = f;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.j = str;
    }

    public o b() {
        return this.c;
    }

    public void b(float f) {
        this.g = f;
    }

    public void b(long j) {
        this.h = j;
    }

    public void b(String str) {
        this.k = str;
    }

    public DriverPosition c() {
        return this.d;
    }

    public float d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, 1);
        parcel.writeParcelable(this.c, 1);
        parcel.writeParcelable(this.d, 1);
        parcel.writeFloat(this.e);
        parcel.writeLong(this.f);
        parcel.writeFloat(this.g);
        parcel.writeLong(this.h);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
    }
}
