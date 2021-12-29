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
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes8.dex */
public class c implements c.a.t0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile c.a.i0.b.f.c f26385f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f26386g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c.a.i0.b.c f26387h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f26388b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f26389c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f26390d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.l.a f26391e;

    /* loaded from: classes8.dex */
    public class a implements c.a.i0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
                if (c.f26385f != null) {
                    int i2 = 1;
                    boolean z2 = c.f26385f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = c.f26385f.g().optInt("full_type", 0) == 1;
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f26391e != null ? this.a.f26391e.hashCode() : 0));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).eventStat();
            }
        }

        @Override // c.a.i0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z3 = c.a.t0.y.a.g.b.a;
                if (this.a.f26391e != null) {
                    if (c.f26385f == null || c.f26385f.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.f26385f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.f26385f.g().optInt("full_type", 0) == 1;
                    }
                    this.a.f26391e.a(z, z2, this.a.f26388b, null, null);
                }
            }
        }

        @Override // c.a.i0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.t0.y.a.i.a.j(c.a.t0.y.a.i.a.f26425b, str, 0);
                c.a.t0.y.a.i.a.k(c.a.t0.y.a.i.a.f26425b, "1");
                if (c.a.t0.y.a.g.b.a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.a.f26389c = AdLoadState.FAILED;
                c.a.t0.y.a.g.a.c().i(this.a.f26391e);
                g("advert_show", 0);
            }
        }

        @Override // c.a.i0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = c.a.t0.y.a.g.b.a;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f26391e == null ? 0 : this.a.f26391e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).eventStat();
                if (this.a.f26391e != null) {
                    this.a.f26391e.onAdDismiss();
                }
            }
        }

        @Override // c.a.i0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                c.a.t0.y.a.i.a.j(c.a.t0.y.a.i.a.f26425b, "0", 0);
                boolean z = c.a.t0.y.a.g.b.a;
                this.a.f26389c = AdLoadState.SUCCEED;
                c.a.t0.y.a.g.a.c().i(this.a.f26391e);
                g("advert_load", 1);
            }
        }

        @Override // c.a.i0.b.c
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (ViewGroup) this.a.f26390d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void g(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
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
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                boolean z = c.a.t0.y.a.g.b.a;
                if (this.a.f26391e != null) {
                    this.a.f26391e.e(true, false, this.a.f26388b);
                }
                c.a.t0.y.a.i.a.k(c.a.t0.y.a.i.a.f26425b, "0");
                g("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f26391e != null ? this.a.f26391e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.i0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f26392e;

            public a(b bVar, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26392e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f26387h == null) {
                    return;
                }
                c.f26387h.e(this.f26392e);
            }
        }

        /* renamed from: c.a.t0.y.a.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1530b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f26393e;

            public RunnableC1530b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26393e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f26387h == null) {
                    return;
                }
                c.f26387h.c(this.f26393e);
            }
        }

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f26387h == null) {
                return;
            }
            c.f26387h.a();
        }

        @Override // c.a.i0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.f26387h == null) {
                return;
            }
            c.f26387h.b();
        }

        @Override // c.a.i0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.f26387h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    c.a.t0.v.d.c().a(this.a.e(), "onAdLoadFailed", hashMap);
                } else if (n.B()) {
                    c.f26387h.c(str);
                } else {
                    e.a().post(new RunnableC1530b(this, str));
                }
            }
        }

        @Override // c.a.i0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.f26387h == null) {
                return;
            }
            c.f26387h.d();
        }

        @Override // c.a.i0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.f26387h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", dVar);
                    c.a.t0.v.d.c().a(this.a.e(), "onAdLoaded", hashMap);
                } else if (n.B()) {
                    c.f26387h.e(dVar);
                } else {
                    e.a().post(new a(this, dVar));
                }
            }
        }

        @Override // c.a.i0.b.c
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (c.f26387h != null) {
                    return c.f26387h.f();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.i0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || c.f26387h == null) {
                return;
            }
            c.f26387h.onAdShow();
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
        this.f26388b = 5;
        this.f26389c = AdLoadState.INIT;
        this.f26391e = null;
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.t0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f26386g = true;
            n(new b(this), null);
        }
    }

    @Override // c.a.t0.y.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26390d.get() != null && this.f26390d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // c.a.t0.y.a.g.b
    public AdLoadState c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26389c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.t0.y.a.g.b
    public void d(c.a.s0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f26391e = dVar.a();
        this.f26390d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        f26387h = aVar;
        if (f26386g) {
            l();
            f26386g = false;
            return;
        }
        n(aVar, this.f26391e);
    }

    @Override // c.a.t0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f26385f != null) {
                f26385f.f();
                f26385f = null;
            }
            f26387h = null;
        }
    }

    @Override // c.a.t0.y.a.g.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void k() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f26390d) == null || weakReference.get().getParent() == null || !(this.f26390d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f26390d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f26390d.get().setLayoutParams(layoutParams);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || f26387h == null || c.a.t0.v.d.c().d(e()).isEmpty()) {
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
                f26387h.e((c.a.m0.a.h.d) aVar.f25158b.get("data"));
            } else if (c2 == 1) {
                f26387h.c((String) aVar.f25158b.get("data"));
            }
        }
        c.a.t0.v.d.c().b(e());
    }

    public final void n(c.a.i0.b.c cVar, c.a.s0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(n.k(context));
                bVar.k(n.i(context));
                f26385f = new c.a.i0.b.f.c(context, "1481698145541", bVar.i(), cVar);
                this.f26389c = AdLoadState.LOADING;
                c.a.t0.y.a.i.a.i(c.a.t0.y.a.i.a.f26425b);
                f26385f.h();
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || f26385f == null || (weakReference = this.f26390d) == null || weakReference.get() == null || this.f26389c != AdLoadState.SUCCEED) {
            return;
        }
        c.a.s0.l.a aVar = this.f26391e;
        if (aVar != null) {
            aVar.d();
        }
        k();
        this.f26389c = AdLoadState.SHOWED;
        boolean z = c.a.t0.y.a.g.b.a;
        f26385f.m(this.f26390d.get());
    }
}
