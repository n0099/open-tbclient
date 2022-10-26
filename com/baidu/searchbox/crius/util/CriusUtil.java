package com.baidu.searchbox.crius.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CriusUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float convertFloatValue(double d, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d), Float.valueOf(f)})) == null) {
            return (float) (d * (d < 1.0d ? 10.0d : f));
        }
        return invokeCommon.floatValue;
    }

    public static float positive(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65543, null, f)) == null) {
            if (f >= 0.0f) {
                return f;
            }
            return 0.0f;
        }
        return invokeF.floatValue;
    }

    public CriusUtil() {
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

    public static boolean equalsDouble(double d, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d), Double.valueOf(d2)})) == null) {
            if (Math.abs(d - d2) <= 0.001d) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static double getDoubleIfExist(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
                return -10000.0d;
            }
            return jSONObject.optDouble(str);
        }
        return invokeLL.doubleValue;
    }

    public static int getIntIfExist(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
                return Integer.MIN_VALUE;
            }
            return jSONObject.optInt(str);
        }
        return invokeLL.intValue;
    }

    public static String getStringIfExist(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || !jSONObject.has(str)) {
                return "";
            }
            return jSONObject.optString(str);
        }
        return (String) invokeLL.objValue;
    }

    public static Map getMapIfExist(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            if (jSONObject == null || TextUtils.isEmpty(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys != null && keys.hasNext()) {
                String next = keys.next();
                String optString = optJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
