package c.a.p0.a.x.i.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.x.i.g.b.a;
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
    public static final boolean f8494g;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.p0.a.x.i.g.b.a a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.d.b f8495b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a.x.i.g.a.c f8496c;

    /* renamed from: d  reason: collision with root package name */
    public long f8497d;

    /* renamed from: e  reason: collision with root package name */
    public String f8498e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f8499f;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8500e;

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
            this.f8500e = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8500e.e(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.x.i.g.a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.i.g.d.d f8501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.p2.g1.c f8502c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f8503d;

        public b(c cVar, c.a.p0.a.x.i.g.a.e eVar, c.a.p0.a.x.i.g.d.d dVar, c.a.p0.a.p2.g1.c cVar2) {
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
            this.f8503d = cVar;
            this.a = eVar;
            this.f8501b = dVar;
            this.f8502c = cVar2;
        }

        @Override // c.a.p0.a.x.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.a.a());
                sb.append(this.f8501b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f8501b.c());
                if (c.f8494g) {
                    String str = ">> " + sb.toString();
                }
                this.f8503d.f8498e = sb.toString();
                c.a.p0.a.p2.g1.c cVar = this.f8502c;
                if (cVar != null) {
                    cVar.onCallback(this.f8503d.f8498e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2123694445, "Lc/a/p0/a/x/i/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2123694445, "Lc/a/p0/a/x/i/h/c;");
                return;
            }
        }
        f8494g = c.a.p0.a.a.a;
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
        this.f8497d = System.currentTimeMillis();
        this.f8498e = "";
        this.a = new c.a.p0.a.x.i.g.b.a();
        this.f8495b = c.a.p0.a.x.i.g.d.b.d();
        this.f8496c = c.a.p0.a.x.i.g.a.c.d();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f8497d > 6000 : invokeV.booleanValue;
    }

    public void e(@Nullable c.a.p0.a.p2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (!d() || TextUtils.isEmpty(this.f8498e)) {
                this.a.a(new b(this, this.f8496c.f(), this.f8495b.f(), cVar));
            } else if (cVar != null) {
                cVar.onCallback(this.f8498e);
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f8498e : (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (timer = this.f8499f) == null) {
            return;
        }
        timer.cancel();
        this.f8499f = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = f8494g;
            g();
            Timer timer = new Timer();
            this.f8499f = timer;
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
