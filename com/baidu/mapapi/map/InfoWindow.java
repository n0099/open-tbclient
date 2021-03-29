package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDescriptor f6882a;

    /* renamed from: b  reason: collision with root package name */
    public View f6883b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6884c;

    /* renamed from: d  reason: collision with root package name */
    public OnInfoWindowClickListener f6885d;

    /* renamed from: e  reason: collision with root package name */
    public int f6886e;

    /* loaded from: classes2.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.f6883b = view;
        this.f6884c = latLng;
        this.f6886e = i;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f6882a = bitmapDescriptor;
        this.f6884c = latLng;
        this.f6885d = onInfoWindowClickListener;
        this.f6886e = i;
    }
}
