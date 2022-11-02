package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static GeoPoint a(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, geoPoint)) == null) {
            Point bd09llTobd09mc = CoordinateUtil.bd09llTobd09mc(geoPoint.getLongitude(), geoPoint.getLatitude());
            if (bd09llTobd09mc != null) {
                return new GeoPoint(bd09llTobd09mc.getDoubleY(), bd09llTobd09mc.getDoubleX());
            }
            return null;
        }
        return (GeoPoint) invokeL.objValue;
    }
}
