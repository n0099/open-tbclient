package c.a.t0.s0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, String> a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f21919b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, String> f21920c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(986465535, "Lc/a/t0/s0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(986465535, "Lc/a/t0/s0/a;");
                return;
            }
        }
        a = new HashMap();
        f21919b = new HashMap();
        f21920c = new HashMap();
        a.put("CAM_X0906", "CAM_X0906");
        f21919b.put("CAM_X0906", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        f21920c.put("CAM_X0906", "testMethod");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f21919b.containsKey(str)) {
                try {
                    Method declaredMethod = Class.forName(f21919b.get(str)).getDeclaredMethod(f21920c.get(str), new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    return ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) ? a.get(str) : str;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
