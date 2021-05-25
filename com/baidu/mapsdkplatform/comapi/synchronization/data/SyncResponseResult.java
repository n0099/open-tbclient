package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7777a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7778b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7779c;

    /* renamed from: d  reason: collision with root package name */
    public float f7780d;

    /* renamed from: e  reason: collision with root package name */
    public long f7781e;

    /* renamed from: f  reason: collision with root package name */
    public float f7782f;

    /* renamed from: g  reason: collision with root package name */
    public long f7783g;

    /* renamed from: h  reason: collision with root package name */
    public int f7784h;

    /* renamed from: i  reason: collision with root package name */
    public String f7785i;
    public String j;

    public SyncResponseResult() {
        this.f7777a = new RouteLineInfo();
        this.f7778b = new TrafficInfo();
        this.f7779c = new DriverPosition();
        this.f7780d = 0.0f;
        this.f7781e = 0L;
        this.f7782f = 0.0f;
        this.f7783g = 0L;
        this.f7784h = 0;
        this.f7785i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7777a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7778b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7779c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7780d = (float) parcel.readLong();
        this.f7781e = parcel.readLong();
        this.f7782f = (float) parcel.readLong();
        this.f7783g = parcel.readLong();
        this.f7784h = parcel.readInt();
        this.f7785i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7777a;
    }

    public void a(float f2) {
        this.f7780d = f2;
    }

    public void a(int i2) {
        this.f7784h = i2;
    }

    public void a(long j) {
        this.f7781e = j;
    }

    public void a(String str) {
        this.f7785i = str;
    }

    public TrafficInfo b() {
        return this.f7778b;
    }

    public void b(float f2) {
        this.f7782f = f2;
    }

    public void b(long j) {
        this.f7783g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7779c;
    }

    public float d() {
        return this.f7782f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7783g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7777a, 1);
        parcel.writeParcelable(this.f7778b, 1);
        parcel.writeParcelable(this.f7779c, 1);
        parcel.writeFloat(this.f7780d);
        parcel.writeLong(this.f7781e);
        parcel.writeFloat(this.f7782f);
        parcel.writeLong(this.f7783g);
        parcel.writeInt(this.f7784h);
        parcel.writeString(this.f7785i);
        parcel.writeString(this.j);
    }
}
