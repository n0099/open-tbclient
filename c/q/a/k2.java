package c.q.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class k2 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1646425680, "Lc/q/a/k2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1646425680, "Lc/q/a/k2;");
                return;
            }
        }
        a = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(30));
    }

    public static String a(Context context, String str, String str2, List list, d2 d2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, list, d2Var)) == null) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                File file = new File(str2, String.valueOf(str3.hashCode()));
                if (file.exists()) {
                    if (file.length() == x1.b(context).a(str3)) {
                        str = str.replace(str3, "file://" + file.getAbsolutePath());
                        atomicInteger.addAndGet(1);
                    }
                }
            }
            if (d2Var != null) {
                if (atomicInteger.get() <= 0) {
                    d2Var.a(0);
                } else if (atomicInteger.get() == list.size()) {
                    d2Var.a(2);
                } else {
                    d2Var.a(1);
                }
            }
            return str;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static void b(Context context, String str, List list, a2 a2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, list, a2Var) == null) {
            try {
                a.execute(new u1(context, str, list, a2Var));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
