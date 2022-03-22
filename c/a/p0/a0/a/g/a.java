package c.a.p0.a0.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.f;
import c.a.o0.k.d;
import c.a.p0.a0.a.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.UsbAbTestConst;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a i;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f11910b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11912d;

    /* renamed from: e  reason: collision with root package name */
    public long f11913e;

    /* renamed from: f  reason: collision with root package name */
    public SplashNativePolicy f11914f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.k.a f11915g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<c.a.p0.a0.a.g.b> f11916h;

    /* renamed from: c.a.p0.a0.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0908a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.k.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a0.a.g.b f11917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11918c;

        public RunnableC0908a(a aVar, c.a.o0.k.a aVar2, c.a.p0.a0.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11918c = aVar;
            this.a = aVar2;
            this.f11917b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.k.a aVar = this.a;
                if (aVar != null) {
                    aVar.e();
                }
                this.f11917b.show();
                c.a.o0.k.a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.b(String.valueOf((int) this.f11918c.f(this.f11917b)));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.g1.b.j().m();
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
        this.f11912d = false;
        this.f11913e = -1L;
        this.f11915g = null;
        this.f11916h = new ArrayList<>();
        this.a = c.a.o0.r.j0.b.k().l("splash_ad_strategy_key", 0);
        this.f11910b = c.a.o0.r.j0.b.k().l("splash_origin_ad_strategy_key", 1);
        q();
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (i == null) {
                synchronized (a.class) {
                    if (i == null) {
                        i = new a();
                    }
                }
            }
            return i;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
            while (it.hasNext()) {
                c.a.p0.a0.a.g.b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f11916h.clear();
            SplashNativePolicy splashNativePolicy = this.f11914f;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.f11914f = null;
            }
        }
    }

    public void c() {
        c.a.o0.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f11915g) == null) {
            return;
        }
        aVar.c("");
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(c.a.p0.a0.a.g.b bVar) {
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

    public final synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f11916h.isEmpty()) {
                    c cVar = new c(this.f11914f);
                    c.a.p0.a0.a.b bVar = new c.a.p0.a0.a.b(this.f11914f);
                    this.f11916h.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (f.w()) {
                            this.f11916h.add(cVar);
                        }
                    } else if (this.f11910b != 0) {
                        this.f11916h.add(cVar);
                    }
                    if (f.q(this.a)) {
                        this.f11916h.add(bVar);
                    }
                    if (c.a.o0.r.j0.b.k().h("key_is_jump_splash_ad", false)) {
                        j();
                        this.f11916h.clear();
                    }
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f.q(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
            while (it.hasNext()) {
                c.a.p0.a0.a.g.b next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void k() {
        c.a.o0.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.f11915g) == null) {
            return;
        }
        aVar.a();
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f11911c = false;
            g();
            Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
            while (it.hasNext()) {
                c.a.p0.a0.a.g.b next = it.next();
                if (i2 == 5 && (next instanceof c)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof c.a.p0.a0.a.b)) {
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void m(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            synchronized (this) {
                this.f11911c = false;
                this.f11913e = dVar.c();
                this.f11915g = dVar.a();
                this.f11912d = dVar.d();
                if (this.f11914f != null) {
                    this.f11914f.onSplashEvent(96);
                }
                g();
                c.a.p0.a0.a.i.a.c();
                Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
                while (it.hasNext()) {
                    it.next().e(dVar);
                }
            }
        }
    }

    public void n(c.a.o0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        o(aVar, true);
    }

    public synchronized void o(c.a.o0.k.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048588, this, aVar, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.f11911c) {
                return;
            }
            Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", f.q(this.a) ? 1 : 0).param("pid", this.f11910b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f11913e).eventStat();
                    }
                    if (aVar != null) {
                        aVar.c("");
                    }
                    return;
                }
                c.a.p0.a0.a.g.b next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.f11911c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.f11912d ? 2 : 1).param("fid", this.f11913e);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            c.a.p0.c4.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            e.a().post(new RunnableC0908a(this, aVar, next));
                        } else {
                            if (aVar != null) {
                                aVar.e();
                            }
                            next.show();
                            if (aVar != null) {
                                aVar.b(String.valueOf((int) f(next)));
                            }
                        }
                        c.a.o0.r.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", m.isEmpty(next.f()) ? "bes" : next.f());
                        return;
                    } else if (next.d() != AdLoadState.FAILED && z) {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            synchronized (this) {
                if (this.f11911c) {
                    return;
                }
                Iterator<c.a.p0.a0.a.g.b> it = this.f11916h.iterator();
                while (it.hasNext()) {
                    c.a.p0.a0.a.g.b next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof c.a.p0.a0.a.b : next instanceof c) && next.d() == AdLoadState.SUCCEED) {
                            this.f11911c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.f11912d ? 2 : 1).param("fid", this.f11913e);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                c.a.p0.c4.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.f11915g != null) {
                                this.f11915g.e();
                            }
                            next.show();
                            if (this.f11915g != null) {
                                this.f11915g.b(String.valueOf((int) f(next)));
                            }
                            c.a.p0.a0.a.i.a.d(String.valueOf((int) f(next)));
                            return;
                        }
                    }
                }
                if (this.f11915g != null) {
                    this.f11915g.c("");
                }
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (UbsABTestHelper.newSplashStrategy()) {
                SplashNativePolicy splashNativePolicy = this.f11914f;
                if (splashNativePolicy == null) {
                    SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                    this.f11914f = splashNativePolicy2;
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(f.u(), f.w(), f.v(), f.k(), f.l());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f11914f = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(f.u(), f.w(), f.v(), f.k(), f.l());
                PrintStream printStream2 = System.out;
                printStream2.println("SplashPolicy update result = " + updateSplashConfig);
                if (updateSplashConfig) {
                    return;
                }
                this.f11914f = null;
                return;
            }
            SplashNativePolicy splashNativePolicy3 = this.f11914f;
            if (splashNativePolicy3 != null) {
                splashNativePolicy3.releaseSplash();
            }
            this.f11914f = null;
        }
    }

    public void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            int e2 = c.a.d.f.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e3 = c.a.d.f.m.b.e(jSONObject.optString("ad_origin_config_switch"), 1);
            int e4 = c.a.d.f.m.b.e(jSONObject.optString("bear_sid_type"), 0);
            int e5 = c.a.d.f.m.b.e(jSONObject.optString(UsbAbTestConst.KEY_NEW_SPLASH_POLICY, "0"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("screen_fill_data_result");
            if (optJSONObject != null) {
                int e6 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_first_switch", com.tencent.connect.common.Constants.DEFAULT_UIN), 1000);
                int e7 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_second_switch", "1400"), 1400);
                int e8 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_bear_switch", "1"), 1);
                int e9 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_plj_switch", "1"), 1);
                int e10 = c.a.d.f.m.b.e(optJSONObject.optString("screen_fill_advertisement_plj_cpc_switch", "1"), 1);
                c.a.o0.r.j0.b.k().w("key_splash_new_policy_bear_enable", e8);
                c.a.o0.r.j0.b.k().w("key_splash_new_policy_plg_enable", e9);
                c.a.o0.r.j0.b.k().w("key_splash_new_policy_plg_cpc_enable", e10);
                c.a.o0.r.j0.b.k().w("key_splash_new_policy_first_timeout", e6);
                c.a.o0.r.j0.b.k().w("key_splash_new_policy_second_timeout", e7);
            }
            c.a.p0.a0.a.b.s(e4);
            c.a.o0.r.j0.b.k().w("splash_ad_strategy_key", e2);
            c.a.o0.r.j0.b.k().w("splash_origin_ad_strategy_key", e3);
            c.a.o0.r.j0.b.k().w("key_splash_new_policy_enable", e5);
            if (!h() && f.q(e2)) {
                if (n.B()) {
                    c.a.p0.g1.b.j().m();
                } else {
                    e.a().post(new b(this));
                }
            }
            this.a = e2;
            this.f11910b = e3;
        }
    }
}
