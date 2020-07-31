package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapView;
import java.lang.ref.SoftReference;
/* loaded from: classes10.dex */
public class a {
    SoftReference<MapView> a = null;
    private BaiduMap b;
    private WNaviBaiduMap c;
    private f d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void a() {
        this.a = null;
    }

    public void a(MapView mapView) {
        this.a = new SoftReference<>(mapView);
        this.b = this.a.get().getMap();
        this.c = WNaviBaiduMap.getInstance();
    }

    public void b() {
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.b.setMapStatus(mapStatusUpdate);
    }

    public MapStatus c() {
        return this.b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void a(f fVar) {
        this.d = fVar;
        this.b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i) {
        this.b.animateMapStatus(com.baidu.platform.comapi.wnplatform.o.e.a(mapStatus), i);
    }

    public void a(int i, int i2) {
        this.b.setCompassPosition(new Point(i, i2));
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
