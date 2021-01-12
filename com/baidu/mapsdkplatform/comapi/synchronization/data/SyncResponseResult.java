package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes6.dex */
public final class SyncResponseResult implements Parcelable {
    public static final Parcelable.Creator<SyncResponseResult> CREATOR = new j();

    /* renamed from: a  reason: collision with root package name */
    private RouteLineInfo f3112a;

    /* renamed from: b  reason: collision with root package name */
    private TrafficInfo f3113b;
    private DriverPosition c;
    private float d;
    private long e;
    private float f;
    private long g;
    private int h;
    private String i;
    private String j;

    public SyncResponseResult() {
        this.f3112a = new RouteLineInfo();
        this.f3113b = new TrafficInfo();
        this.c = new DriverPosition();
        this.d = 0.0f;
        this.e = 0L;
        this.f = 0.0f;
        this.g = 0L;
        this.h = 0;
        this.i = null;
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SyncResponseResult(Parcel parcel) {
        this.f3112a = (RouteLineInfo) parcel.readParcelable(RouteLineInfo.class.getClassLoader());
        this.f3113b = (TrafficInfo) parcel.readParcelable(TrafficInfo.class.getClassLoader());
        this.c = (DriverPosition) parcel.readParcelable(DriverPosition.class.getClassLoader());
        this.d = (float) parcel.readLong();
        this.e = parcel.readLong();
        this.f = (float) parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }

    public RouteLineInfo a() {
        return this.f3112a;
    }

    public void a(float f) {
        this.d = f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.i = str;
    }

    public TrafficInfo b() {
        return this.f3113b;
    }

    public void b(float f) {
        this.f = f;
    }

    public void b(long j) {
        this.g = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public DriverPosition c() {
        return this.c;
    }

    public float d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3112a, 1);
        parcel.writeParcelable(this.f3113b, 1);
        parcel.writeParcelable(this.c, 1);
        parcel.writeFloat(this.d);
        parcel.writeLong(this.e);
        parcel.writeFloat(this.f);
        parcel.writeLong(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
