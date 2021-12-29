package c.a.r0.a.g0;

import android.util.Log;
import c.a.r0.a.h2.c.h;
import c.a.r0.a.k;
import c.a.r0.a.z2.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.util.List;
/* loaded from: classes.dex */
public class c extends h {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425056517, "Lc/a/r0/a/g0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(425056517, "Lc/a/r0/a/g0/c;");
                return;
            }
        }
        a = k.a;
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception e2) {
            if (a) {
                String str = "static createInstance err=" + e2 + " trace=" + Log.getStackTraceString(e2);
            }
        }
    }

    public c() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.f()) {
                boolean z = a;
                CookieManager.getInstance().flush();
                android.webkit.CookieManager.getInstance().flush();
                return;
            }
            boolean z2 = a;
            CookieSyncManager.getInstance().sync();
        }
    }

    @Override // c.a.r0.a.h2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (a) {
                String str2 = "getCookie: httpUrl=" + str;
            }
            String str3 = "";
            try {
                str3 = CookieManager.getInstance().getCookie(str);
                if (a) {
                    String str4 = "RealCookieManager:" + str3;
                }
            } catch (Exception e2) {
                if (a) {
                    String str5 = "getCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2);
                }
            }
            if (a) {
                String str6 = "getCookie: ret cookie=" + str3 + " for httpUrl=" + str;
            }
            return str3;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            if (a) {
                String str2 = "storeCookie: httpUrl= " + str;
                StringBuilder sb = new StringBuilder();
                sb.append("storeCookie: cookies=");
                sb.append(list == null ? -1 : list.size());
                sb.toString();
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                for (String str3 : list) {
                    if (a) {
                        String str4 = "storeCookie: cookies item=" + str3;
                    }
                    CookieManager.getInstance().setCookie(str, str3);
                    android.webkit.CookieManager.getInstance().setCookie(str, str3);
                }
                a();
            } catch (Exception e2) {
                if (a) {
                    String str5 = "storeCookie: err=" + e2 + " trace=" + Log.getStackTraceString(e2);
                }
            }
        }
    }
}
