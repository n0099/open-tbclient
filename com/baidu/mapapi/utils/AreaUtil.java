package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import java.util.List;
/* loaded from: classes3.dex */
public class AreaUtil {
    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            LatLng latLng3 = new LatLng(latLng.latitude, latLng2.longitude);
            double distance = DistanceUtil.getDistance(latLng3, latLng2);
            double distance2 = DistanceUtil.getDistance(latLng, latLng3);
            if (distance != 0.0d && distance2 != 0.0d) {
                return distance * distance2;
            }
        }
        return 0.0d;
    }

    public static double calculateArea(List<LatLng> list) {
        double d = 0.0d;
        if (list == null || list.size() < 3) {
            return 0.0d;
        }
        double d2 = 111319.49079327358d;
        int size = list.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i % size);
            d += (((latLng.longitude * d2) * Math.cos(latLng.latitude * 0.017453292519943295d)) * (latLng2.latitude * 111319.49079327358d)) - ((latLng.latitude * d2) * ((latLng2.longitude * d2) * Math.cos(latLng2.latitude * 0.017453292519943295d)));
            d2 = 111319.49079327358d;
        }
        return (float) Math.abs(d / 2.0d);
    }
}
