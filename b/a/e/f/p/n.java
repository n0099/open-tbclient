package b.a.e.f.p;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f2058a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1111238790, "Lb/a/e/f/p/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1111238790, "Lb/a/e/f/p/n;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        f2058a = hashMap;
        hashMap.put("java.lang.String", "java.lang.String");
        f2058a.put("java.lang.Integer", "java.lang.Integer");
        f2058a.put("java.lang.Double", "java.lang.Double");
        f2058a.put("java.lang.Float", "java.lang.Float");
        f2058a.put("java.lang.Boolean", "java.lang.Boolean");
        f2058a.put("java.lang.Character", "java.lang.Character");
        f2058a.put("java.lang.Short", "java.lang.Short");
        f2058a.put("java.lang.Long", "java.lang.Long");
        f2058a.put("java.lang.Byte", "java.lang.Byte");
        f2058a.put("java.util.Date", "java.util.Date");
        f2058a.put("java.lang.Integer", "java.lang.Integer");
        f2058a.put("java.lang.Integer", "java.lang.Integer");
    }

    public static Object a(Object obj, Field field) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, field)) == null) {
            Object obj2 = null;
            if (obj != null && field != null) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    obj2 = field.get(obj);
                } catch (Throwable unused) {
                }
                field.setAccessible(isAccessible);
            }
            return obj2;
        }
        return invokeLL.objValue;
    }
}
