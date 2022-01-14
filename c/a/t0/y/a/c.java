package c.a.t0.y.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.m0.a.c;
import c.a.m0.a.h.d;
import c.a.s0.s0.j;
import c.a.t0.v.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class c implements c.a.t0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c.a.i0.b.f.c f25599h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f25600i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile c.a.i0.b.c f25601j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f25602b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f25603c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25604d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.l.a f25605e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25606f;

    /* renamed from: g  reason: collision with root package name */
    public long f25607g;

    /* loaded from: classes9.dex */
    public class a implements c.a.i0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.t0.y.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1546a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f25608e;

            public RunnableC1546a(a aVar) {
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
                        return;
                    }
                }
                this.f25608e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f25608e.a.f25605e != null) {
                        this.f25608e.a.f25605e.e(c.a.t0.y.a.i.a.f25641b);
                    }
                    c.a.t0.y.a.g.a.c().j(this.f25608e.a.f25605e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f25609e;

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
                        return;
                    }
                }
                this.f25609e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f25609e.a.f25605e != null) {
                        this.f25609e.a.f25605e.e(c.a.t0.y.a.i.a.f25641b);
                    }
                    c.a.t0.y.a.g.a.c().j(this.f25609e.a.f25605e);
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.i0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                boolean z = c.a.t0.y.a.g.b.a;
                if (c.f25599h != null) {
                    int i2 = 1;
                    boolean z2 = c.f25599h.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = c.f25599h.g().optInt("full_type", 0) == 1;
                    if (z3 && z2) {
                        i2 = 4;
                    } else if (z2) {
                        i2 = 3;
                    } else if (z3) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 5).param("obj_type", i2));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25605e != null ? this.a.f25605e.hashCode() : 0));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f25607g).eventStat();
            }
        }

        @Override // c.a.i0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z3 = c.a.t0.y.a.g.b.a;
                if (this.a.f25605e != null) {
                    if (c.f25599h == null || c.f25599h.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.f25599h.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.f25599h.g().optInt("full_type", 0) == 1;
                    }
                    this.a.f25605e.d(z, z2, this.a.f25602b, null, null, null);
                }
            }
        }

        @Override // c.a.i0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.t0.y.a.i.a.i(c.a.t0.y.a.i.a.f25641b, "1", str, 1, 0, this.a.f25606f, this.a.f25607g);
                c.a.t0.y.a.i.a.j(c.a.t0.y.a.i.a.f25641b, "1", str, null, null, null, this.a.f25607g);
                if (c.a.t0.y.a.g.b.a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                this.a.f25603c = AdLoadState.FAILED;
                if (n.B()) {
                    if (this.a.f25605e != null) {
                        this.a.f25605e.e(c.a.t0.y.a.i.a.f25641b);
                    }
                    c.a.t0.y.a.g.a.c().j(this.a.f25605e);
                } else {
                    e.a().post(new b(this));
                }
                h("advert_show", 0);
            }
        }

        @Override // c.a.i0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = c.a.t0.y.a.g.b.a;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25605e == null ? 0 : this.a.f25605e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f25607g).eventStat();
                if (this.a.f25605e != null) {
                    this.a.f25605e.onAdDismiss();
                }
            }
        }

        @Override // c.a.i0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                c.a.t0.y.a.i.a.i(c.a.t0.y.a.i.a.f25641b, "0", null, 0, 0, this.a.f25606f, this.a.f25607g);
                boolean z = c.a.t0.y.a.g.b.a;
                this.a.f25603c = AdLoadState.SUCCEED;
                if (n.B()) {
                    if (this.a.f25605e != null) {
                        this.a.f25605e.e(c.a.t0.y.a.i.a.f25641b);
                    }
                    c.a.t0.y.a.g.a.c().j(this.a.f25605e);
                } else {
                    e.a().post(new RunnableC1546a(this));
                }
                h("advert_load", 1);
            }
        }

        @Override // c.a.i0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                boolean z = c.a.t0.y.a.g.b.a;
                if (this.a.f25605e != null) {
                    this.a.f25605e.c("play error");
                }
            }
        }

        @Override // c.a.i0.b.c
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (ViewGroup) this.a.f25604d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
                c.a.d.f.n.a a = j.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(c.a.t0.y.a.g.a.c().b()));
                a.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // c.a.i0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                boolean z = c.a.t0.y.a.g.b.a;
                if (this.a.f25605e != null) {
                    this.a.f25605e.f(true, false, this.a.f25602b);
                }
                c.a.t0.y.a.i.a.j(c.a.t0.y.a.i.a.f25641b, "0", null, null, null, null, this.a.f25607g);
                h("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25605e != null ? this.a.f25605e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.a.i0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.i0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f25601j == null) {
                return;
            }
            c.f25601j.a();
        }

        @Override // c.a.i0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.f25601j == null) {
                return;
            }
            c.f25601j.b();
        }

        @Override // c.a.i0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.f25601j != null) {
                    if (c.f25601j != null) {
                        c.f25601j.c(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                c.a.t0.v.d.c().a(this.a.e(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // c.a.i0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.f25601j == null) {
                return;
            }
            c.f25601j.d();
        }

        @Override // c.a.i0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.f25601j != null) {
                    if (c.f25601j != null) {
                        c.f25601j.e(dVar);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", dVar);
                c.a.t0.v.d.c().a(this.a.e(), "onAdLoaded", hashMap);
            }
        }

        @Override // c.a.i0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.f25601j == null) {
                return;
            }
            c.f25601j.f();
        }

        @Override // c.a.i0.b.c
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (c.f25601j != null) {
                    return c.f25601j.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.i0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || c.f25601j == null) {
                return;
            }
            c.f25601j.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(687954697, "Lc/a/t0/y/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(687954697, "Lc/a/t0/y/a/c;");
        }
    }

    public c() {
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
        this.f25602b = 5;
        this.f25603c = AdLoadState.INIT;
        this.f25605e = null;
        this.f25606f = false;
        this.f25607g = -1L;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.t0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f25600i = true;
            p(new b(this), null);
        }
    }

    @Override // c.a.t0.y.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25604d.get() != null && this.f25604d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // c.a.t0.y.a.g.b
    public AdLoadState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25603c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.t0.y.a.g.b
    public void d(c.a.s0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f25605e = dVar.a();
        this.f25606f = dVar.d();
        this.f25607g = dVar.c();
        this.f25604d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        f25601j = aVar;
        if (f25600i) {
            n();
            f25600i = false;
            return;
        }
        p(aVar, this.f25605e);
    }

    @Override // c.a.t0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25599h != null) {
                f25599h.f();
                f25599h = null;
            }
            f25601j = null;
        }
    }

    @Override // c.a.t0.y.a.g.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void m() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f25604d) == null || weakReference.get().getParent() == null || !(this.f25604d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25604d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25604d.get().setLayoutParams(layoutParams);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || f25601j == null || c.a.t0.v.d.c().d(e()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.t0.v.d.c().d(e())) {
            String str = aVar.a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -610376507) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c2 = 0;
                }
            } else if (str.equals("onAdLoadFailed")) {
                c2 = 1;
            }
            if (c2 == 0) {
                f25601j.e((c.a.m0.a.h.d) aVar.f24455b.get("data"));
            } else if (c2 == 1) {
                f25601j.c((String) aVar.f24455b.get("data"));
            }
        }
        c.a.t0.v.d.c().b(e());
    }

    public final void p(c.a.i0.b.c cVar, c.a.s0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(n.k(context));
                bVar.k(n.i(context));
                f25599h = new c.a.i0.b.f.c(context, "1481698145541", bVar.i(), cVar);
                this.f25603c = AdLoadState.LOADING;
                f25599h.h();
                boolean z = c.a.t0.y.a.g.b.a;
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.c("oom");
                }
            }
        }
    }

    @Override // c.a.t0.y.a.g.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || f25599h == null || (weakReference = this.f25604d) == null || weakReference.get() == null || this.f25603c != AdLoadState.SUCCEED) {
            return;
        }
        c.a.s0.l.a aVar = this.f25605e;
        if (aVar != null) {
            aVar.a(c.a.t0.y.a.i.a.f25641b);
        }
        m();
        this.f25603c = AdLoadState.SHOWED;
        boolean z = c.a.t0.y.a.g.b.a;
        f25599h.m(this.f25604d.get());
    }
}
