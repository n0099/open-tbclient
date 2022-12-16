package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.c.a.d;
import com.baidu.android.pushservice.c.e;
import com.baidu.android.pushservice.h.a.a.a;
import com.baidu.android.pushservice.i.m;
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
    public static final List<a.c> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1989504751, "Lcom/baidu/android/pushservice/h/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1989504751, "Lcom/baidu/android/pushservice/h/a/a;");
                return;
            }
        }
        a = new CopyOnWriteArrayList();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private a.c a(long j, long j2, String str, long j3, long j4, String str2, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), str2, Long.valueOf(j5)})) == null) ? a.c.s().a(a.e.d).a(a.j.q().a(j).b(j2).a(str).c(j3).d(j4).b(str2).e(j5).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(long j, String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j), str, str2, Long.valueOf(j2)})) == null) ? a.c.s().a(a.e.b).a(a.l.k().a(j).a(str).b(str2).b(j2).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j, long j2, long j3, String str3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str3, Long.valueOf(j4)})) == null) ? a.c.s().a(a.e.e).a(a.aa.q().a(str).b(str2).a(j).b(j2).c(j3).c(str3).d(j4).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j, String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{str, str2, Long.valueOf(j), str3, Long.valueOf(j2)})) == null) ? a.c.s().a(a.e.f).a(a.C0037a.m().a(str).b(str2).a(j).c(str3).b(j2).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, String str3, String str4, long j, long j2, long j3, String str5, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{str, str2, str3, str4, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str5, Long.valueOf(j4)})) == null) ? a.c.s().a(a.e.c).a(a.n.u().a(str).b(str2).c(str3).d(str4).a(j).b(j2).c(j3).e(str5).d(j4).build()).build() : (a.c) invokeCommon.objValue;
    }

    private void a(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, cVar) == null) {
            a.add(cVar);
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
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, context)) == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i3 = 0;
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
                if (i > i3) {
                    i3 = i;
                    i = i3;
                }
                i2 = displayMetrics.densityDpi;
            } else {
                i = 0;
                i2 = 0;
            }
            return a.ac.q().a(a.x.c).a(i3).b(i).c(i2).build();
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
                a(a(cVar.b, cVar.a, cVar.c, cVar.d));
            }
        }
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            for (d dVar : e.a(context).b()) {
                a(a(dVar.a, dVar.b, dVar.c, dVar.d, dVar.e, dVar.f, dVar.g, dVar.h, dVar.i));
            }
        }
    }

    private void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.b bVar : e.a(context).c()) {
                a(a(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g));
            }
        }
    }

    private void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.e eVar : e.a(context).d()) {
                a(a(eVar.a, eVar.b, eVar.c, eVar.d, eVar.e, eVar.f, eVar.g));
            }
        }
    }

    private void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.a aVar : e.a(context).e()) {
                a(a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e));
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.clear();
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
                if (a.size() <= 0) {
                    return null;
                }
                return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(a).build().toByteArray();
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
