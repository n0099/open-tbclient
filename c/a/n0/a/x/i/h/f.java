package c.a.n0.a.x.i.h;

import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.x.i.g.b.a;
import c.a.n0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.R;
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
    public static final boolean f7156e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.d.b f7157b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.a.c f7158c;

    /* renamed from: d  reason: collision with root package name */
    public SceneType f7159d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.i.g.d.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.i.g.a.e f7160b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f7161c;

        public a(f fVar, c.a.n0.a.x.i.g.d.d dVar, c.a.n0.a.x.i.g.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7161c = fVar;
            this.a = dVar;
            this.f7160b = eVar;
        }

        @Override // c.a.n0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.n0.a.x.i.e.e(this.f7161c.f7159d.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                boolean m0 = g.U().m0();
                long n = c.a.n0.a.s0.a.g0().n();
                if (n >= 6000 || m0) {
                    this.f7161c.f(networkStatus, this.f7160b, this.a);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f7161c.f7159d.getScene());
                sb.append(String.format(Locale.getDefault(), "%d秒截屏；", Long.valueOf(n / 1000)));
                sb.append(m0 ? "框架预加载：已完成；" : "框架预加载：未完成；");
                sb.append(this.f7160b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (f.f7156e) {
                    Log.d("SceneWhiteScreenTips", ">> " + sb.toString());
                }
                c.a.n0.a.x.i.f.g(sb.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536888338, "Lc/a/n0/a/x/i/h/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1536888338, "Lc/a/n0/a/x/i/h/f;");
                return;
            }
        }
        f7156e = c.a.n0.a.a.a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f7159d = SceneType.SCENE_WHITE_SCREEN_L1;
        this.f7158c = c.a.n0.a.x.i.g.a.c.d();
        this.a = new c.a.n0.a.x.i.g.b.a();
        this.f7157b = c.a.n0.a.x.i.g.d.b.d();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (c.a.n0.a.x.i.g.c.g.b().c()) {
                if (f7156e) {
                    Log.d("SceneWhiteScreenTips", ">> start to recheck white screen.");
                }
                c.a.n0.a.x.i.g.c.g.b().h(c.a.n0.a.x.i.g.c.e.b(str, 3000L));
                c.a.n0.a.x.i.g.c.g.b().f();
                return;
            }
            if (f7156e) {
                Log.d("SceneWhiteScreenTips", ">> no need to recheck white screen.");
            }
            if (f7156e) {
                Log.d("SceneWhiteScreenTips", ">> start handle white screen tips.");
            }
            c.a.n0.a.x.i.g.d.b.d().j();
            c.a.n0.a.x.i.g.a.c.d().j();
            c.a.n0.a.x.i.g.c.g.b().j(true);
            c.a.n0.a.x.i.g.a.e f2 = this.f7158c.f();
            this.a.a(new a(this, this.f7157b.f(), f2));
        }
    }

    public void e(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sceneType) == null) {
            this.f7159d = sceneType;
        }
    }

    public final void f(@NonNull NetworkStatus networkStatus, @NonNull c.a.n0.a.x.i.g.a.e eVar, @NonNull c.a.n0.a.x.i.g.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, networkStatus, eVar, dVar) == null) {
            boolean b2 = eVar.b();
            int i = R.string.obfuscated_res_0x7f0f12df;
            if (b2) {
                i = R.string.obfuscated_res_0x7f0f12e4;
            } else if (dVar.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i = R.string.obfuscated_res_0x7f0f12e2;
            } else if (dVar.e() != RequestStatus.STATUS_FAILED) {
                if (dVar.e() == RequestStatus.STATUS_SLOW) {
                    i = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.obfuscated_res_0x7f0f12e3 : R.string.obfuscated_res_0x7f0f12e0;
                } else if (dVar.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i = R.string.obfuscated_res_0x7f0f12e1;
                }
            }
            c.a.n0.a.x.i.d.f(i);
        }
    }
}
