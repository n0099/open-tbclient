package c.a.p0.a.h0.i.h;

import c.a.p0.a.h;
import c.a.p0.a.h0.i.g.b.a;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
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
    public static final boolean f5611d;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.h0.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.a.h0.i.g.d.b f5612b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a.h0.i.g.a.c f5613c;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.h0.i.g.d.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.i.g.a.e f5614b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5615c;

        public a(b bVar, c.a.p0.a.h0.i.g.d.d dVar, c.a.p0.a.h0.i.g.a.e eVar) {
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
            this.f5615c = bVar;
            this.a = dVar;
            this.f5614b = eVar;
        }

        @Override // c.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.p0.a.h0.i.e.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.f5614b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (b.f5611d) {
                    String str = ">> " + sb.toString();
                }
                c.a.p0.a.h0.i.f.g(sb.toString());
                this.f5615c.d(networkStatus);
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.i.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0282b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1329139880, "Lc/a/p0/a/h0/i/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1329139880, "Lc/a/p0/a/h0/i/h/b$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(861185814, "Lc/a/p0/a/h0/i/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(861185814, "Lc/a/p0/a/h0/i/h/b;");
                return;
            }
        }
        f5611d = k.a;
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
        this.f5613c = c.a.p0.a.h0.i.g.a.c.d();
        this.a = new c.a.p0.a.h0.i.g.b.a();
        this.f5612b = c.a.p0.a.h0.i.g.d.b.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f5611d;
            c.a.p0.a.h0.i.g.d.b.d().j();
            c.a.p0.a.h0.i.g.a.c.d().j();
            c.a.p0.a.h0.i.g.a.e f2 = this.f5613c.f();
            this.a.a(new a(this, this.f5612b.f(), f2));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i2 = C0282b.a[networkStatus.ordinal()];
            if (i2 != 1 && i2 != 2) {
                c.a.p0.a.h0.i.d.f(h.swanapp_tip_waiting_and_retry);
            } else {
                c.a.p0.a.h0.i.d.f(h.swanapp_tip_get_pkg_poor_net);
            }
        }
    }
}
