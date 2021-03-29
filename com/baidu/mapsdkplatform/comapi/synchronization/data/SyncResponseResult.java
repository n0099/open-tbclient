package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7764a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7765b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7766c;

    /* renamed from: d  reason: collision with root package name */
    public float f7767d;

    /* renamed from: e  reason: collision with root package name */
    public long f7768e;

    /* renamed from: f  reason: collision with root package name */
    public float f7769f;

    /* renamed from: g  reason: collision with root package name */
    public long f7770g;

    /* renamed from: h  reason: collision with root package name */
    public int f7771h;
    public String i;
    public String j;

    public SyncResponseResult() {
        this.f7764a = new RouteLineInfo();
        this.f7765b = new TrafficInfo();
        this.f7766c = new DriverPosition();
        this.f7767d = 0.0f;
        this.f7768e = 0L;
        this.f7769f = 0.0f;
        this.f7770g = 0L;
        this.f7771h = 0;
        this.i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7764a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7765b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7766c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7767d = (float) parcel.readLong();
        this.f7768e = parcel.readLong();
        this.f7769f = (float) parcel.readLong();
        this.f7770g = parcel.readLong();
        this.f7771h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7764a;
    }

    public void a(float f2) {
        this.f7767d = f2;
    }

    public void a(int i) {
        this.f7771h = i;
    }

    public void a(long j) {
        this.f7768e = j;
    }

    public void a(String str) {
        this.i = str;
    }

    public TrafficInfo b() {
        return this.f7765b;
    }

    public void b(float f2) {
        this.f7769f = f2;
    }

    public void b(long j) {
        this.f7770g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7766c;
    }

    public float d() {
        return this.f7769f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7770g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7764a, 1);
        parcel.writeParcelable(this.f7765b, 1);
        parcel.writeParcelable(this.f7766c, 1);
        parcel.writeFloat(this.f7767d);
        parcel.writeLong(this.f7768e);
        parcel.writeFloat(this.f7769f);
        parcel.writeLong(this.f7770g);
        parcel.writeInt(this.f7771h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
