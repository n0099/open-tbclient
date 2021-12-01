package com.baidu.pass.ecommerce.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class JsonFieldConverter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "JsonFieldConverter";
    public transient /* synthetic */ FieldHolder $fh;

    public JsonFieldConverter() {
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

    public static void putInt(String str, MapObject mapObject, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, mapObject, jSONObject) == null) {
            try {
                jSONObject.put(str, mapObject.getIntValue(str));
            } catch (JSONException e2) {
                Log.e(TAG, "put int field " + str + " is error " + e2.getMessage());
            }
        }
    }

    public static void putJsonObj(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, jSONObject, jSONObject2) == null) {
            try {
                jSONObject2.put(str, jSONObject);
            } catch (JSONException unused) {
                Log.e(TAG, "put JsonObj field " + str + " is error");
            }
        }
    }

    public static void putStr(String str, MapObject mapObject, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mapObject, jSONObject) == null) {
            try {
                jSONObject.put(str, mapObject.getStrValue(str));
            } catch (JSONException e2) {
                Log.e(TAG, "put String field " + str + " is error " + e2.getMessage());
            }
        }
    }

    public static void putInt(String str, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, str, i2, jSONObject) == null) {
            try {
                jSONObject.put(str, i2);
            } catch (JSONException e2) {
                Log.e(TAG, "put int field key=" + str + " value=" + i2 + " is error " + e2.getMessage());
            }
        }
    }

    public static void putStr(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, jSONObject) == null) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException e2) {
                Log.e(TAG, "put String field key=" + str + " value=" + str2 + " is error " + e2.getMessage());
            }
        }
    }
}
