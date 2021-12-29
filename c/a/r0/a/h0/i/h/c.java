package c.a.r0.a.h0.i.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.r0.a.h0.i.g.b.a;
import c.a.r0.a.k;
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
    public static final boolean f6660g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.r0.a.h0.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.d.b f6661b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.a.h0.i.g.a.c f6662c;

    /* renamed from: d  reason: collision with root package name */
    public long f6663d;

    /* renamed from: e  reason: collision with root package name */
    public String f6664e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f6665f;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6666e;

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
            this.f6666e = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6666e.e(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.h0.i.g.a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.i.g.d.d f6667b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f6668c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f6669d;

        public b(c cVar, c.a.r0.a.h0.i.g.a.e eVar, c.a.r0.a.h0.i.g.d.d dVar, c.a.r0.a.z2.g1.c cVar2) {
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
            this.f6669d = cVar;
            this.a = eVar;
            this.f6667b = dVar;
            this.f6668c = cVar2;
        }

        @Override // c.a.r0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.a());
                sb.append(this.f6667b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f6667b.c());
                if (c.f6660g) {
                    String str = ">> " + sb.toString();
                }
                this.f6669d.f6664e = sb.toString();
                c.a.r0.a.z2.g1.c cVar = this.f6668c;
                if (cVar != null) {
                    cVar.onCallback(this.f6669d.f6664e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-149931405, "Lc/a/r0/a/h0/i/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-149931405, "Lc/a/r0/a/h0/i/h/c;");
                return;
            }
        }
        f6660g = k.a;
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
        this.f6663d = System.currentTimeMillis();
        this.f6664e = "";
        this.a = new c.a.r0.a.h0.i.g.b.a();
        this.f6661b = c.a.r0.a.h0.i.g.d.b.d();
        this.f6662c = c.a.r0.a.h0.i.g.a.c.d();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f6663d > 6000 : invokeV.booleanValue;
    }

    public void e(@Nullable c.a.r0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (!d() || TextUtils.isEmpty(this.f6664e)) {
                this.a.a(new b(this, this.f6662c.f(), this.f6661b.f(), cVar));
            } else if (cVar != null) {
                cVar.onCallback(this.f6664e);
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6664e : (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (timer = this.f6665f) == null) {
            return;
        }
        timer.cancel();
        this.f6665f = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = f6660g;
            g();
            Timer timer = new Timer();
            this.f6665f = timer;
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
