package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import java.util.List;
/* loaded from: classes8.dex */
public class SpatialRelationUtil {
    private static LatLng a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        GeoPoint ll2mc3 = CoordUtil.ll2mc(latLng3);
        double sqrt = Math.sqrt(((ll2mc.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6())));
        double latitudeE6 = (((ll2mc3.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6())) + ((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc3.getLongitudeE6() - ll2mc.getLongitudeE6()))) / (sqrt * sqrt);
        return CoordUtil.mc2ll(new GeoPoint(((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * latitudeE6) + ll2mc.getLatitudeE6(), ll2mc.getLongitudeE6() + ((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * latitudeE6)));
    }

    public static LatLng getNearestPointFromLine(List<LatLng> list, LatLng latLng) {
        if (list == null || list.size() == 0 || latLng == null) {
            return null;
        }
        int i = 0;
        LatLng latLng2 = null;
        while (i < list.size() - 1) {
            LatLng a = a(list.get(i), list.get(i + 1), latLng);
            LatLng latLng3 = ((a.latitude - list.get(i).latitude) * (a.latitude - list.get(i + 1).latitude) > 0.0d || (a.longitude - list.get(i).longitude) * (a.longitude - list.get(i + 1).longitude) > 0.0d) ? DistanceUtil.getDistance(latLng, list.get(i)) < DistanceUtil.getDistance(latLng, list.get(i + 1)) ? list.get(i) : list.get(i + 1) : a;
            if (latLng2 != null && DistanceUtil.getDistance(latLng, latLng3) >= DistanceUtil.getDistance(latLng, latLng2)) {
                latLng3 = latLng2;
            }
            i++;
            latLng2 = latLng3;
        }
        return latLng2;
    }

    public static boolean isCircleContainsPoint(LatLng latLng, int i, LatLng latLng2) {
        if (latLng == null || i == 0 || latLng2 == null) {
            return false;
        }
        double distance = DistanceUtil.getDistance(latLng, latLng2);
        if (distance <= i) {
            return distance == ((double) i) ? true : true;
        }
        return false;
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        int i;
        if (list == null || list.size() == 0 || latLng == null) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (latLng.longitude == list.get(i2).longitude && latLng.latitude == list.get(i2).latitude) {
                return true;
            }
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            LatLng latLng2 = list.get(i3);
            LatLng latLng3 = list.get((i3 + 1) % size);
            if (latLng2.latitude == latLng3.latitude) {
                i = i4;
            } else if (latLng.latitude < Math.min(latLng2.latitude, latLng3.latitude)) {
                i = i4;
            } else if (latLng.latitude > Math.max(latLng2.latitude, latLng3.latitude)) {
                i = i4;
            } else {
                double d = latLng2.longitude + (((latLng.latitude - latLng2.latitude) * (latLng3.longitude - latLng2.longitude)) / (latLng3.latitude - latLng2.latitude));
                if (d == latLng.longitude) {
                    return true;
                }
                i = d < latLng.longitude ? i4 + 1 : i4;
            }
            i3++;
            i4 = i;
        }
        return i4 % 2 == 1;
    }
}
