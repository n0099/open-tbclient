package b.q.a;

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
/* loaded from: classes6.dex */
public class p2 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f33433a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(161033588, "Lb/q/a/p2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(161033588, "Lb/q/a/p2;");
                return;
            }
        }
        f33433a = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(30));
    }

    public static String a(Context context, String str, String str2, List list, i2 i2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, list, i2Var)) == null) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                File file = new File(str2, String.valueOf(str3.hashCode()));
                if (file.exists()) {
                    if (file.length() == c2.b(context).a(str3)) {
                        str = str.replace(str3, "file://" + file.getAbsolutePath());
                        atomicInteger.addAndGet(1);
                    }
                }
            }
            if (i2Var != null) {
                if (atomicInteger.get() <= 0) {
                    i2Var.a(0);
                } else if (atomicInteger.get() == list.size()) {
                    i2Var.a(2);
                } else {
                    i2Var.a(1);
                }
            }
            return str;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static void b(Context context, String str, List list, f2 f2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, list, f2Var) == null) {
            try {
                f33433a.execute(new z1(context, str, list, f2Var));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
