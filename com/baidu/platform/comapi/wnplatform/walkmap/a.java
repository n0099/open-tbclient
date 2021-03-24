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
    public SoftReference<MapView> f10384a = null;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f10385b;

    /* renamed from: c  reason: collision with root package name */
    public WNaviBaiduMap f10386c;

    /* renamed from: d  reason: collision with root package name */
    public f f10387d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void b() {
    }

    public MapStatus c() {
        return this.f10385b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void e() {
    }

    public void a() {
        this.f10384a = null;
    }

    public void a(MapView mapView) {
        SoftReference<MapView> softReference = new SoftReference<>(mapView);
        this.f10384a = softReference;
        this.f10385b = softReference.get().getMap();
        this.f10386c = WNaviBaiduMap.getInstance();
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f10385b.setMapStatus(mapStatusUpdate);
    }

    public void a(f fVar) {
        this.f10387d = fVar;
        this.f10385b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i) {
        this.f10385b.animateMapStatus(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus), i);
    }

    public void a(int i, int i2) {
        this.f10385b.setCompassPosition(new Point(i, i2));
    }

    public float a(Bundle bundle, int i, int i2) {
        return this.f10386c.getZoomToBound(bundle, i, i2);
    }

    public void a(boolean z) {
        WNaviBaiduMap.showMapPoi(z);
    }
}
