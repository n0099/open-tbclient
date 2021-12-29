package c.i.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static final HashSet<String> a;

    /* renamed from: b  reason: collision with root package name */
    public static String f30775b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528839415, "Lc/i/b/a/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-528839415, "Lc/i/b/a/k;");
                return;
            }
        }
        a = new HashSet<>();
        f30775b = "goog.exo.core";
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (k.class) {
                if (a.add(str)) {
                    f30775b += StringUtil.ARRAY_ELEMENT_SEPARATOR + str;
                }
            }
        }
    }

    public static synchronized String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (k.class) {
                str = f30775b;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
