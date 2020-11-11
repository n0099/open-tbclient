package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes7.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    BitmapDescriptor f2013a;
    View b;
    LatLng c;
    OnInfoWindowClickListener d;
    a e;
    int f;
    boolean g;
    int h;
    boolean i;
    boolean j;
    boolean k;
    private String l;

    /* loaded from: classes7.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        this.l = "";
        this.g = false;
        this.h = SysOSUtil.getDensityDpi();
        this.i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.b = view;
        this.c = latLng;
        this.f = i;
        this.j = true;
    }

    public InfoWindow(View view, LatLng latLng, int i, boolean z, int i2) {
        this.l = "";
        this.g = false;
        this.h = SysOSUtil.getDensityDpi();
        this.i = false;
        this.j = false;
        this.k = false;
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
        }
        this.b = view;
        this.c = latLng;
        this.f = i;
        this.g = z;
        this.h = i2;
        this.j = true;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.l = "";
        this.g = false;
        this.h = SysOSUtil.getDensityDpi();
        this.i = false;
        this.j = false;
        this.k = false;
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
        }
        this.f2013a = bitmapDescriptor;
        this.c = latLng;
        this.d = onInfoWindowClickListener;
        this.f = i;
        this.k = true;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.f2013a;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public String getTag() {
        return this.l;
    }

    public View getView() {
        return this.b;
    }

    public int getYOffset() {
        return this.f;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.f2013a = bitmapDescriptor;
        this.e.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.c = latLng;
        this.e.b(this);
    }

    public void setTag(String str) {
        this.l = str;
    }

    public void setView(View view) {
        if (view == null) {
            return;
        }
        this.b = view;
        this.e.b(this);
    }

    public void setYOffset(int i) {
        this.f = i;
        this.e.b(this);
    }
}
