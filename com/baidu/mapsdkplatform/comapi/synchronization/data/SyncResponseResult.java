package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7763a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7764b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7765c;

    /* renamed from: d  reason: collision with root package name */
    public float f7766d;

    /* renamed from: e  reason: collision with root package name */
    public long f7767e;

    /* renamed from: f  reason: collision with root package name */
    public float f7768f;

    /* renamed from: g  reason: collision with root package name */
    public long f7769g;

    /* renamed from: h  reason: collision with root package name */
    public int f7770h;
    public String i;
    public String j;

    public SyncResponseResult() {
        this.f7763a = new RouteLineInfo();
        this.f7764b = new TrafficInfo();
        this.f7765c = new DriverPosition();
        this.f7766d = 0.0f;
        this.f7767e = 0L;
        this.f7768f = 0.0f;
        this.f7769g = 0L;
        this.f7770h = 0;
        this.i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7763a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7764b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7765c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7766d = (float) parcel.readLong();
        this.f7767e = parcel.readLong();
        this.f7768f = (float) parcel.readLong();
        this.f7769g = parcel.readLong();
        this.f7770h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7763a;
    }

    public void a(float f2) {
        this.f7766d = f2;
    }

    public void a(int i) {
        this.f7770h = i;
    }

    public void a(long j) {
        this.f7767e = j;
    }

    public void a(String str) {
        this.i = str;
    }

    public TrafficInfo b() {
        return this.f7764b;
    }

    public void b(float f2) {
        this.f7768f = f2;
    }

    public void b(long j) {
        this.f7769g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7765c;
    }

    public float d() {
        return this.f7768f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7769g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7763a, 1);
        parcel.writeParcelable(this.f7764b, 1);
        parcel.writeParcelable(this.f7765c, 1);
        parcel.writeFloat(this.f7766d);
        parcel.writeLong(this.f7767e);
        parcel.writeFloat(this.f7768f);
        parcel.writeLong(this.f7769g);
        parcel.writeInt(this.f7770h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
