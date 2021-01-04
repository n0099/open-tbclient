package com.baidu.platform.comapi.wnplatform.walkmap;

import android.graphics.Point;
import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapView;
import java.lang.ref.SoftReference;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    SoftReference<MapView> f4706a = null;

    /* renamed from: b  reason: collision with root package name */
    private BaiduMap f4707b;
    private WNaviBaiduMap c;
    private f d;

    public a(MapView mapView) {
        a(mapView);
    }

    public void a() {
        this.f4706a = null;
    }

    public void a(MapView mapView) {
        this.f4706a = new SoftReference<>(mapView);
        this.f4707b = this.f4706a.get().getMap();
        this.c = WNaviBaiduMap.getInstance();
    }

    public void b() {
        this.f4706a = null;
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.f4707b.setMapStatus(mapStatusUpdate);
    }

    public MapStatus c() {
        return this.f4707b.getMapStatus();
    }

    public float d() {
        return 0.0f;
    }

    public void a(f fVar) {
        this.d = fVar;
        this.f4707b.setOnMapStatusChangeListener(new b(this));
    }

    public void a(MapStatus mapStatus, int i) {
        this.f4707b.animateMapStatus(com.baidu.platform.comapi.wnplatform.p.f.a(mapStatus), i);
    }

    public void a(int i, int i2) {
        this.f4707b.setCompassPosition(new Point(i, i2));
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
