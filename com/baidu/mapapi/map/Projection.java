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
    public com.baidu.mapsdkplatform.comapi.map.e f6990a;

    public Projection(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.f6990a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        if (point == null || (eVar = this.f6990a) == null) {
            return null;
        }
        return CoordUtil.mc2ll(eVar.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        double d2 = f2;
        double J = this.f6990a.J();
        Double.isNaN(d2);
        return (float) (d2 / J);
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab abVar = mapStatus.f6900a;
        return new PointF((float) (ll2mc.getLongitudeE6() - abVar.f7572d), (float) (ll2mc.getLatitudeE6() - abVar.f7573e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab.a aVar = mapStatus.f6900a.k;
        double abs = Math.abs(aVar.f7578b - aVar.f7577a);
        double abs2 = Math.abs(aVar.f7579c - aVar.f7580d);
        double longitudeE6 = ll2mc.getLongitudeE6();
        double d2 = aVar.f7577a;
        Double.isNaN(d2);
        Double.isNaN(abs);
        double latitudeE6 = ll2mc.getLatitudeE6();
        double d3 = aVar.f7580d;
        Double.isNaN(d3);
        Double.isNaN(abs2);
        return new PointF((float) ((((longitudeE6 - d2) * 2.0d) / abs) - 1.0d), (float) ((((latitudeE6 - d3) * 2.0d) / abs2) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f6990a == null) {
            return null;
        }
        return this.f6990a.a(CoordUtil.ll2mc(latLng));
    }
}
