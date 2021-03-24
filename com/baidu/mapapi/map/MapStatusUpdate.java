package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public final class MapStatusUpdate {
    public static final String p = "MapStatusUpdate";

    /* renamed from: a  reason: collision with root package name */
    public int f6911a;

    /* renamed from: b  reason: collision with root package name */
    public MapStatus f6912b;

    /* renamed from: c  reason: collision with root package name */
    public LatLng f6913c;

    /* renamed from: d  reason: collision with root package name */
    public LatLngBounds f6914d;

    /* renamed from: e  reason: collision with root package name */
    public int f6915e;

    /* renamed from: f  reason: collision with root package name */
    public int f6916f;

    /* renamed from: g  reason: collision with root package name */
    public float f6917g;

    /* renamed from: h  reason: collision with root package name */
    public int f6918h;
    public int i;
    public float j;
    public Point k;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;

    public MapStatusUpdate() {
    }

    public MapStatusUpdate(int i) {
        this.f6911a = i;
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
        LatLngBounds latLngBounds2 = eVar.q;
        if (latLngBounds2 == null) {
            return true;
        }
        LatLng latLng = latLngBounds.southwest;
        double d2 = latLng.latitude;
        double d3 = latLng.longitude;
        LatLng latLng2 = latLngBounds.northeast;
        double d4 = latLng2.latitude;
        double d5 = latLng2.longitude;
        LatLng latLng3 = latLngBounds2.southwest;
        double d6 = latLng3.latitude;
        double d7 = latLng3.longitude;
        LatLng latLng4 = latLngBounds2.northeast;
        return (d2 == d6 && d3 == d7 && d4 == latLng4.latitude && d5 == latLng4.longitude) ? false : true;
    }

    private LatLng b(LatLngBounds latLngBounds, com.baidu.mapsdkplatform.comapi.map.e eVar) {
        if (latLngBounds == null || eVar == null) {
            return null;
        }
        Point a2 = eVar.a(CoordUtil.ll2mc(latLngBounds.getCenter()));
        int i = this.l;
        int i2 = this.n;
        int i3 = a2.x;
        if (i > i2) {
            i3 -= i - i2;
        } else if (i < i2) {
            i3 += i2 - i;
        }
        int i4 = this.m;
        int i5 = this.o;
        int i6 = a2.y;
        if (i4 < i5) {
            i6 -= i4 - i5;
        } else if (i4 > i5) {
            i6 += i5 - i4;
        }
        GeoPoint b2 = eVar.b(i3, i6);
        if (b2 == null) {
            Log.e(p, "New center geopoint is null");
            return null;
        }
        return CoordUtil.mc2ll(b2);
    }

    public MapStatus a(com.baidu.mapsdkplatform.comapi.map.e eVar, MapStatus mapStatus) {
        if (eVar == null || mapStatus == null) {
            return null;
        }
        switch (this.f6911a) {
            case 1:
                return this.f6912b;
            case 2:
                return new MapStatus(mapStatus.rotate, this.f6913c, mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, null);
            case 3:
                LatLngBounds latLngBounds = this.f6914d;
                if (latLngBounds == null) {
                    return null;
                }
                GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.southwest);
                GeoPoint ll2mc2 = CoordUtil.ll2mc(this.f6914d.northeast);
                double longitudeE6 = ll2mc.getLongitudeE6();
                double latitudeE6 = ll2mc2.getLatitudeE6();
                double longitudeE62 = ll2mc2.getLongitudeE6();
                int latitudeE62 = (int) ll2mc.getLatitudeE6();
                WinRound winRound = mapStatus.f6900a.j;
                float a2 = eVar.a((int) longitudeE6, (int) latitudeE6, (int) longitudeE62, latitudeE62, winRound.right - winRound.left, winRound.bottom - winRound.top);
                return new MapStatus(mapStatus.rotate, this.f6914d.getCenter(), mapStatus.overlook, a2, mapStatus.targetScreen, null);
            case 4:
                return new MapStatus(mapStatus.rotate, this.f6913c, mapStatus.overlook, this.f6917g, mapStatus.targetScreen, null);
            case 5:
                GeoPoint b2 = eVar.b((eVar.G() / 2) + this.f6918h, (eVar.H() / 2) + this.i);
                return new MapStatus(mapStatus.rotate, CoordUtil.mc2ll(b2), mapStatus.overlook, mapStatus.zoom, mapStatus.targetScreen, b2.getLongitudeE6(), b2.getLatitudeE6(), null);
            case 6:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, mapStatus.zoom + this.j, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 7:
                Point point = this.k;
                LatLng mc2ll = CoordUtil.mc2ll(eVar.b(point.x, point.y));
                return new MapStatus(mapStatus.rotate, mc2ll, mapStatus.overlook, this.j + mapStatus.zoom, this.k, null);
            case 8:
                return new MapStatus(mapStatus.rotate, mapStatus.target, mapStatus.overlook, this.f6917g, mapStatus.targetScreen, mapStatus.a(), mapStatus.b(), null);
            case 9:
                LatLngBounds latLngBounds2 = this.f6914d;
                if (latLngBounds2 == null) {
                    return null;
                }
                GeoPoint ll2mc3 = CoordUtil.ll2mc(latLngBounds2.southwest);
                GeoPoint ll2mc4 = CoordUtil.ll2mc(this.f6914d.northeast);
                float a3 = eVar.a((int) ll2mc3.getLongitudeE6(), (int) ll2mc4.getLatitudeE6(), (int) ll2mc4.getLongitudeE6(), (int) ll2mc3.getLatitudeE6(), this.f6915e, this.f6916f);
                return new MapStatus(mapStatus.rotate, this.f6914d.getCenter(), mapStatus.overlook, a3, mapStatus.targetScreen, null);
            case 10:
                if (this.f6914d == null) {
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
                LatLng b3 = b(this.f6914d, eVar);
                if (b3 == null) {
                    Log.e(p, "Bound center error");
                    return null;
                }
                float a4 = a(this.f6914d, eVar, G, H);
                if (a(this.f6914d, eVar)) {
                    MapStatus mapStatus2 = new MapStatus(mapStatus.rotate, b3, mapStatus.overlook, a4, mapStatus.targetScreen, null);
                    eVar.r = mapStatus2;
                    eVar.q = this.f6914d;
                    return mapStatus2;
                }
                return eVar.r;
            default:
                return null;
        }
    }
}
