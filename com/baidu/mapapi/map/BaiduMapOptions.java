package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6842a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6843b;

    /* renamed from: c  reason: collision with root package name */
    public int f6844c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6845d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6846e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6847f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6848g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6849h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6850i;
    public LogoPosition j;
    public Point k;
    public Point l;

    public BaiduMapOptions() {
        this.f6842a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6843b = true;
        this.f6844c = 1;
        this.f6845d = true;
        this.f6846e = true;
        this.f6847f = true;
        this.f6848g = true;
        this.f6849h = true;
        this.f6850i = true;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6842a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.f6843b = true;
        this.f6844c = 1;
        this.f6845d = true;
        this.f6846e = true;
        this.f6847f = true;
        this.f6848g = true;
        this.f6849h = true;
        this.f6850i = true;
        this.f6842a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6843b = parcel.readByte() != 0;
        this.f6844c = parcel.readInt();
        this.f6845d = parcel.readByte() != 0;
        this.f6846e = parcel.readByte() != 0;
        this.f6847f = parcel.readByte() != 0;
        this.f6848g = parcel.readByte() != 0;
        this.f6849h = parcel.readByte() != 0;
        this.f6850i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.f6842a.c()).a(this.f6843b).a(this.f6844c).b(this.f6845d).c(this.f6846e).d(this.f6847f).e(this.f6848g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.f6843b = z;
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
            this.f6842a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i2) {
        this.f6844c = i2;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f6847f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.f6845d = z;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z) {
        this.f6850i = z;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z) {
        this.f6846e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f6842a, i2);
        parcel.writeByte(this.f6843b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6844c);
        parcel.writeByte(this.f6845d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6846e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6847f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6848g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6849h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6850i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.k, i2);
        parcel.writeParcelable(this.l, i2);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.f6849h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.f6848g = z;
        return this;
    }
}
