package c.a.c0.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d.g.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062906817, "Lc/a/c0/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062906817, "Lc/a/c0/d/c;");
                return;
            }
        }
        a = new b();
    }

    public static boolean a(@NonNull Context context, @NonNull c.a.c0.d.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, aVar, map, dVar)) == null) ? a.a(context, aVar, map, dVar) : invokeLLLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? c(str, null) : invokeL.booleanValue;
    }

    public static boolean c(String str, @Nullable Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, context)) == null) ? d(str, context, null) : invokeLL.booleanValue;
    }

    public static boolean d(String str, @Nullable Context context, @Nullable Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, context, map)) == null) ? e(str, context, map, null) : invokeLLL.booleanValue;
    }

    public static boolean e(String str, @Nullable Context context, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, str, context, map, dVar)) == null) {
            if (c.a.c0.d.h.d.g(str)) {
                if (context == null) {
                    context = c.a.c0.e.a.b();
                }
                return a(context, new c.a.c0.d.f.a(str), map, dVar);
            }
            if (dVar != null) {
                dVar.a(false, null);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
