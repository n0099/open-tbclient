package com.baidu.ar.ability;

import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public static volatile Map<String, Integer> bv;
    public static volatile Map<String, Integer> bw;
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

    public static Map<String, Integer> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("com.baidu.ar.vo.VOAR", 1300);
            Integer valueOf = Integer.valueOf((int) FeatureCodes.POSE);
            hashMap.put("com.baidu.ar.pose.PoseAR", valueOf);
            hashMap.put("com.baidu.ar.stretch.StretchAR", valueOf);
            hashMap.put("com.baidu.ar.gesture.GestureAR", 1500);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static Map<String, Integer> aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ability_face_model", 1200);
            hashMap.put("ability_face_filter", 1000);
            hashMap.put("ability_makeup_filter", Integer.valueOf((int) FeatureCodes.BEAUTY_MAKEUP));
            hashMap.put("ability_vo", 1300);
            Integer valueOf = Integer.valueOf((int) FeatureCodes.POSE);
            hashMap.put("ability_pose", valueOf);
            hashMap.put("ability_body_detect", valueOf);
            hashMap.put("ability_gesture", 1500);
            hashMap.put("ability_image_segmentation", Integer.valueOf((int) FeatureCodes.BODY_SEG));
            hashMap.put("ability_sky_segmentation", Integer.valueOf((int) FeatureCodes.SKY_SEG));
            hashMap.put("ability_hair_segmentation", 1800);
            hashMap.put("ability_object_detect", 2000);
            hashMap.put("ability_3d_track", Integer.valueOf((int) FeatureCodes.TRACK_3D));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (bv.containsKey(str)) {
                return ARAuth.checkFeatureAuth(bv.get(str).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (bw.containsKey(str)) {
                return ARAuth.checkFeatureAuth(bw.get(str).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (bw.containsKey(str)) {
                return ARAuth.enableFeature(bw.get(str).intValue());
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
