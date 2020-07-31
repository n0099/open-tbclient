package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes10.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new f();
    MapStatus a;
    boolean b;
    int c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    LogoPosition j;
    Point k;
    Point l;

    public BaiduMapOptions() {
        this.a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.b = true;
        this.c = 1;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaiduMapOptions(Parcel parcel) {
        this.a = new MapStatus(0.0f, new LatLng(39.914935d, 116.403119d), 0.0f, 12.0f, null, null);
        this.b = true;
        this.c = 1;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.b = parcel.readByte() != 0;
        this.c = parcel.readInt();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.baidu.mapsdkplatform.comapi.map.z a() {
        return new com.baidu.mapsdkplatform.comapi.map.z().a(this.a.c()).a(this.b).a(this.c).b(this.d).c(this.e).d(this.f).e(this.g);
    }

    public BaiduMapOptions compassEnabled(boolean z) {
        this.b = z;
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
            this.a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i) {
        this.c = i;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z) {
        this.f = z;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z) {
        this.d = z;
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
        this.e = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeByte((byte) (this.b ? 1 : 0));
        parcel.writeInt(this.c);
        parcel.writeByte((byte) (this.d ? 1 : 0));
        parcel.writeByte((byte) (this.e ? 1 : 0));
        parcel.writeByte((byte) (this.f ? 1 : 0));
        parcel.writeByte((byte) (this.g ? 1 : 0));
        parcel.writeByte((byte) (this.h ? 1 : 0));
        parcel.writeByte((byte) (this.i ? 1 : 0));
        parcel.writeParcelable(this.k, i);
        parcel.writeParcelable(this.l, i);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z) {
        this.h = z;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z) {
        this.g = z;
        return this;
    }
}
