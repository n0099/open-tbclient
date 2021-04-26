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
    public com.baidu.mapsdkplatform.comapi.map.e f7275a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f7275a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        if (point == null || (eVar = this.f7275a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(eVar.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        return (float) (f2 / this.f7275a.J());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab abVar = mapStatus.f7178a;
        return new PointF((float) (ll2mc.getLongitudeE6() - abVar.f7877d), (float) (ll2mc.getLatitudeE6() - abVar.f7878e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab.a aVar = mapStatus.f7178a.k;
        return new PointF((float) ((((ll2mc.getLongitudeE6() - aVar.f7883a) * 2.0d) / Math.abs(aVar.f7884b - aVar.f7883a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.f7886d) * 2.0d) / Math.abs(aVar.f7885c - aVar.f7886d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f7275a == null) {
            return null;
        }
        return this.f7275a.a(CoordUtil.ll2mc(latLng));
    }
}
