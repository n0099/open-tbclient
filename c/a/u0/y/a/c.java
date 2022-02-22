package c.a.u0.y.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.n0.a.c;
import c.a.n0.a.h.d;
import c.a.t0.d1.f;
import c.a.t0.s0.j;
import c.a.u0.v.d;
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
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements c.a.u0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static volatile c.a.j0.b.f.c f25276j;
    public static volatile boolean k;
    public static volatile c.a.j0.b.c l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f25277b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f25278c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f25279d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.l.a f25280e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25281f;

    /* renamed from: g  reason: collision with root package name */
    public long f25282g;

    /* renamed from: h  reason: collision with root package name */
    public final SplashNativePolicy f25283h;

    /* renamed from: i  reason: collision with root package name */
    public int f25284i;

    /* loaded from: classes9.dex */
    public class a implements c.a.j0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.u0.y.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1529a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f25285e;

            public RunnableC1529a(a aVar) {
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
                this.f25285e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.u0.y.a.g.a.d().l(this.f25285e.a.f25280e);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f25286e;

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
                this.f25286e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f25286e.a.f25280e != null) {
                        this.f25286e.a.f25280e.e(c.a.u0.y.a.i.a.f25320b);
                    }
                    c.a.u0.y.a.g.a.d().l(this.f25286e.a.f25280e);
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

        @Override // c.a.j0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25280e == null ? 0 : this.a.f25280e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, f.g(this.a.f25284i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f25282g).eventStat();
            }
        }

        @Override // c.a.j0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                if (this.a.f25280e != null) {
                    if (c.f25276j == null || c.f25276j.a() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.f25276j.a().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.f25276j.a().optInt("full_type", 0) == 1;
                    }
                    c.a.t0.l.a aVar = this.a.f25280e;
                    c cVar = this.a;
                    aVar.b(z, z2, cVar.f25277b, null, f.g(cVar.f25284i), null);
                }
            }
        }

        @Override // c.a.j0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.u0.y.a.i.a.i(c.a.u0.y.a.i.a.f25320b, "1", str, null, 1, 0, this.a.f25281f, this.a.f25282g);
                c.a.u0.y.a.i.a.j(c.a.u0.y.a.i.a.f25320b, "1", str, null, null, null, this.a.f25282g);
                if (c.a.u0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                this.a.f25278c = AdLoadState.FAILED;
                if (n.B()) {
                    if (this.a.f25280e != null) {
                        this.a.f25280e.e(c.a.u0.y.a.i.a.f25320b);
                    }
                    c.a.u0.y.a.g.a.d().l(this.a.f25280e);
                } else {
                    e.a().post(new b(this));
                }
                h("advert_show", 0);
                if (this.a.f25283h != null) {
                    this.a.f25283h.onSplashEvent(66);
                }
            }
        }

        @Override // c.a.j0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25280e == null ? 0 : this.a.f25280e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, f.g(this.a.f25284i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f25282g).eventStat();
                if (this.a.f25280e != null) {
                    this.a.f25280e.onAdDismiss();
                }
            }
        }

        @Override // c.a.j0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.f25278c = AdLoadState.SUCCEED;
                if (this.a.f25280e != null) {
                    this.a.f25280e.e(c.a.u0.y.a.i.a.f25320b);
                }
                if (n.B()) {
                    c.a.u0.y.a.g.a.d().l(this.a.f25280e);
                } else {
                    e.a().post(new RunnableC1529a(this));
                }
                h("advert_load", 1);
                if (this.a.f25283h != null) {
                    if (dVar == null) {
                        this.a.f25283h.onSplashEvent(66);
                    } else {
                        JSONObject a = dVar.a();
                        this.a.f25284i = a != null ? a.optInt("source", -1) : -1;
                        this.a.f25283h.onSplashEvent(65, this.a.f25284i);
                    }
                }
                c.a.u0.y.a.i.a.i(c.a.u0.y.a.i.a.f25320b, "0", null, f.g(this.a.f25284i), 0, 0, this.a.f25281f, this.a.f25282g);
            }
        }

        @Override // c.a.j0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.f25280e != null) {
                    this.a.f25280e.c("play error");
                }
            }
        }

        @Override // c.a.j0.b.c
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (ViewGroup) this.a.f25279d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
                c.a.d.f.n.a a = j.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(c.a.u0.y.a.g.a.d().c()));
                a.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // c.a.j0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.f25280e != null) {
                    this.a.f25280e.f(true, false, this.a.f25277b);
                }
                c.a.u0.y.a.i.a.j(c.a.u0.y.a.i.a.f25320b, "0", null, f.g(this.a.f25284i), null, null, this.a.f25282g);
                h("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25280e != null ? this.a.f25280e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.a.j0.b.c {
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

        @Override // c.a.j0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                return;
            }
            c.l.a();
        }

        @Override // c.a.j0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.l == null) {
                return;
            }
            c.l.b();
        }

        @Override // c.a.j0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.l != null) {
                    if (c.l != null) {
                        c.l.c(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                c.a.u0.v.d.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // c.a.j0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.l == null) {
                return;
            }
            c.l.d();
        }

        @Override // c.a.j0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.l != null) {
                    if (c.l != null) {
                        c.l.e(dVar);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", dVar);
                c.a.u0.v.d.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // c.a.j0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.l == null) {
                return;
            }
            c.l.f();
        }

        @Override // c.a.j0.b.c
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (c.l != null) {
                    return c.l.g();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.j0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || c.l == null) {
                return;
            }
            c.l.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1119499766, "Lc/a/u0/y/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1119499766, "Lc/a/u0/y/a/c;");
        }
    }

    public c(SplashNativePolicy splashNativePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25277b = 5;
        this.f25278c = AdLoadState.INIT;
        this.f25280e = null;
        this.f25281f = false;
        this.f25282g = -1L;
        this.f25284i = -1;
        this.f25283h = splashNativePolicy;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.u0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k = true;
            t(new b(this), null);
        }
    }

    @Override // c.a.u0.y.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25279d.get() != null && this.f25279d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // c.a.u0.y.a.g.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f.g(this.f25284i) : (String) invokeV.objValue;
    }

    @Override // c.a.u0.y.a.g.b
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25278c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.u0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f25276j != null) {
                f25276j.g();
                f25276j = null;
            }
            l = null;
        }
    }

    @Override // c.a.u0.y.a.g.b
    public void e(c.a.t0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f25280e = dVar.a();
        this.f25281f = dVar.d();
        this.f25282g = dVar.c();
        this.f25279d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        l = aVar;
        if (k) {
            r();
            k = false;
            return;
        }
        t(aVar, this.f25280e);
    }

    @Override // c.a.u0.y.a.g.b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.f25279d) == null || weakReference.get().getParent() == null || !(this.f25279d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25279d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f25279d.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || l == null || c.a.u0.v.d.c().d(f()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.u0.v.d.c().d(f())) {
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
                l.e((c.a.n0.a.h.d) aVar.f24340b.get("data"));
            } else if (c2 == 1) {
                l.c((String) aVar.f24340b.get("data"));
            }
        }
        c.a.u0.v.d.c().b(f());
    }

    @Override // c.a.u0.y.a.g.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || f25276j == null || (weakReference = this.f25279d) == null || weakReference.get() == null || this.f25278c != AdLoadState.SUCCEED) {
            return;
        }
        c.a.t0.l.a aVar = this.f25280e;
        if (aVar != null) {
            aVar.a(c.a.u0.y.a.i.a.f25320b);
        }
        q();
        this.f25278c = AdLoadState.SHOWED;
        if (c.a.u0.y.a.g.b.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        f25276j.m(this.f25279d.get());
    }

    public final void t(c.a.j0.b.c cVar, c.a.t0.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(n.k(context));
                bVar.k(n.i(context));
                f25276j = new c.a.j0.b.f.c(context, c.a.j0.b.f.f.m(), bVar.i(), cVar);
                this.f25278c = AdLoadState.LOADING;
                f25276j.h();
                if (c.a.u0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad start load");
                }
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onLowMemory();
                if (aVar != null) {
                    aVar.c("oom");
                }
            }
        }
    }
}
