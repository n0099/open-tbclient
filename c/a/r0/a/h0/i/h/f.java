package c.a.r0.a.h0.i.h;

import androidx.annotation.NonNull;
import c.a.r0.a.h;
import c.a.r0.a.h0.i.g.b.a;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6680e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.a.h0.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.d.b f6681b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.a.c f6682c;

    /* renamed from: d  reason: collision with root package name */
    public SceneType f6683d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.i.g.d.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.i.g.a.e f6684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f6685c;

        public a(f fVar, c.a.r0.a.h0.i.g.d.d dVar, c.a.r0.a.h0.i.g.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6685c = fVar;
            this.a = dVar;
            this.f6684b = eVar;
        }

        @Override // c.a.r0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.r0.a.h0.i.e.e(this.f6685c.f6683d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = g.U().m0();
                long n = c.a.r0.a.c1.a.g0().n();
                if (n >= 6000 || m0) {
                    this.f6685c.f(networkStatus, this.f6684b, this.a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6685c.f6683d.getScene());
                sb.append(String.format(Locale.getDefault(), "%d秒截屏；", Long.valueOf(n / 1000)));
                sb.append(m0 ? "框架预加载：已完成；" : "框架预加载：未完成；");
                sb.append(this.f6684b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (f.f6680e) {
                    String str = ">> " + sb.toString();
                }
                c.a.r0.a.h0.i.f.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149931312, "Lc/a/r0/a/h0/i/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149931312, "Lc/a/r0/a/h0/i/h/f;");
                return;
            }
        }
        f6680e = k.a;
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
                return;
            }
        }
        this.f6683d = SceneType.SCENE_WHITE_SCREEN_L1;
        this.f6682c = c.a.r0.a.h0.i.g.a.c.d();
        this.a = new c.a.r0.a.h0.i.g.b.a();
        this.f6681b = c.a.r0.a.h0.i.g.d.b.d();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (c.a.r0.a.h0.i.g.c.g.b().c()) {
                boolean z = f6680e;
                c.a.r0.a.h0.i.g.c.g.b().h(c.a.r0.a.h0.i.g.c.e.b(str, 3000L));
                c.a.r0.a.h0.i.g.c.g.b().f();
                return;
            }
            boolean z2 = f6680e;
            boolean z3 = f6680e;
            c.a.r0.a.h0.i.g.d.b.d().j();
            c.a.r0.a.h0.i.g.a.c.d().j();
            c.a.r0.a.h0.i.g.c.g.b().j(true);
            c.a.r0.a.h0.i.g.a.e f2 = this.f6682c.f();
            this.a.a(new a(this, this.f6681b.f(), f2));
        }
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.f6683d = sceneType;
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull c.a.r0.a.h0.i.g.a.e eVar, @NonNull c.a.r0.a.h0.i.g.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, eVar, dVar) == null) {
            int i2 = h.swanapp_tip_request_default;
            if (eVar.b()) {
                i2 = h.swanapp_tip_show_js_error;
            } else if (dVar.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i2 = h.swanapp_tip_request_fail;
            } else if (dVar.e() == RequestStatus.STATUS_FAILED) {
                i2 = h.swanapp_tip_request_all_fail;
            } else if (dVar.e() == RequestStatus.STATUS_SLOW) {
                if (networkStatus != NetworkStatus.NETWORK_BAD && networkStatus != NetworkStatus.NETWORK_OFFLINE) {
                    i2 = h.swanapp_tip_request_bad_network;
                } else {
                    i2 = h.swanapp_tip_request_slow;
                }
            } else if (dVar.e() == RequestStatus.STATUS_CORE_FAILED) {
                i2 = h.swanapp_tip_request_all_fail;
            }
            c.a.r0.a.h0.i.d.f(i2);
        }
    }
}
