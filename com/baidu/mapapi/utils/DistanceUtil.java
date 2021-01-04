package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.Point;
/* loaded from: classes15.dex */
public class DistanceUtil {
    public static double getDistance(LatLng latLng, LatLng latLng2) {
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
