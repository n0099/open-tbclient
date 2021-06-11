package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7820a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7821b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7822c;

    /* renamed from: d  reason: collision with root package name */
    public float f7823d;

    /* renamed from: e  reason: collision with root package name */
    public long f7824e;

    /* renamed from: f  reason: collision with root package name */
    public float f7825f;

    /* renamed from: g  reason: collision with root package name */
    public long f7826g;

    /* renamed from: h  reason: collision with root package name */
    public int f7827h;

    /* renamed from: i  reason: collision with root package name */
    public String f7828i;
    public String j;

    public SyncResponseResult() {
        this.f7820a = new RouteLineInfo();
        this.f7821b = new TrafficInfo();
        this.f7822c = new DriverPosition();
        this.f7823d = 0.0f;
        this.f7824e = 0L;
        this.f7825f = 0.0f;
        this.f7826g = 0L;
        this.f7827h = 0;
        this.f7828i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7820a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7821b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7822c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7823d = (float) parcel.readLong();
        this.f7824e = parcel.readLong();
        this.f7825f = (float) parcel.readLong();
        this.f7826g = parcel.readLong();
        this.f7827h = parcel.readInt();
        this.f7828i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7820a;
    }

    public void a(float f2) {
        this.f7823d = f2;
    }

    public void a(int i2) {
        this.f7827h = i2;
    }

    public void a(long j) {
        this.f7824e = j;
    }

    public void a(String str) {
        this.f7828i = str;
    }

    public TrafficInfo b() {
        return this.f7821b;
    }

    public void b(float f2) {
        this.f7825f = f2;
    }

    public void b(long j) {
        this.f7826g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7822c;
    }

    public float d() {
        return this.f7825f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7826g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7820a, 1);
        parcel.writeParcelable(this.f7821b, 1);
        parcel.writeParcelable(this.f7822c, 1);
        parcel.writeFloat(this.f7823d);
        parcel.writeLong(this.f7824e);
        parcel.writeFloat(this.f7825f);
        parcel.writeLong(this.f7826g);
        parcel.writeInt(this.f7827h);
        parcel.writeString(this.f7828i);
        parcel.writeString(this.j);
    }
}
