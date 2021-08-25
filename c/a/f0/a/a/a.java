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
    public static final boolean f3344a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3345b;
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
        f3344a = c.a.f0.a.b.a.f3346a.get().t();
        f3345b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f3344a || TextUtils.isEmpty(c.a.f0.a.b.a.f3346a.get().c())) {
                return TextUtils.isEmpty(f3345b) ? "https://afd.baidu.com/afd/entry" : f3345b;
            }
            return c.a.f0.a.b.a.f3346a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
