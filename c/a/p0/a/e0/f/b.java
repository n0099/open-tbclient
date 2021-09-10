package c.a.p0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e0.f.f.d;
import c.a.p0.a.k;
import c.a.p0.a.v2.v;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5185a;

    /* renamed from: b  reason: collision with root package name */
    public static String f5186b;

    /* renamed from: c  reason: collision with root package name */
    public static String f5187c;

    /* renamed from: d  reason: collision with root package name */
    public static a f5188d;

    /* renamed from: e  reason: collision with root package name */
    public static int f5189e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1575672145, "Lc/a/p0/a/e0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1575672145, "Lc/a/p0/a/e0/f/b;");
                return;
            }
        }
        f5185a = k.f7077a;
        f5186b = "";
        f5187c = "";
        f5189e = 0;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f5186b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f5188d != null) {
                return f5188d.c() + File.separator + f5186b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f5187c : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f5188d != null) {
                return f5188d.c() + File.separator + f5187c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f5189e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f5189e == 1 : invokeV.booleanValue;
    }

    public static void g(Bundle bundle) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bundle) == null) || (aVar = f5188d) == null) {
            return;
        }
        aVar.b(bundle);
    }

    public static void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bundle) == null) {
            String i2 = v.i(bundle, "extraWSUrl");
            String i3 = v.i(bundle, "adb_debug_path");
            if (!TextUtils.isEmpty(i2)) {
                f5188d = new d();
                f5189e = 1;
            } else if (!TextUtils.isEmpty(i3)) {
                f5188d = new c.a.p0.a.e0.f.c.b();
                f5189e = 2;
            } else {
                boolean z = f5185a;
                f5189e = 0;
                f5188d = null;
                return;
            }
            f5188d.a(bundle);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f5186b = str;
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f5187c = str;
        }
    }
}
