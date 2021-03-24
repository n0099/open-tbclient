package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6814a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6815b;

    /* renamed from: c  reason: collision with root package name */
    public int f6816c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6817d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6818e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6819f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6820g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6821h;
    public boolean i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6814a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6815b = true;
        this.f6816c = 1;
        this.f6817d = true;
        this.f6818e = true;
        this.f6819f = true;
        this.f6820g = true;
        this.f6821h = true;
        this.i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6814a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6815b = true;
        this.f6816c = 1;
        this.f6817d = true;
        this.f6818e = true;
        this.f6819f = true;
        this.f6820g = true;
        this.f6821h = true;
        this.i = true;
        this.f6814a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6815b = parcel.readByte() != 0;
        this.f6816c = parcel.readInt();
        this.f6817d = parcel.readByte() != 0;
        this.f6818e = parcel.readByte() != 0;
        this.f6819f = parcel.readByte() != 0;
        this.f6820g = parcel.readByte() != 0;
        this.f6821h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6814a.c()).a(this.f6815b).a(this.f6816c).b(this.f6817d).c(this.f6818e).d(this.f6819f).e(this.f6820g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6815b = z;
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
            this.f6814a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i) {
        this.f6816c = i;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6819f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6817d = z;
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
        this.f6818e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6814a, i);
        parcel.writeByte(this.f6815b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6816c);
        parcel.writeByte(this.f6817d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6818e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6819f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6820g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6821h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i);
        parcel.writeParcelable(this.l, i);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6821h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6820g = z;
        return this;
    }
}
