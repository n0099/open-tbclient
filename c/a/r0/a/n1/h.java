package c.a.r0.a.n1;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.n2.i;
import c.a.r0.a.n2.n;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class h implements c.a.r0.a.h0.j.c, c.a.r0.a.h0.j.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f8037d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h f8038e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8039b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.n1.a f8040c;

    /* loaded from: classes.dex */
    public class a implements Action<c.a.r0.a.c2.b.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(c.a.r0.a.c2.b.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.f(new c.a.r0.a.n1.i.a(aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431551110, "Lc/a/r0/a/n1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431551110, "Lc/a/r0/a/n1/h;");
                return;
            }
        }
        f8037d = c.a.r0.a.d2.e.z;
    }

    public h() {
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
        this.f8039b = false;
        this.f8040c = new b();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", c.a.r0.a.c2.b.b.a.class, 0, new a(this));
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            c.a();
        }
    }

    @NonNull
    public static h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8038e == null) {
                synchronized (h.class) {
                    if (f8038e == null) {
                        f8038e = new h();
                    }
                }
            }
            return f8038e;
        }
        return (h) invokeV.objValue;
    }

    @Override // c.a.r0.a.h0.j.e
    public void a(c.a.r0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            boolean z = f8037d;
            f(new c.a.r0.a.n1.i.e(eVar, true));
        }
    }

    @Override // c.a.r0.a.h0.j.e
    public void b(c.a.r0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            boolean z = f8037d;
            f(new c.a.r0.a.n1.i.e(eVar, false));
        }
    }

    public final void f(c.a.r0.a.n1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f8040c.a(cVar);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new c.a.r0.a.n1.i.c(11));
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (f8037d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                sb.toString();
            }
            f(new c.a.r0.a.n1.i.b(z));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && i.f8084d) {
            if (z) {
                k();
            } else {
                j();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f8039b = true;
            f(new c.a.r0.a.n1.i.c(12, null, 0L, false));
            boolean z = f8037d;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f8039b) {
            f(new c.a.r0.a.n1.i.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f8037d) {
                String str = "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z) {
                g.k();
                c.a.r0.a.n2.e.z();
                this.f8039b = false;
            }
        }
    }

    public void m() {
        c.a.r0.a.n1.i.c cVar;
        b.a V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = c.a.r0.a.c1.a.g0().n();
            if (f8037d) {
                String str = "start page monitoring, delay: " + n;
            }
            if (this.a) {
                if (c.a.r0.a.g1.f.U().getActivity() != null && (V = c.a.r0.a.d2.d.J().r().V()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - V.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (f8037d) {
                            String str2 = "WhiteScreenMonitor out of time: time=" + currentTimeMillis;
                        }
                        c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(40L);
                        aVar.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
                        dVar.q(n.n(V.G()));
                        dVar.p(aVar);
                        dVar.r(V);
                        n.R(dVar);
                    }
                }
                cVar = new c.a.r0.a.n1.i.c(1, null, n, true);
                this.a = false;
                c.a.r0.a.h0.i.g.c.g.b().e(n);
                this.f8039b = false;
                if (i.f8084d) {
                    f(cVar);
                }
            } else {
                cVar = null;
            }
            if (f8037d) {
                String str3 = "WhiteScreenMonitor monitortime: " + n;
            }
            if (i.f8084d) {
                return;
            }
            if (cVar == null) {
                cVar = new c.a.r0.a.n1.i.c(1, null, n);
            }
            f(cVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new c.a.r0.a.n1.i.c(9, null, 6000L));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean z = f8037d;
            f(new c.a.r0.a.n1.i.c(7));
        }
    }

    @Override // c.a.r0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
                return;
            }
            f(new c.a.r0.a.n1.i.c(3));
        }
    }
}
