package c.a.r0.j3.o0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(802219148, "Lc/a/r0/j3/o0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(802219148, "Lc/a/r0/j3/o0/b;");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
                return null;
            }
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                    int indexOf = str2.indexOf("=") + 1;
                    return indexOf < str2.length() ? str2.substring(indexOf, str2.length()) : "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
