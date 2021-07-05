package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ConvertUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConvertUtils() {
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

    public static JSONArray array2Json(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, dArr)) != null) {
            return (JSONArray) invokeL.objValue;
        }
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d2 : dArr) {
                try {
                    jSONArray2.put(d2);
                } catch (Exception e2) {
                    e = e2;
                    jSONArray = jSONArray2;
                    RemoteXAdLogger.getInstance().d(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    @TargetApi(8)
    public static String bitmap2tring(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject combineJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, jSONObject2)) == null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject hashMap2Json(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return null;
            }
            try {
                return new JSONObject(hashMap);
            } catch (Exception unused) {
                RemoteXAdLogger.getInstance().d("hashMap2Json error");
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> json2HashMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                } catch (Exception unused) {
                    RemoteXAdLogger.getInstance().d("json2HashMap error");
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static JSONArray list2Json(List<String[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                        jSONArray2.put(list.get(i2)[i3]);
                    }
                    jSONArray.put(jSONArray2);
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d(e2);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static Object optObjectFromJson(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, str)) == null) ? (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "" : invokeLL.objValue;
    }

    public static int readIntFromJson(JSONObject jSONObject, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, jSONObject, str, i2)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str) && jSONObject.has(str)) {
                try {
                    if (jSONObject.opt(str) instanceof Integer) {
                        int intValue = ((Integer) jSONObject.opt(str)).intValue();
                        jSONObject.remove(str);
                        return intValue;
                    }
                } catch (Exception unused) {
                }
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public static String readStringFromJson(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, jSONObject, str, str2)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str) && jSONObject.has(str)) {
                try {
                    Object opt = jSONObject.opt(str);
                    if (opt instanceof String) {
                        String str3 = (String) opt;
                        jSONObject.remove(str);
                        return str3;
                    }
                } catch (Exception unused) {
                }
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }

    @TargetApi(8)
    public static Bitmap string2bitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                byte[] decode = android.util.Base64.decode(str, 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }
}
