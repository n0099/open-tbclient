package c.a.p0.a0.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import c.a.p0.g1.b;
import c.a.p0.x.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
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
/* loaded from: classes2.dex */
public class b implements c.a.p0.a0.a.g.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "6021002119-1732188456";
    public static volatile boolean n;
    public static volatile b.h o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f11880b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f11881c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f11882d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f11883e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f11884f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.k.a f11885g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f11886h;
    public boolean i;
    public long j;
    public final SplashNativePolicy k;
    public final b.i l;

    /* loaded from: classes2.dex */
    public class a extends b.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.f11885g != null) {
                    this.a.f11885g.d(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.f11885g != null) {
                    this.a.f11885g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11885g == null ? 0 : this.a.f11885g.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 6).param("obj_type", "a064").param("obj_param1", 4).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param(TiebaStatic.Params.OBJ_PARAM2, this.a.i ? 2 : 1).param("fid", this.a.j).eventStat();
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                c.a.p0.a0.a.i.b.j(c.a.p0.a0.a.i.b.f11930c, "1", null, null, str, null, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.f11885g != null) {
                    this.a.f11885g.onAdDismiss();
                }
            }
        }

        @Override // c.a.p0.g1.b.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                this.a.f11885g.g(false, false, 6);
                c.a.p0.a0.a.i.b.j(c.a.p0.a0.a.i.b.f11930c, "0", null, str2, str, str3, this.a.j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f11885g != null ? this.a.f11885g.hashCode() : 0));
            }
        }
    }

    /* renamed from: c.a.p0.a0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0902b implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0902b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.f11885g != null) {
                    this.a.f11885g.f(c.a.p0.a0.a.i.b.f11930c);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (c.a.p0.g1.b.j().o(str)) {
                    this.a.f11884f = AdLoadState.SUCCEED;
                    c.a.p0.a0.a.i.b.i(c.a.p0.a0.a.i.b.f11930c, "0", null, null, 0, i, this.a.i, this.a.j);
                } else {
                    this.a.f11884f = AdLoadState.FAILED;
                    c.a.p0.a0.a.i.b.i(c.a.p0.a0.a.i.b.f11930c, "1", str, null, 2, i, this.a.i, this.a.j);
                    ((ViewGroup) this.a.f11880b.get()).removeView(this.a.f11881c);
                }
                c.a.p0.a0.a.g.a.e().n(this.a.f11885g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                c.a.p0.a0.a.i.a.e(this.a.j);
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.a.p0.a0.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                if (this.a.f11885g != null) {
                    this.a.f11885g.f(c.a.p0.a0.a.i.b.f11930c);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                c.a.p0.a0.a.i.b.i(c.a.p0.a0.a.i.b.f11930c, "1", str, null, 1, 0, this.a.i, this.a.j);
                this.a.f11884f = AdLoadState.FAILED;
                ((ViewGroup) this.a.f11880b.get()).removeView(this.a.f11881c);
                c.a.p0.a0.a.g.a.e().n(this.a.f11885g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f11887b;

            public a(c cVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f11887b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.o == null) {
                    return;
                }
                b.o.a(this.a, this.f11887b);
            }
        }

        /* renamed from: c.a.p0.a0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0903b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            public RunnableC0903b(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.o == null) {
                    return;
                }
                b.o.onError(this.a);
            }
        }

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.g1.b.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (b.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i));
                    c.a.p0.x.d.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (n.B()) {
                    b.o.a(str, i);
                } else {
                    e.a().post(new a(this, str, i));
                }
            }
        }

        @Override // c.a.p0.g1.b.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (b.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    c.a.p0.x.d.c().a(this.a.f(), "onError", hashMap);
                } else if (n.B()) {
                    b.o.onError(str);
                } else {
                    e.a().post(new RunnableC0903b(this, str));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.a.f11883e == null || this.a.f11883e.getVisibility() == 0) {
                return;
            }
            this.a.f11883e.setVisibility(0);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(796455230, "Lc/a/p0/a0/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(796455230, "Lc/a/p0/a0/a/b;");
        }
    }

    public b(SplashNativePolicy splashNativePolicy) {
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
        this.f11884f = AdLoadState.INIT;
        this.f11885g = null;
        this.f11886h = null;
        this.i = false;
        this.j = -1L;
        this.l = new a(this);
        this.k = splashNativePolicy;
        int l = c.a.o0.r.j0.b.k().l("splash_bear_sid_type_key", 0);
        if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
            m = l == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            m = l == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i) == null) {
            if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
                m = i == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                m = i == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            c.a.o0.r.j0.b.k().w("splash_bear_sid_type_key", i);
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            c cVar = new c(this);
            c.a.p0.g1.b.j().p(context, m, (int) (n.i(context) * 0.8125d), cVar, c.a.p0.g1.b.b("spalsh", c.a.p0.a0.a.g.a.e().d() + ""));
            n = true;
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = this.f11882d;
            return frameLayout != null && frameLayout.getChildCount() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11884f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.p0.a0.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.g1.b.j().d(m);
            o = null;
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public void e(c.a.o0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.i = dVar.d();
            this.j = dVar.c();
            this.f11880b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0796, (ViewGroup) null, false);
            this.f11881c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f11882d = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d5e);
            p();
            this.f11885g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.k(context), (int) (n.i(this.f11880b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f11880b.get().addView(this.f11881c, layoutParams);
            if (c.a.p0.a0.a.g.b.a) {
                System.out.println("IAdSdkSplash BEAR ad start load");
            }
            o = new C0902b(this);
            if (n) {
                r();
                n = false;
            } else {
                String str = m;
                int i = (int) (n.i(context) * 0.8125d);
                b.h hVar = o;
                c.a.p0.g1.b.j().p((Activity) context, str, i, hVar, c.a.p0.g1.b.b("spalsh", c.a.p0.a0.a.g.a.e().d() + ""));
            }
            if (this.f11884f == AdLoadState.INIT) {
                this.f11884f = AdLoadState.LOADING;
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // c.a.p0.a0.a.g.b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f11881c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f11881c.findViewById(R.id.obfuscated_res_0x7f091d5d);
            this.f11883e = viewGroup;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f11883e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091d60));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f11883e.findViewById(R.id.obfuscated_res_0x7f091d5f), R.drawable.obfuscated_res_0x7f08090a, R.color.CAM_X0201, null);
        }
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (weakReference = this.f11880b) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f11880b.get().getLayoutParams();
        layoutParams.width = n.k(this.f11880b.get().getContext());
        layoutParams.height = (int) (n.i(this.f11880b.get().getContext()) * 0.8125d);
        this.f11880b.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || o == null || c.a.p0.x.d.c().d(f()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.p0.x.d.c().d(f())) {
            String str = aVar.a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1349867671) {
                if (hashCode == 861234439 && str.equals("onAdLoaded")) {
                    c2 = 0;
                }
            } else if (str.equals("onError")) {
                c2 = 1;
            }
            if (c2 == 0) {
                o.a((String) aVar.f20582b.get("sid"), ((Integer) aVar.f20582b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                o.onError((String) aVar.f20582b.get("sid"));
            }
        }
        c.a.p0.x.d.c().b(f());
    }

    @Override // c.a.p0.a0.a.g.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f11880b != null && this.f11884f == AdLoadState.SUCCEED) {
            q();
            this.f11884f = AdLoadState.SHOWED;
            t();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f11881c != null && this.f11882d != null) {
                if (this.f11886h == null) {
                    this.f11886h = new d(this);
                }
                this.f11882d.setOnHierarchyChangeListener(this.f11886h);
                if (this.f11880b.get() != null) {
                    Context context = this.f11880b.get().getContext();
                    if (context instanceof Activity) {
                        c.a.o0.r.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (c.a.p0.a0.a.g.b.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + m);
                        }
                        c.a.p0.g1.b.j().A((Activity) context, m, this.f11882d, this.l, c.a.p0.g1.b.b("spalsh", c.a.p0.a0.a.g.a.e().d() + ""));
                        SkinManager.setBackgroundColor(this.f11881c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
