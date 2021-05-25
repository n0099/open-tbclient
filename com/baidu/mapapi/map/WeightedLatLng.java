package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.map.o;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
/* loaded from: classes2.dex */
public class WeightedLatLng extends o.a {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a  reason: collision with root package name */
    public Point f7068a;
    public final double intensity;
    public final LatLng latLng;

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public WeightedLatLng(LatLng latLng, double d2) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
        }
        this.latLng = latLng;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        this.f7068a = new Point((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6());
        if (d2 > 0.0d) {
            this.intensity = d2;
        } else {
            this.intensity = 1.0d;
        }
    }

    @Override // com.baidu.mapapi.map.o.a
    public Point a() {
        return this.f7068a;
    }
}
