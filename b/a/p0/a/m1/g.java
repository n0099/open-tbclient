package b.a.p0.a.m1;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.h;
import b.a.p0.a.j2.k;
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
public class g implements b.a.p0.a.h0.j.c, b.a.p0.a.h0.j.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6673d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f6674e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6675a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6676b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.m1.a f6677c;

    /* loaded from: classes.dex */
    public class a implements Action<b.a.p0.a.z1.b.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f6678a;

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
            this.f6678a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(b.a.p0.a.z1.b.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f6678a.h(new b.a.p0.a.m1.h.a(aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1329213193, "Lb/a/p0/a/m1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1329213193, "Lb/a/p0/a/m1/g;");
                return;
            }
        }
        f6673d = b.a.p0.a.a2.e.y;
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
        this.f6676b = false;
        this.f6677c = new b();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", b.a.p0.a.z1.b.b.a.class, 0, new a(this));
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
            if (f6674e == null) {
                synchronized (g.class) {
                    if (f6674e == null) {
                        f6674e = new g();
                    }
                }
            }
            return f6674e;
        }
        return (g) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.j.e
    public void a(b.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            boolean z = f6673d;
            h(new b.a.p0.a.m1.h.e(eVar, true));
        }
    }

    @Override // b.a.p0.a.h0.j.e
    public void b(b.a.p0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            boolean z = f6673d;
            h(new b.a.p0.a.m1.h.e(eVar, false));
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((b) this.f6677c).d() : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            b.a.p0.a.c1.a.Z().getSwitch("swan_white_screen_forward", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h(b.a.p0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f6677c.a(cVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(new b.a.p0.a.m1.h.c(11));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (f6673d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                sb.toString();
            }
            h(new b.a.p0.a.m1.h.b(z));
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && h.f6327e) {
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
            this.f6676b = true;
            h(new b.a.p0.a.m1.h.c(12, null, 0L, false));
            boolean z = f6673d;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f6676b) {
            h(new b.a.p0.a.m1.h.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f6673d) {
                String str = "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f6675a = z;
            if (z) {
                f.k();
                b.a.p0.a.j2.e.z();
                this.f6676b = false;
            }
        }
    }

    public void o() {
        b.a.p0.a.m1.h.c cVar;
        b.a K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long o = b.a.p0.a.c1.a.Z().o();
            if (f6673d) {
                String str = "start page monitoring, delay: " + o;
            }
            if (this.f6675a) {
                boolean g2 = g();
                if (f6673d) {
                    String str2 = "WhiteScreenForward: switch=" + g2;
                }
                SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
                if (g2 && activity != null && (K = b.a.p0.a.a2.d.g().r().K()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - K.M();
                    o -= currentTimeMillis;
                    if (o < 0) {
                        if (f6673d) {
                            String str3 = "WhiteScreenMonitor out of time: time=" + currentTimeMillis;
                        }
                        b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(40L);
                        aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                        b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                        dVar.q(k.m(K.F()));
                        dVar.p(aVar);
                        dVar.r(K);
                        k.L(dVar);
                    }
                }
                cVar = new b.a.p0.a.m1.h.c(1, null, o, true);
                this.f6675a = false;
                this.f6676b = false;
                if (h.f6327e) {
                    h(cVar);
                }
            } else {
                cVar = null;
            }
            if (f6673d) {
                String str4 = "WhiteScreenMonitor monitortime: " + o;
            }
            if (h.f6327e) {
                return;
            }
            if (cVar == null) {
                cVar = new b.a.p0.a.m1.h.c(1, null, o);
            }
            h(cVar);
        }
    }

    @Override // b.a.p0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
                return;
            }
            h(new b.a.p0.a.m1.h.c(3));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h(new b.a.p0.a.m1.h.c(9, null, 6000L));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean z = f6673d;
            h(new b.a.p0.a.m1.h.c(7));
        }
    }
}
