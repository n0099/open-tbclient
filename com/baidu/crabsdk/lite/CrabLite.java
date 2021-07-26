package com.baidu.crabsdk.lite;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.crabsdk.lite.a.f;
import com.baidu.crabsdk.lite.a.h;
import com.baidu.crabsdk.lite.a.k;
import com.baidu.crabsdk.lite.a.l;
import com.baidu.crabsdk.lite.a.m;
import com.baidu.crabsdk.lite.a.n;
import com.baidu.crabsdk.lite.a.r;
import com.baidu.crabsdk.lite.sender.c;
import com.baidu.crabsdk.lite.sender.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CrabLite {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Context f4728a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f4729b = "-1";

    /* renamed from: c  reason: collision with root package name */
    public static String f4730c = "/sdcard";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1066359313, "Lcom/baidu/crabsdk/lite/CrabLite;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1066359313, "Lcom/baidu/crabsdk/lite/CrabLite;");
        }
    }

    public CrabLite() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            l.c(str);
            e.b(str);
        }
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
        long currentTimeMillis;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, str, str2, str3, str4) == null) {
            com.baidu.crabsdk.lite.b.a.c(str2, "crablite init begin: " + System.currentTimeMillis());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("sdk_appkey", str);
            hashMap.put("sdk_pkgname", str2);
            hashMap.put("sdk_appvn", str3);
            hashMap.put("sdk_appvc", str4);
            a.f4731a.put(str2, hashMap);
            if (context == null) {
                str5 = "crab init error caused by applcation null value";
            } else {
                f4728a = context;
                f4730c = context.getFilesDir().getAbsolutePath();
                com.baidu.crabsdk.lite.b.a.c(str2, "FILE_PATH IS : " + f4730c);
                e(str2, f4728a);
                long currentTimeMillis2 = System.currentTimeMillis();
                a.k = false;
                str5 = "crab init end: " + currentTimeMillis2 + ", cost: " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            com.baidu.crabsdk.lite.b.a.d(str2, str5);
        }
    }

    public static void c(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context) == null) {
            l.a(context);
            n.a(str, context);
            f.b(str, context);
            h.a();
            k.a(context);
            r.b(context);
            m.a(context);
            com.baidu.crabsdk.lite.a.a.c(str, context);
        }
    }

    public static void d(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, context) == null) {
            c.f(str, context);
        }
    }

    public static void e(String str, Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, context) == null) {
            int myPid = Process.myPid();
            com.baidu.crabsdk.lite.b.a.f(str, "CrabSDK.init from " + f4728a.getPackageName() + " with pid " + myPid);
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
                com.baidu.crabsdk.lite.b.a.f(str, "getRunningAppProcesses error!!");
                return;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    z = true;
                    StringBuilder sb = next.processName.equals(context.getPackageName()) ? new StringBuilder("Main process ") : new StringBuilder("Sub process ");
                    sb.append(next.processName);
                    sb.append(".");
                    com.baidu.crabsdk.lite.b.a.f(str, sb.toString());
                }
            }
            if (z) {
                d(str, context);
                c(str, context);
                com.baidu.crabsdk.lite.sender.a.c().b(context);
                q(str, context);
            }
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.length() > 512) {
            str2 = str2.substring(0, 512);
        }
        g(str, str2);
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_channel", str2);
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, str, z) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_screenshot", Boolean.valueOf(z));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, str, z) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_debug", Boolean.valueOf(z));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void j(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, null, str, z) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_privacy", Boolean.valueOf(z));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void k(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_upload_immediate", Boolean.valueOf(z));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_all_crash_limit", Integer.valueOf(i2));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void m(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) {
            HashMap<String, Object> hashMap = a.f4731a.get(str);
            if (hashMap != null) {
                hashMap.put("sdk_same_crash_limit", Integer.valueOf(i2));
            } else {
                com.baidu.crabsdk.lite.b.a.d(str, "sdk config map is null, please check your pkgName!");
            }
        }
    }

    public static void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        r.g(str, str2);
    }

    public static void o(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, null, str, str2, str3) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap<String, String> e2 = r.e(str);
        e2.put(str2, str3);
        p(str, e2);
    }

    public static void p(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, hashMap) == null) || hashMap == null) {
            return;
        }
        r.a(str, hashMap);
    }

    public static void q(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65554, null, str, context) == null) && c.p(str)) {
            e.c(str, context);
        }
    }
}
