package com.baidu.swan.apps.alliance.login;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.c1.d.l;
import c.a.p0.a.d2.d;
import c.a.p0.a.m.a;
import c.a.p0.a.m.c;
import c.a.p0.a.m1.b;
import c.a.p0.a.n2.n;
import c.a.p0.a.n2.s.e;
import c.a.p0.a.p.d.c1;
import c.a.p0.a.s.a.f;
import c.a.p0.a.s.a.g;
import c.a.p0.w.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b)\u0010\bJ\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bR\u0019\u0010\u0015\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0011R#\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper;", "", "value", "ceresId", "", "allianceLoginStatisticEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "allianceLogout", "()V", "", "isAllianceLogin", "()Z", "isLogin", "isUseSapiLogin", "Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", "listener", "login", "(Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;)V", "onLoginStatusChanged", "(Z)V", "readAllianceLoginStatus", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "callBacked", "Z", "getCallBacked", "setCallBacked", "loginResultCallback", "Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", "getLoginResultCallback", "()Lcom/baidu/swan/apps/account/OnSwanAppLoginResultListener;", "setLoginResultCallback", "", "Lcom/baidu/swan/apps/account/SwanAppAccountStatusChangedListener;", "loginStatusChangeCallbacks$delegate", "Lkotlin/Lazy;", "getLoginStatusChangeCallbacks", "()Ljava/util/List;", "loginStatusChangeCallbacks", "<init>", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class SwanAppAllianceLoginHelper {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static final Lazy f39309b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f39310c;

    /* renamed from: d  reason: collision with root package name */
    public static final SwanAppAllianceLoginHelper f39311d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(908876058, "Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(908876058, "Lcom/baidu/swan/apps/alliance/login/SwanAppAllianceLoginHelper;");
                return;
            }
        }
        SwanAppAllianceLoginHelper swanAppAllianceLoginHelper = new SwanAppAllianceLoginHelper();
        f39311d = swanAppAllianceLoginHelper;
        Intrinsics.checkNotNullExpressionValue(swanAppAllianceLoginHelper.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
        f39309b = LazyKt__LazyJVMKt.lazy(SwanAppAllianceLoginHelper$loginStatusChangeCallbacks$2.INSTANCE);
    }

    public SwanAppAllianceLoginHelper() {
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

    public final void a(String value, String ceresId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, value, ceresId) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(ceresId, "ceresId");
            e eVar = new e();
            eVar.f7113b = f.h();
            eVar.f7116e = value;
            d J = d.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            eVar.a("appkey", J.getAppId());
            n.y(f.g(), ceresId, eVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.a.s.a.d.a.b();
            g.f7891b.d();
            j(false);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f39310c : invokeV.booleanValue;
    }

    public final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a : (a) invokeV.objValue;
    }

    public final List<c> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (List) f39309b.getValue() : (List) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f.i() == null) {
                k();
            }
            Boolean i2 = f.i();
            Intrinsics.checkNotNull(i2);
            return i2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f.i() == null) {
                k();
            }
            if (!Intrinsics.areEqual(f.i(), Boolean.FALSE)) {
                String a2 = c.a.p0.a.s.a.d.a.a();
                if (!(a2 == null || StringsKt__StringsJVMKt.isBlank(a2))) {
                    String a3 = g.f7891b.a();
                    if (!(a3 == null || StringsKt__StringsJVMKt.isBlank(a3))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                Class.forName("com.baidu.sapi2.SapiAccountManager");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void i(a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (f.i() == null) {
                k();
            }
            Intrinsics.areEqual(f.i(), Boolean.FALSE);
            if (g()) {
                listener.onResult(0);
                return;
            }
            c1 n = c.a.p0.a.c1.a.n();
            Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
            String a2 = i.a("https://ossapi.baidu.com/oss/static/open_source_login_v3.html", "hostName", n.a());
            l G0 = c.a.p0.a.c1.a.G0();
            Intrinsics.checkNotNull(G0);
            String a3 = i.a(a2, "zid", G0.a(c.a.p0.a.c1.a.c()));
            c1 n2 = c.a.p0.a.c1.a.n();
            Intrinsics.checkNotNullExpressionValue(n2, "SwanAppRuntime.getConfig()");
            String a4 = i.a(a3, "appKey", n2.b());
            c.a.p0.a.h0.g.l.e3("allianceLogin", b.e(a4, a4));
            a = listener;
            f39310c = false;
            a(f.e(), f.b());
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("status", z);
            c.a.p0.a.y1.b.e.b(c.a.p0.a.s.a.c.class, bundle);
        }
    }

    public final void k() {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                Class.forName("com.baidu.sapi2.SapiAccountManager");
                bool = Boolean.FALSE;
            } catch (ClassNotFoundException unused) {
                bool = Boolean.TRUE;
            }
            f.j(bool);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            f39310c = z;
        }
    }
}
