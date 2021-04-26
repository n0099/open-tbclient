package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f8139a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f8140b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f8141c;

    /* renamed from: d  reason: collision with root package name */
    public int f8142d;

    public LinkPointPolyLineInfo() {
        this.f8139a = 0L;
        this.f8142d = 0;
        this.f8139a = 0L;
        this.f8140b = null;
        this.f8141c = null;
        this.f8142d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f8139a = 0L;
        this.f8142d = 0;
        this.f8139a = parcel.readLong();
        this.f8140b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f8141c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f8142d = parcel.readInt();
    }

    public LatLng a() {
        return this.f8140b;
    }

    public void a(int i2) {
        this.f8142d = i2;
    }

    public void a(LatLng latLng) {
        this.f8140b = latLng;
    }

    public LatLng b() {
        return this.f8141c;
    }

    public void b(LatLng latLng) {
        this.f8141c = latLng;
    }

    public int c() {
        return this.f8142d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8139a);
        parcel.writeParcelable(this.f8140b, i2);
        parcel.writeParcelable(this.f8141c, i2);
        parcel.writeInt(this.f8142d);
    }
}
