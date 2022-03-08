package c.a.b0.v.y.c.b;

import android.net.Uri;
import c.a.b0.v.y.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-571979331, "Lc/a/b0/v/y/c/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-571979331, "Lc/a/b0/v/y/c/b/a;");
                return;
            }
        }
        a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final int a(c cVar, String str) {
        InterceptResult invokeLL;
        c.a.b0.v.y.a.a c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cVar, str)) == null) {
            Integer valueOf = (cVar == null && ((c2 = c.a.b0.v.y.c.a.c(str)) == null || (cVar = c2.a()) == null)) ? null : Integer.valueOf(cVar.a());
            if (valueOf != null) {
                return valueOf.intValue();
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @JvmStatic
    public static final String c(c cVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cVar, str, str2)) == null) ? a.b(a(cVar, str), str2) : (String) invokeLLL.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) {
            return i2 != 1 ? "" : str == null || str.length() == 0 ? "https://sv.baidu.com" : d(str);
        }
        return (String) invokeIL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                Uri url = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(url, "url");
                String scheme = url.getScheme();
                if (scheme != null) {
                    String str2 = scheme + "://";
                    if (str2 != null) {
                        String str3 = str2 + url.getHost();
                        return str3 != null ? str3 : "https://sv.baidu.com";
                    }
                    return "https://sv.baidu.com";
                }
                return "https://sv.baidu.com";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "https://sv.baidu.com";
            }
        }
        return (String) invokeL.objValue;
    }
}
