package c.a.n0.a.x.i.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import c.a.n0.a.x.i.g.b.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f7138g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.n0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.d.b f7139b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.n0.a.x.i.g.a.c f7140c;

    /* renamed from: d  reason: collision with root package name */
    public long f7141d;

    /* renamed from: e  reason: collision with root package name */
    public String f7142e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f7143f;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.i.g.a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.i.g.d.d f7144b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.p2.g1.c f7145c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f7146d;

        public b(c cVar, c.a.n0.a.x.i.g.a.e eVar, c.a.n0.a.x.i.g.d.d dVar, c.a.n0.a.p2.g1.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, dVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7146d = cVar;
            this.a = eVar;
            this.f7144b = dVar;
            this.f7145c = cVar2;
        }

        @Override // c.a.n0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.a());
                sb.append(this.f7144b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f7144b.c());
                if (c.f7138g) {
                    Log.d("SceneLaunchDefaultTips", ">> " + sb.toString());
                }
                this.f7146d.f7142e = sb.toString();
                c.a.n0.a.p2.g1.c cVar = this.f7145c;
                if (cVar != null) {
                    cVar.onCallback(this.f7146d.f7142e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536888431, "Lc/a/n0/a/x/i/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1536888431, "Lc/a/n0/a/x/i/h/c;");
                return;
            }
        }
        f7138g = c.a.n0.a.a.a;
    }

    public c() {
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
        this.f7141d = System.currentTimeMillis();
        this.f7142e = "";
        this.a = new c.a.n0.a.x.i.g.b.a();
        this.f7139b = c.a.n0.a.x.i.g.d.b.d();
        this.f7140c = c.a.n0.a.x.i.g.a.c.d();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f7141d > 6000 : invokeV.booleanValue;
    }

    public void e(@Nullable c.a.n0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (!d() || TextUtils.isEmpty(this.f7142e)) {
                this.a.a(new b(this, this.f7140c.f(), this.f7139b.f(), cVar));
            } else if (cVar != null) {
                cVar.onCallback(this.f7142e);
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f7142e : (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (timer = this.f7143f) == null) {
            return;
        }
        timer.cancel();
        this.f7143f = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f7138g) {
                Log.d("SceneLaunchDefaultTips", ">> start to collect default launch info.");
            }
            g();
            Timer timer = new Timer();
            this.f7143f = timer;
            timer.schedule(new a(this), 6000L);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
        }
    }
}
