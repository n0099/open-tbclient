package c.a.q0.t.a.h;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.f0.b.g.g;
import c.a.q0.t.a.c;
import c.a.q0.t.a.d;
import c.a.q0.t.a.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static a f24475e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f24476a;

    /* renamed from: b  reason: collision with root package name */
    public String f24477b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24478c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b> f24479d;

    /* renamed from: c.a.q0.t.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1132a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC1132a(a aVar) {
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
                c.a.q0.w0.a.i().l();
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
        this.f24479d = new ArrayList<>();
        this.f24476a = c.a.p0.s.d0.b.j().k("splash_ad_strategy_key", 0);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f24475e == null) {
                f24475e = new a();
            }
            return f24475e;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<b> it = this.f24479d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f24479d.clear();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24476a : invokeV.intValue;
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                e eVar = new e();
                c.a.q0.t.a.b bVar = new c.a.q0.t.a.b();
                d dVar = new d();
                c cVar = new c();
                this.f24479d.clear();
                this.f24479d.add(eVar);
                if (g.a()) {
                    this.f24479d.add(bVar);
                }
                if (TbadkCoreApplication.getInst().isDebugMode()) {
                    r0 = "BEAR ad currentStretagy: " + this.f24476a;
                }
                if (this.f24476a == 101) {
                    this.f24479d.add(cVar);
                    this.f24479d.add(dVar);
                } else if (this.f24476a == 102) {
                    this.f24479d.add(dVar);
                    this.f24479d.add(cVar);
                } else {
                    if (this.f24476a != 103 && this.f24476a != 104) {
                        if (this.f24476a == 105) {
                            this.f24479d.add(cVar);
                        } else if (this.f24476a == 106) {
                            BdLog.d("splash nothing to add: " + this.f24476a);
                        } else {
                            this.f24479d.add(dVar);
                        }
                    }
                    String p = c.a.p0.s.d0.b.j().p("splash_ad_last_show_key", "");
                    this.f24477b = p;
                    if (k.isEmpty(p)) {
                        if (this.f24476a == 103) {
                            this.f24479d.add(cVar);
                            this.f24479d.add(dVar);
                        } else {
                            this.f24479d.add(dVar);
                            this.f24479d.add(cVar);
                        }
                    } else if (StringHelper.equals(this.f24477b, cVar.c())) {
                        this.f24479d.add(dVar);
                        this.f24479d.add(cVar);
                    } else {
                        this.f24479d.add(cVar);
                        this.f24479d.add(dVar);
                    }
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().isNeedBearAd(this.f24476a) : invokeV.booleanValue;
    }

    public synchronized void f(c.a.p0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (this) {
                this.f24478c = false;
                d();
                Iterator<b> it = this.f24479d.iterator();
                while (it.hasNext()) {
                    it.next().b(dVar);
                }
            }
        }
    }

    public void g(c.a.p0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            h(aVar, true);
        }
    }

    public synchronized void h(c.a.p0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) {
            synchronized (this) {
                if (this.f24478c) {
                    return;
                }
                Iterator<b> it = this.f24479d.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        if (next.a() == AdLoadState.SUCCEED) {
                            this.f24478c = true;
                            next.show();
                            c.a.p0.s.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.c()) ? "bes" : next.c());
                            i(next.c());
                            return;
                        } else if (next.a() != AdLoadState.FAILED && z) {
                            return;
                        }
                    }
                }
                if (!z) {
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 0).param("obj_type", "a064").param("obj_locate", 4).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
                }
                if (aVar != null) {
                    aVar.a("");
                }
            }
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.f24477b = str;
        c.a.p0.s.d0.b.j().x("splash_ad_last_show_key", str);
    }

    public void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            int d2 = c.a.e.e.m.b.d(jSONObject.optString("ad_sdk_priority"), 0);
            c.k(c.a.e.e.m.b.d(jSONObject.optString("bear_sid_type"), 0));
            if ((d2 == 103 || d2 == 104) && d2 != this.f24476a) {
                this.f24477b = "";
                c.a.p0.s.d0.b.j().C("splash_ad_last_show_key");
            }
            c.a.p0.s.d0.b.j().v("splash_ad_strategy_key", d2);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(d2)) {
                if (l.C()) {
                    c.a.q0.w0.a.i().l();
                } else {
                    c.a.e.e.m.e.a().post(new RunnableC1132a(this));
                }
            }
            this.f24476a = d2;
        }
    }
}
