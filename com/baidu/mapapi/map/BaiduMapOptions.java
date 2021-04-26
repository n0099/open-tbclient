package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f7088a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7089b;

    /* renamed from: c  reason: collision with root package name */
    public int f7090c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7091d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7092e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7093f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7094g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7095h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7096i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f7088a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f7089b = true;
        this.f7090c = 1;
        this.f7091d = true;
        this.f7092e = true;
        this.f7093f = true;
        this.f7094g = true;
        this.f7095h = true;
        this.f7096i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f7088a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f7089b = true;
        this.f7090c = 1;
        this.f7091d = true;
        this.f7092e = true;
        this.f7093f = true;
        this.f7094g = true;
        this.f7095h = true;
        this.f7096i = true;
        this.f7088a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f7089b = parcel.readByte() != 0;
        this.f7090c = parcel.readInt();
        this.f7091d = parcel.readByte() != 0;
        this.f7092e = parcel.readByte() != 0;
        this.f7093f = parcel.readByte() != 0;
        this.f7094g = parcel.readByte() != 0;
        this.f7095h = parcel.readByte() != 0;
        this.f7096i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f7088a.c()).a(this.f7089b).a(this.f7090c).b(this.f7091d).c(this.f7092e).d(this.f7093f).e(this.f7094g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f7089b = z;
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
            this.f7088a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i2) {
        this.f7090c = i2;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f7093f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f7091d = z;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        this.f7096i = z;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f7092e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7088a, i2);
        parcel.writeByte(this.f7089b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f7090c);
        parcel.writeByte(this.f7091d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7092e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7093f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7094g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7095h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7096i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i2);
        parcel.writeParcelable(this.l, i2);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f7095h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f7094g = z;
        return this;
    }
}
