package c.a.n0.a.x.i.h;

import android.util.Log;
import c.a.n0.a.x.i.g.b.a;
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
    public static final boolean f7133d;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.d.b f7134b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.a.c f7135c;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.i.g.d.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.i.g.a.e f7136b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f7137c;

        public a(b bVar, c.a.n0.a.x.i.g.d.d dVar, c.a.n0.a.x.i.g.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7137c = bVar;
            this.a = dVar;
            this.f7136b = eVar;
        }

        @Override // c.a.n0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                c.a.n0.a.x.i.e.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.f7136b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (b.f7133d) {
                    Log.d("SceneInitDataTips", ">> " + sb.toString());
                }
                c.a.n0.a.x.i.f.g(sb.toString());
                this.f7137c.d(networkStatus);
            }
        }
    }

    /* renamed from: c.a.n0.a.x.i.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0541b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(518918836, "Lc/a/n0/a/x/i/h/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(518918836, "Lc/a/n0/a/x/i/h/b$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536888462, "Lc/a/n0/a/x/i/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1536888462, "Lc/a/n0/a/x/i/h/b;");
                return;
            }
        }
        f7133d = c.a.n0.a.a.a;
    }

    public b() {
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
        this.f7135c = c.a.n0.a.x.i.g.a.c.d();
        this.a = new c.a.n0.a.x.i.g.b.a();
        this.f7134b = c.a.n0.a.x.i.g.d.b.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f7133d) {
                Log.d("SceneInitDataTips", ">> trigger init data error event.");
            }
            c.a.n0.a.x.i.g.d.b.d().j();
            c.a.n0.a.x.i.g.a.c.d().j();
            c.a.n0.a.x.i.g.a.e f2 = this.f7135c.f();
            this.a.a(new a(this, this.f7134b.f(), f2));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i = C0541b.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                c.a.n0.a.x.i.d.f(R.string.obfuscated_res_0x7f0f12e6);
            } else {
                c.a.n0.a.x.i.d.f(R.string.obfuscated_res_0x7f0f12dc);
            }
        }
    }
}
