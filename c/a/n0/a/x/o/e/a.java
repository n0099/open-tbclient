package c.a.n0.a.x.o.e;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.o1.b.e;
import c.a.n0.a.o1.b.g;
import c.a.n0.a.p2.l0;
import c.a.n0.a.u.d;
import c.a.n0.a.x.l.g.h;
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
    public static final boolean f7329b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7330c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7331d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7332e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f7333f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f7334g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f7335h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0560a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0560a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1365202960, "Lc/a/n0/a/x/o/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1365202960, "Lc/a/n0/a/x/o/e/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f7329b = ProcessUtils.isMainProcess() ? j("swan_prefetch_app_data", 1) : e();
        f7330c = j("swan_prefetch_slave_data", 0);
        f7331d = j("swan_prefetch_click", 0);
        f7332e = j("swan_prefetch_event_on", 1);
        f7333f = j("swan_prefetch_sub_pkg", 0);
        f7334g = d("swan_prefetch_app_data_multi", 0);
        if (a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + f7329b);
            Log.i("PrefetchABSwitcher", "master prefetch switch -  " + f7332e);
            Log.i("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f7333f);
            Log.i("PrefetchABSwitcher", "master multi preload switch -  " + f7334g);
        }
        f7335h = c.a.n0.a.p2.a1.a.a("hZPrR8cXXYgGHX2eGYOASkdmRyPkKcyT", "3mHyKpYFH6SF5FTWTLVaVdgi3lDGrxYy");
    }

    public static boolean a(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) ? f7331d && m(pMSAppInfo) : invokeL.booleanValue;
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

    public static int d(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (!a || (b2 = b(str)) == -1) {
                c.a.n0.a.s0.a.g0().getSwitch(str, i);
                if (a) {
                    Log.d("PrefetchABSwitcher", str + " value from AB : " + i);
                }
                return i;
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
            g c2 = e.c(C0560a.class, null);
            boolean z = false;
            if (c2.a() && c2.a.getBoolean("result", false)) {
                z = true;
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
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
                Log.d("PrefetchABSwitcher", "prefetch switch in debug sp - " + c2);
                return c2 == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !TextUtils.isEmpty(str) && f7335h.contains(str) : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f7329b : invokeV.booleanValue;
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

    public static boolean j(String str, int i) {
        InterceptResult invokeLI;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            if (a) {
                if (c.a.n0.a.n1.a.a.Y() || (b2 = b(str)) == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
            }
            return d(str, i) == 1;
        }
        return invokeLI.booleanValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            d.k("PrefetchABSwitcher", "preload master is on = " + f7329b);
            d.k("PrefetchABSwitcher", "preload slave is on = " + f7330c);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            boolean z = a0 != null && m(a0.V().f0());
            d.k("PrefetchABSwitcher", "prefetch master show is on = " + z);
            d.k("PrefetchABSwitcher", "prefetch master click is on = " + f7331d);
            d.k("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f7333f);
            c.a.n0.a.x.l.g.a a2 = h.b().a();
            if (a2 != null) {
                d.k("PrefetchABSwitcher", "current running master id = " + a2.i().c());
            }
            d.k("PrefetchABSwitcher", "master multi preload switch -  " + f7334g);
        }
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f7334g : invokeV.intValue;
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
                if (pMSAppInfo != null && f7332e) {
                    boolean z = c.a.n0.a.l.a.b(pMSAppInfo.appId) != 0;
                    c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
                    SwanAppConfigData P = a0 == null ? null : a0.P();
                    if (P != null && !P.u) {
                        SwanAppConfigData.h hVar = P.t;
                        boolean z2 = hVar != null && hVar.a;
                        if (z) {
                            return z2;
                        }
                        return (z2 || g(pMSAppInfo.appKey)) && c.a.n0.a.c1.d.d.g().i(pMSAppInfo);
                    } else if (a) {
                        Log.d("PrefetchABSwitcher", "NA View not support prefetch");
                    }
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
                Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", prefetch on - " + m);
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
                c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
                SwanAppConfigData P = a0 == null ? null : a0.P();
                z = ((P != null && (hVar = P.t) != null && TextUtils.equals(hVar.f29255b, "show")) || g(pMSAppInfo.appKey)) ? true : true;
                if (a) {
                    Log.d("PrefetchABSwitcher", "appId - " + pMSAppInfo.appKey + ", show prefetch - " + z);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? f7330c : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? f7333f : invokeV.booleanValue;
    }
}
