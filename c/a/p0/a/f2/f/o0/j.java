package c.a.p0.a.f2.f.o0;

import android.text.TextUtils;
import c.a.p0.a.z2.o0;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, map) == null) || TextUtils.isEmpty(str) || map == null) {
            return;
        }
        String f2 = o0.f(str);
        String o = o0.o(str);
        String b2 = b(f2);
        if (TextUtils.equals(f2, b2)) {
            return;
        }
        if (!TextUtils.isEmpty(o)) {
            b2 = b2 + "?" + o;
        }
        map.put("pageRoutePath", b2);
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str, c.a.p0.a.d2.d.J().r().P()) : (String) invokeL.objValue;
    }

    public static String c(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                return str;
            }
            String f2 = c.a.p0.a.w1.c.a.f(str);
            return !TextUtils.isEmpty(f2) ? f2 : swanAppConfigData.j(str);
        }
        return (String) invokeLL.objValue;
    }
}
