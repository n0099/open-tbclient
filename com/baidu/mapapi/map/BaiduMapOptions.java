package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6899a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6900b;

    /* renamed from: c  reason: collision with root package name */
    public int f6901c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6902d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6903e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6904f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6905g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6906h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6907i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6899a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6900b = true;
        this.f6901c = 1;
        this.f6902d = true;
        this.f6903e = true;
        this.f6904f = true;
        this.f6905g = true;
        this.f6906h = true;
        this.f6907i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6899a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6900b = true;
        this.f6901c = 1;
        this.f6902d = true;
        this.f6903e = true;
        this.f6904f = true;
        this.f6905g = true;
        this.f6906h = true;
        this.f6907i = true;
        this.f6899a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6900b = parcel.readByte() != 0;
        this.f6901c = parcel.readInt();
        this.f6902d = parcel.readByte() != 0;
        this.f6903e = parcel.readByte() != 0;
        this.f6904f = parcel.readByte() != 0;
        this.f6905g = parcel.readByte() != 0;
        this.f6906h = parcel.readByte() != 0;
        this.f6907i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6899a.c()).a(this.f6900b).a(this.f6901c).b(this.f6902d).c(this.f6903e).d(this.f6904f).e(this.f6905g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6900b = z;
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
            this.f6899a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i2) {
        this.f6901c = i2;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6904f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6902d = z;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        this.f6907i = z;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f6903e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f6899a, i2);
        parcel.writeByte(this.f6900b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6901c);
        parcel.writeByte(this.f6902d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6903e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6904f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6905g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6906h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6907i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i2);
        parcel.writeParcelable(this.l, i2);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6906h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6905g = z;
        return this;
    }
}
