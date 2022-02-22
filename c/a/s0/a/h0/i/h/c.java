package c.a.s0.a.h0.i.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.s0.a.h0.i.g.b.a;
import c.a.s0.a.k;
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
    public static final boolean f6761g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.s0.a.h0.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.s0.a.h0.i.g.d.b f6762b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.s0.a.h0.i.g.a.c f6763c;

    /* renamed from: d  reason: collision with root package name */
    public long f6764d;

    /* renamed from: e  reason: collision with root package name */
    public String f6765e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f6766f;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6767e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6767e = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6767e.e(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.h0.i.g.a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.i.g.d.d f6768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.z2.g1.c f6769c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f6770d;

        public b(c cVar, c.a.s0.a.h0.i.g.a.e eVar, c.a.s0.a.h0.i.g.d.d dVar, c.a.s0.a.z2.g1.c cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, dVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6770d = cVar;
            this.a = eVar;
            this.f6768b = dVar;
            this.f6769c = cVar2;
        }

        @Override // c.a.s0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.a());
                sb.append(this.f6768b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f6768b.c());
                if (c.f6761g) {
                    String str = ">> " + sb.toString();
                }
                this.f6770d.f6765e = sb.toString();
                c.a.s0.a.z2.g1.c cVar = this.f6769c;
                if (cVar != null) {
                    cVar.onCallback(this.f6770d.f6765e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-655490030, "Lc/a/s0/a/h0/i/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-655490030, "Lc/a/s0/a/h0/i/h/c;");
                return;
            }
        }
        f6761g = k.a;
    }

    public c() {
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
        this.f6764d = System.currentTimeMillis();
        this.f6765e = "";
        this.a = new c.a.s0.a.h0.i.g.b.a();
        this.f6762b = c.a.s0.a.h0.i.g.d.b.d();
        this.f6763c = c.a.s0.a.h0.i.g.a.c.d();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f6764d > 6000 : invokeV.booleanValue;
    }

    public void e(@Nullable c.a.s0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (!d() || TextUtils.isEmpty(this.f6765e)) {
                this.a.a(new b(this, this.f6763c.f(), this.f6762b.f(), cVar));
            } else if (cVar != null) {
                cVar.onCallback(this.f6765e);
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6765e : (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (timer = this.f6766f) == null) {
            return;
        }
        timer.cancel();
        this.f6766f = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = f6761g;
            g();
            Timer timer = new Timer();
            this.f6766f = timer;
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
