package b.a.a.a.x;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1486a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1707942991, "Lb/a/a/a/x/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1707942991, "Lb/a/a/a/x/d;");
                return;
            }
        }
        f1486a = Pattern.compile("(\\$\\d+)+$");
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            d(null, 3, null, new Object[0]);
        }
    }

    public static void b(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) {
            d(null, 3, str, objArr);
        }
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, th) == null) {
            d(th, 6, "", new Object[0]);
        }
    }

    public static void d(Throwable th, int i2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, th, i2, str, objArr) == null) && FunAdSdk.isLogEnabled()) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                StackTraceElement stackTraceElement = stackTrace[2];
                if (str == null) {
                    str = stackTraceElement.getMethodName();
                } else if (objArr != null && objArr.length != 0) {
                    str = String.format(str, objArr);
                }
                String className = stackTrace[2].getClassName();
                Matcher matcher = f1486a.matcher(className);
                String str2 = "";
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = className.substring(className.lastIndexOf(46) + 1);
                objArr2[1] = str;
                if (th != null) {
                    str2 = StringUtils.LF + Log.getStackTraceString(th);
                }
                objArr2[2] = str2;
                Log.println(i2, "FunAdSdk", String.format("[%s] %s%s", objArr2));
            } catch (Exception e2) {
                c(e2);
            }
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            d(null, 6, null, new Object[0]);
        }
    }

    public static void f(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) {
            d(null, 6, str, objArr);
        }
    }

    public static void g(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, objArr) == null) {
            d(null, 2, str, objArr);
        }
    }
}
