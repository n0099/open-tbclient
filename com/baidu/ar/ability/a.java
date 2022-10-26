package com.baidu.ar.ability;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Map bv;
    public static volatile Map bw;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-962212017, "Lcom/baidu/ar/ability/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-962212017, "Lcom/baidu/ar/ability/a;");
                return;
            }
        }
        bv = Z();
        bw = aa();
    }

    public static Map Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.ar.vo.VOAR", 1300);
            hashMap.put("com.baidu.ar.pose.PoseAR", 1400);
            hashMap.put("com.baidu.ar.stretch.StretchAR", 1400);
            hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static Map aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ability_face_model", 1200);
            hashMap.put("ability_face_filter", 1000);
            hashMap.put("ability_makeup_filter", Integer.valueOf((int) FeatureCodes.BEAUTY_MAKEUP));
            hashMap.put("ability_vo", 1300);
            hashMap.put("ability_pose", 1400);
            hashMap.put("ability_body_detect", 1400);
            hashMap.put("ability_gesture", 1500);
            hashMap.put("ability_image_segmentation", Integer.valueOf((int) FeatureCodes.BODY_SEG));
            hashMap.put("ability_sky_segmentation", Integer.valueOf((int) FeatureCodes.SKY_SEG));
            hashMap.put("ability_hair_segmentation", 1800);
            hashMap.put("ability_object_detect", 2000);
            hashMap.put("ability_3d_track", 3100);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (bv.containsKey(str)) {
                return ARAuth.checkFeatureAuth(((Integer) bv.get(str)).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (bw.containsKey(str)) {
                return ARAuth.checkFeatureAuth(((Integer) bw.get(str)).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (bw.containsKey(str)) {
                return ARAuth.enableFeature(((Integer) bw.get(str)).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
