package c.a.n0.e.a.h;

import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394946014, "Lc/a/n0/e/a/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1394946014, "Lc/a/n0/e/a/h/c;");
                return;
            }
        }
        try {
            a = c.a.n0.k.a.a.c.a.i(c.a.n0.k.a.a.c.a.b("android.os.SystemProperties", true), SharedPreferenceManager.OPERATION_GET_PERFIX, String.class);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Method method = a;
            if (method != null) {
                try {
                    return (String) method.invoke(null, str);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
