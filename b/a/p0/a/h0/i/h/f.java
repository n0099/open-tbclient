package b.a.p0.a.h0.i.h;

import androidx.annotation.NonNull;
import b.a.p0.a.h;
import b.a.p0.a.h0.i.g.b.a;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
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
    public static final boolean f5672e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.b.a f5673a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.d.b f5674b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.a.c f5675c;

    /* renamed from: d  reason: collision with root package name */
    public SceneType f5676d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.d.d f5677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.a.e f5678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f5679c;

        public a(f fVar, b.a.p0.a.h0.i.g.d.d dVar, b.a.p0.a.h0.i.g.a.e eVar) {
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
            this.f5679c = fVar;
            this.f5677a = dVar;
            this.f5678b = eVar;
        }

        @Override // b.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                b.a.p0.a.h0.i.e.e(this.f5679c.f5676d.getType(), networkStatus.getStatus(), this.f5677a.e().getStatus(), this.f5677a.g(), this.f5677a.b(), this.f5677a.f(), this.f5677a.a());
                boolean m0 = g.U().m0();
                long n = b.a.p0.a.c1.a.g0().n();
                if (n >= 6000 || m0) {
                    this.f5679c.f(networkStatus, this.f5678b, this.f5677a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5679c.f5676d.getScene());
                sb.append(String.format(Locale.getDefault(), "%d秒截屏；", Long.valueOf(n / 1000)));
                sb.append(m0 ? "框架预加载：已完成；" : "框架预加载：未完成；");
                sb.append(this.f5678b.a());
                sb.append(this.f5677a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f5677a.c());
                if (f.f5672e) {
                    String str = ">> " + sb.toString();
                }
                b.a.p0.a.h0.i.f.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858258291, "Lb/a/p0/a/h0/i/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858258291, "Lb/a/p0/a/h0/i/h/f;");
                return;
            }
        }
        f5672e = k.f6863a;
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
        this.f5676d = SceneType.SCENE_WHITE_SCREEN_L1;
        this.f5675c = b.a.p0.a.h0.i.g.a.c.d();
        this.f5673a = new b.a.p0.a.h0.i.g.b.a();
        this.f5674b = b.a.p0.a.h0.i.g.d.b.d();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (b.a.p0.a.h0.i.g.c.g.b().c()) {
                boolean z = f5672e;
                b.a.p0.a.h0.i.g.c.g.b().h(b.a.p0.a.h0.i.g.c.e.b(str, 3000L));
                b.a.p0.a.h0.i.g.c.g.b().f();
                return;
            }
            boolean z2 = f5672e;
            boolean z3 = f5672e;
            b.a.p0.a.h0.i.g.d.b.d().j();
            b.a.p0.a.h0.i.g.a.c.d().j();
            b.a.p0.a.h0.i.g.c.g.b().j(true);
            b.a.p0.a.h0.i.g.a.e f2 = this.f5675c.f();
            this.f5673a.a(new a(this, this.f5674b.f(), f2));
        }
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.f5676d = sceneType;
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull b.a.p0.a.h0.i.g.a.e eVar, @NonNull b.a.p0.a.h0.i.g.d.d dVar) {
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
            b.a.p0.a.h0.i.d.f(i2);
        }
    }
}
