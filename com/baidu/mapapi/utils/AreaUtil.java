package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes7.dex */
public class AreaUtil {
    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        LatLng latLng3 = new LatLng(latLng.latitude, latLng2.longitude);
        double distance = DistanceUtil.getDistance(latLng3, latLng2);
        double distance2 = DistanceUtil.getDistance(latLng, latLng3);
        if (distance == 0.0d || distance2 == 0.0d) {
            return 0.0d;
        }
        return distance * distance2;
    }

    public static double calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0d;
        }
        int size = list.size();
        double d = 0.0d;
        for (int i = 0; i < size; i++) {
            LatLng latLng = list.get(i);
            LatLng latLng2 = list.get((i + 1) % size);
            d += ((latLng2.latitude * 111319.49079327358d) * ((latLng.longitude * 111319.49079327358d) * Math.cos(latLng.latitude * 0.017453292519943295d))) - ((latLng.latitude * 111319.49079327358d) * ((latLng2.longitude * 111319.49079327358d) * Math.cos(latLng2.latitude * 0.017453292519943295d)));
        }
        return (float) Math.abs(d / 2.0d);
    }
}
