package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING, "");
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
                    jSONObject.put("apdid", bVar.f35815a);
                    jSONObject.put("deviceInfoHash", bVar.f35816b);
                    jSONObject.put("timestamp", bVar.f35817c);
                    String jSONObject2 = jSONObject.toString();
                    com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING, jSONObject2);
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
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            }
        }
        return (b) invokeV.objValue;
    }

    public static synchronized b b(Context context) {
        InterceptResult invokeL;
        b a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            synchronized (a.class) {
                String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING);
                if (com.alipay.security.mobile.module.a.a.a(a3)) {
                    a3 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
                }
                a2 = a(a3);
            }
            return a2;
        }
        return (b) invokeL.objValue;
    }

    public static synchronized b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (a.class) {
                String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING);
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                return a(a2);
            }
        }
        return (b) invokeL.objValue;
    }
}
