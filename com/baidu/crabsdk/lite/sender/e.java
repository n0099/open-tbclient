package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.crabsdk.lite.a.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f4748a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78364094, "Lcom/baidu/crabsdk/lite/sender/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-78364094, "Lcom/baidu/crabsdk/lite/sender/e;");
                return;
            }
        }
        f4748a = new ScheduledThreadPoolExecutor(1);
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.substring(str.lastIndexOf("/") + 1) : (String) invokeL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f4748a.execute(new d.a.n.a.b.b(str));
        }
    }

    public static void c(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, context) == null) {
            f4748a.execute(new d.a.n.a.b.a(str, context));
        }
    }

    public static synchronized void d(String str, Context context) {
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context) == null) {
            synchronized (e.class) {
                if (d.g(str, context).size() == 0) {
                    return;
                }
                String b2 = m.b();
                if (!"NONE".equals(b2) && !RomUtils.UNKNOWN.equals(b2)) {
                    HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4705a.get(str);
                    boolean z = false;
                    if ((hashMap == null || (obj2 = hashMap.get("sdk_upload_immediate")) == null) ? false : ((Boolean) obj2).booleanValue()) {
                        com.baidu.crabsdk.lite.b.a.c(str, "upload java immediately!");
                        e(str, context);
                        return;
                    } else if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(b2)) {
                        c.e(str, 0L);
                        e(str, context);
                        return;
                    } else {
                        HashMap<String, Object> hashMap2 = com.baidu.crabsdk.lite.a.f4705a.get(str);
                        if (hashMap2 != null && (obj = hashMap2.get("sdk_wifi")) != null) {
                            z = ((Boolean) obj).booleanValue();
                        }
                        if (z) {
                            com.baidu.crabsdk.lite.b.a.c(str, "network is not wifi, and UPLOAD_CRASH_ONLY_WIFI is true!");
                            return;
                        } else if (!"MOBILE".equals(b2) || !c.a(str)) {
                            com.baidu.crabsdk.lite.b.a.c(str, "network is not wifi!");
                            return;
                        } else {
                            com.baidu.crabsdk.lite.b.a.c(str, "upload without wifi!");
                            c.e(str, 0L);
                            e(str, context);
                            return;
                        }
                    }
                }
                com.baidu.crabsdk.lite.b.a.c(str, "network is not available!");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb A[Catch: all -> 0x0217, TryCatch #2 {, blocks: (B:6:0x0007, B:8:0x0011, B:9:0x0015, B:11:0x001b, B:13:0x003c, B:14:0x0043, B:16:0x0061, B:17:0x0083, B:22:0x00b3, B:24:0x00cb, B:25:0x00d0, B:58:0x0211, B:27:0x00d7, B:31:0x00e2, B:32:0x00e7, B:37:0x0102, B:43:0x011e, B:44:0x0142, B:45:0x0164, B:47:0x0169, B:50:0x0178, B:53:0x019c, B:54:0x01d3, B:55:0x01f7, B:35:0x00f5, B:57:0x01fd, B:18:0x0087, B:20:0x008f), top: B:73:0x0007, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f7 A[Catch: all -> 0x0217, TryCatch #2 {, blocks: (B:6:0x0007, B:8:0x0011, B:9:0x0015, B:11:0x001b, B:13:0x003c, B:14:0x0043, B:16:0x0061, B:17:0x0083, B:22:0x00b3, B:24:0x00cb, B:25:0x00d0, B:58:0x0211, B:27:0x00d7, B:31:0x00e2, B:32:0x00e7, B:37:0x0102, B:43:0x011e, B:44:0x0142, B:45:0x0164, B:47:0x0169, B:50:0x0178, B:53:0x019c, B:54:0x01d3, B:55:0x01f7, B:35:0x00f5, B:57:0x01fd, B:18:0x0087, B:20:0x008f), top: B:73:0x0007, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void e(String str, Context context) {
        String str2;
        String str3;
        int intValue;
        JSONObject jSONObject;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, context) == null) {
            synchronized (e.class) {
                List<String> g2 = d.g(str, context);
                if (g2.size() != 0) {
                    for (String str5 : g2) {
                        com.baidu.crabsdk.lite.b.a.c(str, "(--#)  fileName when send  (--#)" + a(str5));
                        if (c.r(str5)) {
                            byte[] a2 = d.a(str5);
                            com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.sendRecord: " + str5);
                            JSONObject jSONObject2 = null;
                            if (str5.contains("lite_crash_")) {
                                String a3 = a(str5);
                                String a4 = com.baidu.crabsdk.lite.a.a(str);
                                com.baidu.crabsdk.lite.b.a.f(str, "sendCrashRecord postUrl:" + a4);
                                str2 = i.a(str, a4, a2, "Crash", a3);
                                str3 = "HttpSender.sendCrashRecord--->Crash";
                            } else if (str5.contains("lite_catched_")) {
                                String a5 = a(str5);
                                String b2 = com.baidu.crabsdk.lite.a.b(str);
                                com.baidu.crabsdk.lite.b.a.f(str, "sendSdkRecord postUrl:" + b2);
                                str2 = i.a(str, b2, a2, "Exception", a5);
                                str3 = "HttpSender.sendExceptionRecord--->Exception";
                            } else {
                                str2 = null;
                                com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.doUpload.result: " + str2);
                                if (!TextUtils.isEmpty(str2)) {
                                    c.s(str5);
                                    str4 = "result is empty!";
                                } else if (str2 == null || !str2.equals("500")) {
                                    try {
                                        jSONObject = new JSONObject(str2);
                                    } catch (Exception unused) {
                                    }
                                    try {
                                        intValue = ((Integer) jSONObject.get("errno")).intValue();
                                    } catch (Exception unused2) {
                                        jSONObject2 = jSONObject;
                                        try {
                                            intValue = ((Integer) jSONObject2.get("errNo")).intValue();
                                            jSONObject = jSONObject2;
                                            com.baidu.crabsdk.lite.b.a.f(str, "###--> errno = " + intValue);
                                            if (intValue != -1) {
                                            }
                                            c.q(str);
                                        } catch (Exception e2) {
                                            c.s(str5);
                                            com.baidu.crabsdk.lite.b.a.d(str, "handle crash result json error, exception is " + e2);
                                        }
                                        a.f4741g = true;
                                    }
                                    com.baidu.crabsdk.lite.b.a.f(str, "###--> errno = " + intValue);
                                    if (intValue != -1) {
                                        c.s(str5);
                                    } else if (intValue != 0) {
                                        if (intValue == 1) {
                                            try {
                                                int intValue2 = ((Integer) jSONObject.get("days")).intValue();
                                                if (intValue2 <= 0) {
                                                    intValue2 = 1;
                                                }
                                                c.d(str, intValue2);
                                                d.f(str5);
                                                c.m(str, a(str5));
                                                c.o(str, "key_" + a(str5));
                                            } catch (Exception e3) {
                                                com.baidu.crabsdk.lite.b.a.d(str, "handle crash result days json error, exception is " + e3);
                                                c.d(str, 1);
                                                d.f(str5);
                                                c.m(str, a(str5));
                                                c.o(str, "key_" + a(str5));
                                                e3.printStackTrace();
                                            }
                                        } else if (intValue != 10) {
                                            d.f(str5);
                                            c.m(str, a(str5));
                                            c.o(str, "key_" + a(str5));
                                            c.t(str5);
                                        } else {
                                            d.f(str5);
                                            c.m(str, a(str5));
                                            c.o(str, "key_" + a(str5));
                                            c.t(str5);
                                        }
                                        a.f4741g = true;
                                    } else {
                                        d.f(str5);
                                        c.m(str, a(str5));
                                        c.o(str, "key_" + a(str5));
                                        c.t(str5);
                                    }
                                    c.q(str);
                                    a.f4741g = true;
                                } else {
                                    str4 = "not connected to server!";
                                }
                                com.baidu.crabsdk.lite.b.a.g(str, str4);
                                a.f4741g = true;
                            }
                            com.baidu.crabsdk.lite.b.a.f(str, str3);
                            com.baidu.crabsdk.lite.b.a.f(str, "HttpSender.doUpload.result: " + str2);
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            com.baidu.crabsdk.lite.b.a.g(str, str4);
                            a.f4741g = true;
                        } else {
                            d.f(str5);
                            c.t(str5);
                        }
                    }
                }
            }
        }
    }
}
