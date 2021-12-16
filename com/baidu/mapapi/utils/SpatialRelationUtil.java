package com.baidu.mapapi.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class SpatialRelationUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SpatialRelationUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static LatLng a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, latLng, latLng2, latLng3)) == null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            GeoPoint ll2mc3 = CoordUtil.ll2mc(latLng3);
            double sqrt = Math.sqrt(((ll2mc.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6())));
            double longitudeE6 = (((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * (ll2mc3.getLongitudeE6() - ll2mc.getLongitudeE6())) + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * (ll2mc3.getLatitudeE6() - ll2mc.getLatitudeE6()))) / (sqrt * sqrt);
            return CoordUtil.mc2ll(new GeoPoint(ll2mc.getLatitudeE6() + ((ll2mc2.getLatitudeE6() - ll2mc.getLatitudeE6()) * longitudeE6), ll2mc.getLongitudeE6() + ((ll2mc2.getLongitudeE6() - ll2mc.getLongitudeE6()) * longitudeE6)));
        }
        return (LatLng) invokeLLL.objValue;
    }

    public static LatLng getNearestPointFromLine(List<LatLng> list, LatLng latLng) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, latLng)) == null) {
            LatLng latLng2 = null;
            if (list != null && list.size() != 0 && latLng != null) {
                int i2 = 0;
                while (i2 < list.size() - 1) {
                    int i3 = i2 + 1;
                    LatLng a = a(list.get(i2), list.get(i3), latLng);
                    if ((a.latitude - list.get(i2).latitude) * (a.latitude - list.get(i3).latitude) > 0.0d || (a.longitude - list.get(i2).longitude) * (a.longitude - list.get(i3).longitude) > 0.0d) {
                        a = DistanceUtil.getDistance(latLng, list.get(i2)) < DistanceUtil.getDistance(latLng, list.get(i3)) ? list.get(i2) : list.get(i3);
                    }
                    if (latLng2 == null || DistanceUtil.getDistance(latLng, a) < DistanceUtil.getDistance(latLng, latLng2)) {
                        latLng2 = a;
                    }
                    i2 = i3;
                }
            }
            return latLng2;
        }
        return (LatLng) invokeLL.objValue;
    }

    public static boolean isCircleContainsPoint(LatLng latLng, int i2, LatLng latLng2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, latLng, i2, latLng2)) == null) ? (latLng == null || i2 == 0 || latLng2 == null || DistanceUtil.getDistance(latLng, latLng2) > ((double) i2)) ? false : true : invokeLIL.booleanValue;
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, latLng)) == null) {
            if (list == null || list.size() == 0 || latLng == null) {
                return false;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (latLng.longitude == list.get(i3).longitude && latLng.latitude == list.get(i3).latitude) {
                    return true;
                }
            }
            int size = list.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                LatLng latLng2 = list.get(i4);
                i4++;
                LatLng latLng3 = list.get(i4 % size);
                double d2 = latLng2.latitude;
                double d3 = latLng3.latitude;
                if (d2 != d3 && latLng.latitude >= Math.min(d2, d3) && latLng.latitude <= Math.max(latLng2.latitude, latLng3.latitude)) {
                    double d4 = latLng.latitude;
                    double d5 = latLng2.latitude;
                    double d6 = latLng3.longitude;
                    i2 = size;
                    double d7 = latLng2.longitude;
                    double d8 = (((d4 - d5) * (d6 - d7)) / (latLng3.latitude - d5)) + d7;
                    double d9 = latLng.longitude;
                    if (d8 == d9) {
                        return true;
                    }
                    if (d8 < d9) {
                        i5++;
                    }
                } else {
                    i2 = size;
                }
                size = i2;
            }
            return i5 % 2 == 1;
        }
        return invokeLL.booleanValue;
    }
}
