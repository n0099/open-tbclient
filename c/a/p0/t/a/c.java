package c.a.p0.t.a;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.w0.a;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class c implements c.a.p0.t.a.h.b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f24103j = "6021002119-1732188456";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<ViewGroup> f24104b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24105c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f24106d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f24107e;

    /* renamed from: f  reason: collision with root package name */
    public AdLoadState f24108f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.l.a f24109g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f24110h;

    /* renamed from: i  reason: collision with root package name */
    public final a.i f24111i;

    /* loaded from: classes3.dex */
    public class a extends a.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24112a;

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
            this.f24112a = cVar;
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClicked(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (c.a.p0.t.a.h.b.f24147a) {
                    String str4 = "BEAR ad onAdClicked : " + str;
                }
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
                if (this.f24112a.f24109g != null) {
                    this.f24112a.f24109g.b(false, false, 6, str2, str3);
                }
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdClose(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 6).param("obj_type", 1));
                FunAdRecordHttpMessage.uploadSplashSkipRecord("1");
                if (this.f24112a.f24109g != null) {
                    this.f24112a.f24109g.onAdDismiss();
                }
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (c.a.p0.t.a.h.b.f24147a) {
                    String str2 = "BEAR ad onAdError : " + str;
                }
                c.a.p0.t.a.j.a.k(c.a.p0.t.a.j.a.f24158d, "1");
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "1", null, null, null, null, null, null, null);
                if (this.f24112a.f24109g != null) {
                    this.f24112a.f24109g.onAdDismiss();
                }
            }
        }

        @Override // c.a.p0.w0.a.i
        public void onAdShow(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
                boolean z = c.a.p0.t.a.h.b.f24147a;
                this.f24112a.f24109g.c(false, false, 6);
                c.a.p0.t.a.j.a.l(c.a.p0.t.a.j.a.f24158d, "0", str2, str3);
                FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a064", "0", null, null, null, null, null, null, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24113a;

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
            this.f24113a = cVar;
        }

        @Override // c.a.p0.w0.a.h
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (c.a.p0.t.a.h.b.f24147a) {
                    String str2 = "BEAR ad onAdLoaded successed: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "0", null, null, null);
                c.a.p0.t.a.j.a.j(c.a.p0.t.a.j.a.f24158d, "0", i2);
                if (c.a.p0.w0.a.i().m(str)) {
                    this.f24113a.f24108f = AdLoadState.SUCCEED;
                } else {
                    this.f24113a.f24108f = AdLoadState.FAILED;
                    ((ViewGroup) this.f24113a.f24104b.get()).removeView(this.f24113a.f24105c);
                }
                c.a.p0.t.a.h.a.c().g(this.f24113a.f24109g);
            }
        }

        @Override // c.a.p0.w0.a.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (c.a.p0.t.a.h.b.f24147a) {
                    String str2 = "BEAR ad onLoadError: " + str;
                }
                FunAdRecordHttpMessage.uploadRequestRecord("a064", "1", null, null, "0");
                c.a.p0.t.a.j.a.j(c.a.p0.t.a.j.a.f24158d, str, 0);
                this.f24113a.f24108f = AdLoadState.FAILED;
                ((ViewGroup) this.f24113a.f24104b.get()).removeView(this.f24113a.f24105c);
                c.a.p0.t.a.h.a.c().g(this.f24113a.f24109g);
            }
        }
    }

    /* renamed from: c.a.p0.t.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewGroup$OnHierarchyChangeListenerC1120c implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24114e;

        public ViewGroup$OnHierarchyChangeListenerC1120c(c cVar) {
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
            this.f24114e = cVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || this.f24114e.f24107e == null || this.f24114e.f24107e.getVisibility() == 0) {
                return;
            }
            this.f24114e.f24107e.setVisibility(0);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-815307798, "Lc/a/p0/t/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-815307798, "Lc/a/p0/t/a/c;");
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
        this.f24108f = AdLoadState.INIT;
        this.f24109g = null;
        this.f24110h = null;
        this.f24111i = new a(this);
        int k = c.a.o0.s.d0.b.j().k("splash_bear_sid_type_key", 0);
        if (c.a.o0.b.d.h()) {
            f24103j = k == 1 ? "6021002538-255943035" : "6021002533-210422477";
        } else {
            f24103j = k == 1 ? "6021002118-283136489" : "6021002119-1732188456";
        }
    }

    public static void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i2) == null) {
            if (c.a.o0.b.d.h()) {
                f24103j = i2 == 1 ? "6021002538-255943035" : "6021002533-210422477";
            } else {
                f24103j = i2 == 1 ? "6021002118-283136489" : "6021002119-1732188456";
            }
            c.a.o0.s.d0.b.j().v("splash_bear_sid_type_key", i2);
        }
    }

    @Override // c.a.p0.t.a.h.b
    public AdLoadState a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24108f : (AdLoadState) invokeV.objValue;
    }

    @Override // c.a.p0.t.a.h.b
    public void b(c.a.o0.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            Context context = dVar.b().getContext();
            if (!(context instanceof Activity) || dVar.b() == null) {
                return;
            }
            this.f24104b = new WeakReference<>(dVar.b());
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.splash_fun_layout, (ViewGroup) null, false);
            this.f24105c = viewGroup;
            if (viewGroup == null) {
                return;
            }
            this.f24106d = (FrameLayout) viewGroup.findViewById(R.id.splash_fun_container);
            i();
            this.f24109g = dVar.a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(context), (int) (l.i(this.f24104b.get().getContext()) * 0.8125d));
            layoutParams.addRule(14, -1);
            this.f24104b.get().addView(this.f24105c, layoutParams);
            boolean z = c.a.p0.t.a.h.b.f24147a;
            String str = f24103j;
            b bVar = new b(this);
            c.a.p0.w0.a.i().n((Activity) context, str, bVar, c.a.p0.w0.a.b("spalsh", c.a.p0.t.a.h.a.c().b() + ""));
            this.f24108f = AdLoadState.LOADING;
            c.a.p0.t.a.j.a.i(c.a.p0.t.a.j.a.f24158d);
            FunAdRecordHttpMessage.uploadRequestRecord("a064", null, null, null, null);
        }
    }

    @Override // c.a.p0.t.a.h.b
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "bear" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.t.a.h.b
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.p0.w0.a.i().d(f24103j);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f24105c != null && FunAdSplashClickRegionSwitch.isOpen()) {
            ViewGroup viewGroup = (ViewGroup) this.f24105c.findViewById(R.id.splash_fun_click_region);
            this.f24107e = viewGroup;
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f24107e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.o0.s.u.c d3 = c.a.o0.s.u.c.d((TextView) viewGroup.findViewById(R.id.splash_fun_textview));
            d3.y(R.string.F_X01);
            d3.t(R.color.CAM_X0101);
            WebPManager.setPureDrawable((ImageView) this.f24107e.findViewById(R.id.splash_fun_go), R.drawable.icon_pure_go, R.color.CAM_X0201, null);
        }
    }

    public final void j() {
        WeakReference<ViewGroup> weakReference;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (weakReference = this.f24104b) == null || weakReference.get().getParent() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f24104b.get().getLayoutParams();
        layoutParams.width = l.k(this.f24104b.get().getContext());
        layoutParams.height = (int) (l.i(this.f24104b.get().getContext()) * 0.8125d);
        this.f24104b.get().setLayoutParams(layoutParams);
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f24105c != null && this.f24106d != null) {
                if (this.f24110h == null) {
                    this.f24110h = new ViewGroup$OnHierarchyChangeListenerC1120c(this);
                }
                this.f24106d.setOnHierarchyChangeListener(this.f24110h);
                if (this.f24104b.get() != null) {
                    Context context = this.f24104b.get().getContext();
                    if (context instanceof Activity) {
                        c.a.o0.s.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "bear show");
                        if (c.a.p0.t.a.h.b.f24147a) {
                            String str = "BEAR ad showSplash: " + f24103j;
                        }
                        c.a.p0.w0.a.i().y((Activity) context, f24103j, this.f24106d, this.f24111i, c.a.p0.w0.a.b("spalsh", c.a.p0.t.a.h.a.c().b() + ""));
                        SkinManager.setBackgroundColor(this.f24105c, R.color.CAM_X0101, 0);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.t.a.h.b
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f24104b != null && this.f24108f == AdLoadState.SUCCEED) {
            j();
            this.f24108f = AdLoadState.SHOWED;
            l();
        }
    }
}
