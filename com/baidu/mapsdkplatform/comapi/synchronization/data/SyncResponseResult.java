package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7877a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7878b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7879c;

    /* renamed from: d  reason: collision with root package name */
    public float f7880d;

    /* renamed from: e  reason: collision with root package name */
    public long f7881e;

    /* renamed from: f  reason: collision with root package name */
    public float f7882f;

    /* renamed from: g  reason: collision with root package name */
    public long f7883g;

    /* renamed from: h  reason: collision with root package name */
    public int f7884h;

    /* renamed from: i  reason: collision with root package name */
    public String f7885i;
    public String j;

    public SyncResponseResult() {
        this.f7877a = new RouteLineInfo();
        this.f7878b = new TrafficInfo();
        this.f7879c = new DriverPosition();
        this.f7880d = 0.0f;
        this.f7881e = 0L;
        this.f7882f = 0.0f;
        this.f7883g = 0L;
        this.f7884h = 0;
        this.f7885i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7877a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7878b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7879c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7880d = (float) parcel.readLong();
        this.f7881e = parcel.readLong();
        this.f7882f = (float) parcel.readLong();
        this.f7883g = parcel.readLong();
        this.f7884h = parcel.readInt();
        this.f7885i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7877a;
    }

    public void a(float f2) {
        this.f7880d = f2;
    }

    public void a(int i2) {
        this.f7884h = i2;
    }

    public void a(long j) {
        this.f7881e = j;
    }

    public void a(String str) {
        this.f7885i = str;
    }

    public TrafficInfo b() {
        return this.f7878b;
    }

    public void b(float f2) {
        this.f7882f = f2;
    }

    public void b(long j) {
        this.f7883g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7879c;
    }

    public float d() {
        return this.f7882f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7883g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7877a, 1);
        parcel.writeParcelable(this.f7878b, 1);
        parcel.writeParcelable(this.f7879c, 1);
        parcel.writeFloat(this.f7880d);
        parcel.writeLong(this.f7881e);
        parcel.writeFloat(this.f7882f);
        parcel.writeLong(this.f7883g);
        parcel.writeInt(this.f7884h);
        parcel.writeString(this.f7885i);
        parcel.writeString(this.j);
    }
}
