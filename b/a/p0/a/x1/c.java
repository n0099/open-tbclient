package b.a.p0.a.x1;

import android.os.Bundle;
import b.a.p0.a.a2.d;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.e;
import b.a.p0.a.p.d.x0;
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

    /* renamed from: a  reason: collision with root package name */
    public static a f8947a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8948b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f8949c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, String str3);

        void b(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public static final class b<MsgType> implements b.a.p0.a.v2.e1.b<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f8950e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1353908006, "Lb/a/p0/a/x1/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1353908006, "Lb/a/p0/a/x1/c$b;");
                    return;
                }
            }
            f8950e = new b();
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
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.f4946a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b2 = c.f8949c.b();
                    if (optJSONObject != null) {
                        String openId = optJSONObject.optString("openid");
                        if (b2 == null || !ProcessUtils.isMainProcess()) {
                            c.f8949c.d(null, openId);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(openId, "openId");
                        d g2 = d.g();
                        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
                        String appId = g2.getAppId();
                        x0 m = b.a.p0.a.c1.a.m();
                        Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
                        b2.a(openId, appId, m.a());
                    }
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0452c<MsgType> implements b.a.p0.a.v2.e1.b<i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final C0452c f8951e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1353907975, "Lb/a/p0/a/x1/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1353907975, "Lb/a/p0/a/x1/c$c;");
                    return;
                }
            }
            f8951e = new C0452c();
        }

        public C0452c() {
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
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public final void onCallback(i<JSONObject> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.c()) {
                    JSONObject jSONObject = it.f4946a;
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                    a b2 = c.f8949c.b();
                    if (optJSONObject != null) {
                        String swanId = optJSONObject.optString("swanid");
                        if (b2 == null || !ProcessUtils.isMainProcess()) {
                            c.f8949c.d(swanId, null);
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(swanId, "swanId");
                        d g2 = d.g();
                        Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
                        String appId = g2.getAppId();
                        x0 m = b.a.p0.a.c1.a.m();
                        Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
                        b2.b(swanId, appId, m.a());
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1339371800, "Lb/a/p0/a/x1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1339371800, "Lb/a/p0/a/x1/c;");
                return;
            }
        }
        f8949c = new c();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f8947a : (a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f8948b : invokeV.booleanValue;
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            d g2 = d.g();
            Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
            b.a.p0.a.v1.c.e.a z = g2.z();
            if (z != null) {
                Bundle bundle = new Bundle();
                bundle.putString("swanId", str);
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
                d g3 = d.g();
                Intrinsics.checkNotNullExpressionValue(g3, "Swan.get()");
                bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g3.getAppId());
                x0 m = b.a.p0.a.c1.a.m();
                Intrinsics.checkNotNullExpressionValue(m, "SwanAppRuntime.getConfig()");
                bundle.putString("hostName", m.a());
                z.K(bundle, b.a.p0.a.x1.b.class);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d g2 = d.g();
            Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
            b.a.p0.a.p.a y = g2.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            b.a.p0.a.e2.c.j.d f2 = y.a().b().f(d.g());
            f2.o(b.f8950e);
            f2.call();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d g2 = d.g();
            Intrinsics.checkNotNullExpressionValue(g2, "Swan.get()");
            b.a.p0.a.p.a y = g2.y();
            Intrinsics.checkNotNullExpressionValue(y, "Swan.get().adaptationProducer");
            e e2 = y.a().b().e(d.g());
            e2.o(C0452c.f8951e);
            e2.call();
        }
    }
}
