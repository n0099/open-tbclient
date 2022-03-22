package c.a.k.a.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, a> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1331073033, "Lc/a/k/a/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1331073033, "Lc/a/k/a/i/b;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (b.class) {
                b2 = b(str, 0);
            }
            return b2;
        }
        return (a) invokeL.objValue;
    }

    public static synchronized a b(String str, int i) {
        InterceptResult invokeLI;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (b.class) {
                if (!a.containsKey(str) || (aVar = a.get(str)) == null) {
                    a aVar2 = new a(str, i);
                    try {
                        aVar2.start();
                    } catch (Exception unused) {
                    }
                    a.put(str, aVar2);
                    return aVar2;
                }
                return aVar;
            }
        }
        return (a) invokeLI.objValue;
    }

    public static synchronized void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            synchronized (b.class) {
                if (aVar != null) {
                    aVar.a();
                    a.values().remove(aVar);
                }
            }
        }
    }
}
