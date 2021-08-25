package c.a.o0.a.h0.k;

import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6024a;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicInteger f6025b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957905103, "Lc/a/o0/a/h0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957905103, "Lc/a/o0/a/h0/k/a;");
                return;
            }
        }
        f6024a = k.f7049a;
        f6025b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str != null && str.startsWith("localDebug") : invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int andIncrement = f6025b.getAndIncrement();
            String str = "localDebug";
            if (andIncrement >= 1) {
                str = "localDebug" + andIncrement;
            }
            if (f6024a) {
                String str2 = "next daemon id - " + str;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
