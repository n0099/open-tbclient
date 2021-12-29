package c.a.t0.y.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.l.d;
import c.a.t0.y.a.c;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static a f26417e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f26418b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26419c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<b> f26420d;

    /* renamed from: c.a.t0.y.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1534a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC1534a(a aVar) {
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
        this.f26420d = new ArrayList<>();
        this.a = c.a.s0.s.g0.b.j().k("splash_ad_strategy_key", 0);
        this.f26418b = c.a.s0.s.g0.b.j().k("splash_origin_ad_strategy_key", 1);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f26417e == null) {
                f26417e = new a();
            }
            return f26417e;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<b> it = this.f26420d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f26420d.clear();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f26420d.isEmpty()) {
                    c cVar = new c();
                    c.a.t0.y.a.b bVar = new c.a.t0.y.a.b();
                    this.f26420d.clear();
                    if (this.f26418b != 0) {
                        this.f26420d.add(cVar);
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
                            this.f26420d.add(bVar);
                            break;
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
            Iterator<b> it = this.f26420d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && next.b()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f26419c = false;
            d();
            Iterator<b> it = this.f26420d.iterator();
            while (it.hasNext()) {
                b next = it.next();
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

    public synchronized void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            synchronized (this) {
                this.f26419c = false;
                d();
                Iterator<b> it = this.f26420d.iterator();
                while (it.hasNext()) {
                    it.next().d(dVar);
                }
            }
        }
    }

    public void i(c.a.s0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            j(aVar, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r0 == 1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
        r12 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(c.a.s0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, z) == null) {
            synchronized (this) {
                if (this.f26419c) {
                    return;
                }
                Iterator<b> it = this.f26420d.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        if (next.c() == AdLoadState.SUCCEED) {
                            this.f26419c = true;
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
                            StatisticItem.make(TbadkCoreStatisticKey.SHOW_AD_TIME).param("obj_source", i2).param("obj_type", "a064").eventStat();
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                c.a.t0.z3.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                                next.show();
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
                if (!z) {
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 0).param("obj_type", "a064").param("obj_locate", 4).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
                }
                if (aVar != null) {
                    aVar.c("");
                }
            }
        }
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            int e2 = c.a.d.f.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            int e3 = c.a.d.f.m.b.e(jSONObject.optString("ad_origin_config_switch"), 1);
            c.a.t0.y.a.b.o(c.a.d.f.m.b.e(jSONObject.optString("bear_sid_type"), 0));
            c.a.s0.s.g0.b.j().v("splash_ad_strategy_key", e2);
            c.a.s0.s.g0.b.j().v("splash_origin_ad_strategy_key", e3);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(e2)) {
                if (n.B()) {
                    c.a.t0.e1.a.i().l();
                } else {
                    e.a().post(new RunnableC1534a(this));
                }
            }
            this.a = e2;
            this.f26418b = e3;
        }
    }
}
