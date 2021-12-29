package c.a.r0.a.g0;

import android.os.Bundle;
import c.a.r0.a.h2.c.h;
import c.a.r0.a.k;
import c.a.r0.a.y1.b.e;
import c.a.r0.a.y1.b.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6347b;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManager a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425056486, "Lc/a/r0/a/g0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(425056486, "Lc/a/r0/a/g0/b;");
                return;
            }
        }
        f6347b = k.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = new c();
    }

    public final Bundle a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i2)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            return bundle;
        }
        return (Bundle) invokeLLI.objValue;
    }

    @Override // c.a.r0.a.h2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return this.a.getCookie(str);
            }
            g c2 = e.c(a.class, a(str, "", 4));
            if (c2.a()) {
                String string = c2.a.getString("result");
                if (f6347b) {
                    String str2 = "getCookie cookie : " + string;
                }
                return string;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return this.a.shouldAcceptCookie(str, str2);
            }
            g c2 = e.c(a.class, a(str, str2, 1));
            if (c2.a()) {
                return c2.a.getBoolean("result");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return this.a.shouldSendCookie(str, str2);
            }
            g c2 = e.c(a.class, a(str, str2, 2));
            if (c2.a()) {
                return c2.a.getBoolean("result");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            if (ProcessUtils.isMainProcess()) {
                this.a.storeCookie(str, list);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            bundle.putString("param1", str);
            bundle.putStringArrayList("param2", (ArrayList) list);
            e.c(a.class, bundle);
            if (f6347b) {
                String str2 = "set cookies for " + str;
            }
        }
    }
}
