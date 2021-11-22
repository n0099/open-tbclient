package b.a.p0.a.e0.f;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.f.f.d;
import b.a.p0.a.k;
import b.a.p0.a.z2.v;
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
    public static final boolean f4533a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4534b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4535c;

    /* renamed from: d  reason: collision with root package name */
    public static a f4536d;

    /* renamed from: e  reason: collision with root package name */
    public static int f4537e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1065137968, "Lb/a/p0/a/e0/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1065137968, "Lb/a/p0/a/e0/f/b;");
                return;
            }
        }
        f4533a = k.f6863a;
        f4534b = "";
        f4535c = "";
        f4537e = 0;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f4534b : (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f4536d != null) {
                return f4536d.c() + File.separator + f4534b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f4535c : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4536d != null) {
                return f4536d.c() + File.separator + f4535c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f4537e == 2 : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f4537e == 1 : invokeV.booleanValue;
    }

    public static void g(Bundle bundle) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, bundle) == null) || (aVar = f4536d) == null) {
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
                f4536d = new d();
                f4537e = 1;
            } else if (!TextUtils.isEmpty(i3)) {
                f4536d = new b.a.p0.a.e0.f.c.b();
                f4537e = 2;
            } else {
                boolean z = f4533a;
                f4537e = 0;
                f4536d = null;
                return;
            }
            f4536d.a(bundle);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            f4534b = str;
        }
    }

    public static void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            f4535c = str;
        }
    }
}
