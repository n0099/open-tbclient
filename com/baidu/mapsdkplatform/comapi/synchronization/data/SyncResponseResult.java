package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f8080a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f8081b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f8082c;

    /* renamed from: d  reason: collision with root package name */
    public float f8083d;

    /* renamed from: e  reason: collision with root package name */
    public long f8084e;

    /* renamed from: f  reason: collision with root package name */
    public float f8085f;

    /* renamed from: g  reason: collision with root package name */
    public long f8086g;

    /* renamed from: h  reason: collision with root package name */
    public int f8087h;

    /* renamed from: i  reason: collision with root package name */
    public String f8088i;
    public String j;

    public SyncResponseResult() {
        this.f8080a = new RouteLineInfo();
        this.f8081b = new TrafficInfo();
        this.f8082c = new DriverPosition();
        this.f8083d = 0.0f;
        this.f8084e = 0L;
        this.f8085f = 0.0f;
        this.f8086g = 0L;
        this.f8087h = 0;
        this.f8088i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f8080a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f8081b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f8082c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f8083d = (float) parcel.readLong();
        this.f8084e = parcel.readLong();
        this.f8085f = (float) parcel.readLong();
        this.f8086g = parcel.readLong();
        this.f8087h = parcel.readInt();
        this.f8088i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f8080a;
    }

    public void a(float f2) {
        this.f8083d = f2;
    }

    public void a(int i2) {
        this.f8087h = i2;
    }

    public void a(long j) {
        this.f8084e = j;
    }

    public void a(String str) {
        this.f8088i = str;
    }

    public TrafficInfo b() {
        return this.f8081b;
    }

    public void b(float f2) {
        this.f8085f = f2;
    }

    public void b(long j) {
        this.f8086g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f8082c;
    }

    public float d() {
        return this.f8085f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f8086g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f8080a, 1);
        parcel.writeParcelable(this.f8081b, 1);
        parcel.writeParcelable(this.f8082c, 1);
        parcel.writeFloat(this.f8083d);
        parcel.writeLong(this.f8084e);
        parcel.writeFloat(this.f8085f);
        parcel.writeLong(this.f8086g);
        parcel.writeInt(this.f8087h);
        parcel.writeString(this.f8088i);
        parcel.writeString(this.j);
    }
}
