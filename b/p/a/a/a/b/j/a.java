package b.p.a.a.a.b.j;

import android.content.Context;
import android.text.TextUtils;
import b.p.a.a.c.b.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f34487a;

    /* renamed from: b  reason: collision with root package name */
    public static Class f34488b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(736986094, "Lb/p/a/a/a/b/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(736986094, "Lb/p/a/a/a/b/j/a;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f34488b = cls;
            f34487a = cls.newInstance();
        } catch (Throwable th) {
            c.c(th);
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? b(context, "getOAID") : (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (f34487a == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                Object invoke = f34488b.getMethod(str, Context.class).invoke(f34487a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Throwable th) {
                c.c(th);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (f34488b == null || f34487a == null) ? false : true : invokeV.booleanValue;
    }
}
