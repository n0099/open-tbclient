package com.baidu.android.util.io;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object get(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, str)) == null) {
            return get(jSONObject, str, Object.class);
        }
        return invokeLL.objValue;
    }

    public static String getIntOrString(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, str)) == null) {
            Integer num = (Integer) get(jSONObject, str, Integer.class);
            if (num == null) {
                return (String) get(jSONObject, str, String.class);
            }
            return num.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, str)) == null) {
            return (JSONArray) get(jSONObject, str, JSONArray.class);
        }
        return (JSONArray) invokeLL.objValue;
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, str)) == null) {
            return (JSONObject) get(jSONObject, str, JSONObject.class);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject getJSONObjectItem(JSONArray jSONArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, jSONArray, i)) == null) {
            return (JSONObject) getItem(jSONArray, i, JSONObject.class);
        }
        return (JSONObject) invokeLI.objValue;
    }

    public static String getString(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, jSONObject, str)) == null) {
            return (String) get(jSONObject, str, String.class);
        }
        return (String) invokeLL.objValue;
    }

    public static Object get(JSONObject jSONObject, String str, Class cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, jSONObject, str, cls)) == null) {
            if (jSONObject == null) {
                return null;
            }
            Object opt = jSONObject.opt(str);
            if (!cls.isInstance(opt)) {
                return null;
            }
            return opt;
        }
        return invokeLLL.objValue;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, jSONObject, str, z)) == null) {
            Boolean bool = (Boolean) get(jSONObject, str, Boolean.class);
            if (bool == null) {
                return z;
            }
            return bool.booleanValue();
        }
        return invokeLLZ.booleanValue;
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONObject, str, Float.valueOf(f)})) == null) {
            if (jSONObject == null) {
                return f;
            }
            return (float) jSONObject.optDouble(str, f);
        }
        return invokeCommon.floatValue;
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, jSONObject, str, i)) == null) {
            if (((Integer) get(jSONObject, str, Integer.class)) == null) {
                return i;
            }
            return ((Integer) get(jSONObject, str, Integer.class)).intValue();
        }
        return invokeLLI.intValue;
    }

    public static Object getItem(JSONArray jSONArray, int i, Class cls) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, jSONArray, i, cls)) == null) {
            Object opt = jSONArray.opt(i);
            if (cls.isInstance(opt)) {
                return opt;
            }
            return null;
        }
        return invokeLIL.objValue;
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
}
