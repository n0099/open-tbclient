package c.a.n0.a.s.a;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.j2.k;
import c.a.n0.a.p.d.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c.a.n0.a.m.a f8215a;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.n0.a.m.c f8216b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8217c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f8218d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766211756, "Lc/a/n0/a/s/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766211756, "Lc/a/n0/a/s/a/f;");
                return;
            }
        }
        f fVar = new f();
        f8218d = fVar;
        Intrinsics.checkNotNullExpressionValue(fVar.getClass().getSimpleName(), "SwanAppAllianceLoginHelper.javaClass.simpleName");
    }

    public f() {
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
            c.a.n0.a.j2.p.e eVar = new c.a.n0.a.j2.p.e();
            eVar.f6790b = g.h();
            eVar.f6793e = value;
            c.a.n0.a.a2.d g2 = c.a.n0.a.a2.d.g();
            Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
            eVar.a("appkey", g2.getAppId());
            k.v(g.g(), ceresId, eVar);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.f8213a.b();
            h.f8229b.d();
            j(false);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f8217c : invokeV.booleanValue;
    }

    public final c.a.n0.a.m.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? f8215a : (c.a.n0.a.m.a) invokeV.objValue;
    }

    public final c.a.n0.a.m.c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f8216b : (c.a.n0.a.m.c) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (g.i() == null) {
                k();
            }
            Boolean i2 = g.i();
            Intrinsics.checkNotNull(i2);
            return i2.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g.i() == null) {
                k();
            }
            if (!Intrinsics.areEqual(g.i(), Boolean.FALSE)) {
                String a2 = d.f8213a.a();
                if (!(a2 == null || StringsKt__StringsJVMKt.isBlank(a2))) {
                    String a3 = h.f8229b.a();
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

    public final void i(c.a.n0.a.m.a listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (g.i() == null) {
                k();
            }
            Intrinsics.areEqual(g.i(), Boolean.FALSE);
            if (g()) {
                listener.onResult(0);
                return;
            }
            x0 m = c.a.n0.a.c1.a.m();
            Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
            String a2 = c.a.n0.t.i.a("https://ossapi.baidu.com/oss/static/open_source_login_v3.html", "hostName", m.a());
            c.a.n0.a.c1.d.k u0 = c.a.n0.a.c1.a.u0();
            Intrinsics.checkNotNull(u0);
            String a3 = c.a.n0.t.i.a(a2, "zid", u0.a(c.a.n0.a.c1.a.b()));
            x0 m2 = c.a.n0.a.c1.a.m();
            Intrinsics.checkNotNullExpressionValue(m2, "SwanAppRuntime.getConfig()");
            String a4 = c.a.n0.t.i.a(a3, "appKey", m2.b());
            c.a.n0.a.h0.g.k.O2("allianceLogin", c.a.n0.a.l1.b.g(a4, a4));
            f8215a = listener;
            f8217c = false;
            a(g.e(), g.b());
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("status", z);
            c.a.n0.a.v1.b.d.a(c.class, bundle);
        }
    }

    public final void k() {
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                Intrinsics.checkNotNullExpressionValue(Class.forName("com.baidu.sapi2.SapiAccountManager"), "Class.forName(\"com.baidu…api2.SapiAccountManager\")");
                bool = Boolean.FALSE;
            } catch (ClassNotFoundException unused) {
                bool = Boolean.TRUE;
            }
            g.j(bool);
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            f8217c = z;
        }
    }

    public final void m(c.a.n0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            f8216b = cVar;
        }
    }
}
