package c.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.embed_dr.DrLogWriter;
/* loaded from: classes4.dex */
public final class o0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f31171a;

    /* renamed from: b  reason: collision with root package name */
    public static DrLogWriter f31172b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074075225, "Lc/b/a/o0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2074075225, "Lc/b/a/o0;");
                return;
            }
        }
        a(2);
        b(new DrLogWriter.a());
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            f31171a = i2;
        }
    }

    public static void b(DrLogWriter drLogWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, drLogWriter) == null) {
            f31172b = drLogWriter;
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            d(str, str2, null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) || (drLogWriter = f31172b) == null || f31171a > 2) {
            return;
        }
        drLogWriter.logV(str, str2, th);
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            f(str, str2, null);
        }
    }

    public static void f(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, th) == null) || (drLogWriter = f31172b) == null || f31171a > 3) {
            return;
        }
        drLogWriter.logD(str, str2, th);
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            h(str, str2, null);
        }
    }

    public static void h(String str, String str2, Throwable th) {
        DrLogWriter drLogWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, str, str2, th) == null) || (drLogWriter = f31172b) == null || f31171a > 6) {
            return;
        }
        drLogWriter.logE(str, str2, th);
    }
}
