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
/* loaded from: classes4.dex */
public class SpatialRelationUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SpatialRelationUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                int i = 0;
                while (i < list.size() - 1) {
                    int i2 = i + 1;
                    LatLng a = a(list.get(i), list.get(i2), latLng);
                    if ((a.latitude - list.get(i).latitude) * (a.latitude - list.get(i2).latitude) > 0.0d || (a.longitude - list.get(i).longitude) * (a.longitude - list.get(i2).longitude) > 0.0d) {
                        a = DistanceUtil.getDistance(latLng, list.get(i)) < DistanceUtil.getDistance(latLng, list.get(i2)) ? list.get(i) : list.get(i2);
                    }
                    if (latLng2 == null || DistanceUtil.getDistance(latLng, a) < DistanceUtil.getDistance(latLng, latLng2)) {
                        latLng2 = a;
                    }
                    i = i2;
                }
            }
            return latLng2;
        }
        return (LatLng) invokeLL.objValue;
    }

    public static boolean isCircleContainsPoint(LatLng latLng, int i, LatLng latLng2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, latLng, i, latLng2)) == null) ? (latLng == null || i == 0 || latLng2 == null || DistanceUtil.getDistance(latLng, latLng2) > ((double) i)) ? false : true : invokeLIL.booleanValue;
    }

    public static boolean isPolygonContainsPoint(List<LatLng> list, LatLng latLng) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, latLng)) == null) {
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
                i3++;
                LatLng latLng3 = list.get(i3 % size);
                double d2 = latLng2.latitude;
                double d3 = latLng3.latitude;
                if (d2 != d3 && latLng.latitude >= Math.min(d2, d3) && latLng.latitude <= Math.max(latLng2.latitude, latLng3.latitude)) {
                    double d4 = latLng.latitude;
                    double d5 = latLng2.latitude;
                    double d6 = latLng3.longitude;
                    i = size;
                    double d7 = latLng2.longitude;
                    double d8 = (((d4 - d5) * (d6 - d7)) / (latLng3.latitude - d5)) + d7;
                    double d9 = latLng.longitude;
                    if (d8 == d9) {
                        return true;
                    }
                    if (d8 < d9) {
                        i4++;
                    }
                } else {
                    i = size;
                }
                size = i;
            }
            return i4 % 2 == 1;
        }
        return invokeLL.booleanValue;
    }
}
