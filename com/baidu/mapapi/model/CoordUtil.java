package com.baidu.mapapi.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), str})) == null) ? com.baidu.mapsdkplatform.comapi.util.b.a(f, f2, str) : (LatLng) invokeCommon.objValue;
    }

    public static LatLng decodeLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            CoordType coordType = SDKInitializer.getCoordType();
            CoordType coordType2 = CoordType.GCJ02;
            LatLng a = com.baidu.mapsdkplatform.comapi.util.b.a(str);
            return coordType == coordType2 ? CoordTrans.baiduToGcj(a) : a;
        }
        return (LatLng) invokeL.objValue;
    }

    public static List decodeLocationList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? com.baidu.mapsdkplatform.comapi.util.b.c(str) : (List) invokeL.objValue;
    }

    public static List decodeLocationList2D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? com.baidu.mapsdkplatform.comapi.util.b.d(str) : (List) invokeL.objValue;
    }

    public static LatLng decodeNodeLocation(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            CoordType coordType = SDKInitializer.getCoordType();
            CoordType coordType2 = CoordType.GCJ02;
            LatLng b = com.baidu.mapsdkplatform.comapi.util.b.b(str);
            return coordType == coordType2 ? CoordTrans.baiduToGcj(b) : b;
        }
        return (LatLng) invokeL.objValue;
    }

    public static double getDistance(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, point, point2)) == null) ? com.baidu.mapsdkplatform.comjni.tools.a.a(point, point2) : invokeLL.doubleValue;
    }

    public static int getMCDistanceByOneLatLngAndRadius(LatLng latLng, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, latLng, i)) == null) ? SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng), i) : com.baidu.mapsdkplatform.comapi.util.b.a(latLng, i) : invokeLI.intValue;
    }

    public static GeoPoint ll2mc(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, latLng)) == null) ? SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.a(CoordTrans.gcjToBaidu(latLng)) : com.baidu.mapsdkplatform.comapi.util.b.a(latLng) : (GeoPoint) invokeL.objValue;
    }

    public static Point ll2point(LatLng latLng) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, latLng)) == null) ? SDKInitializer.getCoordType() == CoordType.GCJ02 ? com.baidu.mapsdkplatform.comapi.util.b.b(CoordTrans.gcjToBaidu(latLng)) : com.baidu.mapsdkplatform.comapi.util.b.b(latLng) : (Point) invokeL.objValue;
    }

    public static LatLng mc2ll(GeoPoint geoPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, geoPoint)) == null) {
            CoordType coordType = SDKInitializer.getCoordType();
            CoordType coordType2 = CoordType.GCJ02;
            LatLng a = com.baidu.mapsdkplatform.comapi.util.b.a(geoPoint);
            return coordType == coordType2 ? CoordTrans.baiduToGcj(a) : a;
        }
        return (LatLng) invokeL.objValue;
    }
}
