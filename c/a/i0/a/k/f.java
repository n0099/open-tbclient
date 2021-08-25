package c.a.i0.a.k;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3620a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3621b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f3622c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f3623d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1591684311, "Lc/a/i0/a/k/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1591684311, "Lc/a/i0/a/k/f;");
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                return Build.VERSION.SDK_INT >= 23 ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ("permission_location".equalsIgnoreCase(str)) {
                return f3621b;
            }
            if ("permission_storage".equalsIgnoreCase(str)) {
                return f3622c;
            }
            if ("permission_app_list".equalsIgnoreCase(str)) {
                return f3623d;
            }
            if ("permission_read_phone_state".equalsIgnoreCase(str)) {
                return f3620a;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
