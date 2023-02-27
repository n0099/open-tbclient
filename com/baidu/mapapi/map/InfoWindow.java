package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {
    public String a;
    public BitmapDescriptor b;
    public View c;
    public LatLng d;
    public OnInfoWindowClickListener e;
    public a f;
    public int g;
    public boolean h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(InfoWindow infoWindow);

        void b(InfoWindow infoWindow);
    }

    public InfoWindow(View view2, LatLng latLng, int i) {
        this.a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (view2 != null && latLng != null) {
            this.c = view2;
            this.d = latLng;
            this.g = i;
            this.k = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }

    public InfoWindow(View view2, LatLng latLng, int i, boolean z, int i2) {
        this.a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (view2 != null && latLng != null) {
            this.c = view2;
            this.d = latLng;
            this.g = i;
            this.h = z;
            this.i = i2;
            this.k = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        this.a = "";
        this.h = false;
        this.i = SysOSUtil.getDensityDpi();
        this.j = false;
        this.k = false;
        this.l = false;
        if (bitmapDescriptor != null && latLng != null) {
            this.b = bitmapDescriptor;
            this.d = latLng;
            this.e = onInfoWindowClickListener;
            this.g = i;
            this.l = true;
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.b;
    }

    public LatLng getPosition() {
        return this.d;
    }

    public String getTag() {
        return this.a;
    }

    public View getView() {
        return this.c;
    }

    public int getYOffset() {
        return this.g;
    }

    public void setBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.b = bitmapDescriptor;
        this.f.b(this);
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.d = latLng;
        this.f.b(this);
    }

    public void setTag(String str) {
        this.a = str;
    }

    public void setView(View view2) {
        if (view2 == null) {
            return;
        }
        this.c = view2;
        this.f.b(this);
    }

    public void setYOffset(int i) {
        this.g = i;
        this.f.b(this);
    }
}
