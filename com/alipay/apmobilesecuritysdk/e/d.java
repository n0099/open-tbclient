package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                if (!com.alipay.security.mobile.module.a.a.a(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString(com.alipay.sdk.cons.b.f31307g));
                }
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
            return null;
        }
        return (c) invokeL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (d.class) {
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (d.class) {
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
            }
        }
    }

    public static synchronized void a(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, cVar) == null) {
            synchronized (d.class) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("apdid", cVar.a);
                    jSONObject.put("deviceInfoHash", cVar.f31183b);
                    jSONObject.put("timestamp", cVar.f31184c);
                    jSONObject.put("tid", cVar.f31185d);
                    jSONObject.put(com.alipay.sdk.cons.b.f31307g, cVar.f31186e);
                    String jSONObject2 = jSONObject.toString();
                    com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                    com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
                } catch (Exception e2) {
                    com.alipay.apmobilesecuritysdk.c.a.a(e2);
                }
            }
        }
    }

    public static synchronized c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (d.class) {
                String a = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            }
        }
        return (c) invokeV.objValue;
    }

    public static synchronized c b(Context context) {
        InterceptResult invokeL;
        c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (d.class) {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
                }
                a = a(a2);
            }
            return a;
        }
        return (c) invokeL.objValue;
    }

    public static synchronized c c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            synchronized (d.class) {
                String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
                if (com.alipay.security.mobile.module.a.a.a(a)) {
                    return null;
                }
                return a(a);
            }
        }
        return (c) invokeL.objValue;
    }
}
