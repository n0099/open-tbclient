package c.a.b0.d0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static String f1441b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1442c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333201928, "Lc/a/b0/d0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-333201928, "Lc/a/b0/d0/k;");
                return;
            }
        }
        f1441b = c.a.b0.e.a.b().getApplicationInfo().processName;
        String a2 = b.a();
        a = a2;
        f1442c = a(a2);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.equals(str, f1441b)) {
                return true;
            }
            return str.startsWith(f1441b) && !str.contains(":");
        }
        return invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f1442c : invokeV.booleanValue;
    }
}
