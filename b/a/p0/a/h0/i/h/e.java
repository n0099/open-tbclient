package b.a.p0.a.h0.i.h;

import androidx.annotation.NonNull;
import b.a.p0.a.h;
import b.a.p0.a.h0.i.g.b.a;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
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
    public static final boolean f5663e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.b.a f5664a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.d.b f5665b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.a.c f5666c;

    /* renamed from: d  reason: collision with root package name */
    public String f5667d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SceneType f5668a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.d.d f5669b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.a.e f5670c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f5671d;

        public a(e eVar, SceneType sceneType, b.a.p0.a.h0.i.g.d.d dVar, b.a.p0.a.h0.i.g.a.e eVar2) {
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
            this.f5671d = eVar;
            this.f5668a = sceneType;
            this.f5669b = dVar;
            this.f5670c = eVar2;
        }

        @Override // b.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                b.a.p0.a.h0.i.c.b(this.f5671d.f5667d);
                b.a.p0.a.h0.i.f.i(1);
                b.a.p0.a.h0.i.e.e(this.f5668a.getType(), networkStatus.getStatus(), this.f5669b.e().getStatus(), this.f5669b.g(), this.f5669b.b(), this.f5669b.f(), this.f5669b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5668a.getScene());
                sb.append(this.f5670c.a());
                sb.append(this.f5669b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f5669b.c());
                b.a.p0.a.h0.i.f.g(sb.toString());
                if (e.f5663e) {
                    String str = ">> " + sb.toString();
                }
                this.f5671d.h(networkStatus, this.f5670c, this.f5669b);
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

        @Override // b.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                b.a.p0.a.h0.i.g.d.b.d().j();
                b.a.p0.a.h0.i.g.a.c.d().j();
                b.a.p0.a.h0.i.c.c();
                b.a.p0.a.h0.i.f.i(0);
                b.a.p0.a.h0.i.e.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858258260, "Lb/a/p0/a/h0/i/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858258260, "Lb/a/p0/a/h0/i/h/e;");
                return;
            }
        }
        f5663e = k.f6863a;
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
        this.f5666c = b.a.p0.a.h0.i.g.a.c.d();
        this.f5664a = new b.a.p0.a.h0.i.g.b.a();
        this.f5665b = b.a.p0.a.h0.i.g.d.b.d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f5663e;
            this.f5664a.a(new b(this));
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
            if (q0.I(this.f5667d) && q0.H()) {
                boolean z = f5663e;
                b.a.p0.a.h0.i.g.d.b.d().j();
                b.a.p0.a.h0.i.g.a.c.d().j();
                this.f5664a.a(new a(this, sceneType, this.f5665b.f(), this.f5666c.f()));
            } else if (f5663e) {
                String str = "path is not first page: " + this.f5667d;
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f5667d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull b.a.p0.a.h0.i.g.a.e eVar, @NonNull b.a.p0.a.h0.i.g.d.d dVar) {
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
            b.a.p0.a.h0.i.d.f(i2);
        }
    }
}
