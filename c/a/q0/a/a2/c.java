package c.a.q0.a.a2;

import android.os.Bundle;
import c.a.q0.a.d2.d;
import c.a.q0.a.h2.c.i;
import c.a.q0.a.h2.c.j.e;
import c.a.q0.a.p.d.c1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4554b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f4555c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public static final class b<MsgType> implements c.a.q0.a.z2.g1.c<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f4556e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-644478496, "Lc/a/q0/a/a2/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-644478496, "Lc/a/q0/a/a2/c$b;");
                    return;
                }
            }
            f4556e = new b();
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b2 = c.f4555c.b();
                    if (optJSONObject != null) {
                        String openId = optJSONObject.optString("openid");
                        if (b2 == null || !ProcessUtils.isMainProcess()) {
                            c.f4555c.d(null, openId);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(openId, "openId");
                        d J = d.J();
                        Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
                        String appId = J.getAppId();
                        c1 n = c.a.q0.a.c1.a.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b2.a(openId, appId, n.a());
                    }
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.a2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0204c<MsgType> implements c.a.q0.a.z2.g1.c<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0204c f4557e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-644478465, "Lc/a/q0/a/a2/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-644478465, "Lc/a/q0/a/a2/c$c;");
                    return;
                }
            }
            f4557e = new C0204c();
        }

        public C0204c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b2 = c.f4555c.b();
                    if (optJSONObject != null) {
                        String swanId = optJSONObject.optString("swanid");
                        if (b2 == null || !ProcessUtils.isMainProcess()) {
                            c.f4555c.d(swanId, null);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(swanId, "swanId");
                        d J = d.J();
                        Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
                        String appId = J.getAppId();
                        c1 n = c.a.q0.a.c1.a.n();
                        Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                        b2.b(swanId, appId, n.a());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(616088478, "Lc/a/q0/a/a2/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(616088478, "Lc/a/q0/a/a2/c;");
                return;
            }
        }
        f4555c = new c();
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

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a : (a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f4554b : invokeV.booleanValue;
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d J = d.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            c.a.q0.a.y1.c.e.a z = J.z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanId", str);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                d J2 = d.J();
                Intrinsics.checkNotNullExpressionValue(J2, "Swan.get()");
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, J2.getAppId());
                c1 n = c.a.q0.a.c1.a.n();
                Intrinsics.checkNotNullExpressionValue(n, "SwanAppRuntime.getConfig()");
                bundle.putString("hostName", n.a());
                z.V(bundle, c.a.q0.a.a2.b.class);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d J = d.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            c.a.q0.a.p.a y = J.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            c.a.q0.a.h2.c.j.d f2 = y.a().b().f(d.J());
            f2.o(b.f4556e);
            f2.call();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d J = d.J();
            Intrinsics.checkNotNullExpressionValue(J, "Swan.get()");
            c.a.q0.a.p.a y = J.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            e e2 = y.a().b().e(d.J());
            e2.o(C0204c.f4557e);
            e2.call();
        }
    }
}
