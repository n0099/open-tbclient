package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AreaUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AreaUtil() {
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
}
