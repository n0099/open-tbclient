package c.a.r0.y.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.c1.f;
import c.a.q0.k.d;
import c.a.r0.y.a.c;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static a f24670h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f24671b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24672c;

    /* renamed from: d  reason: collision with root package name */
    public long f24673d;

    /* renamed from: e  reason: collision with root package name */
    public SplashNativePolicy f24674e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.k.a f24675f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<c.a.r0.y.a.g.b> f24676g;

    /* renamed from: c.a.r0.y.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1518a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.k.a f24677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.y.a.g.b f24678f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f24679g;

        public RunnableC1518a(a aVar, c.a.q0.k.a aVar2, c.a.r0.y.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24679g = aVar;
            this.f24677e = aVar2;
            this.f24678f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.k.a aVar = this.f24677e;
                if (aVar != null) {
                    aVar.d();
                }
                this.f24678f.show();
                c.a.q0.k.a aVar2 = this.f24677e;
                if (aVar2 != null) {
                    aVar2.a(String.valueOf((int) this.f24679g.f(this.f24678f)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                c.a.r0.e1.a.i().l();
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
        this.f24673d = -1L;
        this.f24675f = null;
        this.f24676g = new ArrayList<>();
        this.a = c.a.q0.r.j0.b.k().l("splash_ad_strategy_key", 0);
        this.f24671b = c.a.q0.r.j0.b.k().l("splash_origin_ad_strategy_key", 1);
        p();
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f24670h == null) {
                synchronized (a.class) {
                    if (f24670h == null) {
                        f24670h = new a();
                    }
                }
            }
            return f24670h;
        }
        return (a) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
            while (it.hasNext()) {
                c.a.r0.y.a.g.b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f24676g.clear();
            SplashNativePolicy splashNativePolicy = this.f24674e;
            if (splashNativePolicy != null) {
                splashNativePolicy.releaseSplash();
                this.f24674e = null;
            }
        }
    }

    public void c() {
        c.a.q0.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f24675f) == null) {
            return;
        }
        aVar.c("");
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public final byte f(c.a.r0.y.a.g.b bVar) {
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
                if (this.f24676g.isEmpty()) {
                    c cVar = new c(this.f24674e);
                    c.a.r0.y.a.b bVar = new c.a.r0.y.a.b(this.f24674e);
                    this.f24676g.clear();
                    if (UbsABTestHelper.newSplashStrategy()) {
                        if (f.n()) {
                            this.f24676g.add(cVar);
                        }
                    } else if (this.f24671b != 0) {
                        this.f24676g.add(cVar);
                    }
                    if (f.i(this.a)) {
                        this.f24676g.add(bVar);
                    }
                    if (c.a.q0.r.j0.b.k().h("key_is_jump_splash_ad", false)) {
                        j();
                        this.f24676g.clear();
                    }
                }
            }
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f.i(this.a) : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
            while (it.hasNext()) {
                c.a.r0.y.a.g.b next = it.next();
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

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f24672c = false;
            g();
            Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
            while (it.hasNext()) {
                c.a.r0.y.a.g.b next = it.next();
                if (i2 == 5 && (next instanceof c)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof c.a.r0.y.a.b)) {
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            synchronized (this) {
                this.f24672c = false;
                this.f24673d = dVar.c();
                this.f24675f = dVar.a();
                if (this.f24674e != null) {
                    this.f24674e.onSplashEvent(96);
                }
                g();
                c.a.r0.y.a.i.a.c();
                Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
                while (it.hasNext()) {
                    it.next().e(dVar);
                }
            }
        }
    }

    public void m(c.a.q0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || UbsABTestHelper.newSplashStrategy()) {
            return;
        }
        n(aVar, true);
    }

    public synchronized void n(c.a.q0.k.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048587, this, aVar, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.f24672c) {
                return;
            }
            Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", f.i(this.a) ? 1 : 0).param("pid", this.f24671b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f24673d).eventStat();
                    }
                    if (aVar != null) {
                        aVar.c("");
                    }
                    return;
                }
                c.a.r0.y.a.g.b next = it.next();
                if (next != null) {
                    if (next.d() == AdLoadState.SUCCEED) {
                        this.f24672c = true;
                        StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f24673d);
                        if (!StringUtils.isNull(next.c())) {
                            param.param(TiebaStatic.Params.OBJ_TO, next.c());
                        }
                        param.eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            c.a.r0.a4.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            e.a().post(new RunnableC1518a(this, aVar, next));
                        } else {
                            if (aVar != null) {
                                aVar.d();
                            }
                            next.show();
                            if (aVar != null) {
                                aVar.a(String.valueOf((int) f(next)));
                            }
                        }
                        c.a.q0.r.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", m.isEmpty(next.f()) ? "bes" : next.f());
                        return;
                    } else if (next.d() != AdLoadState.FAILED && z) {
                        return;
                    }
                }
            }
        }
    }

    public synchronized void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            synchronized (this) {
                if (this.f24672c) {
                    return;
                }
                Iterator<c.a.r0.y.a.g.b> it = this.f24676g.iterator();
                while (it.hasNext()) {
                    c.a.r0.y.a.g.b next = it.next();
                    if (next != null) {
                        if ((z ? next instanceof c.a.r0.y.a.b : next instanceof c) && next.d() == AdLoadState.SUCCEED) {
                            this.f24672c = true;
                            StatisticItem param = StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", (int) f(next)).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f24673d);
                            if (!StringUtils.isNull(next.c())) {
                                param.param(TiebaStatic.Params.OBJ_TO, next.c());
                            }
                            param.eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                c.a.r0.a4.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            }
                            if (this.f24675f != null) {
                                this.f24675f.d();
                            }
                            next.show();
                            if (this.f24675f != null) {
                                this.f24675f.a(String.valueOf((int) f(next)));
                            }
                            c.a.r0.y.a.i.a.d(String.valueOf((int) f(next)));
                            return;
                        }
                    }
                }
                if (this.f24675f != null) {
                    this.f24675f.c("");
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (UbsABTestHelper.newSplashStrategy()) {
                SplashNativePolicy splashNativePolicy = this.f24674e;
                if (splashNativePolicy == null) {
                    SplashNativePolicy splashNativePolicy2 = new SplashNativePolicy();
                    this.f24674e = splashNativePolicy2;
                    boolean initSplashPolicy = splashNativePolicy2.initSplashPolicy(f.l(), f.n(), f.m(), f.e(), f.f());
                    PrintStream printStream = System.out;
                    printStream.println("SplashPolicy init result = " + initSplashPolicy);
                    if (initSplashPolicy) {
                        return;
                    }
                    this.f24674e = null;
                    return;
                }
                boolean updateSplashConfig = splashNativePolicy.updateSplashConfig(f.l(), f.n(), f.m(), f.e(), f.f());
                PrintStream printStream2 = System.out;
                printStream2.println("SplashPolicy update result = " + updateSplashConfig);
                if (updateSplashConfig) {
                    return;
                }
                this.f24674e = null;
                return;
            }
            SplashNativePolicy splashNativePolicy3 = this.f24674e;
            if (splashNativePolicy3 != null) {
                splashNativePolicy3.releaseSplash();
            }
            this.f24674e = null;
        }
    }

    public void q(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
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
                c.a.q0.r.j0.b.k().w("key_splash_new_policy_bear_enable", e8);
                c.a.q0.r.j0.b.k().w("key_splash_new_policy_plg_enable", e9);
                c.a.q0.r.j0.b.k().w("key_splash_new_policy_plg_cpc_enable", e10);
                c.a.q0.r.j0.b.k().w("key_splash_new_policy_first_timeout", e6);
                c.a.q0.r.j0.b.k().w("key_splash_new_policy_second_timeout", e7);
            }
            c.a.r0.y.a.b.s(e4);
            c.a.q0.r.j0.b.k().w("splash_ad_strategy_key", e2);
            c.a.q0.r.j0.b.k().w("splash_origin_ad_strategy_key", e3);
            c.a.q0.r.j0.b.k().w("key_splash_new_policy_enable", e5);
            if (!h() && f.i(e2)) {
                if (n.B()) {
                    c.a.r0.e1.a.i().l();
                } else {
                    e.a().post(new b(this));
                }
            }
            this.a = e2;
            this.f24671b = e3;
        }
    }
}
