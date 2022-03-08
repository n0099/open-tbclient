package c.a.r0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder(th.toString());
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (int i2 = 0; i2 < stackTrace.length; i2++) {
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (stackTraceElement != null && i2 < 7) {
                        sb.append(" ----> ");
                        sb.append(stackTraceElement.getClassName());
                        sb.append(".");
                        sb.append(stackTraceElement.getMethodName());
                        sb.append("()");
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
