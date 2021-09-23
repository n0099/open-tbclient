package c.a.p0.a.m1;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.j2.h;
import c.a.p0.a.j2.k;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g implements c.a.p0.a.h0.j.c, c.a.p0.a.h0.j.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f7364d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f7365e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f7366a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7367b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.a.m1.a f7368c;

    /* loaded from: classes.dex */
    public class a implements Action<c.a.p0.a.z1.b.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f7369a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7369a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(c.a.p0.a.z1.b.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f7369a.h(new c.a.p0.a.m1.h.a(aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823654568, "Lc/a/p0/a/m1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823654568, "Lc/a/p0/a/m1/g;");
                return;
            }
        }
        f7364d = c.a.p0.a.a2.e.y;
    }

    public g() {
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
        this.f7367b = false;
        this.f7368c = new b();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", c.a.p0.a.z1.b.b.a.class, 0, new a(this));
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            c.a();
        }
    }

    @NonNull
    public static g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f7365e == null) {
                synchronized (g.class) {
                    if (f7365e == null) {
                        f7365e = new g();
                    }
                }
            }
            return f7365e;
        }
        return (g) invokeV.objValue;
    }

    @Override // c.a.p0.a.h0.j.e
    public void a(c.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            boolean z = f7364d;
            h(new c.a.p0.a.m1.h.e(eVar, true));
        }
    }

    @Override // c.a.p0.a.h0.j.e
    public void b(c.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            boolean z = f7364d;
            h(new c.a.p0.a.m1.h.e(eVar, false));
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((b) this.f7368c).d() : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.a.c1.a.Z().getSwitch("swan_white_screen_forward", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h(c.a.p0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f7368c.a(cVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(new c.a.p0.a.m1.h.c(11));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (f7364d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                sb.toString();
            }
            h(new c.a.p0.a.m1.h.b(z));
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && h.f7012e) {
            if (z) {
                m();
            } else {
                l();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f7367b = true;
            h(new c.a.p0.a.m1.h.c(12, null, 0L, false));
            boolean z = f7364d;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f7367b) {
            h(new c.a.p0.a.m1.h.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f7364d) {
                String str = "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f7366a = z;
            if (z) {
                f.k();
                c.a.p0.a.j2.e.z();
                this.f7367b = false;
            }
        }
    }

    public void o() {
        c.a.p0.a.m1.h.c cVar;
        b.a L;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long o = c.a.p0.a.c1.a.Z().o();
            if (f7364d) {
                String str = "start page monitoring, delay: " + o;
            }
            if (this.f7366a) {
                boolean g2 = g();
                if (f7364d) {
                    String str2 = "WhiteScreenForward: switch=" + g2;
                }
                SwanAppActivity activity = c.a.p0.a.g1.f.V().getActivity();
                if (g2 && activity != null && (L = c.a.p0.a.a2.d.g().r().L()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - L.N();
                    o -= currentTimeMillis;
                    if (o < 0) {
                        if (f7364d) {
                            String str3 = "WhiteScreenMonitor out of time: time=" + currentTimeMillis;
                        }
                        c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(40L);
                        aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                        c.a.p0.a.j2.p.d dVar = new c.a.p0.a.j2.p.d();
                        dVar.q(k.m(L.G()));
                        dVar.p(aVar);
                        dVar.r(L);
                        k.L(dVar);
                    }
                }
                cVar = new c.a.p0.a.m1.h.c(1, null, o, true);
                this.f7366a = false;
                this.f7367b = false;
                if (h.f7012e) {
                    h(cVar);
                }
            } else {
                cVar = null;
            }
            if (f7364d) {
                String str4 = "WhiteScreenMonitor monitortime: " + o;
            }
            if (h.f7012e) {
                return;
            }
            if (cVar == null) {
                cVar = new c.a.p0.a.m1.h.c(1, null, o);
            }
            h(cVar);
        }
    }

    @Override // c.a.p0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
                return;
            }
            h(new c.a.p0.a.m1.h.c(3));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h(new c.a.p0.a.m1.h.c(9, null, 6000L));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean z = f7364d;
            h(new c.a.p0.a.m1.h.c(7));
        }
    }
}
