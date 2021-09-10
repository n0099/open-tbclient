package c.a.f0.a.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3335a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3336b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464586283, "Lc/a/f0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-464586283, "Lc/a/f0/a/a/a;");
                return;
            }
        }
        f3335a = c.a.f0.a.b.a.f3337a.get().t();
        f3336b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f3335a || TextUtils.isEmpty(c.a.f0.a.b.a.f3337a.get().c())) {
                return TextUtils.isEmpty(f3336b) ? "https://afd.baidu.com/afd/entry" : f3336b;
            }
            return c.a.f0.a.b.a.f3337a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
