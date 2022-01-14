package c.a.t0.y.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.i0.b.f.f;
import c.a.s0.l.d;
import c.a.t0.y.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.tblauncher.MainTabScheduleStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f25631f;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f25632b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25633c;

    /* renamed from: d  reason: collision with root package name */
    public long f25634d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c.a.t0.y.a.g.b> f25635e;

    /* renamed from: c.a.t0.y.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1550a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.y.a.g.b f25636e;

        public RunnableC1550a(a aVar, c.a.t0.y.a.g.b bVar) {
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
            this.f25636e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25636e.show();
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
                c.a.t0.e1.a.i().l();
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
        this.f25634d = -1L;
        this.f25635e = new ArrayList<>();
        this.a = c.a.s0.s.h0.b.k().l("splash_ad_strategy_key", 0);
        this.f25632b = c.a.s0.s.h0.b.k().l("splash_origin_ad_strategy_key", 1);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f25631f == null) {
                f25631f = new a();
            }
            return f25631f;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<c.a.t0.y.a.g.b> it = this.f25635e.iterator();
            while (it.hasNext()) {
                c.a.t0.y.a.g.b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f25635e.clear();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public final synchronized void d() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f25635e.isEmpty()) {
                    c cVar = new c();
                    c.a.t0.y.a.b bVar = new c.a.t0.y.a.b();
                    this.f25635e.clear();
                    if (this.f25632b != 0) {
                        this.f25635e.add(cVar);
                        z = f.a();
                    } else {
                        z = true;
                    }
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        String str = "BEAR ad currentStretagy: " + this.a;
                    }
                    switch (this.a) {
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                            if (z) {
                                this.f25635e.add(bVar);
                                break;
                            }
                            break;
                    }
                    if (c.a.s0.s.h0.b.k().h("key_is_jump_splash_ad", false)) {
                        g();
                        this.f25635e.clear();
                    }
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().isNeedBearAd(this.a) : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Iterator<c.a.t0.y.a.g.b> it = this.f25635e.iterator();
            while (it.hasNext()) {
                c.a.t0.y.a.g.b next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        UBCManager uBCManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) == null) {
            return;
        }
        uBCManager.onEvent("5088");
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f25633c = false;
            d();
            Iterator<c.a.t0.y.a.g.b> it = this.f25635e.iterator();
            while (it.hasNext()) {
                c.a.t0.y.a.g.b next = it.next();
                if (i2 == 5 && (next instanceof c)) {
                    next.a();
                    return;
                } else if (i2 == 6 && (next instanceof c.a.t0.y.a.b)) {
                    next.a();
                    return;
                }
            }
        }
    }

    public synchronized void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            synchronized (this) {
                this.f25633c = false;
                this.f25634d = dVar.c();
                d();
                Iterator<c.a.t0.y.a.g.b> it = this.f25635e.iterator();
                while (it.hasNext()) {
                    it.next().d(dVar);
                }
            }
        }
    }

    public void j(c.a.s0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            k(aVar, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r14 == 1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
        r13 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k(c.a.s0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLZ(1048585, this, aVar, z) != null) {
            return;
        }
        synchronized (this) {
            if (this.f25633c) {
                return;
            }
            Iterator<c.a.t0.y.a.g.b> it = this.f25635e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    if (!z) {
                        StatisticItem.make(TbadkCoreStatisticKey.HOT_SPLASH_TIMEOUT).param("obj_type", "a064").param("tid", TbadkCoreApplication.getInst().isNeedBearAd(this.a) ? 1 : 0).param("pid", this.f25632b != 0 ? 1 : 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f25634d).eventStat();
                    }
                    if (aVar != null) {
                        aVar.c("");
                    }
                    return;
                }
                c.a.t0.y.a.g.b next = it.next();
                if (next != null) {
                    if (next.c() == AdLoadState.SUCCEED) {
                        this.f25633c = true;
                        if (aVar != null) {
                            aVar.b();
                        }
                        String e2 = next.e();
                        char c2 = 65535;
                        int hashCode = e2.hashCode();
                        if (hashCode != -1348168235) {
                            if (hashCode == 3019700 && e2.equals("bear")) {
                                c2 = 0;
                            }
                        } else if (e2.equals("prologue_gd")) {
                            c2 = 1;
                        }
                        int i2 = 6;
                        StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", i2).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f25634d).eventStat();
                        if (AdToMainTabActivitySwitch.getIsOn()) {
                            c.a.t0.z3.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                            e.a().post(new RunnableC1550a(this, next));
                        } else {
                            next.show();
                        }
                        c.a.s0.s.b0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", m.isEmpty(next.e()) ? "bes" : next.e());
                        return;
                    } else if (next.c() != AdLoadState.FAILED && z) {
                        return;
                    }
                }
            }
        }
    }

    public void l(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            int e2 = c.a.d.f.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e3 = c.a.d.f.m.b.e(jSONObject.optString("ad_origin_config_switch"), 1);
            c.a.t0.y.a.b.q(c.a.d.f.m.b.e(jSONObject.optString("bear_sid_type"), 0));
            c.a.s0.s.h0.b.k().w("splash_ad_strategy_key", e2);
            c.a.s0.s.h0.b.k().w("splash_origin_ad_strategy_key", e3);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(e2)) {
                if (n.B()) {
                    c.a.t0.e1.a.i().l();
                } else {
                    e.a().post(new b(this));
                }
            }
            this.a = e2;
            this.f25632b = e3;
        }
    }
}
