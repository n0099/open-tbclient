package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, point, point2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1, point.x);
            bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1, point.y);
            bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X2, point2.x);
            bundle.putDouble(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y2, point2.y);
            JNITools.GetDistanceByMC(bundle);
            return bundle.getDouble("distance");
        }
        return invokeLL.doubleValue;
    }

    public static com.baidu.platform.comapi.basestruct.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && !str.equals("")) {
                Bundle bundle = new Bundle();
                bundle.putString("strkey", str);
                JNITools.TransGeoStr2ComplexPt(bundle);
                com.baidu.platform.comapi.basestruct.a aVar = new com.baidu.platform.comapi.basestruct.a();
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
                        ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                        ArrayList<Point> arrayList = new ArrayList<>();
                        for (ParcelItem parcelItem2 : parcelItemArr) {
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
            return null;
        }
        return (com.baidu.platform.comapi.basestruct.a) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return JNITools.GetToken();
        }
        return (String) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            JNITools.initClass(new Bundle(), 0);
        }
    }

    public static void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            JNITools.openLogEnable(z, i);
        }
    }
}
