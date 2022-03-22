package c.a.n0.a.u.f;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.v;
import c.a.n0.a.u.f.f.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6387b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6388c;

    /* renamed from: d  reason: collision with root package name */
    public static a f6389d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6390e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-708804623, "Lc/a/n0/a/u/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-708804623, "Lc/a/n0/a/u/f/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f6387b = "";
        f6388c = "";
        f6390e = 0;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f6387b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f6389d != null) {
                return f6389d.c() + File.separator + f6387b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f6388c : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6389d != null) {
                return f6389d.c() + File.separator + f6388c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f6390e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? f6390e == 1 : invokeV.booleanValue;
    }

    public static void g(Bundle bundle) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bundle) == null) || (aVar = f6389d) == null) {
            return;
        }
        aVar.b(bundle);
    }

    public static void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bundle) == null) {
            String i = v.i(bundle, "extraWSUrl");
            String i2 = v.i(bundle, "adb_debug_path");
            if (!TextUtils.isEmpty(i)) {
                f6389d = new d();
                f6390e = 1;
            } else if (!TextUtils.isEmpty(i2)) {
                f6389d = new c.a.n0.a.u.f.c.b();
                f6390e = 2;
            } else {
                if (a) {
                    Log.d("UserDebugParams", "not debug mode");
                }
                f6390e = 0;
                f6389d = null;
                return;
            }
            f6389d.a(bundle);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f6387b = str;
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f6388c = str;
        }
    }
}
