package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7818a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7819b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7820c;

    /* renamed from: d  reason: collision with root package name */
    public int f7821d;

    public LinkPointPolyLineInfo() {
        this.f7818a = 0L;
        this.f7821d = 0;
        this.f7818a = 0L;
        this.f7819b = null;
        this.f7820c = null;
        this.f7821d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7818a = 0L;
        this.f7821d = 0;
        this.f7818a = parcel.readLong();
        this.f7819b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7820c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7821d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7819b;
    }

    public void a(int i) {
        this.f7821d = i;
    }

    public void a(LatLng latLng) {
        this.f7819b = latLng;
    }

    public LatLng b() {
        return this.f7820c;
    }

    public void b(LatLng latLng) {
        this.f7820c = latLng;
    }

    public int c() {
        return this.f7821d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7818a);
        parcel.writeParcelable(this.f7819b, i);
        parcel.writeParcelable(this.f7820c, i);
        parcel.writeInt(this.f7821d);
    }
}
