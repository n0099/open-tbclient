package c.a.p0.a.m1.d;

import c.a.p0.a.k;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1257959576, "Lc/a/p0/a/m1/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1257959576, "Lc/a/p0/a/m1/d/b;");
                return;
            }
        }
        a = k.a;
    }

    public static String a(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                boolean z = a;
                return "";
            }
            String str = pMSAppInfo.serverExt;
            if (a) {
                String str2 = "appId - " + pMSAppInfo.appId + ",get app info' ext - " + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
