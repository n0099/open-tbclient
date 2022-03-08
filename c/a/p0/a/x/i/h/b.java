package c.a.p0.a.x.i.h;

import c.a.p0.a.x.i.g.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8489d;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.d.b f8490b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.a.c f8491c;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.i.g.d.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.i.g.a.e f8492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f8493c;

        public a(b bVar, c.a.p0.a.x.i.g.d.d dVar, c.a.p0.a.x.i.g.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8493c = bVar;
            this.a = dVar;
            this.f8492b = eVar;
        }

        @Override // c.a.p0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.p0.a.x.i.e.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.f8492b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (b.f8489d) {
                    String str = ">> " + sb.toString();
                }
                c.a.p0.a.x.i.f.g(sb.toString());
                this.f8493c.d(networkStatus);
            }
        }
    }

    /* renamed from: c.a.p0.a.x.i.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0549b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760944842, "Lc/a/p0/a/x/i/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-760944842, "Lc/a/p0/a/x/i/h/b$b;");
                    return;
                }
            }
            int[] iArr = new int[NetworkStatus.values().length];
            a = iArr;
            try {
                iArr[NetworkStatus.NETWORK_BAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkStatus.NETWORK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2123694476, "Lc/a/p0/a/x/i/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2123694476, "Lc/a/p0/a/x/i/h/b;");
                return;
            }
        }
        f8489d = c.a.p0.a.a.a;
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
                return;
            }
        }
        this.f8491c = c.a.p0.a.x.i.g.a.c.d();
        this.a = new c.a.p0.a.x.i.g.b.a();
        this.f8490b = c.a.p0.a.x.i.g.d.b.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f8489d;
            c.a.p0.a.x.i.g.d.b.d().j();
            c.a.p0.a.x.i.g.a.c.d().j();
            c.a.p0.a.x.i.g.a.e f2 = this.f8491c.f();
            this.a.a(new a(this, this.f8490b.f(), f2));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i2 = C0549b.a[networkStatus.ordinal()];
            if (i2 != 1 && i2 != 2) {
                c.a.p0.a.x.i.d.f(R.string.swanapp_tip_waiting_and_retry);
            } else {
                c.a.p0.a.x.i.d.f(R.string.swanapp_tip_get_pkg_poor_net);
            }
        }
    }
}
