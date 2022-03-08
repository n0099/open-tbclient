package c.a.r0.y.a;

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
import c.a.r0.e1.a;
import c.a.r0.v.d;
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
/* loaded from: classes3.dex */
public class b implements c.a.r0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String m = "6021002119-1732188456";
    public static volatile boolean n;
    public static volatile a.h o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f24625b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24626c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24627d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f24628e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f24629f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.k.a f24630g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f24631h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24632i;

    /* renamed from: j  reason: collision with root package name */
    public long f24633j;
    public final SplashNativePolicy k;
    public final a.i l;

    /* loaded from: classes3.dex */
    public class a extends a.k {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdClicked : " + str);
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.f24630g != null) {
                    this.a.f24630g.b(false, false, 6, str, str2, str3);
                }
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.f24630g != null) {
                    this.a.f24630g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f24630g == null ? 0 : this.a.f24630g.hashCode()));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 6).param("obj_type", "a064").param("obj_param1", 4).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.f24633j).eventStat();
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash bear ad onAdClose");
                }
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdError : " + str);
                }
                c.a.r0.y.a.i.b.j(c.a.r0.y.a.i.b.f24691c, "1", null, null, str, null, this.a.f24633j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.f24630g != null) {
                    this.a.f24630g.onAdDismiss();
                }
            }
        }

        @Override // c.a.r0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    System.out.println("IAdSdkSplash BEAR ad onAdshow");
                }
                this.a.f24630g.f(false, false, 6);
                c.a.r0.y.a.i.b.j(c.a.r0.y.a.i.b.f24691c, "0", null, str2, str, str3, this.a.f24633j);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f24630g != null ? this.a.f24630g.hashCode() : 0));
            }
        }
    }

    /* renamed from: c.a.r0.y.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1512b implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1512b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.e1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onAdLoaded successed: " + str);
                }
                if (this.a.f24630g != null) {
                    this.a.f24630g.e(c.a.r0.y.a.i.b.f24691c);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                if (c.a.r0.e1.a.i().m(str)) {
                    this.a.f24629f = AdLoadState.SUCCEED;
                    c.a.r0.y.a.i.b.i(c.a.r0.y.a.i.b.f24691c, "0", null, null, 0, i2, this.a.f24632i, this.a.f24633j);
                } else {
                    this.a.f24629f = AdLoadState.FAILED;
                    c.a.r0.y.a.i.b.i(c.a.r0.y.a.i.b.f24691c, "1", str, null, 2, i2, this.a.f24632i, this.a.f24633j);
                    ((ViewGroup) this.a.f24625b.get()).removeView(this.a.f24626c);
                }
                c.a.r0.y.a.g.a.e().m(this.a.f24630g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(81);
                }
                c.a.r0.y.a.i.a.e(this.a.f24633j);
            }
        }

        @Override // c.a.r0.e1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.a.r0.y.a.g.b.a) {
                    PrintStream printStream = System.out;
                    printStream.println("IAdSdkSplash BEAR ad onLoadError: " + str);
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                c.a.r0.y.a.i.b.i(c.a.r0.y.a.i.b.f24691c, "1", str, null, 1, 0, this.a.f24632i, this.a.f24633j);
                this.a.f24629f = AdLoadState.FAILED;
                ((ViewGroup) this.a.f24625b.get()).removeView(this.a.f24626c);
                c.a.r0.y.a.g.a.e().m(this.a.f24630g);
                if (this.a.k != null) {
                    this.a.k.onSplashEvent(82);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24634e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f24635f;

            public a(c cVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24634e = str;
                this.f24635f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.o == null) {
                    return;
                }
                b.o.a(this.f24634e, this.f24635f);
            }
        }

        /* renamed from: c.a.r0.y.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1513b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24636e;

            public RunnableC1513b(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24636e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.o == null) {
                    return;
                }
                b.o.onError(this.f24636e);
            }
        }

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.e1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (b.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i2));
                    c.a.r0.v.d.c().a(this.a.f(), "onAdLoaded", hashMap);
                } else if (n.B()) {
                    b.o.a(str, i2);
                } else {
                    e.a().post(new a(this, str, i2));
                }
            }
        }

        @Override // c.a.r0.e1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (b.o == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    c.a.r0.v.d.c().a(this.a.f(), "onError", hashMap);
                } else if (n.B()) {
                    b.o.onError(str);
                } else {
                    e.a().post(new RunnableC1513b(this, str));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24637e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24637e = bVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f24637e.f24628e == null || this.f24637e.f24628e.getVisibility() == 0) {
                return;
            }
            this.f24637e.f24628e.setVisibility(0);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(7896296, "Lc/a/r0/y/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(7896296, "Lc/a/r0/y/a/b;");
        }
    }

    public b(SplashNativePolicy splashNativePolicy) {
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
        this.f24629f = AdLoadState.INIT;
        this.f24630g = null;
        this.f24631h = null;
        this.f24632i = false;
        this.f24633j = -1L;
        this.l = new a(this);
        this.k = splashNativePolicy;
        int l = c.a.q0.r.j0.b.k().l("splash_bear_sid_type_key", 0);
        if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
            m = l == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            m = l == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            if (UbsABTestHelper.isClickEyeSplashFunAdABTest()) {
                m = i2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                m = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            c.a.q0.r.j0.b.k().w("splash_bear_sid_type_key", i2);
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            c.a.r0.e1.a i2 = c.a.r0.e1.a.i();
            String str = m;
            c cVar = new c(this);
            i2.n(context, str, cVar, c.a.r0.e1.a.b("spalsh", c.a.r0.y.a.g.a.e().d() + ""));
            n = true;
        }
    }

    @Override // c.a.r0.y.a.g.b
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = this.f24627d;
            return frameLayout != null && frameLayout.getChildCount() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.y.a.g.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public AdLoadState d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24629f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.e1.a.i().d(m);
            o = null;
        }
    }

    @Override // c.a.r0.y.a.g.b
    public void e(c.a.q0.k.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f24632i = dVar.d();
            this.f24633j = dVar.c();
            this.f24625b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f24626c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f24627d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            p();
            this.f24630g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.k(context), (int) (n.i(this.f24625b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f24625b.get().addView(this.f24626c, layoutParams);
            if (c.a.r0.y.a.g.b.a) {
                System.out.println("IAdSdkSplash BEAR ad start load");
            }
            o = new C1512b(this);
            if (n) {
                r();
                n = false;
            } else {
                String str = m;
                a.h hVar = o;
                c.a.r0.e1.a.i().n((Activity) context, str, hVar, c.a.r0.e1.a.b("spalsh", c.a.r0.y.a.g.a.e().d() + ""));
            }
            if (this.f24629f == AdLoadState.INIT) {
                this.f24629f = AdLoadState.LOADING;
            }
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // c.a.r0.y.a.g.b
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f24626c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f24626c.findViewById(R.id.splash_fun_click_region);
            this.f24628e = viewGroup;
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f24628e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f24628e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void q() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (weakReference = this.f24625b) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f24625b.get().getLayoutParams();
        layoutParams.width = n.k(this.f24625b.get().getContext());
        layoutParams.height = (int) (n.i(this.f24625b.get().getContext()) * 0.8125d);
        this.f24625b.get().setLayoutParams(layoutParams);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || o == null || c.a.r0.v.d.c().d(f()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.r0.v.d.c().d(f())) {
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
                o.a((String) aVar.f24150b.get("sid"), ((Integer) aVar.f24150b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                o.onError((String) aVar.f24150b.get("sid"));
            }
        }
        c.a.r0.v.d.c().b(f());
    }

    @Override // c.a.r0.y.a.g.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f24625b != null && this.f24629f == AdLoadState.SUCCEED) {
            q();
            this.f24629f = AdLoadState.SHOWED;
            t();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f24626c != null && this.f24627d != null) {
                if (this.f24631h == null) {
                    this.f24631h = new d(this);
                }
                this.f24627d.setOnHierarchyChangeListener(this.f24631h);
                if (this.f24625b.get() != null) {
                    Context context = this.f24625b.get().getContext();
                    if (context instanceof Activity) {
                        c.a.q0.r.d0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (c.a.r0.y.a.g.b.a) {
                            PrintStream printStream = System.out;
                            printStream.println("IAdSdkSplash BEAR ad showSplash: " + m);
                        }
                        c.a.r0.e1.a.i().y((Activity) context, m, this.f24627d, this.l, c.a.r0.e1.a.b("spalsh", c.a.r0.y.a.g.a.e().d() + ""));
                        SkinManager.setBackgroundColor(this.f24626c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
