package c.a.r0.a.h0.p;

import android.os.Bundle;
import android.preference.PreferenceManager;
import c.a.r0.a.k;
import c.a.r0.a.y1.c.f.c;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.h0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0402a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;

        /* renamed from: b  reason: collision with root package name */
        public static int f6818b = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(50253482, "Lc/a/r0/a/h0/p/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(50253482, "Lc/a/r0/a/h0/p/a$a;");
            }
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab") : (String) invokeV.objValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a.a) {
                    String str = "isOnAppLaunchEnable getAppLaunchDebugSwitch : " + a();
                    String a2 = a();
                    char c2 = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != 251117829) {
                        if (hashCode != 547804557) {
                            if (hashCode == 569516856 && a2.equals("debug_on_activity_create")) {
                                c2 = 1;
                            }
                        } else if (a2.equals("debug_ab")) {
                            c2 = 2;
                        }
                    } else if (a2.equals("debug_on_app_launch")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        return true;
                    }
                    if (c2 == 1) {
                        return false;
                    }
                }
                if (a < 0) {
                    c.a.r0.a.c1.a.g0().getSwitch("swan_sub_pkg_launch_switch", 0);
                    a = 0;
                }
                if (a.a) {
                    String str2 = "isOnAppLaunchEnable sLaunchABSwitcher : " + a;
                }
                return a == 1;
            }
            return invokeV.booleanValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f6818b == -1) {
                    c.a.r0.a.c1.a.g0().getSwitch("swan_app_launch_optimize_v2", 0);
                    f6818b = 0;
                }
                return f6818b == 1;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1345302215, "Lc/a/r0/a/h0/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1345302215, "Lc/a/r0/a/h0/p/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void b(c cVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, bundle) == null) {
            boolean z = a;
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("swan_app_on_launch_event", bundle);
            c.a.r0.a.y1.c.c cVar2 = new c.a.r0.a.y1.c.c(122, bundle2);
            if (!cVar.S() && C0402a.c()) {
                cVar.e0(cVar2.h());
            } else {
                c.a.r0.a.y1.c.a e2 = c.a.r0.a.y1.c.a.e();
                cVar2.b(cVar.f9731f);
                cVar2.p(true);
                e2.h(cVar2);
            }
            boolean z2 = a;
        }
    }
}
