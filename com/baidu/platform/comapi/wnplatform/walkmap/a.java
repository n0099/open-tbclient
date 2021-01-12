package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapView;
import java.lang.ref.SoftReference;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    SoftReference<MapView> f4470a = null;

    /* renamed from: b  reason: collision with root package name */
    private BaiduMap f4471b;
    private WNaviBaiduMap c;
    private f d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void a() {
        this.f4470a = null;
    }

    public void a(MapView mapView) {
        this.f4470a = new SoftReference<>(mapView);
        this.f4471b = this.f4470a.get().getMap();
        this.c = WNaviBaiduMap.getInstance();
    }

    public void b() {
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f4471b.setMapStatus(mapStatusUpdate);
    }

    public MapStatus c() {
        return this.f4471b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void a(f fVar) {
        this.d = fVar;
        this.f4471b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i) {
        this.f4471b.animateMapStatus(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus), i);
    }

    public void a(int i, int i2) {
        this.f4471b.setCompassPosition(new Point(i, i2));
    }

    public void e() {
    }

    public float a(Bundle bundle, int i, int i2) {
        return this.c.getZoomToBound(bundle, i, i2);
    }

    public void a(boolean z) {
        WNaviBaiduMap.showMapPoi(z);
    }
}
