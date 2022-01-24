package c.a.r0.a.c1.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;
@Singleton
@Service
/* loaded from: classes.dex */
public class l implements c.a.r0.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.p.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String g2 = SwanAppNetworkUtils.g();
            return (TextUtils.isEmpty(g2) && c.a.r0.p.e.a.g().c()) ? c.a.r0.a.w2.a.a() : g2;
        }
        return (String) invokeV.objValue;
    }

    public final c.a b() {
        InterceptResult invokeV;
        c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 == null) {
                boolean z = c.a.r0.a.k.a;
                return null;
            }
            SwanAppConfigData P = a0.P();
            if (P == null || (aVar = P.f39374h) == null) {
                boolean z2 = c.a.r0.a.k.a;
                return null;
            }
            return aVar;
        }
        return (c.a) invokeV.objValue;
    }

    @Override // c.a.r0.p.a
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.r0.a.c1.a.q().a() : (CookieManager) invokeV.objValue;
    }

    @Override // c.a.r0.p.a
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.c(b()) : invokeV.intValue;
    }

    @Override // c.a.r0.p.a
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    @Override // c.a.r0.p.a
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.c(b()) : invokeV.intValue;
    }

    @Override // c.a.r0.p.a
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.r0.a.c1.a.g0().getSwitch("bbasm_framework_request_with_ua", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.p.a
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName()) && c.a.r0.a.u1.l.e.c() : invokeV.booleanValue;
    }

    @Override // c.a.r0.p.a
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? c.a.r0.a.k.a : invokeV.booleanValue;
    }

    @Override // c.a.r0.p.a
    public void j(String str, HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, httpRequestBuilder) == null) && c.a.r0.a.d0.c.u(str)) {
            httpRequestBuilder.setHeader("x-u-id", c.a.r0.x.b.b(AppRuntime.getAppContext()).a());
            try {
                httpRequestBuilder.setHeader("x-c2-id", c.a.r0.a.c1.a.h0().i(AppRuntime.getAppContext()));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // c.a.r0.p.a
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? c.a.r0.a.u1.l.b.a() == 2 ? 128 : 0 : invokeV.intValue;
    }

    @Override // c.a.r0.p.a
    public List<Interceptor> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.a.r0.a.p1.o.c());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.r0.p.a
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c.a.c(b()) : invokeV.intValue;
    }
}
