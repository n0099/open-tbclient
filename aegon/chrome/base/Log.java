package aegon.chrome.base;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Locale;
/* loaded from: classes.dex */
public class Log {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void e(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, str2, objArr) == null) {
            String formatLog = formatLog(str2, objArr);
            Throwable throwableToLog = getThrowableToLog(objArr);
            String normalizeTag = normalizeTag(str);
            if (throwableToLog != null) {
                android.util.Log.e(normalizeTag, formatLog, throwableToLog);
            } else {
                android.util.Log.e(normalizeTag, formatLog);
            }
        }
    }

    public static String formatLog(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, objArr)) == null) ? (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static Throwable getThrowableToLog(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, objArr)) == null) {
            if (objArr == null || objArr.length == 0) {
                return null;
            }
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
            return null;
        }
        return (Throwable) invokeL.objValue;
    }

    public static void i(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, objArr) == null) {
            String formatLog = formatLog(str2, objArr);
            Throwable throwableToLog = getThrowableToLog(objArr);
            String normalizeTag = normalizeTag(str);
            if (throwableToLog != null) {
                android.util.Log.i(normalizeTag, formatLog, throwableToLog);
            } else {
                android.util.Log.i(normalizeTag, formatLog);
            }
        }
    }

    public static String normalizeTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (str.startsWith("cr_")) {
                return str;
            }
            int i2 = str.startsWith("cr.") ? 3 : 0;
            return "cr_" + str.substring(i2, str.length());
        }
        return (String) invokeL.objValue;
    }
}
