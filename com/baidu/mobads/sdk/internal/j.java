package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    @TargetApi(8)
    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                byte[] decode = Base64.decode(str, 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Object a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, str)) == null) {
            if (jSONObject == null || !jSONObject.has(str)) {
                return "";
            }
            return jSONObject.opt(str);
        }
        return invokeLL.objValue;
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        InterceptResult invokeL;
        String[] strArr;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        HashMap hashMap = new HashMap(map);
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        int i = 0;
                        for (String str : ArticleInfo.PREDEFINED_KEYS) {
                            if (hashMap.containsKey(str)) {
                                String str2 = (String) hashMap.remove(str);
                                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                                    hashMap2.put(str, str2);
                                    i = length;
                                }
                            }
                        }
                        if (!hashMap.isEmpty()) {
                            Set<String> keySet = hashMap.keySet();
                            JSONArray jSONArray = new JSONArray();
                            for (String str3 : keySet) {
                                if (!TextUtils.isEmpty(str3)) {
                                    String str4 = (String) hashMap.get(str3);
                                    if (!TextUtils.isEmpty(str4)) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("k", str3);
                                        jSONObject.put("v", str4);
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            if (jSONArray.length() > 0) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("ext", jSONArray.toString());
                                if (jSONObject2.toString().length() < 3000) {
                                    hashMap2.put("ext", jSONObject2.toString());
                                }
                            }
                        }
                        return hashMap2;
                    }
                } catch (Throwable unused) {
                    return new HashMap<>();
                }
            }
            return new HashMap<>();
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (Exception unused) {
                br.a().a("json2HashMap error");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static JSONArray a(List<String[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < list.get(i).length; i2++) {
                        jSONArray2.put(list.get(i)[i2]);
                    }
                    jSONArray.put(jSONArray2);
                } catch (Exception e) {
                    br.a().a(e);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONArray a(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dArr)) == null) {
            JSONArray jSONArray = null;
            if (dArr == null) {
                return null;
            }
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (double d : dArr) {
                    try {
                        jSONArray2.put(d);
                    } catch (Exception e) {
                        e = e;
                        jSONArray = jSONArray2;
                        br.a().a(e);
                        return jSONArray;
                    }
                }
                return jSONArray2;
            } catch (Exception e2) {
                e = e2;
            }
        } else {
            return (JSONArray) invokeL.objValue;
        }
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return null;
            }
            try {
                return new JSONObject(hashMap);
            } catch (Exception unused) {
                br.a().a("hashMap2Json error");
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, jSONObject2)) == null) {
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
}
