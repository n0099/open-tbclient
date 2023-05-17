package com.baidu.sofire.k;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;
    public static ConcurrentHashMap<Long, Throwable> b;
    public static ConcurrentHashMap<Long, Throwable> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259171, "Lcom/baidu/sofire/k/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259171, "Lcom/baidu/sofire/k/k;");
                return;
            }
        }
        b = new ConcurrentHashMap<>(32);
        c = new ConcurrentHashMap<>(32);
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                if (!a) {
                    return;
                }
                Throwable th = new Throwable();
                if (c.size() >= 20) {
                    long j = Long.MAX_VALUE;
                    for (Long l : c.keySet()) {
                        long longValue = l.longValue();
                        if (longValue < j) {
                            j = longValue;
                        }
                    }
                    c.remove(Long.valueOf(j));
                }
                c.put(Long.valueOf(System.currentTimeMillis()), th);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                if (!a) {
                    return;
                }
                Throwable th = new Throwable();
                if (b.size() >= 10) {
                    long j = Long.MAX_VALUE;
                    for (Long l : b.keySet()) {
                        long longValue = l.longValue();
                        if (longValue < j) {
                            j = longValue;
                        }
                    }
                    b.remove(Long.valueOf(j));
                }
                b.put(Long.valueOf(System.currentTimeMillis()), th);
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
        }
    }
}
