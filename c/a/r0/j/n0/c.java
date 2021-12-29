package c.a.r0.j.n0;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str, @NonNull JSTypeMismatchException jSTypeMismatchException) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, jSTypeMismatchException)) == null) ? String.format("%s:fail parameter error: parameter.%s should be %s instead of %s", str, jSTypeMismatchException.name, c(jSTypeMismatchException.requiredType), c(jSTypeMismatchException.actualType)) : (String) invokeLL.objValue;
    }

    public static String b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? String.format("%s: %s", str, str2) : (String) invokeLL.objValue;
    }

    public static String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return "boolean";
                case 2:
                case 3:
                case 5:
                    return "number";
                case 4:
                case 9:
                case 10:
                default:
                    return "object";
                case 6:
                    return "array object";
                case 7:
                    return "string";
                case 8:
                    return "function object";
                case 11:
                    return StringUtil.NULL_STRING;
                case 12:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeI.objValue;
    }

    public static void call(c.a.r0.a.y.b.a aVar, boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{aVar, Boolean.valueOf(z), obj}) == null) {
            c.a.r0.j.d.c.a e2 = c.a.r0.j.d.c.a.e(aVar);
            if (z) {
                e2.d(obj);
            } else {
                e2.b(obj);
            }
        }
    }

    public static void d(c.a.r0.a.l0.c cVar, JSTypeMismatchException jSTypeMismatchException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, jSTypeMismatchException) == null) {
            cVar.throwJSException(JSExceptionType.TypeError, String.format("The \"%s\" argument must be %s. Received type %s", jSTypeMismatchException.name, c(jSTypeMismatchException.requiredType), c(jSTypeMismatchException.actualType)));
        }
    }
}
