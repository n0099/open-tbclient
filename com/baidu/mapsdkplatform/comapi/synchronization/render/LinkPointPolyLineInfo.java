package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7836a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7837b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7838c;

    /* renamed from: d  reason: collision with root package name */
    public int f7839d;

    public LinkPointPolyLineInfo() {
        this.f7836a = 0L;
        this.f7839d = 0;
        this.f7836a = 0L;
        this.f7837b = null;
        this.f7838c = null;
        this.f7839d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7836a = 0L;
        this.f7839d = 0;
        this.f7836a = parcel.readLong();
        this.f7837b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7838c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7839d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7837b;
    }

    public void a(int i2) {
        this.f7839d = i2;
    }

    public void a(LatLng latLng) {
        this.f7837b = latLng;
    }

    public LatLng b() {
        return this.f7838c;
    }

    public void b(LatLng latLng) {
        this.f7838c = latLng;
    }

    public int c() {
        return this.f7839d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f7836a);
        parcel.writeParcelable(this.f7837b, i2);
        parcel.writeParcelable(this.f7838c, i2);
        parcel.writeInt(this.f7839d);
    }
}
