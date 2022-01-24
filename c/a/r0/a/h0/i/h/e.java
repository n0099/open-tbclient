package c.a.r0.a.h0.i.h;

import androidx.annotation.NonNull;
import c.a.r0.a.h;
import c.a.r0.a.h0.i.g.b.a;
import c.a.r0.a.k;
import c.a.r0.a.z2.q0;
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
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6674e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.a.h0.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.d.b f6675b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.a.c f6676c;

    /* renamed from: d  reason: collision with root package name */
    public String f6677d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.i.g.d.d f6678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.i.g.a.e f6679c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f6680d;

        public a(e eVar, SceneType sceneType, c.a.r0.a.h0.i.g.d.d dVar, c.a.r0.a.h0.i.g.a.e eVar2) {
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
            this.f6680d = eVar;
            this.a = sceneType;
            this.f6678b = dVar;
            this.f6679c = eVar2;
        }

        @Override // c.a.r0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.r0.a.h0.i.c.b(this.f6680d.f6677d);
                c.a.r0.a.h0.i.f.i(1);
                c.a.r0.a.h0.i.e.e(this.a.getType(), networkStatus.getStatus(), this.f6678b.e().getStatus(), this.f6678b.g(), this.f6678b.b(), this.f6678b.f(), this.f6678b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.f6679c.a());
                sb.append(this.f6678b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f6678b.c());
                c.a.r0.a.h0.i.f.g(sb.toString());
                if (e.f6674e) {
                    String str = ">> " + sb.toString();
                }
                this.f6680d.h(networkStatus, this.f6679c, this.f6678b);
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

        @Override // c.a.r0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.r0.a.h0.i.g.d.b.d().j();
                c.a.r0.a.h0.i.g.a.c.d().j();
                c.a.r0.a.h0.i.c.c();
                c.a.r0.a.h0.i.f.i(0);
                c.a.r0.a.h0.i.e.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149931343, "Lc/a/r0/a/h0/i/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149931343, "Lc/a/r0/a/h0/i/h/e;");
                return;
            }
        }
        f6674e = k.a;
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
        this.f6676c = c.a.r0.a.h0.i.g.a.c.d();
        this.a = new c.a.r0.a.h0.i.g.b.a();
        this.f6675b = c.a.r0.a.h0.i.g.d.b.d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f6674e;
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
            if (q0.I(this.f6677d) && q0.H()) {
                boolean z = f6674e;
                c.a.r0.a.h0.i.g.d.b.d().j();
                c.a.r0.a.h0.i.g.a.c.d().j();
                this.a.a(new a(this, sceneType, this.f6675b.f(), this.f6676c.f()));
            } else if (f6674e) {
                String str = "path is not first page: " + this.f6677d;
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f6677d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull c.a.r0.a.h0.i.g.a.e eVar, @NonNull c.a.r0.a.h0.i.g.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, eVar, dVar) == null) {
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
