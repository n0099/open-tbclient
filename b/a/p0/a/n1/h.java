package b.a.p0.a.n1;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.n2.i;
import b.a.p0.a.n2.n;
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
public class h implements b.a.p0.a.h0.j.c, b.a.p0.a.h0.j.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7248d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile h f7249e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f7250a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7251b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.n1.a f7252c;

    /* loaded from: classes.dex */
    public class a implements Action<b.a.p0.a.c2.b.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f7253a;

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
            this.f7253a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(b.a.p0.a.c2.b.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f7253a.f(new b.a.p0.a.n1.i.a(aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330136745, "Lb/a/p0/a/n1/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330136745, "Lb/a/p0/a/n1/h;");
                return;
            }
        }
        f7248d = b.a.p0.a.d2.e.z;
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
        this.f7251b = false;
        this.f7252c = new b();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", b.a.p0.a.c2.b.b.a.class, 0, new a(this));
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
            if (f7249e == null) {
                synchronized (h.class) {
                    if (f7249e == null) {
                        f7249e = new h();
                    }
                }
            }
            return f7249e;
        }
        return (h) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.j.e
    public void a(b.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            boolean z = f7248d;
            f(new b.a.p0.a.n1.i.e(eVar, true));
        }
    }

    @Override // b.a.p0.a.h0.j.e
    public void b(b.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            boolean z = f7248d;
            f(new b.a.p0.a.n1.i.e(eVar, false));
        }
    }

    public final void f(b.a.p0.a.n1.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f7252c.a(cVar);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new b.a.p0.a.n1.i.c(11));
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (f7248d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                sb.toString();
            }
            f(new b.a.p0.a.n1.i.b(z));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && i.f7306d) {
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
            this.f7251b = true;
            f(new b.a.p0.a.n1.i.c(12, null, 0L, false));
            boolean z = f7248d;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f7251b) {
            f(new b.a.p0.a.n1.i.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f7248d) {
                String str = "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f7250a = z;
            if (z) {
                g.k();
                b.a.p0.a.n2.e.z();
                this.f7251b = false;
            }
        }
    }

    public void m() {
        b.a.p0.a.n1.i.c cVar;
        b.a V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = b.a.p0.a.c1.a.g0().n();
            if (f7248d) {
                String str = "start page monitoring, delay: " + n;
            }
            if (this.f7250a) {
                if (b.a.p0.a.g1.f.U().getActivity() != null && (V = b.a.p0.a.d2.d.J().r().V()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - V.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (f7248d) {
                            String str2 = "WhiteScreenMonitor out of time: time=" + currentTimeMillis;
                        }
                        b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                        aVar.k(5L);
                        aVar.i(40L);
                        aVar.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
                        dVar.q(n.n(V.G()));
                        dVar.p(aVar);
                        dVar.r(V);
                        n.R(dVar);
                    }
                }
                cVar = new b.a.p0.a.n1.i.c(1, null, n, true);
                this.f7250a = false;
                b.a.p0.a.h0.i.g.c.g.b().e(n);
                this.f7251b = false;
                if (i.f7306d) {
                    f(cVar);
                }
            } else {
                cVar = null;
            }
            if (f7248d) {
                String str3 = "WhiteScreenMonitor monitortime: " + n;
            }
            if (i.f7306d) {
                return;
            }
            if (cVar == null) {
                cVar = new b.a.p0.a.n1.i.c(1, null, n);
            }
            f(cVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new b.a.p0.a.n1.i.c(9, null, 6000L));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean z = f7248d;
            f(new b.a.p0.a.n1.i.c(7));
        }
    }

    @Override // b.a.p0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
                return;
            }
            f(new b.a.p0.a.n1.i.c(3));
        }
    }
}
