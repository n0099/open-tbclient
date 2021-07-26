package com.baidu.android.pushservice.i.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c.a.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.i.a.a.a;
import com.baidu.android.pushservice.j.m;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<a.c> f3189a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1960875600, "Lcom/baidu/android/pushservice/i/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1960875600, "Lcom/baidu/android/pushservice/i/a/a;");
                return;
            }
        }
        f3189a = new CopyOnWriteArrayList();
    }

    public a() {
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

    private a.c a(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), str2, Long.valueOf(j5)})) == null) ? a.c.s().a(a.e.f3277d).a(a.j.q().a(j).b(j2).a(str).c(j3).d(j4).b(str2).e(j5).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(long j, String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)})) == null) ? a.c.s().a(a.e.f3275b).a(a.l.k().a(j).a(str).b(str2).b(j2).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)})) == null) ? a.c.s().a(a.e.f3278e).a(a.aa.q().a(str).b(str2).a(j).b(j2).c(j3).c(str3).d(j4).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j, String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, str2, Long.valueOf(j), str3, Long.valueOf(j2)})) == null) ? a.c.s().a(a.e.f3279f).a(a.C0037a.m().a(str).b(str2).a(j).c(str3).b(j2).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, String str3, String str4, long j, long j2, long j3, String str5, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str5, Long.valueOf(j4)})) == null) ? a.c.s().a(a.e.f3276c).a(a.n.u().a(str).b(str2).c(str3).d(str4).a(j).b(j2).c(j3).e(str5).d(j4).build()).build() : (a.c) invokeCommon.objValue;
    }

    private void a(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, cVar) == null) {
            f3189a.add(cVar);
        }
    }

    private a.h c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            a.p build = a.p.e().a(DeviceId.getCUID(context)).build();
            a.f.C0043a a2 = a.f.i().a(context.getPackageName());
            return a.h.t().a(build).a(-1L).b(System.currentTimeMillis()).a(d(context)).a(e(context)).a(a2.b("" + m.a(context)).c("").build()).build();
        }
        return (a.h) invokeL.objValue;
    }

    private a.ac d(Context context) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i4 = 0;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
                if (i2 > i4) {
                    i4 = i2;
                    i2 = i4;
                }
                i3 = displayMetrics.densityDpi;
            } else {
                i2 = 0;
                i3 = 0;
            }
            return a.ac.q().a(a.x.f3411c).a(Build.VERSION.RELEASE).b(Build.MANUFACTURER.toUpperCase()).c(Build.MODEL).a(i4).b(i2).c(i3).build();
        }
        return (a.ac) invokeL.objValue;
    }

    public static a.v e(Context context) {
        InterceptResult invokeL;
        String str;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String str2 = "";
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                str = "";
            } else {
                String str3 = "" + activeNetworkInfo.getTypeName();
                str = "" + activeNetworkInfo.getExtraInfo();
                str2 = str3;
            }
            return a.v.g().a(str2).b(str).build();
        }
        return (a.v) invokeL.objValue;
    }

    private void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.c cVar : e.a(context).a()) {
                a(a(cVar.f2857b, cVar.f2856a, cVar.f2858c, cVar.f2859d));
            }
        }
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            for (d dVar : e.a(context).b()) {
                a(a(dVar.f2869a, dVar.f2870b, dVar.f2871c, dVar.f2872d, dVar.f2873e, dVar.f2874f, dVar.f2875g, dVar.f2876h, dVar.f2877i));
            }
        }
    }

    private void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.b bVar : e.a(context).c()) {
                a(a(bVar.f2840a, bVar.f2841b, bVar.f2842c, bVar.f2843d, bVar.f2844e, bVar.f2845f, bVar.f2846g));
            }
        }
    }

    private void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.e eVar : e.a(context).d()) {
                a(a(eVar.f2878a, eVar.f2879b, eVar.f2880c, eVar.f2881d, eVar.f2882e, eVar.f2883f, eVar.f2884g));
            }
        }
    }

    private void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.a aVar : e.a(context).e()) {
                a(a(aVar.f2827a, aVar.f2828b, aVar.f2829c, aVar.f2830d, aVar.f2831e));
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f3189a.clear();
        }
    }

    public byte[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                a();
                f(context);
                g(context);
                h(context);
                i(context);
                j(context);
                if (f3189a.size() <= 0) {
                    return null;
                }
                return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(f3189a).build().toByteArray();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a("startWork", "", System.currentTimeMillis(), -1L, -1L, "", 501020L));
                return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(arrayList).build().toByteArray();
            } catch (Exception unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
