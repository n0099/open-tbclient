package c.a.r0.y.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.k0.a.c;
import c.a.k0.a.h.d;
import c.a.q0.c1.f;
import c.a.q0.r0.j;
import c.a.r0.v.d;
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
/* loaded from: classes3.dex */
public class c implements c.a.r0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static volatile c.a.g0.b.f.c f24638j;
    public static volatile boolean k;
    public static volatile c.a.g0.b.c l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f24639b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f24640c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f24641d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.k.a f24642e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24643f;

    /* renamed from: g  reason: collision with root package name */
    public long f24644g;

    /* renamed from: h  reason: collision with root package name */
    public final SplashNativePolicy f24645h;

    /* renamed from: i  reason: collision with root package name */
    public int f24646i;

    /* loaded from: classes3.dex */
    public class a implements c.a.g0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.r0.y.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1514a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24647e;

            public RunnableC1514a(a aVar) {
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
                this.f24647e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.y.a.g.a.e().m(this.f24647e.a.f24642e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f24648e;

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
                this.f24648e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.y.a.g.a.e().m(this.f24648e.a.f24642e);
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

        @Override // c.a.g0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f24642e == null ? 0 : this.a.f24642e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, f.g(this.a.f24646i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f24644g).eventStat();
            }
        }

        @Override // c.a.g0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                if (this.a.f24642e != null) {
                    if (c.f24638j == null || c.f24638j.a() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.f24638j.a().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.f24638j.a().optInt("full_type", 0) == 1;
                    }
                    c.a.q0.k.a aVar = this.a.f24642e;
                    c cVar = this.a;
                    aVar.b(z, z2, cVar.f24639b, null, f.g(cVar.f24646i), null);
                }
            }
        }

        @Override // c.a.g0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.r0.y.a.i.b.i(c.a.r0.y.a.i.b.f24690b, "1", str, null, 1, 0, this.a.f24643f, this.a.f24644g);
                c.a.r0.y.a.i.b.j(c.a.r0.y.a.i.b.f24690b, "1", str, null, null, null, this.a.f24644g);
                if (c.a.r0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                this.a.f24640c = AdLoadState.FAILED;
                if (n.B()) {
                    c.a.r0.y.a.g.a.e().m(this.a.f24642e);
                } else {
                    e.a().post(new b(this));
                }
                h("advert_show", 0);
                if (this.a.f24645h != null) {
                    this.a.f24645h.onSplashEvent(66);
                }
            }
        }

        @Override // c.a.g0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f24642e == null ? 0 : this.a.f24642e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, f.g(this.a.f24646i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f24644g).eventStat();
                if (this.a.f24642e != null) {
                    this.a.f24642e.onAdDismiss();
                }
            }
        }

        @Override // c.a.g0.b.c
        public void e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.f24640c = AdLoadState.SUCCEED;
                if (this.a.f24642e != null) {
                    this.a.f24642e.e(c.a.r0.y.a.i.b.f24690b);
                }
                if (n.B()) {
                    c.a.r0.y.a.g.a.e().m(this.a.f24642e);
                } else {
                    e.a().post(new RunnableC1514a(this));
                }
                h("advert_load", 1);
                if (this.a.f24645h != null) {
                    if (dVar == null) {
                        this.a.f24645h.onSplashEvent(66);
                    } else {
                        JSONObject a = dVar.a();
                        this.a.f24646i = a != null ? a.optInt("source", -1) : -1;
                        this.a.f24645h.onSplashEvent(65, this.a.f24646i);
                    }
                }
                c.a.r0.y.a.i.b.i(c.a.r0.y.a.i.b.f24690b, "0", null, f.g(this.a.f24646i), 0, 0, this.a.f24643f, this.a.f24644g);
                c.a.r0.y.a.i.a.f(this.a.f24646i, this.a.f24644g);
            }
        }

        @Override // c.a.g0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.f24642e != null) {
                    this.a.f24642e.c("play error");
                }
            }
        }

        @Override // c.a.g0.b.c
        @NonNull
        public ViewGroup g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (ViewGroup) this.a.f24641d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void h(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
                c.a.d.f.n.a a = j.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(c.a.r0.y.a.g.a.e().d()));
                a.c("isSuccess", Integer.valueOf(i2));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // c.a.g0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.f24642e != null) {
                    this.a.f24642e.f(true, false, this.a.f24639b);
                }
                c.a.r0.y.a.i.b.j(c.a.r0.y.a.i.b.f24690b, "0", null, f.g(this.a.f24646i), null, null, this.a.f24644g);
                h("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f24642e != null ? this.a.f24642e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.g0.b.c {
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

        @Override // c.a.g0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                return;
            }
            c.l.a();
        }

        @Override // c.a.g0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.l == null) {
                return;
            }
            c.l.b();
        }

        @Override // c.a.g0.b.c
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
                c.a.r0.v.d.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // c.a.g0.b.c
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || c.l == null) {
                return;
            }
            c.l.d();
        }

        @Override // c.a.g0.b.c
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
                c.a.r0.v.d.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // c.a.g0.b.c
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || c.l == null) {
                return;
            }
            c.l.f();
        }

        @Override // c.a.g0.b.c
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

        @Override // c.a.g0.b.c
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
        this.f24639b = 5;
        this.f24640c = AdLoadState.INIT;
        this.f24642e = null;
        this.f24643f = false;
        this.f24644g = -1L;
        this.f24646i = -1;
        this.f24645h = splashNativePolicy;
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k = true;
            t(new b(this), null);
        }
    }

    @Override // c.a.r0.y.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24641d.get() != null && this.f24641d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // c.a.r0.y.a.g.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f.g(this.f24646i) : (String) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24640c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f24638j != null) {
                f24638j.g();
                f24638j = null;
            }
            l = null;
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void e(c.a.q0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f24642e = dVar.a();
        this.f24643f = dVar.d();
        this.f24644g = dVar.c();
        this.f24641d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        l = aVar;
        if (k) {
            r();
            k = false;
            return;
        }
        t(aVar, this.f24642e);
    }

    @Override // c.a.r0.y.a.g.b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.f24641d) == null || weakReference.get().getParent() == null || !(this.f24641d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24641d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f24641d.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || l == null || c.a.r0.v.d.c().d(f()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.r0.v.d.c().d(f())) {
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
                l.e((c.a.k0.a.h.d) aVar.f24150b.get("data"));
            } else if (c2 == 1) {
                l.c((String) aVar.f24150b.get("data"));
            }
        }
        c.a.r0.v.d.c().b(f());
    }

    @Override // c.a.r0.y.a.g.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || f24638j == null || (weakReference = this.f24641d) == null || weakReference.get() == null || this.f24640c != AdLoadState.SUCCEED) {
            return;
        }
        q();
        this.f24640c = AdLoadState.SHOWED;
        if (c.a.r0.y.a.g.b.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        f24638j.m(this.f24641d.get());
    }

    public final void t(c.a.g0.b.c cVar, c.a.q0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(n.k(context));
                bVar.k(n.i(context));
                f24638j = new c.a.g0.b.f.c(context, c.a.g0.b.f.f.m(), bVar.i(), cVar);
                this.f24640c = AdLoadState.LOADING;
                f24638j.h();
                if (c.a.r0.y.a.g.b.a) {
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
