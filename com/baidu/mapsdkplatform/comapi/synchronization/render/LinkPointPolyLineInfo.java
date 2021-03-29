package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7819a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7820b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7821c;

    /* renamed from: d  reason: collision with root package name */
    public int f7822d;

    public LinkPointPolyLineInfo() {
        this.f7819a = 0L;
        this.f7822d = 0;
        this.f7819a = 0L;
        this.f7820b = null;
        this.f7821c = null;
        this.f7822d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7819a = 0L;
        this.f7822d = 0;
        this.f7819a = parcel.readLong();
        this.f7820b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7821c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7822d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7820b;
    }

    public void a(int i) {
        this.f7822d = i;
    }

    public void a(LatLng latLng) {
        this.f7820b = latLng;
    }

    public LatLng b() {
        return this.f7821c;
    }

    public void b(LatLng latLng) {
        this.f7821c = latLng;
    }

    public int c() {
        return this.f7822d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7819a);
        parcel.writeParcelable(this.f7820b, i);
        parcel.writeParcelable(this.f7821c, i);
        parcel.writeInt(this.f7822d);
    }
}
