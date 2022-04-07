package com.baidu.android.pushservice;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 5287;
    public static int b = 5288;
    public static String c = "https://info.tuisong.baidu.com";
    public static String d = "/setter";
    public static String e = "/v2/setter";
    public static String f = "/getter";
    public static String g = "/v2/getter";
    public static String h = "/bccs/upload";
    public static String i = "https://ack.tuisong.baidu.com";
    public static String j = "/click";
    public static String k = "api.tuisong.baidu.com";
    public static String[] l = null;
    public static String m = "sa.tuisong.baidu.com";
    public static String[] n;
    public static boolean o;
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
        l = new String[]{"api0.tuisong.baidu.com", "api1.tuisong.baidu.com", "api2.tuisong.baidu.com", "api3.tuisong.baidu.com", "api4.tuisong.baidu.com", "api5.tuisong.baidu.com", "api6.tuisong.baidu.com", "api7.tuisong.baidu.com", "api8.tuisong.baidu.com", "api9.tuisong.baidu.com"};
        n = new String[]{"sa0.tuisong.baidu.com", "sa1.tuisong.baidu.com", "sa2.tuisong.baidu.com", "sa3.tuisong.baidu.com", "sa4.tuisong.baidu.com", "sa5.tuisong.baidu.com", "sa6.tuisong.baidu.com", "sa7.tuisong.baidu.com", "sa8.tuisong.baidu.com", "sa9.tuisong.baidu.com"};
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? m.o(context) ? b : a : invokeL.intValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return "http://" + k;
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return "https://" + k;
        }
        return (String) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) != null) {
            return;
        }
        if (!PushSettings.f(context)) {
            String a2 = PushSettings.a(context);
            if (TextUtils.isEmpty(a2) || a2.length() <= 0) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(a2.substring(a2.length() - 1));
                k = l[parseInt % 10];
                m = n[parseInt % 10];
                return;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return;
            }
        }
        File file = new File(context.getExternalFilesDir("").getAbsolutePath(), "pushservice.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            if (m.k(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream = fileInputStream2;
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                    com.baidu.android.pushservice.d.c.a(context, fileInputStream);
                    return;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    com.baidu.android.pushservice.d.c.a(context, fileInputStream);
                    throw th;
                }
            } else {
                properties.put("http_server", "http://10.95.41.15:8080");
                if (m.o(context)) {
                    properties.put("socket_server_port_v3", "8006");
                } else {
                    properties.put("socket_server_port", WbAuthConstants.AUTH_FAILED_QUICK_NULL_TOKEN_ERROR_CODE);
                }
                properties.put("socket_server", "10.95.41.15");
            }
            String property = properties.getProperty("http_server");
            if (!TextUtils.isEmpty(property)) {
                if (property.startsWith("http://")) {
                    property = property.replace("http://", "");
                }
                k = property;
            }
            String property2 = properties.getProperty("socket_server");
            if (!TextUtils.isEmpty(property2)) {
                m = property2;
            }
            String property3 = properties.getProperty("data_update_server");
            if (!TextUtils.isEmpty(property3)) {
                c = property3;
            }
            String property4 = properties.getProperty("push_ack_server");
            if (!TextUtils.isEmpty(property4)) {
                i = property4;
            }
            if (m.o(context)) {
                String property5 = properties.getProperty("socket_server_port_v3");
                if (!TextUtils.isEmpty(property5)) {
                    b = Integer.parseInt(property5);
                }
            } else {
                String property6 = properties.getProperty("socket_server_port");
                if (!TextUtils.isEmpty(property6)) {
                    a = Integer.parseInt(property6);
                }
            }
            if (e.a == 0) {
                String property7 = properties.getProperty(Constants.API_KEY);
                if (TextUtils.equals(properties.getProperty(EmotionResourceInfo.JSON_KEY_PKG_NAME), context.getPackageName()) && !TextUtils.isEmpty(property7)) {
                    e.b = property7;
                }
            }
            o = true;
            com.baidu.android.pushservice.d.c.a(context, fileInputStream);
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? k : (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String a2 = PushSettings.a(context);
            if (!TextUtils.isEmpty(a2) && a2.length() > 0) {
                try {
                    return n[Integer.parseInt(a2.substring(a2.length() - 1)) % 10];
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
            return "sa.tuisong.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? m : (String) invokeV.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            String a2 = PushSettings.a(context);
            if (!TextUtils.isEmpty(a2) && a2.length() > 0) {
                try {
                    return l[Integer.parseInt(a2.substring(a2.length() - 1)) % 10];
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
            return "api.tuisong.baidu.com";
        }
        return (String) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        StringBuilder sb;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (o) {
                sb = new StringBuilder();
                b2 = a();
            } else {
                sb = new StringBuilder();
                b2 = b();
            }
            sb.append(b2);
            sb.append("/rest/2.0/channel/");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? o : invokeV.booleanValue;
    }
}
