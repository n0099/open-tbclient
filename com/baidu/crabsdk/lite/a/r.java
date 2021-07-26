package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f4761a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f4762b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, hashMap) == null) {
            if (f4762b == null || hashMap == null) {
                SharedPreferences sharedPreferences = f4762b;
                if (sharedPreferences == null || hashMap != null) {
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                com.baidu.crabsdk.lite.b.c.c(edit.putString("users_custom_" + str, ""), false);
                return;
            }
            try {
                String c2 = com.baidu.crabsdk.lite.sender.d.c(hashMap);
                SharedPreferences.Editor edit2 = f4762b.edit();
                com.baidu.crabsdk.lite.b.c.c(edit2.putString("users_custom_" + str, c2), false);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && f4761a == null) {
            f4761a = context;
            f4762b = context.getSharedPreferences("crablite_user_info", 0);
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = com.baidu.crabsdk.lite.a.f4732b;
            if (str2 != null && str2.length() > 0) {
                com.baidu.crabsdk.lite.b.a.f(str, "uid is which user setted");
                HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4731a.get(str);
                if (hashMap != null && (obj = hashMap.get("sdk_uid")) != null) {
                    return (String) obj;
                }
            }
            Context context = f4761a;
            if (context == null) {
                com.baidu.crabsdk.lite.b.a.d(str, "get SharedPreferences error because context is null for unknown reasons!!!");
                return "N/A";
            }
            if (f4762b == null) {
                f4762b = context.getSharedPreferences("crablite_user_info", 0);
            }
            SharedPreferences sharedPreferences = f4762b;
            String string = sharedPreferences.getString("userId_" + str, "");
            if (string == null || string.length() == 0) {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor edit = f4762b.edit();
                com.baidu.crabsdk.lite.b.c.c(edit.putString("userId_" + str, string), false);
            }
            com.baidu.crabsdk.lite.b.a.f(str, "uid is UUID " + string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            SharedPreferences sharedPreferences = f4762b;
            if (sharedPreferences != null) {
                return sharedPreferences.getString("userName_" + str, "");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            SharedPreferences sharedPreferences = f4762b;
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("users_custom_" + str, "");
                if (string != null && string.length() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            SharedPreferences sharedPreferences = f4762b;
            if (sharedPreferences != null) {
                return sharedPreferences.getString("users_custom_" + str, "");
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str, String str2) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) || (sharedPreferences = f4762b) == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        com.baidu.crabsdk.lite.b.c.c(edit.putString("userName_" + str, str2), false);
    }
}
