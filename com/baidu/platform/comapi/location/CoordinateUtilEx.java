package com.baidu.platform.comapi.location;

import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.basestruct.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class CoordinateUtilEx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CoordinateUtilEx() {
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

    public static Point Coordinate_encryptEx(float f, float f2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), str})) == null) {
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                str = "bd09ll";
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1395470197:
                    if (str.equals("bd09ll")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1395470175:
                    if (str.equals("bd09mc")) {
                        c = 3;
                        break;
                    }
                    break;
                case 98175376:
                    if (str.equals("gcj02")) {
                        c = 1;
                        break;
                    }
                    break;
                case 113079775:
                    if (str.equals("wgs84")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            return null;
                        }
                        return new Point(f, f2);
                    }
                    return CoordinateUtil.bd09llTobd09mc(f, f2);
                }
                return CoordinateUtil.gcj02Tobd09mc(f, f2);
            }
            return CoordinateUtil.wgs84Tobd09mc(f, f2);
        }
        return (Point) invokeCommon.objValue;
    }

    public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> arrayList, String str) {
        InterceptResult invokeLL;
        Point wgs84Tobd09mc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, str)) == null) {
            String str2 = str;
            if (str2 == null) {
                return null;
            }
            if (str2.equals("")) {
                str2 = "bd09ll";
            }
            if (!str2.equals("bd09ll") && !str2.equals("bd09mc") && !str2.equals("gcj02") && !str2.equals("wgs84")) {
                return null;
            }
            int size = arrayList.size();
            float[] fArr = new float[size];
            float[] fArr2 = new float[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                fArr[i] = arrayList.get(i).getIntX() / 100000.0f;
                fArr2[i] = arrayList.get(i).getIntY() / 100000.0f;
            }
            ArrayList<Point> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1395470197:
                        if (str2.equals("bd09ll")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1395470175:
                        if (str2.equals("bd09mc")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 98175376:
                        if (str2.equals("gcj02")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 113079775:
                        if (str2.equals("wgs84")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                wgs84Tobd09mc = null;
                            } else {
                                wgs84Tobd09mc = new Point(fArr[i2], fArr2[i2]);
                            }
                        } else {
                            wgs84Tobd09mc = CoordinateUtil.bd09llTobd09mc(fArr[i2], fArr2[i2]);
                        }
                    } else {
                        wgs84Tobd09mc = CoordinateUtil.gcj02Tobd09mc(fArr[i2], fArr2[i2]);
                    }
                } else {
                    wgs84Tobd09mc = CoordinateUtil.wgs84Tobd09mc(fArr[i2], fArr2[i2]);
                }
                if (wgs84Tobd09mc != null) {
                    arrayList2.add(wgs84Tobd09mc);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static double getDistanceByMc(GeoPoint geoPoint, GeoPoint geoPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, geoPoint, geoPoint2)) == null) {
            return CoordinateUtil.getDistanceByMc(geoPoint.getLongitude(), geoPoint.getLatitude(), geoPoint2.getLongitude(), geoPoint2.getLatitude());
        }
        return invokeLL.doubleValue;
    }

    public static double getDistanceByMc(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, point, point2)) == null) {
            return CoordinateUtil.getDistanceByMc(point.getDoubleX(), point.getDoubleY(), point2.getDoubleX(), point2.getDoubleY());
        }
        return invokeLL.doubleValue;
    }

    @Deprecated
    public static a getGeoComplexPointFromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null && !str.equals("")) {
                return CoordinateUtil.geoStringToComplexPt(str);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    @Deprecated
    public static a getGeoComplexPtBoundFromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str != null && !str.equals("")) {
                return CoordinateUtil.geoStringToComplexPtBound(str);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static Point getGeoPointFromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null && !str.equals("")) {
                return CoordinateUtil.geoStringToPoint(str);
            }
            return null;
        }
        return (Point) invokeL.objValue;
    }

    public static String getStringFromGeoPoint(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, point)) == null) {
            return CoordinateUtil.pointToGeoString(point);
        }
        return (String) invokeL.objValue;
    }
}
