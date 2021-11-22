package b.a.p0.a.h0.i.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.a.p0.a.h0.i.g.b.a;
import b.a.p0.a.k;
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
    public static final boolean f5645g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.b.a f5646a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.d.b f5647b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a.p0.a.h0.i.g.a.c f5648c;

    /* renamed from: d  reason: collision with root package name */
    public long f5649d;

    /* renamed from: e  reason: collision with root package name */
    public String f5650e;

    /* renamed from: f  reason: collision with root package name */
    public Timer f5651f;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5652e;

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
            this.f5652e = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5652e.e(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.a.e f5653a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.i.g.d.d f5654b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f5655c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f5656d;

        public b(c cVar, b.a.p0.a.h0.i.g.a.e eVar, b.a.p0.a.h0.i.g.d.d dVar, b.a.p0.a.z2.g1.c cVar2) {
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
            this.f5656d = cVar;
            this.f5653a = eVar;
            this.f5654b = dVar;
            this.f5655c = cVar2;
        }

        @Override // b.a.p0.a.h0.i.g.b.a.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5653a.a());
                sb.append(this.f5654b.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.f5654b.c());
                if (c.f5645g) {
                    String str = ">> " + sb.toString();
                }
                this.f5656d.f5650e = sb.toString();
                b.a.p0.a.z2.g1.c cVar = this.f5655c;
                if (cVar != null) {
                    cVar.onCallback(this.f5656d.f5650e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858258198, "Lb/a/p0/a/h0/i/h/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1858258198, "Lb/a/p0/a/h0/i/h/c;");
                return;
            }
        }
        f5645g = k.f6863a;
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
        this.f5649d = System.currentTimeMillis();
        this.f5650e = "";
        this.f5646a = new b.a.p0.a.h0.i.g.b.a();
        this.f5647b = b.a.p0.a.h0.i.g.d.b.d();
        this.f5648c = b.a.p0.a.h0.i.g.a.c.d();
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? System.currentTimeMillis() - this.f5649d > 6000 : invokeV.booleanValue;
    }

    public void e(@Nullable b.a.p0.a.z2.g1.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (!d() || TextUtils.isEmpty(this.f5650e)) {
                this.f5646a.a(new b(this, this.f5648c.f(), this.f5647b.f(), cVar));
            } else if (cVar != null) {
                cVar.onCallback(this.f5650e);
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5650e : (String) invokeV.objValue;
    }

    public final void g() {
        Timer timer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (timer = this.f5651f) == null) {
            return;
        }
        timer.cancel();
        this.f5651f = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = f5645g;
            g();
            Timer timer = new Timer();
            this.f5651f = timer;
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
