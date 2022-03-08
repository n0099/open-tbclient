package c.a.p0.a.x.i.h;

import androidx.annotation.NonNull;
import c.a.p0.a.p2.q0;
import c.a.p0.a.x.i.g.b.a;
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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8507e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.d.b f8508b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.a.c f8509c;

    /* renamed from: d  reason: collision with root package name */
    public String f8510d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.i.g.d.d f8511b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.i.g.a.e f8512c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f8513d;

        public a(e eVar, SceneType sceneType, c.a.p0.a.x.i.g.d.d dVar, c.a.p0.a.x.i.g.a.e eVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, sceneType, dVar, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8513d = eVar;
            this.a = sceneType;
            this.f8511b = dVar;
            this.f8512c = eVar2;
        }

        @Override // c.a.p0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.p0.a.x.i.c.b(this.f8513d.f8510d);
                c.a.p0.a.x.i.f.i(1);
                c.a.p0.a.x.i.e.e(this.a.getType(), networkStatus.getStatus(), this.f8511b.e().getStatus(), this.f8511b.g(), this.f8511b.b(), this.f8511b.f(), this.f8511b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.f8512c.a());
                sb.append(this.f8511b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f8511b.c());
                c.a.p0.a.x.i.f.g(sb.toString());
                if (e.f8507e) {
                    String str = ">> " + sb.toString();
                }
                this.f8513d.h(networkStatus, this.f8512c, this.f8511b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.p0.a.x.i.g.d.b.d().j();
                c.a.p0.a.x.i.g.a.c.d().j();
                c.a.p0.a.x.i.c.c();
                c.a.p0.a.x.i.f.i(0);
                c.a.p0.a.x.i.e.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2123694383, "Lc/a/p0/a/x/i/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2123694383, "Lc/a/p0/a/x/i/h/e;");
                return;
            }
        }
        f8507e = c.a.p0.a.a.a;
    }

    public e() {
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
        this.f8509c = c.a.p0.a.x.i.g.a.c.d();
        this.a = new c.a.p0.a.x.i.g.b.a();
        this.f8508b = c.a.p0.a.x.i.g.d.b.d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f8507e;
            this.a.a(new b(this));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f(SceneType.SCENE_SKELETON_TIMEOUT);
        }
    }

    public void f(SceneType sceneType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sceneType) == null) {
            if (q0.I(this.f8510d) && q0.H()) {
                boolean z = f8507e;
                c.a.p0.a.x.i.g.d.b.d().j();
                c.a.p0.a.x.i.g.a.c.d().j();
                this.a.a(new a(this, sceneType, this.f8508b.f(), this.f8509c.f()));
            } else if (f8507e) {
                String str = "path is not first page: " + this.f8510d;
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f8510d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull c.a.p0.a.x.i.g.a.e eVar, @NonNull c.a.p0.a.x.i.g.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, eVar, dVar) == null) {
            boolean b2 = eVar.b();
            int i2 = R.string.swanapp_tip_request_all_fail;
            if (b2) {
                i2 = R.string.swanapp_tip_show_js_error;
            } else if (dVar.e() == RequestStatus.STATUS_SERVER_FAILED) {
                i2 = R.string.swanapp_tip_request_fail;
            } else if (dVar.e() != RequestStatus.STATUS_FAILED) {
                if (dVar.e() == RequestStatus.STATUS_SLOW) {
                    i2 = (networkStatus == NetworkStatus.NETWORK_BAD || networkStatus == NetworkStatus.NETWORK_OFFLINE) ? R.string.swanapp_tip_request_slow : R.string.swanapp_tip_request_bad_network;
                } else if (dVar.e() != RequestStatus.STATUS_CORE_FAILED) {
                    i2 = R.string.swanapp_tip_request_default;
                }
            }
            c.a.p0.a.x.i.d.f(i2);
        }
    }
}
