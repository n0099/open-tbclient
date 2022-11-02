package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class AreaUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AreaUtil() {
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

    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, latLng, latLng2)) == null) {
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
        return invokeLL.doubleValue;
    }

    public static double calculateArea(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
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
        return invokeL.doubleValue;
    }
}
