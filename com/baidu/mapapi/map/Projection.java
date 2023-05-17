package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.x;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes3.dex */
public final class Projection {
    public com.baidu.mapsdkplatform.comapi.map.d a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.a = dVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        if (point != null && (dVar = this.a) != null) {
            return CoordUtil.mc2ll(dVar.b(point.x, point.y));
        }
        return null;
    }

    public float metersToEquatorPixels(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return (float) (f / this.a.K());
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng != null && this.a != null) {
            return this.a.a(CoordUtil.ll2mc(latLng));
        }
        return null;
    }

    public Point geoPoint3toScreenLocation(LatLng latLng, int i) {
        if (latLng != null && this.a != null && i >= 0) {
            return this.a.a(CoordUtil.ll2mc(latLng), i);
        }
        return null;
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng != null && mapStatus != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            com.baidu.mapsdkplatform.comapi.map.x xVar = mapStatus.a;
            return new PointF((float) (ll2mc.getLongitudeE6() - xVar.d), (float) (ll2mc.getLatitudeE6() - xVar.e));
        }
        return null;
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng != null && mapStatus != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            x.a aVar = mapStatus.a.k;
            return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.a) * 2.0d) / Math.abs(aVar.b - aVar.a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
        }
        return null;
    }
}
