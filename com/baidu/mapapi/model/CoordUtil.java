package com.baidu.mapapi.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class CoordUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CoordUtil() {
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

    public static LatLng Coordinate_encryptEx(float f, float f2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), str})) == null) {
            return com.baidu.mapsdkplatform.comapi.util.b.a(f, f2, str);
        }
        return (LatLng) invokeCommon.objValue;
    }

    public static LatLng decodeLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.a(str));
            }
            return com.baidu.mapsdkplatform.comapi.util.b.a(str);
        }
        return (LatLng) invokeL.objValue;
    }

    public static List<LatLng> decodeLocationList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return com.baidu.mapsdkplatform.comapi.util.b.c(str);
        }
        return (List) invokeL.objValue;
    }

    public static List<List<LatLng>> decodeLocationList2D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return com.baidu.mapsdkplatform.comapi.util.b.d(str);
        }
        return (List) invokeL.objValue;
    }

    public static LatLng decodeNodeLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.b(str));
            }
            return com.baidu.mapsdkplatform.comapi.util.b.b(str);
        }
        return (LatLng) invokeL.objValue;
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, latLng)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng));
            }
            return com.baidu.mapsdkplatform.comapi.util.b.a(latLng);
        }
        return (GeoPoint) invokeL.objValue;
    }

    public static Point ll2point(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, latLng)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return com.baidu.mapsdkplatform.comapi.util.b.b(CoordTrans.gcjToBaidu(latLng));
            }
            return com.baidu.mapsdkplatform.comapi.util.b.b(latLng);
        }
        return (Point) invokeL.objValue;
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, geoPoint)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return CoordTrans.baiduToGcj(com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint));
            }
            return com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint);
        }
        return (LatLng) invokeL.objValue;
    }

    public static double getDistance(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, point, point2)) == null) {
            return com.baidu.mapsdkplatform.comjni.tools.a.a(point, point2);
        }
        return invokeLL.doubleValue;
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, latLng, i)) == null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                return com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng), i);
            }
            return com.baidu.mapsdkplatform.comapi.util.b.a(latLng, i);
        }
        return invokeLI.intValue;
    }
}
