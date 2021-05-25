package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6799a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6800b;

    /* renamed from: c  reason: collision with root package name */
    public int f6801c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6802d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6803e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6804f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6805g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6806h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6807i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6799a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6800b = true;
        this.f6801c = 1;
        this.f6802d = true;
        this.f6803e = true;
        this.f6804f = true;
        this.f6805g = true;
        this.f6806h = true;
        this.f6807i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6799a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6800b = true;
        this.f6801c = 1;
        this.f6802d = true;
        this.f6803e = true;
        this.f6804f = true;
        this.f6805g = true;
        this.f6806h = true;
        this.f6807i = true;
        this.f6799a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6800b = parcel.readByte() != 0;
        this.f6801c = parcel.readInt();
        this.f6802d = parcel.readByte() != 0;
        this.f6803e = parcel.readByte() != 0;
        this.f6804f = parcel.readByte() != 0;
        this.f6805g = parcel.readByte() != 0;
        this.f6806h = parcel.readByte() != 0;
        this.f6807i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6799a.c()).a(this.f6800b).a(this.f6801c).b(this.f6802d).c(this.f6803e).d(this.f6804f).e(this.f6805g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6800b = z;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaiduMapOptions logoPosition(LogoPosition logoPosition) {
        this.j = logoPosition;
        return this;
    }

    public BaiduMapOptions mapStatus(MapStatus mapStatus) {
        if (mapStatus != null) {
            this.f6799a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i2) {
        this.f6801c = i2;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6804f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6802d = z;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        this.f6807i = z;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f6803e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f6799a, i2);
        parcel.writeByte(this.f6800b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6801c);
        parcel.writeByte(this.f6802d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6803e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6804f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6805g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6806h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6807i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i2);
        parcel.writeParcelable(this.l, i2);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6806h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6805g = z;
        return this;
    }
}
