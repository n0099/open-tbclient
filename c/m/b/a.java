package c.m.b;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.m.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1513a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Object f34355a;

        /* renamed from: b  reason: collision with root package name */
        public static Class<?> f34356b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f34357c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2147423748, "Lc/m/b/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2147423748, "Lc/m/b/a$a;");
                    return;
                }
            }
            try {
                Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
                f34356b = cls;
                f34355a = cls.newInstance();
                f34356b.getMethod("getUDID", Context.class);
                f34357c = f34356b.getMethod("getOAID", Context.class);
                f34356b.getMethod("getVAID", Context.class);
                f34356b.getMethod("getAAID", Context.class);
            } catch (Throwable unused) {
            }
        }

        public static String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? b(context, f34357c) : (String) invokeL.objValue;
        }

        public static String b(Context context, Method method) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, method)) == null) {
                Object obj = f34355a;
                if (obj == null || method == null) {
                    return null;
                }
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        return (String) invoke;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeLL.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f34356b == null || f34355a == null) ? false : true : invokeV.booleanValue;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? C1513a.a(context.getApplicationContext()) : (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C1513a.c() : invokeV.booleanValue;
    }
}
