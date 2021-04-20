package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7854a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7855b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7856c;

    /* renamed from: d  reason: collision with root package name */
    public int f7857d;

    public LinkPointPolyLineInfo() {
        this.f7854a = 0L;
        this.f7857d = 0;
        this.f7854a = 0L;
        this.f7855b = null;
        this.f7856c = null;
        this.f7857d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7854a = 0L;
        this.f7857d = 0;
        this.f7854a = parcel.readLong();
        this.f7855b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7856c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7857d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7855b;
    }

    public void a(int i) {
        this.f7857d = i;
    }

    public void a(LatLng latLng) {
        this.f7855b = latLng;
    }

    public LatLng b() {
        return this.f7856c;
    }

    public void b(LatLng latLng) {
        this.f7856c = latLng;
    }

    public int c() {
        return this.f7857d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7854a);
        parcel.writeParcelable(this.f7855b, i);
        parcel.writeParcelable(this.f7856c, i);
        parcel.writeInt(this.f7857d);
    }
}
