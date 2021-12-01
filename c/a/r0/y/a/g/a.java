package c.a.r0.y.a.g;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.l.d;
import c.a.r0.y.a.c;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f25525d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25526b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<b> f25527c;

    /* renamed from: c.a.r0.y.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1461a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC1461a(a aVar) {
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
        this.f25527c = new ArrayList<>();
        this.a = c.a.q0.s.e0.b.j().k("splash_ad_strategy_key", 0);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f25525d == null) {
                f25525d = new a();
            }
            return f25525d;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<b> it = this.f25527c.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f25527c.clear();
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
                if (this.f25527c.isEmpty()) {
                    c cVar = new c();
                    c.a.r0.y.a.b bVar = new c.a.r0.y.a.b();
                    this.f25527c.clear();
                    this.f25527c.add(cVar);
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        String str = "BEAR ad currentStretagy: " + this.a;
                    }
                    switch (this.a) {
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                            this.f25527c.add(bVar);
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

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25526b = false;
            d();
            Iterator<b> it = this.f25527c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public synchronized void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            synchronized (this) {
                this.f25526b = false;
                d();
                Iterator<b> it = this.f25527c.iterator();
                while (it.hasNext()) {
                    it.next().c(dVar);
                }
            }
        }
    }

    public void h(c.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            i(aVar, true);
        }
    }

    public synchronized void i(c.a.q0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, aVar, z) == null) {
            synchronized (this) {
                if (this.f25526b) {
                    return;
                }
                Iterator<b> it = this.f25527c.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        if (next.b() == AdLoadState.SUCCEED) {
                            this.f25526b = true;
                            if (aVar != null) {
                                aVar.b();
                            }
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                c.a.r0.w3.c.a(MainTabScheduleStrategy.UNSCHEDULE);
                                next.show();
                            } else {
                                next.show();
                            }
                            c.a.q0.s.a0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.d()) ? "bes" : next.d());
                            return;
                        } else if (next.b() != AdLoadState.FAILED && z) {
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

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            int e2 = c.a.d.f.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            c.a.r0.y.a.b.n(c.a.d.f.m.b.e(jSONObject.optString("bear_sid_type"), 0));
            c.a.q0.s.e0.b.j().v("splash_ad_strategy_key", e2);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(e2)) {
                if (l.B()) {
                    c.a.r0.e1.a.i().l();
                } else {
                    e.a().post(new RunnableC1461a(this));
                }
            }
            this.a = e2;
        }
    }
}
