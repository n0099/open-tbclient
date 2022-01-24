package c.a.r0.a.z2.c1;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f10091b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f10092c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f10093d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1823525021, "Lc/a/r0/a/z2/c1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1823525021, "Lc/a/r0/a/z2/c1/a;");
                return;
            }
        }
        a = a("b3Bwbw==");
        f10091b = a("T1BQTw==");
        a("T3Bwbw==");
        f10092c = a("cm8uYnVpbGQudmVyc2lvbi5vcHBvcm9t");
        f10093d = a("Y29tLm9wcG8uZmVhdHVyZS5zY3JlZW4uaGV0ZXJvbW9ycGhpc20=");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new String(Base64.decode(str, 0)) : (String) invokeL.objValue;
    }
}
