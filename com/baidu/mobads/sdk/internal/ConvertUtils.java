package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
                    XAdLogger.getInstance().d(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static JSONObject combineJson(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, jSONObject2)) == null) {
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static JSONObject hashMap2Json(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return null;
            }
            try {
                return new JSONObject(hashMap);
            } catch (Exception unused) {
                XAdLogger.getInstance().d("hashMap2Json error");
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> json2HashMap(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, jSONObject)) == null) {
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
                    XAdLogger.getInstance().d("json2HashMap error");
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static JSONArray list2Json(List<String[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                        jSONArray2.put(list.get(i2)[i3]);
                    }
                    jSONArray.put(jSONArray2);
                } catch (Exception e2) {
                    XAdLogger.getInstance().d(e2);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static Object optObjectFromJson(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str)) == null) ? (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "" : invokeLL.objValue;
    }
}
