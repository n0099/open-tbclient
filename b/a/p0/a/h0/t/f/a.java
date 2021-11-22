package b.a.p0.a.h0.t.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.d;
import b.a.p0.a.d2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6123a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f6124b;

    /* renamed from: c  reason: collision with root package name */
    public static int f6125c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2121848081, "Lb/a/p0/a/h0/t/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2121848081, "Lb/a/p0/a/h0/t/f/a;");
                return;
            }
        }
        f6123a = k.f6863a;
        b.a.p0.a.c1.a.g0().getSwitch("swan_naview_slave_preload_type", 0);
        f6125c = 0;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g.U().r0() && b.a.p0.a.c1.a.F0().j(1)) {
                String c0 = g.U().c0();
                if (!TextUtils.isEmpty(c0) && new File(c0, "slave-talos/index.js").isFile()) {
                    if (f6123a && b.a.p0.a.x1.a.a.Y()) {
                        return true;
                    }
                    boolean z = f6125c != 0;
                    if (f6123a) {
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

    public static int b(@Nullable b.a.p0.a.d2.n.g gVar) {
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
            int b2 = b(f.U().e(str));
            if (f6123a) {
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
            Boolean bool = f6124b;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(a());
            f6124b = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f6125c == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f6125c == 1 : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f6125c == 3 : invokeV.booleanValue;
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
            if (b.a.p0.a.x1.a.a.B(eVar.V())) {
                str = d.b.g().getPath() + File.separator;
            } else {
                str = d.e.i(V.H(), V.v1()).getPath() + File.separator;
            }
            if (f6123a) {
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
