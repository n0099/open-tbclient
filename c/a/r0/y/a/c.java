package c.a.r0.y.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.l;
import c.a.k0.a.c;
import c.a.k0.a.h.d;
import c.a.q0.r0.j;
import c.a.r0.v.d;
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
/* loaded from: classes7.dex */
public class c implements c.a.r0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile c.a.g0.b.f.c f25493f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f25494g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c.a.g0.b.c f25495h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f25496b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f25497c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25498d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.l.a f25499e;

    /* loaded from: classes7.dex */
    public class a implements c.a.g0.b.c {
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

        @Override // c.a.g0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                boolean z = c.a.r0.y.a.g.b.a;
                if (c.f25493f != null) {
                    int i2 = 1;
                    boolean z2 = c.f25493f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                    boolean z3 = c.f25493f.g().optInt("full_type", 0) == 1;
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25499e != null ? this.a.f25499e.hashCode() : 0));
            }
        }

        @Override // c.a.g0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z3 = c.a.r0.y.a.g.b.a;
                if (this.a.f25499e != null) {
                    if (c.f25493f == null || c.f25493f.g() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.f25493f.g().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.f25493f.g().optInt("full_type", 0) == 1;
                    }
                    this.a.f25499e.a(z, z2, this.a.f25496b, null, null);
                }
            }
        }

        @Override // c.a.g0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.r0.y.a.i.a.j(c.a.r0.y.a.i.a.f25532b, str, 0);
                c.a.r0.y.a.i.a.k(c.a.r0.y.a.i.a.f25532b, "1");
                if (c.a.r0.y.a.g.b.a) {
                    String str2 = "prologue ad loaded failed: " + str;
                }
                if (BdLog.isDebugMode()) {
                    BdLog.e("");
                }
                this.a.f25497c = AdLoadState.FAILED;
                c.a.r0.y.a.g.a.c().h(this.a.f25499e);
                g("advert_show", 0);
            }
        }

        @Override // c.a.g0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                boolean z = c.a.r0.y.a.g.b.a;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25499e == null ? 0 : this.a.f25499e.hashCode()));
                if (this.a.f25499e != null) {
                    this.a.f25499e.onAdDismiss();
                }
            }
        }

        @Override // c.a.g0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                c.a.r0.y.a.i.a.j(c.a.r0.y.a.i.a.f25532b, "0", 0);
                boolean z = c.a.r0.y.a.g.b.a;
                this.a.f25497c = AdLoadState.SUCCEED;
                c.a.r0.y.a.g.a.c().h(this.a.f25499e);
                g("advert_load", 1);
            }
        }

        @Override // c.a.g0.b.c
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (ViewGroup) this.a.f25498d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void g(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
                c.a.d.f.n.a a = j.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(c.a.r0.y.a.g.a.c().b()));
                a.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // c.a.g0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                boolean z = c.a.r0.y.a.g.b.a;
                if (this.a.f25499e != null) {
                    this.a.f25499e.e(true, false, this.a.f25496b);
                }
                c.a.r0.y.a.i.a.k(c.a.r0.y.a.i.a.f25532b, "0");
                g("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25499e != null ? this.a.f25499e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.g0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f25500e;

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
                this.f25500e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f25495h == null) {
                    return;
                }
                c.f25495h.e(this.f25500e);
            }
        }

        /* renamed from: c.a.r0.y.a.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1457b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25501e;

            public RunnableC1457b(b bVar, String str) {
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
                this.f25501e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f25495h == null) {
                    return;
                }
                c.f25495h.c(this.f25501e);
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

        @Override // c.a.g0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.f25495h == null) {
                return;
            }
            c.f25495h.a();
        }

        @Override // c.a.g0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.f25495h == null) {
                return;
            }
            c.f25495h.b();
        }

        @Override // c.a.g0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.f25495h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", str);
                    c.a.r0.v.d.c().a(this.a.d(), "onAdLoadFailed", hashMap);
                } else if (l.B()) {
                    c.f25495h.c(str);
                } else {
                    e.a().post(new RunnableC1457b(this, str));
                }
            }
        }

        @Override // c.a.g0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.f25495h == null) {
                return;
            }
            c.f25495h.d();
        }

        @Override // c.a.g0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.f25495h == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("data", dVar);
                    c.a.r0.v.d.c().a(this.a.d(), "onAdLoaded", hashMap);
                } else if (l.B()) {
                    c.f25495h.e(dVar);
                } else {
                    e.a().post(new a(this, dVar));
                }
            }
        }

        @Override // c.a.g0.b.c
        @NonNull
        public ViewGroup f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (c.f25495h != null) {
                    return c.f25495h.f();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.g0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || c.f25495h == null) {
                return;
            }
            c.f25495h.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(7896327, "Lc/a/r0/y/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(7896327, "Lc/a/r0/y/a/c;");
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
        this.f25496b = 5;
        this.f25497c = AdLoadState.INIT;
        this.f25499e = null;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f25494g = true;
            m(new b(this), null);
        }
    }

    @Override // c.a.r0.y.a.g.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25497c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f25499e = dVar.a();
        this.f25498d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        f25495h = aVar;
        if (f25494g) {
            k();
            f25494g = false;
            return;
        }
        m(aVar, this.f25499e);
    }

    @Override // c.a.r0.y.a.g.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25493f != null) {
                f25493f.f();
                f25493f = null;
            }
            f25495h = null;
        }
    }

    public final void j() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f25498d) == null || weakReference.get().getParent() == null || !(this.f25498d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25498d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25498d.get().setLayoutParams(layoutParams);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || f25495h == null || c.a.r0.v.d.c().d(d()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.r0.v.d.c().d(d())) {
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
                f25495h.e((c.a.k0.a.h.d) aVar.f24582b.get("data"));
            } else if (c2 == 1) {
                f25495h.c((String) aVar.f24582b.get("data"));
            }
        }
        c.a.r0.v.d.c().b(d());
    }

    public final void m(c.a.g0.b.c cVar, c.a.q0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(l.k(context));
                bVar.k(l.i(context));
                f25493f = new c.a.g0.b.f.c(context, "1481698145541", bVar.i(), cVar);
                this.f25497c = AdLoadState.LOADING;
                c.a.r0.y.a.i.a.i(c.a.r0.y.a.i.a.f25532b);
                f25493f.h();
                boolean z = c.a.r0.y.a.g.b.a;
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.c("oom");
                }
            }
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || f25493f == null || (weakReference = this.f25498d) == null || weakReference.get() == null || this.f25497c != AdLoadState.SUCCEED) {
            return;
        }
        c.a.q0.l.a aVar = this.f25499e;
        if (aVar != null) {
            aVar.d();
        }
        j();
        this.f25497c = AdLoadState.SHOWED;
        boolean z = c.a.r0.y.a.g.b.a;
        f25493f.m(this.f25498d.get());
    }
}
