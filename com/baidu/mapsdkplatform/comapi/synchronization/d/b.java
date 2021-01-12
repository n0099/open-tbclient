package com.baidu.mapsdkplatform.comapi.synchronization.d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
/* loaded from: classes6.dex */
public class b {
    public static double a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return -1.0d;
        }
        Point ll2point = CoordUtil.ll2point(latLng);
        Point ll2point2 = CoordUtil.ll2point(latLng2);
        if (ll2point == null || ll2point2 == null) {
            return -1.0d;
        }
        return CoordUtil.getDistance(ll2point, ll2point2);
    }
}
