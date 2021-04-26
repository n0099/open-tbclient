package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f7159a;

    /* renamed from: b  reason: collision with root package name */
    public View f7160b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f7161c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f7162d;

    /* renamed from: e  reason: collision with root package name */
    public int f7163e;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i2) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.f7160b = view;
        this.f7161c = latLng;
        this.f7163e = i2;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i2, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f7159a = bitmapDescriptor;
        this.f7161c = latLng;
        this.f7162d = onInfoWindowClickListener;
        this.f7163e = i2;
    }
}
