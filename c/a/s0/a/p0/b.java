package c.a.s0.a.p0;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import c.a.s0.a.z2.g1.c;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(236854670, "Lc/a/s0/a/p0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(236854670, "Lc/a/s0/a/p0/b;");
                return;
            }
        }
        a = k.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f(0).f().c();
            f(0).e().f();
            if (f(1) != null) {
                f(1).f().c();
                f(1).e().f();
            }
        }
    }

    public static <T extends c.a.s0.a.p0.g.a> Exception b(int i2, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, t)) == null) {
            c.a.s0.a.p0.d.b f2 = f(i2);
            if (f2 == null) {
                return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
            }
            return f2.a(t);
        }
        return (Exception) invokeIL.objValue;
    }

    public static ExtensionCore c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            c.a.s0.a.p0.d.b f2 = f(i2);
            if (f2 == null) {
                return null;
            }
            return f2.c();
        }
        return (ExtensionCore) invokeI.objValue;
    }

    public static long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            ExtensionCore c2 = c(i2);
            if (c2 != null) {
                return c2.extensionCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            ExtensionCore c2 = c(i2);
            return (c2 == null || TextUtils.isEmpty(c2.extensionCoreVersionName)) ? "0" : c2.extensionCoreVersionName;
        }
        return (String) invokeI.objValue;
    }

    public static c.a.s0.a.p0.d.b f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            if (i2 == 1) {
                c.a.s0.a.p0.d.b u = c.a.s0.a.c1.b.i().u();
                if (u == null) {
                    boolean z = k.a;
                }
                return u;
            }
            return a.k();
        }
        return (c.a.s0.a.p0.d.b) invokeI.objValue;
    }

    public static void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i2, i3) == null) {
            if (a) {
                String str = "onAppUpgrade oldVersion: " + i2 + " ,newVersion: " + i3;
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i2 != i3) {
                a();
                c.a.s0.a.p0.j.a.i(0, true);
                c.a.s0.a.p0.j.a.i(1, true);
            }
        }
    }

    public static void h(int i2, @Nullable c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, cVar) == null) {
            c.a.s0.a.p0.d.b f2 = f(i2);
            if (f2 != null) {
                f2.g(cVar);
            } else if (cVar != null) {
                cVar.onCallback(null);
            }
        }
    }
}
