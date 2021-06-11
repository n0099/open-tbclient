package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class LinkPointPolyLineInfo implements Parcelable {
    public static final Parcelable.Creator<LinkPointPolyLineInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public long f7879a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7880b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7881c;

    /* renamed from: d  reason: collision with root package name */
    public int f7882d;

    public LinkPointPolyLineInfo() {
        this.f7879a = 0L;
        this.f7882d = 0;
        this.f7879a = 0L;
        this.f7880b = null;
        this.f7881c = null;
        this.f7882d = 0;
    }

    public LinkPointPolyLineInfo(Parcel parcel) {
        this.f7879a = 0L;
        this.f7882d = 0;
        this.f7879a = parcel.readLong();
        this.f7880b = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7881c = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f7882d = parcel.readInt();
    }

    public LatLng a() {
        return this.f7880b;
    }

    public void a(int i2) {
        this.f7882d = i2;
    }

    public void a(LatLng latLng) {
        this.f7880b = latLng;
    }

    public LatLng b() {
        return this.f7881c;
    }

    public void b(LatLng latLng) {
        this.f7881c = latLng;
    }

    public int c() {
        return this.f7882d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f7879a);
        parcel.writeParcelable(this.f7880b, i2);
        parcel.writeParcelable(this.f7881c, i2);
        parcel.writeInt(this.f7882d);
    }
}
