package b.a.f0.a.a;

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
    public static final boolean f2872a;

    /* renamed from: b  reason: collision with root package name */
    public static String f2873b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-171183276, "Lb/a/f0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-171183276, "Lb/a/f0/a/a/a;");
                return;
            }
        }
        f2872a = b.a.f0.a.b.a.f2874a.get().s();
        f2873b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f2872a || TextUtils.isEmpty(b.a.f0.a.b.a.f2874a.get().c())) {
                return TextUtils.isEmpty(f2873b) ? "https://afd.baidu.com/afd/entry" : f2873b;
            }
            return b.a.f0.a.b.a.f2874a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
