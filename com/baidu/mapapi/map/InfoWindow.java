package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6917a;

    /* renamed from: b  reason: collision with root package name */
    public View f6918b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6919c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6920d;

    /* renamed from: e  reason: collision with root package name */
    public int f6921e;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.f6918b = view;
        this.f6919c = latLng;
        this.f6921e = i;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f6917a = bitmapDescriptor;
        this.f6919c = latLng;
        this.f6920d = onInfoWindowClickListener;
        this.f6921e = i;
    }
}
