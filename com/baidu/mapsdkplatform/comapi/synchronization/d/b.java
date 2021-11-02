package com.baidu.mapsdkplatform.comapi.synchronization.d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(LatLng latLng, LatLng latLng2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, latLng, latLng2)) == null) {
            if (latLng != null && latLng2 != null) {
                Point ll2point = CoordUtil.ll2point(latLng);
                Point ll2point2 = CoordUtil.ll2point(latLng2);
                if (ll2point != null && ll2point2 != null) {
                    return CoordUtil.getDistance(ll2point, ll2point2);
                }
            }
            return -1.0d;
        }
        return invokeLL.doubleValue;
    }
}
