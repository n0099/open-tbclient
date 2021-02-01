package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes4.dex */
public final class MapStatusUpdate {
    private static final String p = MapStatusUpdate.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    int f2734a;

    /* renamed from: b  reason: collision with root package name */
    MapStatus f2735b;
    LatLng c;
    LatLngBounds d;
    int e;
    int f;
    float g;
    int h;
    int i;
    float j;
    Point k;
    int l = 0;
    int m = 0;
    int n = 0;
    int o = 0;

    MapStatusUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatusUpdate(int i) {
        this.f2734a = i;
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, int i, int i2) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        Point a2 = eVar.a(ll2mc);
        Point a3 = eVar.a(ll2mc2);
        Point point = new Point(a2.x - Math.abs(this.l), a2.y + Math.abs(this.o));
        Point point2 = new Point(a3.x + Math.abs(this.n), a3.y - Math.abs(this.m));
        GeoPoint b2 = eVar.b(point.x, point.y);
        GeoPoint b3 = eVar.b(point2.x, point2.y);
        return eVar.a((int) b2.getLongitudeE6(), (int) b2.getLatitudeE6(), (int) b3.getLongitudeE6(), (int) b3.getLatitudeE6(), i, i2);
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        if (eVar.q == null) {
            return true;
        }
        return (latLngBounds.southwest.latitude == eVar.q.southwest.latitude && latLngBounds.southwest.longitude == eVar.q.southwest.longitude && latLngBounds.northeast.latitude == eVar.q.northeast.latitude && latLngBounds.northeast.longitude == eVar.q.northeast.longitude) ? false : true;
    }

    private LatLng b(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        if (latLngBounds == null || eVar == null) {
            return null;
        }
        Point a2 = eVar.a(CoordUtil.ll2mc(latLngBounds.getCenter()));
        GeoPoint b2 = eVar.b(this.l > this.n ? a2.x - (this.l - this.n) : this.l < this.n ? a2.x + (this.n - this.l) : a2.x, this.m < this.o ? a2.y - (this.m - this.o) : this.m > this.o ? a2.y + (this.o - this.m) : a2.y);
        if (b2 == null) {
            Log.e(p, "New center geopoint is null");
            return null;
        }
        return CoordUtil.mc2ll(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.e eVar, MapStatus mapStatus) {
        if (eVar == null || mapStatus == null) {
            return null;
        }
        switch (this.f2734a) {
            case 1:
                return this.f2735b;
            case 2:
                return new MapStatus(mapStatus.rotate, this.c, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                if (this.d == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(this.d.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.d.northeast);
                float a2 = eVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), mapStatus.f2730a.j.right - mapStatus.f2730a.j.left, mapStatus.f2730a.j.bottom - mapStatus.f2730a.j.top);
                return new MapStatus(mapStatus.rotate, this.d.getCenter(), mapStatus.overlook, a2, mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.c, mapStatus.overlook, this.g, mapStatus.targetScreen, null);
            case 5:
                GeoPoint b2 = eVar.b((eVar.G() / 2) + this.h, (eVar.H() / 2) + this.i);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b2), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b2.getLongitudeE6(), b2.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.j, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(this.k.x, this.k.y)), mapStatus.overlook, mapStatus.zoom + this.j, this.k, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.g, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                if (this.d == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(this.d.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.d.northeast);
                float a3 = eVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.e, this.f);
                return new MapStatus(mapStatus.rotate, this.d.getCenter(), mapStatus.overlook, a3, mapStatus.targetScreen, null);
            case 10:
                if (this.d == null) {
                    return null;
                }
                int G = (eVar.G() - this.l) - this.n;
                if (G < 0) {
                    G = eVar.G();
                    Log.e(p, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int H = (eVar.H() - this.m) - this.o;
                if (H < 0) {
                    H = eVar.H();
                    Log.e(p, "Bound paddingTop or paddingBottom too larger, please check");
                }
                LatLng b3 = b(this.d, eVar);
                if (b3 == null) {
                    Log.e(p, "Bound center error");
                    return null;
                }
                float a4 = a(this.d, eVar, G, H);
                if (a(this.d, eVar)) {
                    MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, b3, mapStatus.overlook, a4, mapStatus.targetScreen, null);
                    eVar.r = mapStatus2;
                    eVar.q = this.d;
                    return mapStatus2;
                }
                return eVar.r;
            default:
                return null;
        }
    }
}
