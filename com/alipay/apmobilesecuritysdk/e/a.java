package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                if (!com.alipay.security.mobile.module.a.a.a(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
                }
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (a.class) {
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (a.class) {
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", "");
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
            }
        }
    }

    public static synchronized void a(Context context, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, bVar) == null) {
            synchronized (a.class) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("apdid", bVar.a);
                    jSONObject.put("deviceInfoHash", bVar.f30729b);
                    jSONObject.put("timestamp", bVar.f30730c);
                    String jSONObject2 = jSONObject.toString();
                    com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid", jSONObject2);
                    com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
                } catch (Exception e2) {
                    com.alipay.apmobilesecuritysdk.c.a.a(e2);
                }
            }
        }
    }

    public static synchronized b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (a.class) {
                String a = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            }
        }
        return (b) invokeV.objValue;
    }

    public static synchronized b b(Context context) {
        InterceptResult invokeL;
        b a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (a.class) {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                }
                a = a(a2);
            }
            return a;
        }
        return (b) invokeL.objValue;
    }

    public static synchronized b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (a.class) {
                String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", "deviceid");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            }
        }
        return (b) invokeL.objValue;
    }
}
