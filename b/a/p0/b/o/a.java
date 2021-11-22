package b.a.p0.b.o;

import android.os.Bundle;
import b.a.p0.a.h2.c.h;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
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
public class a extends h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9966b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CookieManager f9967a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1036812497, "Lb/a/p0/b/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1036812497, "Lb/a/p0/b/o/a;");
                return;
            }
        }
        f9966b = k.f6863a;
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
                return;
            }
        }
        this.f9967a = null;
        this.f9967a = new b();
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

    @Override // b.a.p0.a.h2.c.h, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return this.f9967a.getCookie(str);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, "", 4));
            if (callOnMainWithContentProvider.isOk()) {
                String string = callOnMainWithContentProvider.mResult.getString("result");
                if (f9966b) {
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
                return this.f9967a.shouldAcceptCookie(str, str2);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, str2, 1));
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getBoolean("result");
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
                return this.f9967a.shouldSendCookie(str, str2);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, a(str, str2, 2));
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getBoolean("result");
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
                this.f9967a.storeCookie(str, list);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            bundle.putString("param1", str);
            bundle.putStringArrayList("param2", (ArrayList) list);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
            if (f9966b) {
                String str2 = "set cookies for " + str;
            }
        }
    }
}
