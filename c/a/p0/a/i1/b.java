package c.a.p0.a.i1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<a> f6580a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819960329, "Lc/a/p0/a/i1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(819960329, "Lc/a/p0/a/i1/b;");
                return;
            }
        }
        f6580a = new ArrayList<>();
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, aVar) == null) || aVar == null || f6580a.contains(aVar)) {
            return;
        }
        f6580a.add(aVar);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f6580a.clear();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null) {
                    aVar.onDestroy();
                }
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = f6580a.size() - 1; size >= 0; size--) {
            a aVar = f6580a.get(size);
            if (aVar != null && TextUtils.equals(str, aVar.b())) {
                aVar.onDestroy();
            }
        }
    }

    public static a e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.c())) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static a f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, aVar.b())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, aVar.f())) || TextUtils.equals(str3, aVar.c())))) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeLLL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null && TextUtils.equals(str, aVar.b()) && aVar.onBackPressed()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null) {
                    aVar.j(z);
                }
            }
        }
    }

    public static void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            for (int size = f6580a.size() - 1; size >= 0; size--) {
                a aVar = f6580a.get(size);
                if (aVar != null) {
                    aVar.k(z);
                }
            }
        }
    }

    public static void j(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, aVar) == null) || aVar == null) {
            return;
        }
        f6580a.remove(aVar);
    }
}
