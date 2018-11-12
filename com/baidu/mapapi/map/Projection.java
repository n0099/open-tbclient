package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
/* loaded from: classes4.dex */
public final class Projection {
    private com.baidu.mapsdkplatform.comapi.map.e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Projection(com.baidu.mapsdkplatform.comapi.map.e eVar) {
        this.a = eVar;
    }

    public LatLng fromScreenLocation(Point point) {
        if (point == null || this.a == null) {
            return null;
        }
        return CoordUtil.mc2ll(this.a.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return (float) (f / this.a.J());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab abVar = mapStatus.a;
        return new PointF((float) ((ll2mc.getLongitudeE6() - abVar.d) / abVar.n), (float) ((ll2mc.getLatitudeE6() - abVar.e) / abVar.n));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        ab.a aVar = mapStatus.a.k;
        return new PointF((float) (((2.0d * (ll2mc.getLongitudeE6() - aVar.a)) / Math.abs(aVar.b - aVar.a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.a == null) {
            return null;
        }
        return this.a.a(CoordUtil.ll2mc(latLng));
    }
}
