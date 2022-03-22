package c.a.n0.a.x.i.h;

import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.i.g.b.a;
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
    public static final boolean f7149e;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.d.b f7150b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.a.c f7151c;

    /* renamed from: d  reason: collision with root package name */
    public String f7152d;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SceneType a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.i.g.d.d f7153b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.i.g.a.e f7154c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f7155d;

        public a(e eVar, SceneType sceneType, c.a.n0.a.x.i.g.d.d dVar, c.a.n0.a.x.i.g.a.e eVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, sceneType, dVar, eVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7155d = eVar;
            this.a = sceneType;
            this.f7153b = dVar;
            this.f7154c = eVar2;
        }

        @Override // c.a.n0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.n0.a.x.i.c.b(this.f7155d.f7152d);
                c.a.n0.a.x.i.f.i(1);
                c.a.n0.a.x.i.e.e(this.a.getType(), networkStatus.getStatus(), this.f7153b.e().getStatus(), this.f7153b.g(), this.f7153b.b(), this.f7153b.f(), this.f7153b.a());
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.getScene());
                sb.append(this.f7154c.a());
                sb.append(this.f7153b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f7153b.c());
                c.a.n0.a.x.i.f.g(sb.toString());
                if (e.f7149e) {
                    Log.d("SceneSkeletonTips", ">> " + sb.toString());
                }
                this.f7155d.h(networkStatus, this.f7154c, this.f7153b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.n0.a.x.i.g.d.b.d().j();
                c.a.n0.a.x.i.g.a.c.d().j();
                c.a.n0.a.x.i.c.c();
                c.a.n0.a.x.i.f.i(0);
                c.a.n0.a.x.i.e.c("exit_skeleton", networkStatus.getStatus());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536888369, "Lc/a/n0/a/x/i/h/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1536888369, "Lc/a/n0/a/x/i/h/e;");
                return;
            }
        }
        f7149e = c.a.n0.a.a.a;
    }

    public e() {
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
        this.f7151c = c.a.n0.a.x.i.g.a.c.d();
        this.a = new c.a.n0.a.x.i.g.b.a();
        this.f7150b = c.a.n0.a.x.i.g.d.b.d();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f7149e) {
                Log.d("SceneSkeletonTips", ">> trigger skeleton error event.");
            }
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
            if (q0.I(this.f7152d) && q0.H()) {
                if (f7149e) {
                    Log.d("SceneSkeletonTips", ">> trigger skeleton remove event.");
                }
                c.a.n0.a.x.i.g.d.b.d().j();
                c.a.n0.a.x.i.g.a.c.d().j();
                c.a.n0.a.x.i.g.a.e f2 = this.f7151c.f();
                this.a.a(new a(this, sceneType, this.f7150b.f(), f2));
            } else if (f7149e) {
                Log.d("SceneSkeletonTips", "path is not first page: " + this.f7152d);
            }
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f7152d = str;
        }
    }

    public final void h(@NonNull NetworkStatus networkStatus, @NonNull c.a.n0.a.x.i.g.a.e eVar, @NonNull c.a.n0.a.x.i.g.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, networkStatus, eVar, dVar) == null) {
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
