package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6914a;

    /* renamed from: b  reason: collision with root package name */
    public View f6915b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6916c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6917d;

    /* renamed from: e  reason: collision with root package name */
    public a f6918e;

    /* renamed from: f  reason: collision with root package name */
    public int f6919f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6920g;

    /* renamed from: h  reason: collision with root package name */
    public int f6921h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6922i;
    public boolean j;
    public boolean k;
    public String l;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i2) {
        this.l = "";
        this.f6920g = false;
        this.f6921h = SysOSUtil.getDensityDpi();
        this.f6922i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6915b = view;
        this.f6916c = latLng;
        this.f6919f = i2;
        this.j = true;
    }

    public InfoWindow(View view, LatLng latLng, int i2, boolean z, int i3) {
        this.l = "";
        this.f6920g = false;
        this.f6921h = SysOSUtil.getDensityDpi();
        this.f6922i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6915b = view;
        this.f6916c = latLng;
        this.f6919f = i2;
        this.f6920g = z;
        this.f6921h = i3;
        this.j = true;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i2, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.l = "";
        this.f6920g = false;
        this.f6921h = SysOSUtil.getDensityDpi();
        this.f6922i = false;
        this.j = false;
        this.k = false;
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
        }
        this.f6914a = bitmapDescriptor;
        this.f6916c = latLng;
        this.f6917d = onInfoWindowClickListener;
        this.f6919f = i2;
        this.k = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f6914a;
    }

    public LatLng getPosition() {
        return this.f6916c;
    }

    public String getTag() {
        return this.l;
    }

    public View getView() {
        return this.f6915b;
    }

    public int getYOffset() {
        return this.f6919f;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f6914a = bitmapDescriptor;
        this.f6918e.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.f6916c = latLng;
        this.f6918e.b(this);
    }

    public void setTag(String str) {
        this.l = str;
    }

    public void setView(View view) {
        if (view == null) {
            return;
        }
        this.f6915b = view;
        this.f6918e.b(this);
    }

    public void setYOffset(int i2) {
        this.f6919f = i2;
        this.f6918e.b(this);
    }
}
