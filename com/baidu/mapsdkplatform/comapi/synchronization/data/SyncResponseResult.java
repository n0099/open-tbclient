package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    public RouteLineInfo f7799a;

    /* renamed from: b  reason: collision with root package name */
    public TrafficInfo f7800b;

    /* renamed from: c  reason: collision with root package name */
    public DriverPosition f7801c;

    /* renamed from: d  reason: collision with root package name */
    public float f7802d;

    /* renamed from: e  reason: collision with root package name */
    public long f7803e;

    /* renamed from: f  reason: collision with root package name */
    public float f7804f;

    /* renamed from: g  reason: collision with root package name */
    public long f7805g;

    /* renamed from: h  reason: collision with root package name */
    public int f7806h;
    public String i;
    public String j;

    public SyncResponseResult() {
        this.f7799a = new RouteLineInfo();
        this.f7800b = new TrafficInfo();
        this.f7801c = new DriverPosition();
        this.f7802d = 0.0f;
        this.f7803e = 0L;
        this.f7804f = 0.0f;
        this.f7805g = 0L;
        this.f7806h = 0;
        this.i = null;
        this.j = null;
    }

    public SyncResponseResult(Parcel parcel) {
        this.f7799a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f7800b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.f7801c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.f7802d = (float) parcel.readLong();
        this.f7803e = parcel.readLong();
        this.f7804f = (float) parcel.readLong();
        this.f7805g = parcel.readLong();
        this.f7806h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f7799a;
    }

    public void a(float f2) {
        this.f7802d = f2;
    }

    public void a(int i) {
        this.f7806h = i;
    }

    public void a(long j) {
        this.f7803e = j;
    }

    public void a(String str) {
        this.i = str;
    }

    public TrafficInfo b() {
        return this.f7800b;
    }

    public void b(float f2) {
        this.f7804f = f2;
    }

    public void b(long j) {
        this.f7805g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.f7801c;
    }

    public float d() {
        return this.f7804f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f7805g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7799a, 1);
        parcel.writeParcelable(this.f7800b, 1);
        parcel.writeParcelable(this.f7801c, 1);
        parcel.writeFloat(this.f7802d);
        parcel.writeLong(this.f7803e);
        parcel.writeFloat(this.f7804f);
        parcel.writeLong(this.f7805g);
        parcel.writeInt(this.f7806h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
