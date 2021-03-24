package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6881a;

    /* renamed from: b  reason: collision with root package name */
    public View f6882b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6883c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6884d;

    /* renamed from: e  reason: collision with root package name */
    public int f6885e;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.f6882b = view;
        this.f6883c = latLng;
        this.f6885e = i;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f6881a = bitmapDescriptor;
        this.f6883c = latLng;
        this.f6884d = onInfoWindowClickListener;
        this.f6885e = i;
    }
}
