package com.baidu.platform.comapi.location;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.basestruct.a;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CoordinateUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native Point bd09llTobd09mc(double d, double d2);

    public static native Point bd09llTogcj02ll(double d, double d2);

    public static native Point bd09mcTobd09ll(double d, double d2);

    public static native Point gcj02Tobd09ll(double d, double d2);

    public static native double getDistanceByMc(double d, double d2, double d3, double d4);

    public static native Point nativeComplexPtToPoint(String str);

    public static native boolean nativeGeoStringToComplexPt(String str, Bundle bundle);

    public static native boolean nativeGeoStringToComplexPtBound(String str, Bundle bundle);

    public static native Point nativeGeoStringToPoint(String str);

    public static native String nativePointToGeoString(double d, double d2);

    public static native Point wgs84Togcj02(double d, double d2);

    public CoordinateUtil() {
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

    public static Point bd09mcTogcj02ll(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            Point bd09mcTobd09ll = bd09mcTobd09ll(d, d2);
            if (bd09mcTobd09ll != null) {
                return bd09llTogcj02ll(bd09mcTobd09ll.getDoubleX(), bd09mcTobd09ll.getDoubleY());
            }
            return null;
        }
        return (Point) invokeCommon.objValue;
    }

    public static Point gcj02Tobd09mc(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            Point gcj02Tobd09ll = gcj02Tobd09ll(d, d2);
            if (gcj02Tobd09ll != null) {
                return bd09llTobd09mc(gcj02Tobd09ll.getDoubleX(), gcj02Tobd09ll.getDoubleY());
            }
            return null;
        }
        return (Point) invokeCommon.objValue;
    }

    public static Point wgs84Tobd09ll(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            Point wgs84Togcj02 = wgs84Togcj02(d, d2);
            if (wgs84Togcj02 != null) {
                return gcj02Tobd09ll(wgs84Togcj02.getDoubleX(), wgs84Togcj02.getDoubleY());
            }
            return null;
        }
        return (Point) invokeCommon.objValue;
    }

    public static Point complexPtToPoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null && !str.equals("")) {
                return nativeComplexPtToPoint(str);
            }
            return null;
        }
        return (Point) invokeL.objValue;
    }

    public static Point geoStringToPoint(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str != null && !str.equals("")) {
                return nativeGeoStringToPoint(str);
            }
            return null;
        }
        return (Point) invokeL.objValue;
    }

    public static String pointToGeoString(Point point) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, point)) == null) {
            if (point == null) {
                return "";
            }
            return nativePointToGeoString(point.getDoubleX(), point.getDoubleY());
        }
        return (String) invokeL.objValue;
    }

    public static a geoStringToComplexPt(String str) {
        InterceptResult invokeL;
        ParcelItem[] parcelItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str != null && !str.equals("")) {
                Bundle bundle = new Bundle();
                if (nativeGeoStringToComplexPt(str, bundle)) {
                    a aVar = new a();
                    Bundle bundle2 = bundle.getBundle("map_bound");
                    if (bundle2 != null) {
                        Bundle bundle3 = bundle2.getBundle("ll");
                        if (bundle3 != null) {
                            aVar.b = new Point((int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                        Bundle bundle4 = bundle2.getBundle("ru");
                        if (bundle4 != null) {
                            aVar.c = new Point((int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                    }
                    for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
                        if (aVar.d == null) {
                            aVar.d = new ArrayList<>();
                        }
                        Bundle bundle5 = parcelItem.getBundle();
                        if (bundle5 != null) {
                            ParcelItem[] parcelItemArr2 = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                            ArrayList<Point> arrayList = new ArrayList<>();
                            for (ParcelItem parcelItem2 : parcelItemArr2) {
                                Bundle bundle6 = parcelItem2.getBundle();
                                if (bundle6 != null) {
                                    arrayList.add(new Point((int) bundle6.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle6.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY)));
                                }
                            }
                            arrayList.trimToSize();
                            aVar.d.add(arrayList);
                        }
                    }
                    aVar.d.trimToSize();
                    aVar.a = (int) bundle.getDouble("type");
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a geoStringToComplexPtBound(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str != null && !str.equals("")) {
                Bundle bundle = new Bundle();
                if (nativeGeoStringToComplexPtBound(str, bundle)) {
                    a aVar = new a();
                    Bundle bundle2 = bundle.getBundle("map_bound");
                    if (bundle2 != null) {
                        Bundle bundle3 = bundle2.getBundle("ll");
                        if (bundle3 != null) {
                            aVar.b = new Point((int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                        Bundle bundle4 = bundle2.getBundle("ru");
                        if (bundle4 != null) {
                            aVar.c = new Point((int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                    }
                    aVar.a = (int) bundle.getDouble("type");
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static Point wgs84Tobd09mc(double d, double d2) {
        InterceptResult invokeCommon;
        Point gcj02Tobd09ll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            Point wgs84Togcj02 = wgs84Togcj02(d, d2);
            if (wgs84Togcj02 != null && (gcj02Tobd09ll = gcj02Tobd09ll(wgs84Togcj02.getDoubleX(), wgs84Togcj02.getDoubleY())) != null) {
                return bd09llTobd09mc(gcj02Tobd09ll.getDoubleX(), gcj02Tobd09ll.getDoubleY());
            }
            return null;
        }
        return (Point) invokeCommon.objValue;
    }
}
