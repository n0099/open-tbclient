package b.a.r0.z2.l0;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.j0.p;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f28200a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(519554741, "Lb/a/r0/z2/l0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(519554741, "Lb/a/r0/z2/l0/d;");
        }
    }

    public static void a(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, cVar, i2) == null) {
            cVar.i(SDKLogTypeConstants.CLOSE_GAME_TYPE);
            boolean z = i2 == 1000;
            cVar.c(z ? "APP" : "URL");
            if (!z) {
                cVar.l(i2);
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

    public static void d(String str, String str2, int i2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) {
            c cVar = new c();
            cVar.h(str);
            cVar.v(str2);
            cVar.d(i2);
            cVar.i(i3);
            cVar.k(str3);
            e.b().d(cVar);
        }
    }

    public static void e(String str, @NonNull String str2, int i2, int i3, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3, str4, str5, str6, str7, str8}) == null) {
            c cVar = new c();
            cVar.h(str);
            cVar.v(str2);
            cVar.d(i2);
            cVar.i(i3);
            cVar.c(str3);
            cVar.k(str4);
            cVar.m(str5);
            cVar.o(str6);
            cVar.q(str7);
            cVar.s(str8);
            e.b().d(cVar);
        }
    }

    public static void f(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, advertAppInfo, i2) == null) {
            g(advertAppInfo, 0, "", i2);
        }
    }

    public static void g(AdvertAppInfo advertAppInfo, int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{advertAppInfo, Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            c b2 = g.b(advertAppInfo, 2, i2);
            if (TextUtils.isEmpty(str)) {
                str = "hotarea";
            }
            b2.c(str);
            e.b().d(b2);
            a(b2, i3);
            e.b().d(b2);
        }
    }

    public static void h(AdvertAppInfo advertAppInfo, int i2, HashMap hashMap, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{advertAppInfo, Integer.valueOf(i2), hashMap, Integer.valueOf(i3)}) == null) {
            g(advertAppInfo, i2, b(hashMap), i3);
        }
    }

    public static void i(AdvertAppInfo advertAppInfo, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, advertAppInfo, i2, i3) == null) {
            j(advertAppInfo, i2, i3, BannerFocusImageViewGroup.f57724f, BannerFocusImageViewGroup.f57724f);
        }
    }

    public static void j(AdvertAppInfo advertAppInfo, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{advertAppInfo, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || advertAppInfo == null || (i6 = advertAppInfo.Z3) == 1001 || i6 == -1001) {
            return;
        }
        c h2 = g.h(advertAppInfo, 5, i2, i3);
        if (i4 != -999) {
            h2.l(i4);
        }
        if (i5 != -999) {
            h2.n(i5);
        }
        if (i3 == 31) {
            if (TextUtils.isEmpty(f28200a)) {
                f28200a = c();
            }
            h2.s(f28200a);
        }
        e.b().d(h2);
    }

    public static void k(p pVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, pVar, i2) == null) {
            l(pVar, i2, BannerFocusImageViewGroup.f57724f, BannerFocusImageViewGroup.f57724f);
        }
    }

    public static void l(p pVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(65548, null, pVar, i2, i3, i4) == null) || pVar == null || pVar.getAdvertAppInfo() == null || pVar.getAdvertAppInfo().Z3 == 1001 || pVar.getAdvertAppInfo().Z3 == -1001) {
            return;
        }
        c e2 = g.e(pVar, 5);
        e2.j(i2);
        if (i3 != -999) {
            e2.l(i3);
        }
        if (i4 != -999) {
            e2.n(i4);
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

    public static void o(AdvertAppInfo advertAppInfo, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{advertAppInfo, Integer.valueOf(i2), str, str2, str3}) == null) {
            c c2 = g.c(advertAppInfo, 2, i2);
            c2.w(str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = "hotarea";
            }
            c2.c(str3);
            e.b().d(c2);
        }
    }

    public static void p(AdvertAppInfo advertAppInfo, int i2, String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{advertAppInfo, Integer.valueOf(i2), str, str2, hashMap}) == null) {
            o(advertAppInfo, i2, str, str2, b(hashMap));
        }
    }

    public static void q(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, advertAppInfo) == null) {
            e.b().d(g.b(advertAppInfo, 3, 0));
        }
    }
}
