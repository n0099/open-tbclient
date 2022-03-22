package c.a.p0.a0.a;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.i0.a.c;
import c.a.i0.a.h.d;
import c.a.o0.c1.f;
import c.a.o0.r0.j;
import c.a.p0.x.d;
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
/* loaded from: classes2.dex */
public class c implements c.a.p0.a0.a.g.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c.a.f0.b.f.c k;
    public static volatile boolean l;
    public static volatile c.a.f0.b.c m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f11888b;

    /* renamed from: c  reason: collision with root package name */
    public volatile AdLoadState f11889c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<ViewGroup> f11890d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.k.a f11891e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11892f;

    /* renamed from: g  reason: collision with root package name */
    public long f11893g;

    /* renamed from: h  reason: collision with root package name */
    public final SplashNativePolicy f11894h;
    public int i;
    public boolean j;

    /* loaded from: classes2.dex */
    public class a implements c.a.f0.b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.p0.a0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0904a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0904a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a0.a.g.a.e().n(this.a.a.f11891e);
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.a0.a.g.a.e().n(this.a.a.f11891e);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.f0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                System.out.println("SplashTes=>PrologueAdSdkSplash=>onSkip");
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onskip");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11891e == null ? 0 : this.a.f11891e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 3).param(TiebaStatic.Params.OBJ_TO, f.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11892f ? 2 : 1).param("fid", this.a.f11893g).eventStat();
            }
        }

        @Override // c.a.f0.b.c
        public void b() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onclick");
                }
                if (this.a.f11891e != null) {
                    if (c.k == null || c.k.a() == null) {
                        z = false;
                        z2 = false;
                    } else {
                        z = c.k.a().optInt(TiebaStatic.Params.AD_TYPE, 0) == 1;
                        z2 = c.k.a().optInt("full_type", 0) == 1;
                    }
                    c.a.o0.k.a aVar = this.a.f11891e;
                    c cVar = this.a;
                    aVar.d(z, z2, cVar.f11888b, null, f.m(cVar.i), null);
                }
            }
        }

        @Override // c.a.f0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                c.a.p0.a0.a.i.b.i(c.a.p0.a0.a.i.b.f11929b, "1", str, null, 1, 0, this.a.f11892f, this.a.f11893g);
                c.a.p0.a0.a.i.b.j(c.a.p0.a0.a.i.b.f11929b, "1", str, null, null, null, this.a.f11893g);
                if (c.a.p0.a0.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash prologue ad loaded failed: " + str);
                }
                if (this.a.f11891e != null) {
                    this.a.f11891e.f(c.a.p0.a0.a.i.b.f11929b);
                }
                this.a.f11889c = AdLoadState.FAILED;
                if (n.B()) {
                    c.a.p0.a0.a.g.a.e().n(this.a.f11891e);
                } else {
                    e.a().post(new b(this));
                }
                i("advert_show", 0);
                if (this.a.f11894h != null) {
                    this.a.f11894h.onSplashEvent(66);
                }
            }
        }

        @Override // c.a.f0.b.c
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.f0.b.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad finish");
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11891e == null ? 0 : this.a.f11891e.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 5).param("obj_type", "a064").param("obj_param1", 2).param(TiebaStatic.Params.OBJ_TO, f.m(this.a.i)).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11892f ? 2 : 1).param("fid", this.a.f11893g).eventStat();
                if (this.a.f11891e != null) {
                    this.a.f11891e.onAdDismiss();
                }
            }
        }

        @Override // c.a.f0.b.c
        public void f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue gd loaded success");
                }
                this.a.f11889c = AdLoadState.SUCCEED;
                if (this.a.f11891e != null) {
                    this.a.f11891e.f(c.a.p0.a0.a.i.b.f11929b);
                }
                if (n.B()) {
                    c.a.p0.a0.a.g.a.e().n(this.a.f11891e);
                } else {
                    e.a().post(new RunnableC0904a(this));
                }
                i("advert_load", 1);
                if (this.a.f11894h != null) {
                    if (dVar == null) {
                        this.a.f11894h.onSplashEvent(66);
                    } else {
                        JSONObject a = dVar.a();
                        this.a.i = a != null ? a.optInt("source", -1) : -1;
                        this.a.f11894h.onSplashEvent(65, this.a.i);
                    }
                }
                c.a.p0.a0.a.i.b.i(c.a.p0.a0.a.i.b.f11929b, "0", null, f.m(this.a.i), 0, 0, this.a.f11892f, this.a.f11893g);
                c.a.p0.a0.a.i.a.f(this.a.i, this.a.f11893g);
            }
        }

        @Override // c.a.f0.b.c
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad onAdPlayError");
                }
                if (this.a.f11891e != null) {
                    this.a.f11891e.c("play error");
                }
            }
        }

        @Override // c.a.f0.b.c
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (ViewGroup) this.a.f11890d.get() : (ViewGroup) invokeV.objValue;
        }

        public final void i(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
                c.a.d.f.n.a a = j.a();
                a.b("type", "prologue");
                a.b("locate", SpeedStatsUtils.UBC_VALUE_SPLASH);
                a.c("switch", Integer.valueOf(c.a.p0.a0.a.g.a.e().d()));
                a.c("isSuccess", Integer.valueOf(i));
                BdStatisticsManager.getInstance().debug(str, a);
            }
        }

        @Override // c.a.f0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash prologue ad show");
                }
                if (this.a.f11891e != null) {
                    this.a.f11891e.g(true, false, this.a.f11888b);
                }
                if (!this.a.j) {
                    this.a.j = true;
                    c.a.p0.a0.a.i.b.j(c.a.p0.a0.a.i.b.f11929b, "0", null, f.m(this.a.i), null, null, this.a.f11893g);
                }
                i("advert_show", 1);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11891e != null ? this.a.f11891e.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.f0.b.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.f0.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.m == null) {
                return;
            }
            c.m.a();
        }

        @Override // c.a.f0.b.c
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || c.m == null) {
                return;
            }
            c.m.b();
        }

        @Override // c.a.f0.b.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.m != null) {
                    if (c.m != null) {
                        c.m.c(str);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", str);
                c.a.p0.x.d.c().a(this.a.f(), "onAdLoadFailed", hashMap);
            }
        }

        @Override // c.a.f0.b.c
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.f0.b.c
        public void e() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || c.m == null) {
                return;
            }
            c.m.e();
        }

        @Override // c.a.f0.b.c
        public void f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
                if (c.m != null) {
                    if (c.m != null) {
                        c.m.f(dVar);
                        return;
                    }
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("data", dVar);
                c.a.p0.x.d.c().a(this.a.f(), "onAdLoaded", hashMap);
            }
        }

        @Override // c.a.f0.b.c
        public void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || c.m == null) {
                return;
            }
            c.m.g();
        }

        @Override // c.a.f0.b.c
        @NonNull
        public ViewGroup h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (c.m != null) {
                    return c.m.h();
                }
                return new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            }
            return (ViewGroup) invokeV.objValue;
        }

        @Override // c.a.f0.b.c
        public void onAdShow() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || c.m == null) {
                return;
            }
            c.m.onAdShow();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(796455261, "Lc/a/p0/a0/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(796455261, "Lc/a/p0/a0/a/c;");
        }
    }

    public c(SplashNativePolicy splashNativePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {splashNativePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11888b = 5;
        this.f11889c = AdLoadState.INIT;
        this.f11891e = null;
        this.f11892f = false;
        this.f11893g = -1L;
        this.i = -1;
        this.j = false;
        this.f11894h = splashNativePolicy;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            c.a.b.f().g();
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l = true;
            v(new b(this), null);
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11890d.get() != null && this.f11890d.get().getChildCount() > 0 : invokeV.booleanValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f.m(this.i) : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11889c : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (k != null) {
                k.g();
                k = null;
            }
            m = null;
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public void e(c.a.o0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null || dVar.b() == null || dVar.b().getContext() == null) {
            return;
        }
        this.f11891e = dVar.a();
        this.f11892f = dVar.d();
        this.f11893g = dVar.c();
        this.f11890d = new WeakReference<>(dVar.b());
        a aVar = new a(this);
        m = aVar;
        if (l) {
            t();
            l = false;
            return;
        }
        v(aVar, this.f11891e);
    }

    @Override // c.a.p0.a0.a.g.b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "prologue_gd" : (String) invokeV.objValue;
    }

    public final void s() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (weakReference = this.f11890d) == null || weakReference.get().getParent() == null || !(this.f11890d.get().getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11890d.get().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f11890d.get().setLayoutParams(layoutParams);
    }

    @Override // c.a.p0.a0.a.g.b
    public void show() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || k == null || (weakReference = this.f11890d) == null || weakReference.get() == null || this.f11889c != AdLoadState.SUCCEED) {
            return;
        }
        s();
        this.f11889c = AdLoadState.SHOWED;
        if (c.a.p0.a0.a.g.b.a) {
            System.out.println("IAdSdkSplash prologue ad start show");
        }
        k.m(this.f11890d.get());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || m == null || c.a.p0.x.d.c().d(f()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.p0.x.d.c().d(f())) {
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
                m.f((c.a.i0.a.h.d) aVar.f20582b.get("data"));
            } else if (c2 == 1) {
                m.c((String) aVar.f20582b.get("data"));
            }
        }
        c.a.p0.x.d.c().b(f());
    }

    public final void v(c.a.f0.b.c cVar, c.a.o0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cVar, aVar) == null) {
            try {
                Context context = TbadkCoreApplication.getInst().getContext();
                c.b bVar = new c.b();
                bVar.j(n.k(context));
                bVar.k(n.i(context));
                k = new c.a.f0.b.f.c(context, c.a.f0.b.f.f.m(), bVar.i(), cVar);
                this.f11889c = AdLoadState.LOADING;
                k.h();
                if (c.a.p0.a0.a.g.b.a) {
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
