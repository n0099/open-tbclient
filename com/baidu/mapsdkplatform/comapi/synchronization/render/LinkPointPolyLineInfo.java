package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7936a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7937b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7938c;

    /* renamed from: d  reason: collision with root package name */
    public int f7939d;

    public LinkPointPolyLineInfo() {
        this.f7936a = 0L;
        this.f7939d = 0;
        this.f7936a = 0L;
        this.f7937b = null;
        this.f7938c = null;
        this.f7939d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7936a = 0L;
        this.f7939d = 0;
        this.f7936a = parcel.readLong();
        this.f7937b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7938c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7939d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7937b;
    }

    public void a(int i2) {
        this.f7939d = i2;
    }

    public void a(LatLng latLng) {
        this.f7937b = latLng;
    }

    public LatLng b() {
        return this.f7938c;
    }

    public void b(LatLng latLng) {
        this.f7938c = latLng;
    }

    public int c() {
        return this.f7939d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f7936a);
        parcel.writeParcelable(this.f7937b, i2);
        parcel.writeParcelable(this.f7938c, i2);
        parcel.writeInt(this.f7939d);
    }
}
