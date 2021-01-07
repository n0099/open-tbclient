package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes3.dex */
public final class Projection {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapsdkplatform.comapi.map.d f2873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Projection(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.f2873a = dVar;
    }

    public LatLng fromScreenLocation(Point point) {
        if (point == null || this.f2873a == null) {
            return null;
        }
        return CoordUtil.mc2ll(this.f2873a.b(point.x, point.y));
    }

    public float metersToEquatorPixels(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        return (float) (f / this.f2873a.H());
    }

    public PointF toOpenGLLocation(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        com.baidu.mapsdkplatform.comapi.map.w wVar = mapStatus.f2839a;
        return new PointF((float) (ll2mc.getLongitudeE6() - wVar.d), (float) (ll2mc.getLatitudeE6() - wVar.e));
    }

    public PointF toOpenGLNormalization(LatLng latLng, MapStatus mapStatus) {
        if (latLng == null || mapStatus == null) {
            return null;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        w.a aVar = mapStatus.f2839a.k;
        return new PointF((float) (((2.0d * (ll2mc.getLongitudeE6() - aVar.f3205a)) / Math.abs(aVar.f3206b - aVar.f3205a)) - 1.0d), (float) ((((ll2mc.getLatitudeE6() - aVar.d) * 2.0d) / Math.abs(aVar.c - aVar.d)) - 1.0d));
    }

    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null || this.f2873a == null) {
            return null;
        }
        return this.f2873a.a(CoordUtil.ll2mc(latLng));
    }
}
