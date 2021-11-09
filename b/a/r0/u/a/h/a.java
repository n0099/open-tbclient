package b.a.r0.u.a.h;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.f0.b.g.g;
import b.a.r0.u.a.c;
import b.a.r0.u.a.d;
import b.a.r0.u.a.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static a f23934e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f23935a;

    /* renamed from: b  reason: collision with root package name */
    public String f23936b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f23937c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b.a.r0.u.a.h.b> f23938d;

    /* renamed from: b.a.r0.u.a.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1160a implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.u.a.h.b f23939a;

        public C1160a(a aVar, b.a.r0.u.a.h.b bVar) {
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
            this.f23939a = bVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f23939a.show();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
                b.a.r0.y0.a.i().l();
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
        this.f23938d = new ArrayList<>();
        this.f23935a = b.a.q0.s.e0.b.j().k("splash_ad_strategy_key", 0);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f23934e == null) {
                f23934e = new a();
            }
            return f23934e;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<b.a.r0.u.a.h.b> it = this.f23938d.iterator();
            while (it.hasNext()) {
                b.a.r0.u.a.h.b next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
            this.f23938d.clear();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23935a : invokeV.intValue;
    }

    public final synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f23938d.isEmpty()) {
                    e eVar = new e();
                    b.a.r0.u.a.b bVar = new b.a.r0.u.a.b();
                    d dVar = new d();
                    c cVar = new c();
                    this.f23938d.clear();
                    this.f23938d.add(eVar);
                    if (g.a()) {
                        this.f23938d.add(bVar);
                    }
                    if (TbadkCoreApplication.getInst().isDebugMode()) {
                        r0 = "BEAR ad currentStretagy: " + this.f23935a;
                    }
                    if (this.f23935a == 101) {
                        this.f23938d.add(cVar);
                        this.f23938d.add(dVar);
                    } else if (this.f23935a == 102) {
                        this.f23938d.add(dVar);
                        this.f23938d.add(cVar);
                    } else {
                        if (this.f23935a != 103 && this.f23935a != 104) {
                            if (this.f23935a == 105) {
                                this.f23938d.add(cVar);
                            } else if (this.f23935a == 106) {
                                BdLog.d("splash nothing to add: " + this.f23935a);
                            } else {
                                this.f23938d.add(dVar);
                            }
                        }
                        String p = b.a.q0.s.e0.b.j().p("splash_ad_last_show_key", "");
                        this.f23936b = p;
                        if (k.isEmpty(p)) {
                            if (this.f23935a == 103) {
                                this.f23938d.add(cVar);
                                this.f23938d.add(dVar);
                            } else {
                                this.f23938d.add(dVar);
                                this.f23938d.add(cVar);
                            }
                        } else if (StringHelper.equals(this.f23936b, cVar.d())) {
                            this.f23938d.add(dVar);
                            this.f23938d.add(cVar);
                        } else {
                            this.f23938d.add(cVar);
                            this.f23938d.add(dVar);
                        }
                    }
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TbadkCoreApplication.getInst().isNeedBearAd(this.f23935a) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f23937c = false;
            d();
            Iterator<b.a.r0.u.a.h.b> it = this.f23938d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public synchronized void g(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            synchronized (this) {
                this.f23937c = false;
                d();
                Iterator<b.a.r0.u.a.h.b> it = this.f23938d.iterator();
                while (it.hasNext()) {
                    it.next().c(dVar);
                }
            }
        }
    }

    public void h(b.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            i(aVar, true);
        }
    }

    public synchronized void i(b.a.q0.l.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, aVar, z) == null) {
            synchronized (this) {
                if (this.f23937c) {
                    return;
                }
                Iterator<b.a.r0.u.a.h.b> it = this.f23938d.iterator();
                while (it.hasNext()) {
                    b.a.r0.u.a.h.b next = it.next();
                    if (next != null) {
                        if (next.b() == AdLoadState.SUCCEED) {
                            this.f23937c = true;
                            if (aVar != null) {
                                aVar.c();
                            }
                            if (AdToMainTabActivitySwitch.getIsOn()) {
                                Looper.myQueue().addIdleHandler(new C1160a(this, next));
                            } else {
                                next.show();
                            }
                            b.a.q0.s.a0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "splashType", k.isEmpty(next.d()) ? "bes" : next.d());
                            j(next.d());
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
                    aVar.b("");
                }
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        this.f23936b = str;
        b.a.q0.s.e0.b.j().x("splash_ad_last_show_key", str);
    }

    public void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            int e2 = b.a.e.e.m.b.e(jSONObject.optString("ad_sdk_priority"), 0);
            c.n(b.a.e.e.m.b.e(jSONObject.optString("bear_sid_type"), 0));
            if ((e2 == 103 || e2 == 104) && e2 != this.f23935a) {
                this.f23936b = "";
                b.a.q0.s.e0.b.j().C("splash_ad_last_show_key");
            }
            b.a.q0.s.e0.b.j().v("splash_ad_strategy_key", e2);
            if (!e() && TbadkCoreApplication.getInst().isNeedBearAd(e2)) {
                if (l.C()) {
                    b.a.r0.y0.a.i().l();
                } else {
                    b.a.e.e.m.e.a().post(new b(this));
                }
            }
            this.f23935a = e2;
        }
    }
}
