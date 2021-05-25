package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6871a;

    /* renamed from: b  reason: collision with root package name */
    public View f6872b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6873c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6874d;

    /* renamed from: e  reason: collision with root package name */
    public a f6875e;

    /* renamed from: f  reason: collision with root package name */
    public int f6876f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6877g;

    /* renamed from: h  reason: collision with root package name */
    public int f6878h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6879i;
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
        this.f6877g = false;
        this.f6878h = SysOSUtil.getDensityDpi();
        this.f6879i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6872b = view;
        this.f6873c = latLng;
        this.f6876f = i2;
        this.j = true;
    }

    public InfoWindow(View view, LatLng latLng, int i2, boolean z, int i3) {
        this.l = "";
        this.f6877g = false;
        this.f6878h = SysOSUtil.getDensityDpi();
        this.f6879i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6872b = view;
        this.f6873c = latLng;
        this.f6876f = i2;
        this.f6877g = z;
        this.f6878h = i3;
        this.j = true;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i2, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.l = "";
        this.f6877g = false;
        this.f6878h = SysOSUtil.getDensityDpi();
        this.f6879i = false;
        this.j = false;
        this.k = false;
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
        }
        this.f6871a = bitmapDescriptor;
        this.f6873c = latLng;
        this.f6874d = onInfoWindowClickListener;
        this.f6876f = i2;
        this.k = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f6871a;
    }

    public LatLng getPosition() {
        return this.f6873c;
    }

    public String getTag() {
        return this.l;
    }

    public View getView() {
        return this.f6872b;
    }

    public int getYOffset() {
        return this.f6876f;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f6871a = bitmapDescriptor;
        this.f6875e.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.f6873c = latLng;
        this.f6875e.b(this);
    }

    public void setTag(String str) {
        this.l = str;
    }

    public void setView(View view) {
        if (view == null) {
            return;
        }
        this.f6872b = view;
        this.f6875e.b(this);
    }

    public void setYOffset(int i2) {
        this.f6876f = i2;
        this.f6875e.b(this);
    }
}
