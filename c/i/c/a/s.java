package c.i.c.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500210016, "Lc/i/c/a/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-500210016, "Lc/i/c/a/s;");
                return;
            }
        }
        Object b2 = b();
        a = b2;
        if (b2 != null) {
            a();
        }
        if (a == null) {
            return;
        }
        d();
    }

    public static Method a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c("getStackTraceElement", Throwable.class, Integer.TYPE) : (Method) invokeV.objValue;
    }

    public static Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    public static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, clsArr)) == null) {
            try {
                return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Method) invokeLL.objValue;
    }

    public static Method d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                Method c2 = c("getStackTraceDepth", Throwable.class);
                if (c2 == null) {
                    return null;
                }
                c2.invoke(b(), new Throwable());
                return c2;
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
                return null;
            }
        }
        return (Method) invokeV.objValue;
    }

    @Deprecated
    public static RuntimeException e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, th)) == null) {
            f(th);
            throw new RuntimeException(th);
        }
        return (RuntimeException) invokeL.objValue;
    }

    public static void f(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, th) == null) {
            n.p(th);
            if (!(th instanceof RuntimeException)) {
                if (th instanceof Error) {
                    throw ((Error) th);
                }
                return;
            }
            throw ((RuntimeException) th);
        }
    }
}
