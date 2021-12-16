package c.p.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1761043639, "Lc/p/a/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1761043639, "Lc/p/a/q0;");
                return;
            }
        }
        Executors.newFixedThreadPool(1);
        a = new HashMap();
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (q0.class) {
                a.remove(str);
            }
        }
    }

    public static synchronized void b(String str, o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, o0Var) == null) {
            synchronized (q0.class) {
                HashSet hashSet = (HashSet) a.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    a.put(str, hashSet);
                }
                hashSet.add(o0Var);
            }
        }
    }

    public static void c(String str, String str2, Object obj) {
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, obj) == null) || (hashSet = (HashSet) a.get(str)) == null || hashSet.size() <= 0) {
            return;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((o0) it.next()).a(str, str2, obj);
        }
    }
}
