package com.baidu.android.util.io;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public final class JSONUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "JSONUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public JSONUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> T get(JSONObject jSONObject, String str, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, str, cls)) == null) {
            if (jSONObject == null) {
                return null;
            }
            T t = (T) jSONObject.opt(str);
            if (cls.isInstance(t)) {
                return t;
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, jSONObject, str, z)) == null) {
            Boolean bool = (Boolean) get(jSONObject, str, Boolean.class);
            return bool == null ? z : bool.booleanValue();
        }
        return invokeLLZ.booleanValue;
    }

    public static float getFloat(JSONObject jSONObject, String str, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONObject, str, Float.valueOf(f2)})) == null) ? jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2) : invokeCommon.floatValue;
    }

    public static int getInt(JSONObject jSONObject, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, jSONObject, str, i2)) == null) ? ((Integer) get(jSONObject, str, Integer.class)) == null ? i2 : ((Integer) get(jSONObject, str, Integer.class)).intValue() : invokeLLI.intValue;
    }

    public static String getIntOrString(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str)) == null) {
            Integer num = (Integer) get(jSONObject, str, Integer.class);
            if (num == null) {
                return (String) get(jSONObject, str, String.class);
            }
            return num.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static <T> T getItem(JSONArray jSONArray, int i2, Class<T> cls) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, jSONArray, i2, cls)) == null) {
            T t = (T) jSONArray.opt(i2);
            if (cls.isInstance(t)) {
                return t;
            }
            return null;
        }
        return (T) invokeLIL.objValue;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, str)) == null) ? (JSONArray) get(jSONObject, str, JSONArray.class) : (JSONArray) invokeLL.objValue;
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, str)) == null) ? (JSONObject) get(jSONObject, str, JSONObject.class) : (JSONObject) invokeLL.objValue;
    }

    public static JSONObject getJSONObjectItem(JSONArray jSONArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, jSONArray, i2)) == null) ? (JSONObject) getItem(jSONArray, i2, JSONObject.class) : (JSONObject) invokeLI.objValue;
    }

    public static String getString(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, jSONObject, str)) == null) ? (String) get(jSONObject, str, String.class) : (String) invokeLL.objValue;
    }

    public static JSONObject parseString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static Object get(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) ? get(jSONObject, str, Object.class) : invokeLL.objValue;
    }
}
