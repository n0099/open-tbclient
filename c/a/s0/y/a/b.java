package c.a.s0.y.a;

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
import c.a.d.f.p.m;
import c.a.s0.e1.a;
import c.a.s0.v.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSplashClickRegionSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
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
public class b implements c.a.s0.y.a.g.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f25890j = "6021002119-1732188456";

    /* renamed from: k  reason: collision with root package name */
    public static volatile boolean f25891k;
    public static volatile a.h l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f25892b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f25893c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f25894d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f25895e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f25896f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.l.a f25897g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f25898h;

    /* renamed from: i  reason: collision with root package name */
    public final a.i f25899i;

    /* loaded from: classes8.dex */
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

        @Override // c.a.s0.e1.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (c.a.s0.y.a.g.b.a) {
                    String str4 = "BEAR ad onAdClicked : " + str;
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.a.f25897g != null) {
                    this.a.f25897g.a(false, false, 6, str2, str3);
                }
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.a.f25897g != null) {
                    this.a.f25897g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25897g == null ? 0 : this.a.f25897g.hashCode()));
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.a.s0.y.a.g.b.a) {
                    String str2 = "BEAR ad onAdError : " + str;
                }
                c.a.s0.y.a.i.a.k(c.a.s0.y.a.i.a.f25945c, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.a.f25897g != null) {
                    this.a.f25897g.onAdDismiss();
                }
            }
        }

        @Override // c.a.s0.e1.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                boolean z = c.a.s0.y.a.g.b.a;
                this.a.f25897g.e(false, false, 6);
                c.a.s0.y.a.i.a.l(c.a.s0.y.a.i.a.f25945c, "0", str2, str3);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.a.f25897g != null ? this.a.f25897g.hashCode() : 0));
            }
        }
    }

    /* renamed from: c.a.s0.y.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1501b implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1501b(b bVar) {
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

        @Override // c.a.s0.e1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.a.s0.y.a.g.b.a) {
                    String str2 = "BEAR ad onAdLoaded successed: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                c.a.s0.y.a.i.a.j(c.a.s0.y.a.i.a.f25945c, "0", i2);
                if (c.a.s0.e1.a.i().m(str)) {
                    this.a.f25896f = AdLoadState.SUCCEED;
                } else {
                    this.a.f25896f = AdLoadState.FAILED;
                    ((ViewGroup) this.a.f25892b.get()).removeView(this.a.f25893c);
                }
                c.a.s0.y.a.g.a.c().h(this.a.f25897g);
            }
        }

        @Override // c.a.s0.e1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.a.s0.y.a.g.b.a) {
                    String str2 = "BEAR ad onLoadError: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                c.a.s0.y.a.i.a.j(c.a.s0.y.a.i.a.f25945c, "1", 0);
                this.a.f25896f = AdLoadState.FAILED;
                ((ViewGroup) this.a.f25892b.get()).removeView(this.a.f25893c);
                c.a.s0.y.a.g.a.c().h(this.a.f25897g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25900e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f25901f;

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
                this.f25900e = str;
                this.f25901f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.l == null) {
                    return;
                }
                b.l.a(this.f25900e, this.f25901f);
            }
        }

        /* renamed from: c.a.s0.y.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1502b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f25902e;

            public RunnableC1502b(c cVar, String str) {
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
                this.f25902e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.l == null) {
                    return;
                }
                b.l.onError(this.f25902e);
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

        @Override // c.a.s0.e1.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (b.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i2));
                    c.a.s0.v.d.c().a(this.a.d(), "onAdLoaded", hashMap);
                } else if (m.B()) {
                    b.l.a(str, i2);
                } else {
                    e.a().post(new a(this, str, i2));
                }
            }
        }

        @Override // c.a.s0.e1.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (b.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    c.a.s0.v.d.c().a(this.a.d(), "onError", hashMap);
                } else if (m.B()) {
                    b.l.onError(str);
                } else {
                    e.a().post(new RunnableC1502b(this, str));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25903e;

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
            this.f25903e = bVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f25903e.f25895e == null || this.f25903e.f25895e.getVisibility() == 0) {
                return;
            }
            this.f25903e.f25895e.setVisibility(0);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1799558167, "Lc/a/s0/y/a/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1799558167, "Lc/a/s0/y/a/b;");
        }
    }

    public b() {
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
        this.f25896f = AdLoadState.INIT;
        this.f25897g = null;
        this.f25898h = null;
        this.f25899i = new a(this);
        int k2 = c.a.r0.s.g0.b.j().k("splash_bear_sid_type_key", 0);
        if (c.a.r0.b.d.i()) {
            f25890j = k2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            f25890j = k2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            if (c.a.r0.b.d.i()) {
                f25890j = i2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                f25890j = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            c.a.r0.s.g0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // c.a.s0.y.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            c.a.s0.e1.a i2 = c.a.s0.e1.a.i();
            String str = f25890j;
            c cVar = new c(this);
            i2.n(context, str, cVar, c.a.s0.e1.a.b("spalsh", c.a.s0.y.a.g.a.c().b() + ""));
            f25891k = true;
        }
    }

    @Override // c.a.s0.y.a.g.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25896f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.s0.y.a.g.b
    public void c(c.a.r0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f25892b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f25893c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f25894d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            k();
            this.f25897g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.k(context), (int) (m.i(this.f25892b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f25892b.get().addView(this.f25893c, layoutParams);
            boolean z = c.a.s0.y.a.g.b.a;
            l = new C1501b(this);
            if (f25891k) {
                m();
                f25891k = false;
            } else {
                String str = f25890j;
                a.h hVar = l;
                c.a.s0.e1.a.i().n((Activity) context, str, hVar, c.a.s0.e1.a.b("spalsh", c.a.s0.y.a.g.a.c().b() + ""));
            }
            if (this.f25896f == AdLoadState.INIT) {
                this.f25896f = AdLoadState.LOADING;
            }
            c.a.s0.y.a.i.a.i(c.a.s0.y.a.i.a.f25945c);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // c.a.s0.y.a.g.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.y.a.g.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.s0.e1.a.i().d(f25890j);
            l = null;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f25893c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f25893c.findViewById(R.id.splash_fun_click_region);
            this.f25895e = viewGroup;
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f25895e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f25895e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f25892b) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f25892b.get().getLayoutParams();
        layoutParams.width = m.k(this.f25892b.get().getContext());
        layoutParams.height = (int) (m.i(this.f25892b.get().getContext()) * 0.8125d);
        this.f25892b.get().setLayoutParams(layoutParams);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || l == null || c.a.s0.v.d.c().d(d()).isEmpty()) {
            return;
        }
        for (d.a aVar : c.a.s0.v.d.c().d(d())) {
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
                l.a((String) aVar.f24646b.get("sid"), ((Integer) aVar.f24646b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                l.onError((String) aVar.f24646b.get("sid"));
            }
        }
        c.a.s0.v.d.c().b(d());
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f25893c != null && this.f25894d != null) {
                if (this.f25898h == null) {
                    this.f25898h = new d(this);
                }
                this.f25894d.setOnHierarchyChangeListener(this.f25898h);
                if (this.f25892b.get() != null) {
                    Context context = this.f25892b.get().getContext();
                    if (context instanceof Activity) {
                        c.a.r0.s.c0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (c.a.s0.y.a.g.b.a) {
                            String str = "BEAR ad showSplash: " + f25890j;
                        }
                        c.a.s0.e1.a.i().y((Activity) context, f25890j, this.f25894d, this.f25899i, c.a.s0.e1.a.b("spalsh", c.a.s0.y.a.g.a.c().b() + ""));
                        SkinManager.setBackgroundColor(this.f25893c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y.a.g.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f25892b != null && this.f25896f == AdLoadState.SUCCEED) {
            c.a.r0.l.a aVar = this.f25897g;
            if (aVar != null) {
                aVar.d();
            }
            l();
            this.f25896f = AdLoadState.SHOWED;
            o();
        }
    }
}
