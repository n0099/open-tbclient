package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes2.dex */
public final class Projection {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f6991a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f6991a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        if (point == null || (eVar = this.f6991a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(eVar.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        return (float) (f2 / this.f6991a.J());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab abVar = mapStatus.f6901a;
        return new PointF((float) (ll2mc.getLongitudeE6() - abVar.f7573d), (float) (ll2mc.getLatitudeE6() - abVar.f7574e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab.a aVar = mapStatus.f6901a.k;
        return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.f7578a) * 2.0d) / Math.abs(aVar.f7579b - aVar.f7578a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.f7581d) * 2.0d) / Math.abs(aVar.f7580c - aVar.f7581d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f6991a == null) {
            return null;
        }
        return this.f6991a.a(CoordUtil.ll2mc(latLng));
    }
}
