package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;
/* loaded from: classes4.dex */
public class InfoWindow {

    /* renamed from: a  reason: collision with root package name */
    BitmapDescriptor f2022a;
    View b;
    LatLng c;
    OnInfoWindowClickListener d;
    int e;

    /* loaded from: classes4.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.b = view;
        this.c = latLng;
        this.e = i;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f2022a = bitmapDescriptor;
        this.c = latLng;
        this.d = onInfoWindowClickListener;
        this.e = i;
    }
}
