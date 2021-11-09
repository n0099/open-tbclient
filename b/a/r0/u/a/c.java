package b.a.r0.u.a;

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
import b.a.e.e.p.l;
import b.a.r0.r.b;
import b.a.r0.y0.a;
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
/* loaded from: classes5.dex */
public class c implements b.a.r0.u.a.h.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String j = "6021002119-1732188456";
    public static volatile boolean k;
    public static volatile a.h l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f23882b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f23883c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f23884d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f23885e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f23886f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.l.a f23887g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f23888h;

    /* renamed from: i  reason: collision with root package name */
    public final a.i f23889i;

    /* loaded from: classes5.dex */
    public class a extends a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23890a;

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
            this.f23890a = cVar;
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str4 = "BEAR ad onAdClicked : " + str;
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.f23890a.f23887g != null) {
                    this.f23890a.f23887g.a(false, false, 6, str2, str3);
                }
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.f23890a.f23887g != null) {
                    this.f23890a.f23887g.onAdDismiss();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f23890a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, this.f23890a.f23887g == null ? 0 : this.f23890a.f23887g.hashCode()));
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str2 = "BEAR ad onAdError : " + str;
                }
                b.a.r0.u.a.j.a.k(b.a.r0.u.a.j.a.f23951d, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.f23890a.f23887g != null) {
                    this.f23890a.f23887g.onAdDismiss();
                }
            }
        }

        @Override // b.a.r0.y0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                boolean z = b.a.r0.u.a.h.b.f23940a;
                this.f23890a.f23887g.e(false, false, 6);
                b.a.r0.u.a.j.a.l(b.a.r0.u.a.j.a.f23951d, "0", str2, str3);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.f23890a.getClass().getSimpleName()).param("obj_param1", 0).param(TiebaStatic.Params.OBJ_PARAM2, this.f23890a.f23887g != null ? this.f23890a.f23887g.hashCode() : 0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23891a;

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
            this.f23891a = cVar;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str2 = "BEAR ad onAdLoaded successed: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23951d, "0", i2);
                if (b.a.r0.y0.a.i().m(str)) {
                    this.f23891a.f23886f = AdLoadState.SUCCEED;
                } else {
                    this.f23891a.f23886f = AdLoadState.FAILED;
                    ((ViewGroup) this.f23891a.f23882b.get()).removeView(this.f23891a.f23883c);
                }
                b.a.r0.u.a.h.a.c().h(this.f23891a.f23887g);
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (b.a.r0.u.a.h.b.f23940a) {
                    String str2 = "BEAR ad onLoadError: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                b.a.r0.u.a.j.a.j(b.a.r0.u.a.j.a.f23951d, "1", 0);
                this.f23891a.f23886f = AdLoadState.FAILED;
                ((ViewGroup) this.f23891a.f23882b.get()).removeView(this.f23891a.f23883c);
                b.a.r0.u.a.h.a.c().h(this.f23891a.f23887g);
            }
        }
    }

    /* renamed from: b.a.r0.u.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1158c implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23892a;

        /* renamed from: b.a.r0.u.a.c$c$a */
        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f23893e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f23894f;

            public a(C1158c c1158c, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1158c, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23893e = str;
                this.f23894f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                    return;
                }
                c.l.a(this.f23893e, this.f23894f);
            }
        }

        /* renamed from: b.a.r0.u.a.c$c$b */
        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f23895e;

            public b(C1158c c1158c, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1158c, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f23895e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.l == null) {
                    return;
                }
                c.l.onError(this.f23895e);
            }
        }

        public C1158c(c cVar) {
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
            this.f23892a = cVar;
        }

        @Override // b.a.r0.y0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    hashMap.put("loadSize", Integer.valueOf(i2));
                    b.a.r0.r.b.c().a(this.f23892a.d(), "onAdLoaded", hashMap);
                } else if (l.C()) {
                    c.l.a(str, i2);
                } else {
                    b.a.e.e.m.e.a().post(new a(this, str, i2));
                }
            }
        }

        @Override // b.a.r0.y0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.l == null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("sid", str);
                    b.a.r0.r.b.c().a(this.f23892a.d(), "onError", hashMap);
                } else if (l.C()) {
                    c.l.onError(str);
                } else {
                    b.a.e.e.m.e.a().post(new b(this, str));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23896e;

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
            this.f23896e = cVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f23896e.f23885e == null || this.f23896e.f23885e.getVisibility() == 0) {
                return;
            }
            this.f23896e.f23885e.setVisibility(0);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(186782730, "Lb/a/r0/u/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(186782730, "Lb/a/r0/u/a/c;");
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
        this.f23886f = AdLoadState.INIT;
        this.f23887g = null;
        this.f23888h = null;
        this.f23889i = new a(this);
        int k2 = b.a.q0.s.e0.b.j().k("splash_bear_sid_type_key", 0);
        if (b.a.q0.b.d.h()) {
            j = k2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            j = k2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            if (b.a.q0.b.d.h()) {
                j = i2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                j = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            b.a.q0.s.e0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // b.a.r0.u.a.h.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            b.a.r0.y0.a i2 = b.a.r0.y0.a.i();
            String str = j;
            C1158c c1158c = new C1158c(this);
            i2.n(context, str, c1158c, b.a.r0.y0.a.b("spalsh", b.a.r0.u.a.h.a.c().b() + ""));
            k = true;
        }
    }

    @Override // b.a.r0.u.a.h.b
    public AdLoadState b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23886f : (AdLoadState) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void c(b.a.q0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f23882b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f23883c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f23884d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            k();
            this.f23887g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f23882b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f23882b.get().addView(this.f23883c, layoutParams);
            boolean z = b.a.r0.u.a.h.b.f23940a;
            l = new b(this);
            if (k) {
                m();
                k = false;
            } else {
                String str = j;
                a.h hVar = l;
                b.a.r0.y0.a.i().n((Activity) context, str, hVar, b.a.r0.y0.a.b("spalsh", b.a.r0.u.a.h.a.c().b() + ""));
            }
            if (this.f23886f == AdLoadState.INIT) {
                this.f23886f = AdLoadState.LOADING;
            }
            b.a.r0.u.a.j.a.i(b.a.r0.u.a.j.a.f23951d);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // b.a.r0.u.a.h.b
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.r0.y0.a.i().d(j);
            l = null;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f23883c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f23883c.findViewById(R.id.splash_fun_click_region);
            this.f23885e = viewGroup;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f23885e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f23885e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void l() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (weakReference = this.f23882b) == null || weakReference.get().getParent() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f23882b.get().getLayoutParams();
        layoutParams.width = l.k(this.f23882b.get().getContext());
        layoutParams.height = (int) (l.i(this.f23882b.get().getContext()) * 0.8125d);
        this.f23882b.get().setLayoutParams(layoutParams);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || l == null || b.a.r0.r.b.c().d(d()).isEmpty()) {
            return;
        }
        for (b.a aVar : b.a.r0.r.b.c().d(d())) {
            String str = aVar.f22935a;
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
                l.a((String) aVar.f22936b.get("sid"), ((Integer) aVar.f22936b.get("loadSize")).intValue());
            } else if (c2 == 1) {
                l.onError((String) aVar.f22936b.get("sid"));
            }
        }
        b.a.r0.r.b.c().b(d());
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f23883c != null && this.f23884d != null) {
                if (this.f23888h == null) {
                    this.f23888h = new d(this);
                }
                this.f23884d.setOnHierarchyChangeListener(this.f23888h);
                if (this.f23882b.get() != null) {
                    Context context = this.f23882b.get().getContext();
                    if (context instanceof Activity) {
                        b.a.q0.s.a0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (b.a.r0.u.a.h.b.f23940a) {
                            String str = "BEAR ad showSplash: " + j;
                        }
                        b.a.r0.y0.a.i().y((Activity) context, j, this.f23884d, this.f23889i, b.a.r0.y0.a.b("spalsh", b.a.r0.u.a.h.a.c().b() + ""));
                        SkinManager.setBackgroundColor(this.f23883c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.u.a.h.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f23882b != null && this.f23886f == AdLoadState.SUCCEED) {
            b.a.q0.l.a aVar = this.f23887g;
            if (aVar != null) {
                aVar.d();
            }
            l();
            this.f23886f = AdLoadState.SHOWED;
            o();
        }
    }
}
