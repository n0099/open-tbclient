package c.a.n0.a.f0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.g1.c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1210186985, "Lc/a/n0/a/f0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1210186985, "Lc/a/n0/a/f0/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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

    public static <T extends c.a.n0.a.f0.g.a> Exception b(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, t)) == null) {
            c.a.n0.a.f0.d.b f2 = f(i);
            if (f2 == null) {
                return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
            }
            return f2.a(t);
        }
        return (Exception) invokeIL.objValue;
    }

    public static ExtensionCore c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            c.a.n0.a.f0.d.b f2 = f(i);
            if (f2 == null) {
                return null;
            }
            return f2.c();
        }
        return (ExtensionCore) invokeI.objValue;
    }

    public static long d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            ExtensionCore c2 = c(i);
            if (c2 != null) {
                return c2.extensionCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            ExtensionCore c2 = c(i);
            return (c2 == null || TextUtils.isEmpty(c2.extensionCoreVersionName)) ? "0" : c2.extensionCoreVersionName;
        }
        return (String) invokeI.objValue;
    }

    public static c.a.n0.a.f0.d.b f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i == 1) {
                c.a.n0.a.f0.d.b u = c.a.n0.a.s0.b.i().u();
                if (u == null && c.a.n0.a.a.a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口getSwanGameExtensionCoreManager未实现，直接返回");
                }
                return u;
            }
            return a.k();
        }
        return (c.a.n0.a.f0.d.b) invokeI.objValue;
    }

    public static void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            if (a) {
                Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
                a();
                c.a.n0.a.f0.j.a.i(0, true);
                c.a.n0.a.f0.j.a.i(1, true);
            }
        }
    }

    public static void h(int i, @Nullable c<Exception> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, cVar) == null) {
            c.a.n0.a.f0.d.b f2 = f(i);
            if (f2 != null) {
                f2.g(cVar);
            } else if (cVar != null) {
                cVar.onCallback(null);
            }
        }
    }
}
