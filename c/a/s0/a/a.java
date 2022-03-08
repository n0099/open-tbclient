package c.a.s0.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(252160756, "Lc/a/s0/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(252160756, "Lc/a/s0/a/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            b(str, str2, new Object[0]);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, objArr) == null) {
            e(str2, objArr);
            if (g(objArr) != null) {
                if (a) {
                    i(str);
                }
            } else if (a) {
                i(str);
            }
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, objArr) == null) {
            d(str2, objArr);
            if (g(objArr) != null) {
                if (a) {
                    i(str);
                }
            } else if (a) {
                i(str);
            }
        }
    }

    public static String d(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, objArr)) == null) ? (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static String e(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, objArr)) == null) {
            return PreferencesUtil.LEFT_MOUNT + f() + "] " + d(str, objArr);
        }
        return (String) invokeLL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = a.class.getName();
            int i2 = 0;
            while (true) {
                if (i2 >= stackTrace.length) {
                    break;
                } else if (stackTrace[i2].getClassName().equals(name)) {
                    i2 += 4;
                    break;
                } else {
                    i2++;
                }
            }
            return stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber();
        }
        return (String) invokeV.objValue;
    }

    public static Throwable g(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return null;
            }
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
            return null;
        }
        return (Throwable) invokeL.objValue;
    }

    public static void h(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, objArr) == null) {
            d(str2, objArr);
            if (g(objArr) != null) {
                if (a) {
                    i(str);
                }
            } else if (a) {
                i(str);
            }
        }
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str.startsWith("cr_")) {
                return str;
            }
            int i2 = str.startsWith("cr.") ? 3 : 0;
            return "cr_" + str.substring(i2, str.length());
        }
        return (String) invokeL.objValue;
    }
}
