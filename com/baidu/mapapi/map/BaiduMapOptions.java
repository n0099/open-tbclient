package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6850a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6851b;

    /* renamed from: c  reason: collision with root package name */
    public int f6852c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6853d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6854e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6855f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6856g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6857h;
    public boolean i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6850a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6851b = true;
        this.f6852c = 1;
        this.f6853d = true;
        this.f6854e = true;
        this.f6855f = true;
        this.f6856g = true;
        this.f6857h = true;
        this.i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6850a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6851b = true;
        this.f6852c = 1;
        this.f6853d = true;
        this.f6854e = true;
        this.f6855f = true;
        this.f6856g = true;
        this.f6857h = true;
        this.i = true;
        this.f6850a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6851b = parcel.readByte() != 0;
        this.f6852c = parcel.readInt();
        this.f6853d = parcel.readByte() != 0;
        this.f6854e = parcel.readByte() != 0;
        this.f6855f = parcel.readByte() != 0;
        this.f6856g = parcel.readByte() != 0;
        this.f6857h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6850a.c()).a(this.f6851b).a(this.f6852c).b(this.f6853d).c(this.f6854e).d(this.f6855f).e(this.f6856g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6851b = z;
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
            this.f6850a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i) {
        this.f6852c = i;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6855f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6853d = z;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        this.i = z;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f6854e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6850a, i);
        parcel.writeByte(this.f6851b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6852c);
        parcel.writeByte(this.f6853d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6854e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6855f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6856g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6857h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i);
        parcel.writeParcelable(this.l, i);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6857h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6856g = z;
        return this;
    }
}
