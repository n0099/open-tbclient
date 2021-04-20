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
    public SoftReference<MapView> f9943a = null;

    /* renamed from: b  reason: collision with root package name */
    public BaiduMap f9944b;

    /* renamed from: c  reason: collision with root package name */
    public WNaviBaiduMap f9945c;

    /* renamed from: d  reason: collision with root package name */
    public f f9946d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void b() {
    }

    public MapStatus c() {
        return this.f9944b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void e() {
    }

    public void a() {
        this.f9943a = null;
    }

    public void a(MapView mapView) {
        SoftReference<MapView> softReference = new SoftReference<>(mapView);
        this.f9943a = softReference;
        this.f9944b = softReference.get().getMap();
        this.f9945c = WNaviBaiduMap.getInstance();
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f9944b.setMapStatus(mapStatusUpdate);
    }

    public void a(f fVar) {
        this.f9946d = fVar;
        this.f9944b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i) {
        this.f9944b.animateMapStatus(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus), i);
    }

    public void a(int i, int i2) {
        this.f9944b.setCompassPosition(new Point(i, i2));
    }

    public float a(Bundle bundle, int i, int i2) {
        return this.f9945c.getZoomToBound(bundle, i, i2);
    }

    public void a(boolean z) {
        WNaviBaiduMap.showMapPoi(z);
    }
}
