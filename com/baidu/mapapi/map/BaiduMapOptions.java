package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6815a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6816b;

    /* renamed from: c  reason: collision with root package name */
    public int f6817c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6818d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6819e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6820f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6821g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6822h;
    public boolean i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6815a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6816b = true;
        this.f6817c = 1;
        this.f6818d = true;
        this.f6819e = true;
        this.f6820f = true;
        this.f6821g = true;
        this.f6822h = true;
        this.i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6815a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6816b = true;
        this.f6817c = 1;
        this.f6818d = true;
        this.f6819e = true;
        this.f6820f = true;
        this.f6821g = true;
        this.f6822h = true;
        this.i = true;
        this.f6815a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6816b = parcel.readByte() != 0;
        this.f6817c = parcel.readInt();
        this.f6818d = parcel.readByte() != 0;
        this.f6819e = parcel.readByte() != 0;
        this.f6820f = parcel.readByte() != 0;
        this.f6821g = parcel.readByte() != 0;
        this.f6822h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6815a.c()).a(this.f6816b).a(this.f6817c).b(this.f6818d).c(this.f6819e).d(this.f6820f).e(this.f6821g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6816b = z;
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
            this.f6815a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i) {
        this.f6817c = i;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6820f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6818d = z;
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
        this.f6819e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6815a, i);
        parcel.writeByte(this.f6816b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6817c);
        parcel.writeByte(this.f6818d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6819e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6820f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6821g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6822h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i);
        parcel.writeParcelable(this.l, i);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6822h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6821g = z;
        return this;
    }
}
