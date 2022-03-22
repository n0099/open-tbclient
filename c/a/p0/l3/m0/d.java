package c.a.p0.l3.m0;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a4.k0.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-710039036, "Lc/a/p0/l3/m0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-710039036, "Lc/a/p0/l3/m0/d;");
        }
    }

    public static void a(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, cVar, i) == null) {
            cVar.i(706);
            boolean z = i == 1000;
            cVar.c(z ? "APP" : "URL");
            if (!z) {
                cVar.l(i);
            }
            cVar.h("DEEPLINK");
        }
    }

    public static String b(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            String valueOf = hashMap != null ? String.valueOf(hashMap.get("da_area")) : null;
            return TextUtils.isEmpty(valueOf) ? "hotarea" : valueOf;
        }
        return (String) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "GET_PROCESS_NAME_FAIL";
            } catch (Exception unused) {
                return "GET_PROCESS_NAME_FAIL";
            }
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            c cVar = new c();
            cVar.h(str);
            cVar.v(str2);
            cVar.d(i);
            cVar.i(i2);
            cVar.k(str3);
            e.b().d(cVar);
        }
    }

    public static void e(String str, @NonNull String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4, str5, str6, str7, str8}) == null) {
            c cVar = new c();
            cVar.h(str);
            cVar.v(str2);
            cVar.d(i);
            cVar.i(i2);
            cVar.c(str3);
            cVar.k(str4);
            cVar.m(str5);
            cVar.o(str6);
            cVar.q(str7);
            cVar.s(str8);
            e.b().d(cVar);
        }
    }

    public static void f(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, advertAppInfo, i) == null) {
            g(advertAppInfo, 0, "", i);
        }
    }

    public static void g(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        c.a.a0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            c b2 = g.b(advertAppInfo, 2, i);
            if (TextUtils.isEmpty(str)) {
                str = "hotarea";
            }
            if (advertAppInfo != null && (aVar = advertAppInfo.u) != null) {
                b2.o(aVar.a());
            }
            b2.c(str);
            e.b().d(b2);
            a(b2, i2);
            e.b().d(b2);
        }
    }

    public static void h(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{advertAppInfo, Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            g(advertAppInfo, i, b(hashMap), i2);
        }
    }

    public static void i(AdvertAppInfo advertAppInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, advertAppInfo, i, i2) == null) {
            j(advertAppInfo, i, i2, -999, -999);
        }
    }

    public static void j(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || advertAppInfo == null || (i5 = advertAppInfo.f29816c) == 1001 || i5 == -1001) {
            return;
        }
        c h2 = g.h(advertAppInfo, 5, i, i2);
        if (i3 != -999) {
            h2.l(i3);
        }
        if (i4 != -999) {
            h2.n(i4);
        }
        if (i2 == 31) {
            if (TextUtils.isEmpty(a)) {
                a = c();
            }
            h2.s(a);
        }
        e.b().d(h2);
    }

    public static void k(o oVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, oVar, i) == null) {
            l(oVar, i, -999, -999);
        }
    }

    public static void l(o oVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65548, null, oVar, i, i2, i3) == null) || oVar == null || oVar.getAdvertAppInfo() == null || oVar.getAdvertAppInfo().f29816c == 1001 || oVar.getAdvertAppInfo().f29816c == -1001) {
            return;
        }
        c e2 = g.e(oVar, 5);
        e2.j(i);
        if (i2 != -999) {
            e2.l(i2);
        }
        if (i3 != -999) {
            e2.n(i3);
        }
        e.b().d(e2);
    }

    public static void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, advertAppInfo) == null) {
            e.b().d(g.b(advertAppInfo, 7, 0));
        }
    }

    public static void n(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, advertAppInfo) == null) {
            o(advertAppInfo, 0, "", "", "");
        }
    }

    public static void o(AdvertAppInfo advertAppInfo, int i, String str, String str2, String str3) {
        c.a.a0.f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, str3}) == null) {
            c c2 = g.c(advertAppInfo, 2, i);
            c2.w(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "hotarea";
            }
            if (advertAppInfo != null && (aVar = advertAppInfo.u) != null) {
                c2.o(aVar.a());
            }
            c2.c(str3);
            e.b().d(c2);
        }
    }

    public static void p(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, hashMap}) == null) {
            o(advertAppInfo, i, str, str2, b(hashMap));
        }
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, advertAppInfo) == null) {
            e.b().d(g.b(advertAppInfo, 3, 0));
        }
    }
}
