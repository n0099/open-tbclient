package b.a.p0.a.h0.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5555a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5556b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597462448, "Lb/a/p0/a/h0/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597462448, "Lb/a/p0/a/h0/i/b;");
                return;
            }
        }
        f5555a = "检测到白屏区域超过" + a(0.7d) + "；";
        f5556b = "检测到白屏区域超过" + a(0.5d) + "且正在loading；";
    }

    public static String a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) {
            return ((int) (d2 * 100.0d)) + "%";
        }
        return (String) invokeCommon.objValue;
    }
}
