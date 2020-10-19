package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes7.dex */
public final class MapStatusUpdate {
    private static final String o = MapStatusUpdate.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    MapStatus f2022a;
    LatLng b;
    LatLngBounds c;
    int d;
    int e;
    float f;
    int g;
    int h;
    float i;
    Point j;
    int k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    private int p;

    private MapStatusUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatusUpdate(int i) {
        this.p = i;
    }

    private float a(float f) {
        return (float) (Math.pow(2.0d, 18.0f - f) / (SysOSUtil.getDensityDpi() / 310.0f));
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar, int i, int i2) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        return dVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), longitudeE6, (int) ll2mc.getLatitudeE6(), i, i2);
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
        synchronized (this) {
            mapStatusUpdate.f2022a = mapStatus;
            mapStatusUpdate.c = this.c;
            mapStatusUpdate.k = this.k;
            mapStatusUpdate.l = this.l;
            mapStatusUpdate.m = this.m;
            mapStatusUpdate.n = this.n;
        }
        return mapStatusUpdate;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar, float f) {
        if (latLngBounds == null || dVar == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
        double d = this.k * f;
        double d2 = this.m * f;
        double d3 = this.l * f;
        double d4 = this.n * f;
        return CoordUtil.mc2ll(new GeoPoint(this.l < this.n ? (ll2mc.getLatitudeE6() - ((d4 - d3) / 2.0d)) + (d3 / 2.0d) : this.l > this.n ? ll2mc.getLatitudeE6() + ((d3 - d4) / 2.0d) : ll2mc.getLatitudeE6(), this.k > this.m ? ll2mc.getLongitudeE6() - ((d - d2) / 2.0d) : this.k < this.m ? ((d2 - d) / 2.0d) + ll2mc.getLongitudeE6() : ll2mc.getLongitudeE6()));
    }

    private boolean a(int i, int i2, int i3, int i4, com.baidu.mapsdkplatform.comapi.map.d dVar) {
        MapStatusUpdate D = dVar.D();
        return (D != null && i == D.k && i2 == D.l && i3 == D.m && i4 == D.n) ? false : true;
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.d dVar) {
        MapStatusUpdate D = dVar.D();
        if (D == null) {
            return true;
        }
        return (latLngBounds.southwest.latitude == D.c.southwest.latitude && latLngBounds.southwest.longitude == D.c.southwest.longitude && latLngBounds.northeast.latitude == D.c.northeast.latitude && latLngBounds.northeast.longitude == D.c.northeast.longitude) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.d dVar, MapStatus mapStatus) {
        if (dVar == null || mapStatus == null) {
            return null;
        }
        switch (this.p) {
            case 1:
                return this.f2022a;
            case 2:
                return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                if (this.c == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(this.c.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.c.northeast);
                float a2 = dVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), mapStatus.f2020a.j.right - mapStatus.f2020a.j.left, mapStatus.f2020a.j.bottom - mapStatus.f2020a.j.top);
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a2, mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.b, mapStatus.overlook, this.f, mapStatus.targetScreen, null);
            case 5:
                GeoPoint b = dVar.b((dVar.E() / 2) + this.g, (dVar.F() / 2) + this.h);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b.getLongitudeE6(), b.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(dVar.b(this.j.x, this.j.y)), mapStatus.overlook, mapStatus.zoom + this.i, this.j, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                if (this.c == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(this.c.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.c.northeast);
                float a3 = dVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.d, this.e);
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a3, mapStatus.targetScreen, null);
            case 10:
                if (this.c == null) {
                    return null;
                }
                int E = (dVar.E() - this.k) - this.m;
                if (E < 0) {
                    E = dVar.E();
                    Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int F = (dVar.F() - this.l) - this.n;
                if (F < 0) {
                    F = dVar.F();
                    Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                }
                float a4 = a(this.c, dVar, E, F);
                LatLng a5 = a(this.c, dVar, a(a4));
                if (a5 == null) {
                    Log.e(o, "Bound center error");
                    return null;
                }
                boolean a6 = a(this.c, dVar);
                boolean a7 = a(this.k, this.l, this.m, this.n, dVar);
                if (a6 || a7) {
                    MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, a5, mapStatus.overlook, a4, null, null);
                    dVar.a(a(mapStatus2));
                    return mapStatus2;
                } else if (dVar.D() != null) {
                    return dVar.D().f2022a;
                } else {
                    return null;
                }
            case 11:
                if (this.c == null) {
                    return null;
                }
                int E2 = (dVar.E() - this.k) - this.m;
                if (E2 < 0) {
                    E2 = dVar.E();
                    Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int F2 = (dVar.F() - this.l) - this.n;
                if (F2 < 0) {
                    F2 = dVar.F();
                    Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                }
                GeoPoint ll2mc5 = CoordUtil.ll2mc(this.c.southwest);
                GeoPoint ll2mc6 = CoordUtil.ll2mc(this.c.northeast);
                float a8 = dVar.a((int) ll2mc5.getLongitudeE6(), (int) ll2mc6.getLatitudeE6(), (int) ll2mc6.getLongitudeE6(), (int) ll2mc5.getLatitudeE6(), E2, F2);
                Point point = new Point(this.k + (E2 / 2), this.l + (F2 / 2));
                return new MapStatus(mapStatus.rotate, this.c.getCenter(), mapStatus.overlook, a8, point, null);
            default:
                return null;
        }
    }
}
