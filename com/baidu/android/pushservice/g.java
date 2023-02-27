package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "api.tuisong.baidu.com";
    public static String[] b = null;
    public static String c = "sa.tuisong.baidu.com";
    public static String[] d = null;
    public static int e = 5287;
    public static int f = 5288;
    public static String g = "https://info.tuisong.baidu.com";
    public static String h = "/v2/setter";
    public static String i = "/v2/getter";
    public static String j = "/bccs/upload";
    public static String k = "https://ack.tuisong.baidu.com";
    public static String l = "/click";
    public static boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-840926954, "Lcom/baidu/android/pushservice/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-840926954, "Lcom/baidu/android/pushservice/g;");
                return;
            }
        }
        b = new String[]{"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
        d = new String[]{"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};
    }

    public static String a() {
        InterceptResult invokeV;
        StringBuilder sb;
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m) {
                sb = new StringBuilder();
                d2 = c();
            } else {
                sb = new StringBuilder();
                d2 = d();
            }
            sb.append(d2);
            sb.append("/rest/2.0/channel/");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String b2 = PushSettings.b(context);
            if (!TextUtils.isEmpty(b2) && b2.length() > 0) {
                try {
                    return b[Integer.parseInt(b2.substring(b2.length() - 1)) % 10];
                } catch (Exception unused) {
                }
            }
            return "api.tuisong.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String b2 = PushSettings.b(context);
            if (!TextUtils.isEmpty(b2) && b2.length() > 0) {
                try {
                    return d[Integer.parseInt(b2.substring(b2.length() - 1)) % 10];
                } catch (Exception unused) {
                }
            }
            return "sa.tuisong.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? Utility.D(context) ? f : e : invokeL.intValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return "http://" + a;
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return "https://" + a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            try {
                if (!PushSettings.e(context)) {
                    String b2 = PushSettings.b(context);
                    if (TextUtils.isEmpty(b2) || b2.length() <= 0) {
                        return;
                    }
                    int parseInt = Integer.parseInt(b2.substring(b2.length() - 1));
                    a = b[parseInt % 10];
                    c = d[parseInt % 10];
                    return;
                }
                String c2 = com.baidu.android.pushservice.a0.i.c(context, "com.baidu.android.pushservice.offline_environment_conf");
                if (TextUtils.isEmpty(c2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(c2);
                String optString = jSONObject.optString("http_server");
                if (!TextUtils.isEmpty(optString)) {
                    if (optString.startsWith("http://")) {
                        optString = optString.replace("http://", "");
                    }
                    a = optString;
                }
                String optString2 = jSONObject.optString("socket_server");
                if (!TextUtils.isEmpty(optString2)) {
                    c = optString2;
                }
                String optString3 = jSONObject.optString("data_update_server");
                if (!TextUtils.isEmpty(optString3)) {
                    g = optString3;
                }
                String optString4 = jSONObject.optString("push_ack_server");
                if (!TextUtils.isEmpty(optString4)) {
                    k = optString4;
                }
                if (Utility.D(context)) {
                    String optString5 = jSONObject.optString("socket_server_port_v3");
                    if (!TextUtils.isEmpty(optString5)) {
                        f = Integer.parseInt(optString5);
                    }
                } else {
                    String optString6 = jSONObject.optString("socket_server_port");
                    if (!TextUtils.isEmpty(optString6)) {
                        e = Integer.parseInt(optString6);
                    }
                }
                if (e.a == 0) {
                    String optString7 = jSONObject.optString("api_key");
                    if (TextUtils.equals(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME), context.getPackageName()) && !TextUtils.isEmpty(optString7)) {
                        e.b = optString7;
                    }
                }
                m = true;
            } catch (Exception unused) {
            }
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c : (String) invokeV.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? m : invokeV.booleanValue;
    }
}
