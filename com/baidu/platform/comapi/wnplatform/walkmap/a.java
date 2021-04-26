package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapView;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public SoftReference<MapView> f10311a = null;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f10312b;

    /* renamed from: c  reason: collision with root package name */
    public WNaviBaiduMap f10313c;

    /* renamed from: d  reason: collision with root package name */
    public f f10314d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void b() {
    }

    public MapStatus c() {
        return this.f10312b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void e() {
    }

    public void a() {
        this.f10311a = null;
    }

    public void a(MapView mapView) {
        SoftReference<MapView> softReference = new SoftReference<>(mapView);
        this.f10311a = softReference;
        this.f10312b = softReference.get().getMap();
        this.f10313c = WNaviBaiduMap.getInstance();
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f10312b.setMapStatus(mapStatusUpdate);
    }

    public void a(f fVar) {
        this.f10314d = fVar;
        this.f10312b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i2) {
        this.f10312b.animateMapStatus(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus), i2);
    }

    public void a(int i2, int i3) {
        this.f10312b.setCompassPosition(new Point(i2, i3));
    }

    public float a(Bundle bundle, int i2, int i3) {
        return this.f10313c.getZoomToBound(bundle, i2, i3);
    }

    public void a(boolean z) {
        WNaviBaiduMap.showMapPoi(z);
    }
}
