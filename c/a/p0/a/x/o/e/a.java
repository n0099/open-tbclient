package c.a.p0.a.x.o.e;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.o1.b.e;
import c.a.p0.a.o1.b.g;
import c.a.p0.a.p2.l0;
import c.a.p0.a.u.d;
import c.a.p0.a.x.l.g.h;
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
    public static final boolean f8725b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8726c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8727d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8728e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8729f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8730g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f8731h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.x.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0568a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0568a() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952008974, "Lc/a/p0/a/x/o/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952008974, "Lc/a/p0/a/x/o/e/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f8725b = ProcessUtils.isMainProcess() ? j("swan_prefetch_app_data", 1) : e();
        f8726c = j("swan_prefetch_slave_data", 0);
        f8727d = j("swan_prefetch_click", 0);
        f8728e = j("swan_prefetch_event_on", 1);
        f8729f = j("swan_prefetch_sub_pkg", 0);
        f8730g = d("swan_prefetch_app_data_multi", 0);
        if (a) {
            String str = "prefetch switch - " + f8725b;
            String str2 = "master prefetch switch -  " + f8728e;
            String str3 = "sub pkg prefetch switch -  " + f8729f;
            String str4 = "master multi preload switch -  " + f8730g;
        }
        f8731h = c.a.p0.a.p2.a1.a.a("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", "3mHyKpYFH6SF5FTWTLVaVdgi3lDGrxYy");
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) ? f8727d && m(pMSAppInfo) : invokeL.booleanValue;
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
                c.a.p0.a.s0.a.g0().getSwitch(str, i2);
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
            g c2 = e.c(C0568a.class, null);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && f8731h.contains(str) : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f8725b : invokeV.booleanValue;
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
                if (c.a.p0.a.n1.a.a.Y() || (b2 = b(str)) == 1) {
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
            d.k("PrefetchABSwitcher", "preload master is on = " + f8725b);
            d.k("PrefetchABSwitcher", "preload slave is on = " + f8726c);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            boolean z = a0 != null && m(a0.V().f0());
            d.k("PrefetchABSwitcher", "prefetch master show is on = " + z);
            d.k("PrefetchABSwitcher", "prefetch master click is on = " + f8727d);
            d.k("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f8729f);
            c.a.p0.a.x.l.g.a a2 = h.b().a();
            if (a2 != null) {
                d.k("PrefetchABSwitcher", "current running master id = " + a2.i().c());
            }
            d.k("PrefetchABSwitcher", "master multi preload switch -  " + f8730g);
        }
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f8730g : invokeV.intValue;
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
                if (pMSAppInfo != null && f8728e) {
                    boolean z = c.a.p0.a.l.a.b(pMSAppInfo.appId) != 0;
                    c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                    SwanAppConfigData P = a0 == null ? null : a0.P();
                    if (P != null && !P.u) {
                        SwanAppConfigData.h hVar = P.t;
                        boolean z2 = hVar != null && hVar.a;
                        if (z) {
                            return z2;
                        }
                        return (z2 || g(pMSAppInfo.appKey)) && c.a.p0.a.c1.d.d.g().i(pMSAppInfo);
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
                c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                SwanAppConfigData P = a0 == null ? null : a0.P();
                z = ((P != null && (hVar = P.t) != null && TextUtils.equals(hVar.f38021b, "show")) || g(pMSAppInfo.appKey)) ? true : true;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f8726c : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f8729f : invokeV.booleanValue;
    }
}
