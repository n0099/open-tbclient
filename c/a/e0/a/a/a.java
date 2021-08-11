package c.a.e0.a.a;

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
    public static final boolean f3039a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3040b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1342868180, "Lc/a/e0/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1342868180, "Lc/a/e0/a/a/a;");
                return;
            }
        }
        f3039a = c.a.e0.a.b.a.f3041a.get().s();
        f3040b = "https://afd.baidu.com/afd/entry";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f3039a || TextUtils.isEmpty(c.a.e0.a.b.a.f3041a.get().c())) {
                return TextUtils.isEmpty(f3040b) ? "https://afd.baidu.com/afd/entry" : f3040b;
            }
            return c.a.e0.a.b.a.f3041a.get().c();
        }
        return (String) invokeV.objValue;
    }
}
