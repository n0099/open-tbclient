package b.i.b.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
/* loaded from: classes6.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet<String> f32739a;

    /* renamed from: b  reason: collision with root package name */
    public static String f32740b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-332325910, "Lb/i/b/a/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-332325910, "Lb/i/b/a/k;");
                return;
            }
        }
        f32739a = new HashSet<>();
        f32740b = "goog.exo.core";
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (k.class) {
                if (f32739a.add(str)) {
                    f32740b += StringUtil.ARRAY_ELEMENT_SEPARATOR + str;
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
                str = f32740b;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
