package c.a.r0.t.a;

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
import c.a.e.e.p.l;
import c.a.r0.q.b;
import c.a.r0.x0.a;
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
/* loaded from: classes3.dex */
public class c implements c.a.r0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f24861j = "6021002119-1732188456";
    public static volatile boolean k;
    public static volatile a.h l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f24862b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24863c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24864d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f24865e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f24866f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.l.a f24867g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f24868h;

    /* renamed from: i  reason: collision with root package name */
    public final a.i f24869i;

    /* loaded from: classes3.dex */
    public class a extends a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24870a;

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
            this.f24870a = cVar;
        }

        @Override // c.a.r0.x0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (c.a.r0.t.a.h.b.f24921a) {
                    String str4 = "BEAR ad onAdClicked : " + str;
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.f24870a.f24867g != null) {
                    this.f24870a.f24867g.b(false, false, 6, str2, str3);
                }
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.f24870a.f24867g != null) {
                    this.f24870a.f24867g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f24870a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.f24870a.f24867g == null ? 0 : this.f24870a.f24867g.hashCode()));
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.a.r0.t.a.h.b.f24921a) {
                    String str2 = "BEAR ad onAdError : " + str;
                }
                c.a.r0.t.a.j.a.k(c.a.r0.t.a.j.a.f24932d, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.f24870a.f24867g != null) {
                    this.f24870a.f24867g.onAdDismiss();
                }
            }
        }

        @Override // c.a.r0.x0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                boolean z = c.a.r0.t.a.h.b.f24921a;
                this.f24870a.f24867g.c(false, false, 6);
                c.a.r0.t.a.j.a.l(c.a.r0.t.a.j.a.f24932d, "0", str2, str3);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f24870a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.f24870a.f24867g != null ? this.f24870a.f24867g.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24871a;

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
            this.f24871a = cVar;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.a.r0.t.a.h.b.f24921a) {
                    String str2 = "BEAR ad onAdLoaded successed: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24932d, "0", i2);
                if (c.a.r0.x0.a.i().m(str)) {
                    this.f24871a.f24866f = AdLoadState.SUCCEED;
                } else {
                    this.f24871a.f24866f = AdLoadState.FAILED;
                    ((ViewGroup) this.f24871a.f24862b.get()).removeView(this.f24871a.f24863c);
                }
                c.a.r0.t.a.h.a.c().h(this.f24871a.f24867g);
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.a.r0.t.a.h.b.f24921a) {
                    String str2 = "BEAR ad onLoadError: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                c.a.r0.t.a.j.a.j(c.a.r0.t.a.j.a.f24932d, "1", 0);
                this.f24871a.f24866f = AdLoadState.FAILED;
                ((ViewGroup) this.f24871a.f24862b.get()).removeView(this.f24871a.f24863c);
                c.a.r0.t.a.h.a.c().h(this.f24871a.f24867g);
            }
        }
    }

    /* renamed from: c.a.r0.t.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1150c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24872a;

        /* renamed from: c.a.r0.t.a.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24873e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f24874f;

            public a(C1150c c1150c, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1150c, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24873e = str;
                this.f24874f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                    return;
                }
                c.l.a(this.f24873e, this.f24874f);
            }
        }

        /* renamed from: c.a.r0.t.a.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f24875e;

            public b(C1150c c1150c, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1150c, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f24875e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                    return;
                }
                c.l.onError(this.f24875e);
            }
        }

        public C1150c(c cVar) {
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
            this.f24872a = cVar;
        }

        @Override // c.a.r0.x0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i2));
                    c.a.r0.q.b.c().a(this.f24872a.d(), "onAdLoaded", hashMap);
                } else if (l.C()) {
                    c.l.a(str, i2);
                } else {
                    c.a.e.e.m.e.a().post(new a(this, str, i2));
                }
            }
        }

        @Override // c.a.r0.x0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    c.a.r0.q.b.c().a(this.f24872a.d(), "onError", hashMap);
                } else if (l.C()) {
                    c.l.onError(str);
                } else {
                    c.a.e.e.m.e.a().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24876e;

        public d(c cVar) {
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
            this.f24876e = cVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f24876e.f24865e == null || this.f24876e.f24865e.getVisibility() == 0) {
                return;
            }
            this.f24876e.f24865e.setVisibility(0);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-135249428, "Lc/a/r0/t/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-135249428, "Lc/a/r0/t/a/c;");
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
        this.f24866f = AdLoadState.INIT;
        this.f24867g = null;
        this.f24868h = null;
        this.f24869i = new a(this);
        int k2 = c.a.q0.s.d0.b.j().k("splash_bear_sid_type_key", 0);
        if (c.a.q0.b.d.h()) {
            f24861j = k2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            f24861j = k2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            if (c.a.q0.b.d.h()) {
                f24861j = i2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                f24861j = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            c.a.q0.s.d0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // c.a.r0.t.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            c.a.r0.x0.a i2 = c.a.r0.x0.a.i();
            String str = f24861j;
            C1150c c1150c = new C1150c(this);
            i2.n(context, str, c1150c, c.a.r0.x0.a.b("spalsh", c.a.r0.t.a.h.a.c().b() + ""));
            k = true;
        }
    }

    @Override // c.a.r0.t.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24866f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void c(c.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f24862b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f24863c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f24864d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            k();
            this.f24867g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f24862b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f24862b.get().addView(this.f24863c, layoutParams);
            boolean z = c.a.r0.t.a.h.b.f24921a;
            l = new b(this);
            if (k) {
                m();
                k = false;
            } else {
                String str = f24861j;
                a.h hVar = l;
                c.a.r0.x0.a.i().n((Activity) context, str, hVar, c.a.r0.x0.a.b("spalsh", c.a.r0.t.a.h.a.c().b() + ""));
            }
            this.f24866f = AdLoadState.LOADING;
            c.a.r0.t.a.j.a.i(c.a.r0.t.a.j.a.f24932d);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // c.a.r0.t.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.r0.x0.a.i().d(f24861j);
            l = null;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f24863c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f24863c.findViewById(R.id.splash_fun_click_region);
            this.f24865e = viewGroup;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f24865e);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.B(R.string.F_X01);
            d3.w(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f24865e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f24862b) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24862b.get().getLayoutParams();
        layoutParams.width = l.k(this.f24862b.get().getContext());
        layoutParams.height = (int) (l.i(this.f24862b.get().getContext()) * 0.8125d);
        this.f24862b.get().setLayoutParams(layoutParams);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || l == null || c.a.r0.q.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : c.a.r0.q.b.c().d(d())) {
            String str = aVar.f24088a;
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
                l.a((String) aVar.f24089b.get("sid"), ((Integer) aVar.f24089b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                l.onError((String) aVar.f24089b.get("sid"));
            }
        }
        c.a.r0.q.b.c().b(d());
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f24863c != null && this.f24864d != null) {
                if (this.f24868h == null) {
                    this.f24868h = new d(this);
                }
                this.f24864d.setOnHierarchyChangeListener(this.f24868h);
                if (this.f24862b.get() != null) {
                    Context context = this.f24862b.get().getContext();
                    if (context instanceof Activity) {
                        c.a.q0.s.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (c.a.r0.t.a.h.b.f24921a) {
                            String str = "BEAR ad showSplash: " + f24861j;
                        }
                        c.a.r0.x0.a.i().y((Activity) context, f24861j, this.f24864d, this.f24869i, c.a.r0.x0.a.b("spalsh", c.a.r0.t.a.h.a.c().b() + ""));
                        SkinManager.setBackgroundColor(this.f24863c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.t.a.h.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f24862b != null && this.f24866f == AdLoadState.SUCCEED) {
            l();
            this.f24866f = AdLoadState.SHOWED;
            o();
        }
    }
}
