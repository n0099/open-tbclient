package b.a.p0.a.h0.i.h;

import b.a.p0.a.h;
import b.a.p0.a.h0.i.g.b.a;
import b.a.p0.a.k;
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
    public static final boolean f5637d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.b.a f5638a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.d.b f5639b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.a.c f5640c;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.d.d f5641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.a.e f5642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5643c;

        public a(b bVar, b.a.p0.a.h0.i.g.d.d dVar, b.a.p0.a.h0.i.g.a.e eVar) {
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
            this.f5643c = bVar;
            this.f5641a = dVar;
            this.f5642b = eVar;
        }

        @Override // b.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                b.a.p0.a.h0.i.e.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.f5641a.e().getStatus(), this.f5641a.g(), this.f5641a.b(), this.f5641a.f(), this.f5641a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.f5642b.a());
                sb.append(this.f5641a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f5641a.c());
                if (b.f5637d) {
                    String str = ">> " + sb.toString();
                }
                b.a.p0.a.h0.i.f.g(sb.toString());
                this.f5643c.d(networkStatus);
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.i.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0226b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5644a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-920315655, "Lb/a/p0/a/h0/i/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-920315655, "Lb/a/p0/a/h0/i/h/b$b;");
                    return;
                }
            }
            int[] iArr = new int[NetworkStatus.values().length];
            f5644a = iArr;
            try {
                iArr[NetworkStatus.NETWORK_BAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5644a[NetworkStatus.NETWORK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858258167, "Lb/a/p0/a/h0/i/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858258167, "Lb/a/p0/a/h0/i/h/b;");
                return;
            }
        }
        f5637d = k.f6863a;
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
        this.f5640c = b.a.p0.a.h0.i.g.a.c.d();
        this.f5638a = new b.a.p0.a.h0.i.g.b.a();
        this.f5639b = b.a.p0.a.h0.i.g.d.b.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = f5637d;
            b.a.p0.a.h0.i.g.d.b.d().j();
            b.a.p0.a.h0.i.g.a.c.d().j();
            b.a.p0.a.h0.i.g.a.e f2 = this.f5640c.f();
            this.f5638a.a(new a(this, this.f5639b.f(), f2));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i2 = C0226b.f5644a[networkStatus.ordinal()];
            if (i2 != 1 && i2 != 2) {
                b.a.p0.a.h0.i.d.f(h.swanapp_tip_waiting_and_retry);
            } else {
                b.a.p0.a.h0.i.d.f(h.swanapp_tip_get_pkg_poor_net);
            }
        }
    }
}
