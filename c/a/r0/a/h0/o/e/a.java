package c.a.r0.a.h0.o.e;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import c.a.r0.a.h0.l.g.h;
import c.a.r0.a.k;
import c.a.r0.a.y1.b.e;
import c.a.r0.a.y1.b.g;
import c.a.r0.a.z2.l0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6892b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6893c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6894d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6895e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6896f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f6897g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f6898h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.h0.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0403a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0403a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("result", a.h());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(21754066, "Lc/a/r0/a/h0/o/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(21754066, "Lc/a/r0/a/h0/o/e/a;");
                return;
            }
        }
        a = k.a;
        f6892b = ProcessUtils.isMainProcess() ? j("swan_prefetch_app_data", 1) : e();
        f6893c = j("swan_prefetch_slave_data", 0);
        f6894d = j("swan_prefetch_click", 0);
        f6895e = j("swan_prefetch_event_on", 1);
        f6896f = j("swan_prefetch_sub_pkg", 0);
        f6897g = d("swan_prefetch_app_data_multi", 0);
        if (a) {
            String str = "prefetch switch - " + f6892b;
            String str2 = "master prefetch switch -  " + f6895e;
            String str3 = "sub pkg prefetch switch -  " + f6896f;
            String str4 = "master multi preload switch -  " + f6897g;
        }
        f6898h = c.a.r0.a.z2.a1.a.a("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", "3mHyKpYFH6SF5FTWTLVaVdgi3lDGrxYy");
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) ? f6894d && m(pMSAppInfo) : invokeL.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt(str, -1) : invokeL.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_event", -1) : invokeV.intValue;
    }

    public static int d(String str, int i2) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) {
            if (!a || (b2 = b(str)) == -1) {
                c.a.r0.a.c1.a.g0().getSwitch(str, i2);
                if (a) {
                    String str2 = str + " value from AB : " + i2;
                }
                return i2;
            }
            return b2;
        }
        return invokeLI.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            g c2 = e.c(C0403a.class, null);
            boolean z = false;
            if (c2.a() && c2.a.getBoolean("result", false)) {
                z = true;
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"LogConditional"})
    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (a) {
                int c2 = c();
                String str = "prefetch switch in debug sp - " + c2;
                return c2 == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && f6898h.contains(str) : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f6892b : invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            boolean z = !l0.f("3.290.0");
            if (!a || b("swan_prefetch_app_data_multi") <= 0) {
                return z;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean j(String str, int i2) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) {
            if (a) {
                if (c.a.r0.a.x1.a.a.Y() || (b2 = b(str)) == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
            }
            return d(str, i2) == 1;
        }
        return invokeLI.booleanValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            d.k("PrefetchABSwitcher", "preload master is on = " + f6892b);
            d.k("PrefetchABSwitcher", "preload slave is on = " + f6893c);
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            boolean z = a0 != null && m(a0.V().f0());
            d.k("PrefetchABSwitcher", "prefetch master show is on = " + z);
            d.k("PrefetchABSwitcher", "prefetch master click is on = " + f6894d);
            d.k("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f6896f);
            c.a.r0.a.h0.l.g.a a2 = h.b().a();
            if (a2 != null) {
                d.k("PrefetchABSwitcher", "current running master id = " + a2.i().c());
            }
            d.k("PrefetchABSwitcher", "master multi preload switch -  " + f6897g);
        }
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f6897g : invokeV.intValue;
    }

    public static boolean m(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (h()) {
                if (a) {
                    int c2 = c();
                    if (c2 == 1) {
                        return true;
                    }
                    if (c2 == 0) {
                        return false;
                    }
                }
                if (pMSAppInfo != null && f6895e) {
                    boolean z = c.a.r0.a.v.a.b(pMSAppInfo.appId) != 0;
                    c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                    SwanAppConfigData P = a0 == null ? null : a0.P();
                    if (P != null && !P.u) {
                        SwanAppConfigData.h hVar = P.t;
                        boolean z2 = hVar != null && hVar.a;
                        if (z) {
                            return z2;
                        }
                        return (z2 || g(pMSAppInfo.appKey)) && c.a.r0.a.m1.d.d.g().i(pMSAppInfo);
                    }
                    boolean z3 = a;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, pMSAppInfo)) == null) {
            boolean z = false;
            if (pMSAppInfo == null) {
                return false;
            }
            boolean m = m(pMSAppInfo);
            if (a) {
                String str = "appId - " + pMSAppInfo.appKey + ", prefetch on - " + m;
            }
            if (m) {
                if (a) {
                    int c2 = c();
                    if (c2 == 1) {
                        return true;
                    }
                    if (c2 == 0) {
                        return false;
                    }
                }
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                SwanAppConfigData P = a0 == null ? null : a0.P();
                z = ((P != null && (hVar = P.t) != null && TextUtils.equals(hVar.f39389b, "show")) || g(pMSAppInfo.appKey)) ? true : true;
                if (a) {
                    String str2 = "appId - " + pMSAppInfo.appKey + ", show prefetch - " + z;
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f6893c : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f6896f : invokeV.booleanValue;
    }
}
