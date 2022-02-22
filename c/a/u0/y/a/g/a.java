package c.a.u0.y.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.b.d;
import c.a.t0.d1.f;
import c.a.u0.y.a.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static a f25308h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25309b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25310c;

    /* renamed from: d  reason: collision with root package name */
    public long f25311d;

    /* renamed from: e  reason: collision with root package name */
    public SplashNativePolicy f25312e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.l.a f25313f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<c.a.u0.y.a.g.b> f25314g;

    /* renamed from: c.a.u0.y.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1533a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.u0.y.a.g.b f25315e;

        public RunnableC1533a(a aVar, c.a.u0.y.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25315e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25315e.show();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.u0.f1.a.i().l();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25311d = -1L;
        this.f25313f = null;
        this.f25314g = new ArrayList<>();
        this.a = c.a.t0.s.j0.b.k().l("splash_ad_strategy_key", 0);
        this.f25309b = c.a.t0.s.j0.b.k().l("splash_origin_ad_strategy_key", 1);
        o();
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f25308h == null) {
                synchronized (a.class) {
                    if (f25308h == null) {
                        f25308h = new a();
                    }
                }
            }
            return f25308h;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
            while (it.hasNext()) {
                c.a.u0.y.a.g.b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f25314g.clear();
            SplashNativePolicy splashNativePolicy = this.f25312e;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.f25312e = null;
            }
        }
    }

    public void b() {
        c.a.t0.l.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f25313f) == null) {
            return;
        }
        aVar.c("");
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte e(c.a.u0.y.a.g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar == null) {
                return (byte) 0;
            }
            String f2 = bVar.f();
            char c2 = 65535;
            int hashCode = f2.hashCode();
            if (hashCode != -1348168235) {
                if (hashCode == 3019700 && f2.equals("bear")) {
                    c2 = 0;
                }
            } else if (f2.equals("prologue_gd")) {
                c2 = 1;
            }
            if (c2 != 0) {
                return c2 != 1 ? (byte) 0 : (byte) 5;
            }
            return (byte) 6;
        }
        return invokeL.byteValue;
    }

    public final synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f25314g.isEmpty()) {
                    c cVar = new c(this.f25312e);
                    c.a.u0.y.a.b bVar = new c.a.u0.y.a.b(this.f25312e);
                    this.f25314g.clear();
                    if (d.K0()) {
                        if (f.n()) {
                            this.f25314g.add(cVar);
                        }
                    } else if (this.f25309b != 0) {
                        this.f25314g.add(cVar);
                    }
                    if (f.i(this.a)) {
                        this.f25314g.add(bVar);
                    }
                    if (c.a.t0.s.j0.b.k().h("key_is_jump_splash_ad", false)) {
                        i();
                        this.f25314g.clear();
                    }
                }
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f.i(this.a) : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
            while (it.hasNext()) {
                c.a.u0.y.a.g.b next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f25310c = false;
            f();
            Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
            while (it.hasNext()) {
                c.a.u0.y.a.g.b next = it.next();
                if (i2 == 5 && (next instanceof c)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof c.a.u0.y.a.b)) {
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void k(c.a.t0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            synchronized (this) {
                this.f25310c = false;
                this.f25311d = dVar.c();
                this.f25313f = dVar.a();
                if (this.f25312e != null) {
                    this.f25312e.onSplashEvent(96);
                }
                f();
                Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
                while (it.hasNext()) {
                    it.next().e(dVar);
                }
            }
        }
    }

    public void l(c.a.t0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || d.K0()) {
            return;
        }
        m(aVar, true);
    }

    public synchronized void m(c.a.t0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048587, this, aVar, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.f25310c) {
                return;
            }
            Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", f.i(this.a) ? 1 : 0).param("pid", this.f25309b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f25311d).eventStat();
                    }
                    if (aVar != null) {
                        aVar.c("");
                    }
                    return;
                }
                c.a.u0.y.a.g.b next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.f25310c = true;
                        if (aVar != null) {
                            aVar.d(String.valueOf((int) e(next)));
                        }
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f25311d);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            c.a.u0.c4.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            e.a().post(new RunnableC1533a(this, next));
                        } else {
                            next.show();
                        }
                        c.a.t0.s.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", m.isEmpty(next.f()) ? "bes" : next.f());
                        return;
                    } else if (next.d() != AdLoadState.FAILED && z) {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            synchronized (this) {
                if (this.f25310c) {
                    return;
                }
                Iterator<c.a.u0.y.a.g.b> it = this.f25314g.iterator();
                while (it.hasNext()) {
                    c.a.u0.y.a.g.b next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof c.a.u0.y.a.b : next instanceof c) && next.d() == AdLoadState.SUCCEED) {
                            this.f25310c = true;
                            if (this.f25313f != null) {
                                this.f25313f.d(String.valueOf((int) e(next)));
                            }
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) e(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f25311d);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            next.show();
                            return;
                        }
                    }
                }
                if (this.f25313f != null) {
                    this.f25313f.c("");
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (d.K0()) {
                SplashNativePolicy splashNativePolicy = this.f25312e;
                if (splashNativePolicy == null) {
                    SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                    this.f25312e = splashNativePolicy2;
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(f.l(), f.n(), f.m(), f.e(), f.f());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f25312e = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(f.l(), f.n(), f.m(), f.e(), f.f());
                PrintStream printStream2 = System.out;
                printStream2.println("SplashPolicy update result = " + updateSplashConfig);
                if (updateSplashConfig) {
                    return;
                }
                this.f25312e = null;
                return;
            }
            SplashNativePolicy splashNativePolicy3 = this.f25312e;
            if (splashNativePolicy3 != null) {
                splashNativePolicy3.releaseSplash();
            }
            this.f25312e = null;
        }
    }

    public void p(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            int e2 = c.a.d.f.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e3 = c.a.d.f.m.b.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e4 = c.a.d.f.m.b.e(jSONObject.optString("bear_sid_type"), 0);
            int e5 = c.a.d.f.m.b.e(jSONObject.optString("12_20_0_screen_fill_Ad_experiment", "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e6 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e7 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e8 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e9 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e10 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                c.a.t0.s.j0.b.k().w("key_splash_new_policy_bear_enable", e8);
                c.a.t0.s.j0.b.k().w("key_splash_new_policy_plg_enable", e9);
                c.a.t0.s.j0.b.k().w("key_splash_new_policy_plg_cpc_enable", e10);
                c.a.t0.s.j0.b.k().w("key_splash_new_policy_first_timeout", e6);
                c.a.t0.s.j0.b.k().w("key_splash_new_policy_second_timeout", e7);
            }
            c.a.u0.y.a.b.t(e4);
            c.a.t0.s.j0.b.k().w("splash_ad_strategy_key", e2);
            c.a.t0.s.j0.b.k().w("splash_origin_ad_strategy_key", e3);
            c.a.t0.s.j0.b.k().w("key_splash_new_policy_enable", e5);
            if (!g() && f.i(e2)) {
                if (n.B()) {
                    c.a.u0.f1.a.i().l();
                } else {
                    e.a().post(new b(this));
                }
            }
            this.a = e2;
            this.f25309b = e3;
        }
    }
}
