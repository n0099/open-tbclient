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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final List<a.c> f37352a;
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
        f37352a = new CopyOnWriteArrayList();
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

    private a.c a(long j2, long j3, String str, long j4, long j5, String str2, long j6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4), Long.valueOf(j5), str2, Long.valueOf(j6)})) == null) ? a.c.s().a(a.e.f37445d).a(a.j.q().a(j2).b(j3).a(str).c(j4).d(j5).b(str2).e(j6).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(long j2, String str, String str2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3)})) == null) ? a.c.s().a(a.e.f37443b).a(a.l.k().a(j2).a(str).b(str2).b(j3).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j2, long j3, long j4, String str3, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str3, Long.valueOf(j5)})) == null) ? a.c.s().a(a.e.f37446e).a(a.aa.q().a(str).b(str2).a(j2).b(j3).c(j4).c(str3).d(j5).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, long j2, String str3, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, str2, Long.valueOf(j2), str3, Long.valueOf(j3)})) == null) ? a.c.s().a(a.e.f37447f).a(a.C1591a.m().a(str).b(str2).a(j2).c(str3).b(j3).build()).build() : (a.c) invokeCommon.objValue;
    }

    private a.c a(String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5, long j5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str5, Long.valueOf(j5)})) == null) ? a.c.s().a(a.e.f37444c).a(a.n.u().a(str).b(str2).c(str3).d(str4).a(j2).b(j3).c(j4).e(str5).d(j5).build()).build() : (a.c) invokeCommon.objValue;
    }

    private void a(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, cVar) == null) {
            f37352a.add(cVar);
        }
    }

    private a.h c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            a.p build = a.p.e().a(DeviceId.getCUID(context)).build();
            a.f.C1597a a2 = a.f.i().a(context.getPackageName());
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
            return a.ac.q().a(a.x.f37584c).a(Build.VERSION.RELEASE).b(Build.MANUFACTURER.toUpperCase()).c(Build.MODEL).a(i4).b(i2).c(i3).build();
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
                a(a(cVar.f37009b, cVar.f37008a, cVar.f37010c, cVar.f37011d));
            }
        }
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            for (d dVar : e.a(context).b()) {
                a(a(dVar.f37022a, dVar.f37023b, dVar.f37024c, dVar.f37025d, dVar.f37026e, dVar.f37027f, dVar.f37028g, dVar.f37029h, dVar.f37030i));
            }
        }
    }

    private void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.b bVar : e.a(context).c()) {
                a(a(bVar.f36991a, bVar.f36992b, bVar.f36993c, bVar.f36994d, bVar.f36995e, bVar.f36996f, bVar.f36997g));
            }
        }
    }

    private void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.e eVar : e.a(context).d()) {
                a(a(eVar.f37031a, eVar.f37032b, eVar.f37033c, eVar.f37034d, eVar.f37035e, eVar.f37036f, eVar.f37037g));
            }
        }
    }

    private void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, context) == null) {
            for (com.baidu.android.pushservice.c.a.a aVar : e.a(context).e()) {
                a(a(aVar.f36978a, aVar.f36979b, aVar.f36980c, aVar.f36981d, aVar.f36982e));
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f37352a.clear();
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
                if (f37352a.size() <= 0) {
                    return null;
                }
                return a.y.k().a(c(context)).a("push").a(com.baidu.android.pushservice.a.a()).a(f37352a).build().toByteArray();
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
