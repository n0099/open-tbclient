package c.a.p0.a.x.t.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.q0.d;
import c.a.p0.a.t1.e;
import c.a.p0.a.v0.e.b;
import c.a.p0.a.w0.f;
import c.a.p0.a.x.u.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f8871b;

    /* renamed from: c  reason: collision with root package name */
    public static int f8872c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1808833428, "Lc/a/p0/a/x/t/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1808833428, "Lc/a/p0/a/x/t/f/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        c.a.p0.a.s0.a.g0().getSwitch("swan_naview_slave_preload_type", 0);
        f8872c = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g.U().r0() && c.a.p0.a.s0.a.F0().j(1)) {
                String c0 = g.U().c0();
                if (!TextUtils.isEmpty(c0) && new File(c0, "slave-talos/index.js").isFile()) {
                    if (a && c.a.p0.a.n1.a.a.Y()) {
                        return true;
                    }
                    boolean z = f8872c != 0;
                    if (a) {
                        String str = "isNARenderEnabled canUseNA: " + z;
                    }
                    return z;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int b(@Nullable c.a.p0.a.t1.n.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) {
            if (gVar == null || !d()) {
                return 0;
            }
            return "na".equals(gVar.r) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            int b2 = b(f.U().f(str));
            if (a) {
                String str2 = "getSlaveType pageUrl: " + str + " slaveType:" + b2;
            }
            return b2;
        }
        return invokeL.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Boolean bool = f8871b;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(a());
            f8871b = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f8872c == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f8872c == 1 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f8872c == 3 : invokeV.booleanValue;
    }

    public static boolean h(e eVar) {
        InterceptResult invokeL;
        b.a V;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, eVar)) == null) {
            if (eVar == null || !eVar.D()) {
                return false;
            }
            if (c.a.p0.a.n1.a.a.B(eVar.V())) {
                str = d.b.g().getPath() + File.separator;
            } else {
                str = d.e.i(V.H(), V.v1()).getPath() + File.separator;
            }
            if (a) {
                String str2 = "手动解析的basePath: " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            f.U().K(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
