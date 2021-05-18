package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6971a;

    /* renamed from: b  reason: collision with root package name */
    public View f6972b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6973c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6974d;

    /* renamed from: e  reason: collision with root package name */
    public a f6975e;

    /* renamed from: f  reason: collision with root package name */
    public int f6976f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6977g;

    /* renamed from: h  reason: collision with root package name */
    public int f6978h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6979i;
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
        this.f6977g = false;
        this.f6978h = SysOSUtil.getDensityDpi();
        this.f6979i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6972b = view;
        this.f6973c = latLng;
        this.f6976f = i2;
        this.j = true;
    }

    public InfoWindow(View view, LatLng latLng, int i2, boolean z, int i3) {
        this.l = "";
        this.f6977g = false;
        this.f6978h = SysOSUtil.getDensityDpi();
        this.f6979i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.f6972b = view;
        this.f6973c = latLng;
        this.f6976f = i2;
        this.f6977g = z;
        this.f6978h = i3;
        this.j = true;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i2, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.l = "";
        this.f6977g = false;
        this.f6978h = SysOSUtil.getDensityDpi();
        this.f6979i = false;
        this.j = false;
        this.k = false;
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
        }
        this.f6971a = bitmapDescriptor;
        this.f6973c = latLng;
        this.f6974d = onInfoWindowClickListener;
        this.f6976f = i2;
        this.k = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f6971a;
    }

    public LatLng getPosition() {
        return this.f6973c;
    }

    public String getTag() {
        return this.l;
    }

    public View getView() {
        return this.f6972b;
    }

    public int getYOffset() {
        return this.f6976f;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f6971a = bitmapDescriptor;
        this.f6975e.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.f6973c = latLng;
        this.f6975e.b(this);
    }

    public void setTag(String str) {
        this.l = str;
    }

    public void setView(View view) {
        if (view == null) {
            return;
        }
        this.f6972b = view;
        this.f6975e.b(this);
    }

    public void setYOffset(int i2) {
        this.f6976f = i2;
        this.f6975e.b(this);
    }
}
