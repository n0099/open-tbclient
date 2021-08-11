package c.a.n0.a.g0;

import android.os.Bundle;
import c.a.n0.a.e2.c.h;
import c.a.n0.a.k;
import c.a.n0.a.v1.b.d;
import c.a.n0.a.v1.b.f;
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
    public static final boolean f5463b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CookieManager f5464a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211110506, "Lc/a/n0/a/g0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211110506, "Lc/a/n0/a/g0/b;");
                return;
            }
        }
        f5463b = k.f6803a;
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
        this.f5464a = null;
        this.f5464a = new c();
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

    @Override // c.a.n0.a.e2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return this.f5464a.getCookie(str);
            }
            f b2 = d.b(a.class, a(str, "", 4));
            if (b2.a()) {
                String string = b2.f8955a.getString("result");
                if (f5463b) {
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
                return this.f5464a.shouldAcceptCookie(str, str2);
            }
            f b2 = d.b(a.class, a(str, str2, 1));
            if (b2.a()) {
                return b2.f8955a.getBoolean("result");
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
                return this.f5464a.shouldSendCookie(str, str2);
            }
            f b2 = d.b(a.class, a(str, str2, 2));
            if (b2.a()) {
                return b2.f8955a.getBoolean("result");
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
                this.f5464a.storeCookie(str, list);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            bundle.putString("param1", str);
            bundle.putStringArrayList("param2", (ArrayList) list);
            d.b(a.class, bundle);
            if (f5463b) {
                String str2 = "set cookies for " + str;
            }
        }
    }
}
