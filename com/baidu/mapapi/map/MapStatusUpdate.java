package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class MapStatusUpdate {
    public static final String o = "MapStatusUpdate";

    /* renamed from: a  reason: collision with root package name */
    public MapStatus f6949a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6950b;

    /* renamed from: c  reason: collision with root package name */
    public LatLngBounds f6951c;

    /* renamed from: d  reason: collision with root package name */
    public int f6952d;

    /* renamed from: e  reason: collision with root package name */
    public int f6953e;

    /* renamed from: f  reason: collision with root package name */
    public float f6954f;

    /* renamed from: g  reason: collision with root package name */
    public int f6955g;

    /* renamed from: h  reason: collision with root package name */
    public int f6956h;

    /* renamed from: i  reason: collision with root package name */
    public float f6957i;
    public Point j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int p;

    public MapStatusUpdate() {
    }

    public MapStatusUpdate(int i2) {
        this.p = i2;
    }

    private float a(float f2) {
        return (float) (Math.pow(2.0d, 18.0f - f2) / (SysOSUtil.getDensityDpi() / 310.0f));
    }

    private float a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, int i2, int i3) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.northeast);
        int latitudeE6 = (int) ll2mc.getLatitudeE6();
        return eVar.a((int) ll2mc.getLongitudeE6(), (int) ll2mc2.getLatitudeE6(), (int) ll2mc2.getLongitudeE6(), latitudeE6, i2, i3);
    }

    private MapStatusUpdate a(MapStatus mapStatus) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate();
        synchronized (this) {
            mapStatusUpdate.f6949a = mapStatus;
            mapStatusUpdate.f6951c = this.f6951c;
            mapStatusUpdate.k = this.k;
            mapStatusUpdate.l = this.l;
            mapStatusUpdate.m = this.m;
            mapStatusUpdate.n = this.n;
        }
        return mapStatusUpdate;
    }

    private LatLng a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar, float f2) {
        double latitudeE6;
        double latitudeE62;
        if (latLngBounds == null || eVar == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.getCenter());
        int i2 = this.k;
        double d2 = i2 * f2;
        int i3 = this.m;
        double d3 = i3 * f2;
        double d4 = this.l * f2;
        double d5 = this.n * f2;
        double longitudeE6 = i2 > i3 ? ll2mc.getLongitudeE6() - ((d2 - d3) / 2.0d) : i2 < i3 ? ll2mc.getLongitudeE6() + ((d3 - d2) / 2.0d) : ll2mc.getLongitudeE6();
        int i4 = this.l;
        int i5 = this.n;
        if (i4 < i5) {
            latitudeE62 = ll2mc.getLatitudeE6() - ((d5 - d4) / 2.0d);
        } else if (i4 <= i5) {
            latitudeE6 = ll2mc.getLatitudeE6();
            return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
        } else {
            latitudeE62 = ll2mc.getLatitudeE6();
            d4 -= d5;
        }
        latitudeE6 = latitudeE62 + (d4 / 2.0d);
        return CoordUtil.mc2ll(new GeoPoint(latitudeE6, longitudeE6));
    }

    private boolean a(int i2, int i3, int i4, int i5, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        MapStatusUpdate G = eVar.G();
        return (G != null && i2 == G.k && i3 == G.l && i4 == G.m && i5 == G.n) ? false : true;
    }

    private boolean a(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        MapStatusUpdate G = eVar.G();
        if (G == null) {
            return true;
        }
        LatLng latLng = latLngBounds.southwest;
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        LatLng latLng2 = latLngBounds.northeast;
        double d4 = latLng2.latitude;
        double d5 = latLng2.longitude;
        LatLngBounds latLngBounds2 = G.f6951c;
        LatLng latLng3 = latLngBounds2.southwest;
        double d6 = latLng3.latitude;
        double d7 = latLng3.longitude;
        LatLng latLng4 = latLngBounds2.northeast;
        return (d2 == d6 && d3 == d7 && d4 == latLng4.latitude && d5 == latLng4.longitude) ? false : true;
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.e eVar, MapStatus mapStatus) {
        MapStatus mapStatus2;
        if (eVar == null || mapStatus == null) {
            return null;
        }
        switch (this.p) {
            case 1:
                return this.f6949a;
            case 2:
                return new MapStatus(mapStatus.rotate, this.f6950b, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                LatLngBounds latLngBounds = this.f6951c;
                if (latLngBounds == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6951c.northeast);
                double longitudeE6 = ll2mc.getLongitudeE6();
                double latitudeE6 = ll2mc2.getLatitudeE6();
                double longitudeE62 = ll2mc2.getLongitudeE6();
                int latitudeE62 = (int) ll2mc.getLatitudeE6();
                WinRound winRound = mapStatus.f6937a.j;
                return new MapStatus(mapStatus.rotate, this.f6951c.getCenter(), mapStatus.overlook, eVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top), mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.f6950b, mapStatus.overlook, this.f6954f, mapStatus.targetScreen, null);
            case 5:
                GeoPoint b2 = eVar.b((eVar.H() / 2) + this.f6955g, (eVar.I() / 2) + this.f6956h);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b2), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b2.getLongitudeE6(), b2.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.f6957i, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                Point point = this.j;
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(point.x, point.y)), mapStatus.overlook, mapStatus.zoom + this.f6957i, this.j, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f6954f, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                LatLngBounds latLngBounds2 = this.f6951c;
                if (latLngBounds2 == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.f6951c.northeast);
                return new MapStatus(mapStatus.rotate, this.f6951c.getCenter(), mapStatus.overlook, eVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.f6952d, this.f6953e), mapStatus.targetScreen, null);
            case 10:
                if (this.f6951c == null) {
                    return null;
                }
                int H = (eVar.H() - this.k) - this.m;
                if (H < 0) {
                    H = eVar.H();
                    Log.e(o, "Bound paddingLeft or paddingRight too larger, please check");
                }
                int I = (eVar.I() - this.l) - this.n;
                if (I < 0) {
                    I = eVar.I();
                    Log.e(o, "Bound paddingTop or paddingBottom too larger, please check");
                }
                float a2 = a(this.f6951c, eVar, H, I);
                LatLng a3 = a(this.f6951c, eVar, a(a2));
                if (a3 == null) {
                    Log.e(o, "Bound center error");
                    return null;
                }
                boolean a4 = a(this.f6951c, eVar);
                boolean a5 = a(this.k, this.l, this.m, this.n, eVar);
                if (a4 || a5) {
                    mapStatus2 = new MapStatus(mapStatus.rotate, a3, mapStatus.overlook, a2, null, null);
                    eVar.a(a(mapStatus2));
                } else if (eVar.G() == null) {
                    return null;
                } else {
                    mapStatus2 = eVar.G().f6949a;
                }
                return mapStatus2;
            case 11:
                if (this.f6951c == null) {
                    return null;
                }
                WinRound winRound2 = mapStatus.winRound;
                int abs = Math.abs(winRound2.right - winRound2.left);
                int abs2 = Math.abs(winRound2.bottom - winRound2.top);
                GeoPoint ll2mc5 = CoordUtil.ll2mc(this.f6951c.southwest);
                GeoPoint ll2mc6 = CoordUtil.ll2mc(this.f6951c.northeast);
                double longitudeE63 = ll2mc5.getLongitudeE6();
                double latitudeE63 = ll2mc6.getLatitudeE6();
                double longitudeE64 = ll2mc6.getLongitudeE6();
                double latitudeE64 = ll2mc5.getLatitudeE6();
                float a6 = eVar.a((int) longitudeE63, (int) latitudeE63, (int) longitudeE64, (int) latitudeE64, (abs - this.k) - this.m, (abs2 - this.l) - Math.abs(this.n));
                if (a6 == 0.0f) {
                    return null;
                }
                Point a7 = eVar.a(CoordUtil.ll2mc(this.f6951c.northeast));
                Point a8 = eVar.a(CoordUtil.ll2mc(this.f6951c.southwest));
                if (Math.abs(a7.y) < Math.abs(this.n)) {
                    a6 -= this.n / abs2;
                }
                if (longitudeE63 == longitudeE64 && latitudeE63 == latitudeE64) {
                    a6 = mapStatus.zoom;
                }
                int i2 = abs / 2;
                int i3 = a8.y;
                int i4 = abs2 - i3;
                int i5 = this.n;
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(eVar.b(i2, i4 > i5 ? ((((abs2 / 2) + 0) + (i5 / 2)) - (this.l / 2)) + 50 : (((((abs2 / 2) + 0) + ((i5 - (abs2 - i3)) / 2)) + (i5 / 2)) - (this.l / 2)) + 50)), mapStatus.overlook, a6, mapStatus.targetScreen, null);
            default:
                return null;
        }
    }
}
