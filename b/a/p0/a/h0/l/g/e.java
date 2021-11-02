package b.a.p0.a.h0.l.g;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5452a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f5453b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944115922, "Lb/a/p0/a/h0/l/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1944115922, "Lb/a/p0/a/h0/l/g/e;");
                return;
            }
        }
        f5452a = b.a.p0.a.k.f6397a;
        f5453b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str != null && str.startsWith("master") : invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = "master";
            if (b.a.p0.a.h0.o.e.a.f()) {
                int andIncrement = f5453b.getAndIncrement();
                if (andIncrement >= 1) {
                    str = "master" + andIncrement;
                }
                if (f5452a) {
                    String str2 = "next master id - " + str;
                }
                return str;
            }
            return "master";
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int andSet = f5453b.getAndSet(0);
            if (f5452a) {
                String str = "last master id - " + andSet;
            }
            return andSet;
        }
        return invokeV.intValue;
    }
}
