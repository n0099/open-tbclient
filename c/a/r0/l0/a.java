package c.a.r0.l0;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.airbnb.lottie.RenderMode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.easterEgg.ActivityLifeCycleListener;
import com.baidu.tieba.easterEgg.EasterEggBridge;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f21348a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f21349b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.k3.m0.a f21350c;

    /* renamed from: d  reason: collision with root package name */
    public ActivityLifeCycleListener f21351d;

    /* renamed from: e  reason: collision with root package name */
    public BaseWebView f21352e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.k3.m0.c f21353f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f21354g;

    /* renamed from: c.a.r0.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0998a implements c.a.r0.k3.m0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21355a;

        public C0998a(a aVar) {
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
            this.f21355a = aVar;
        }

        @Override // c.a.r0.k3.m0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsPromptResult)) == null) ? this.f21355a.f21350c != null && this.f21355a.f21350c.b(this.f21355a.f21352e, str, jsPromptResult) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21356e;

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
            this.f21356e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21356e.f21349b.removeCallbacksAndMessages(null);
                this.f21356e.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21357e;

        public c(a aVar) {
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
            this.f21357e = aVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21357e.f21348a = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21359f;

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21359f = aVar;
            this.f21358e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f21359f.h(this.f21358e);
                } catch (Throwable unused) {
                    this.f21359f.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements BaseWebView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21360e;

        public e(a aVar) {
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
            this.f21360e = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                this.f21360e.f21349b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements BaseWebView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21361a;

        public f(a aVar) {
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
            this.f21361a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i2, str, str2) == null) {
                this.f21361a.f21349b.removeCallbacksAndMessages(null);
                this.f21361a.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21362e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f21363f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f21364g;

        public g(a aVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21364g = aVar;
            this.f21362e = str;
            this.f21363f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f21364g.i(this.f21362e, this.f21363f);
                } catch (Throwable unused) {
                    this.f21364g.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21365e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f21366f;

        public h(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21366f = aVar;
            this.f21365e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!k.isEmpty(this.f21365e) && (view.getContext() instanceof TbPageContextSupport)) {
                    TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 1));
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) view.getContext()).getPageContext(), new String[]{this.f21365e});
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13451").param("obj_type", 2));
                this.f21366f.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21367e;

        public i(a aVar) {
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
            this.f21367e = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f21367e.e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f21367e.f21349b.removeCallbacksAndMessages(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f21368a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1576023796, "Lc/a/r0/l0/a$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1576023796, "Lc/a/r0/l0/a$j;");
                    return;
                }
            }
            f21368a = new a(null);
        }
    }

    public /* synthetic */ a(C0998a c0998a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? j.f21368a : (a) invokeV.objValue;
    }

    public void e() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f21348a) != null && popupWindow.isShowing()) {
            try {
                this.f21348a.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public final boolean g(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) ? activity != null && (activity.getClass().getName().contains("Write") || activity.getClass().getName().contains("TransmitPostEditActivity") || activity.getClass().getName().contains("Vcode")) : invokeL.booleanValue;
    }

    public void h(String str) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || k.isEmpty(str) || (b2 = c.a.e.a.b.g().b()) == null || b2.getWindow() == null || b2.getWindow().getDecorView() == null) {
            return;
        }
        if (g(b2)) {
            this.f21349b.postDelayed(new d(this, str), 1000L);
            return;
        }
        PopupWindow popupWindow = this.f21348a;
        if (popupWindow != null && popupWindow.isShowing()) {
            if (this.f21348a.getContentView() != null && this.f21348a.getContentView().getContext() == b2) {
                return;
            }
            e();
        }
        View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_h5_layout, (ViewGroup) null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        BaseWebView baseWebView = (BaseWebView) inflate.findViewById(R.id.dialog_webview);
        this.f21352e = baseWebView;
        baseWebView.loadUrl(str);
        this.f21352e.setOnPageFinishedListener(new e(this));
        this.f21352e.setOnReceivedErrorListener(new f(this));
        this.f21352e.setBackgroundColor(0);
        this.f21352e.setOnJsPromptCallback(this.f21353f);
        j(b2, inflate);
    }

    public void i(String str, String str2) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) || k.isEmpty(str)) {
            return;
        }
        PopupWindow popupWindow = this.f21348a;
        if ((popupWindow == null || !popupWindow.isShowing()) && (b2 = c.a.e.a.b.g().b()) != null && PermissionUtil.checkWriteExternalStorage(b2)) {
            if (g(b2)) {
                this.f21349b.postDelayed(new g(this, str, str2), 1000L);
                return;
            }
            View inflate = LayoutInflater.from(b2).inflate(R.layout.easter_egg_dialog_lottie_layout, (ViewGroup) null);
            inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) inflate.findViewById(R.id.easter_egg_lottie_view);
            tBLottieAnimationView.setBackgroundResource(R.color.transparent);
            tBLottieAnimationView.setAnimationUrl(str);
            tBLottieAnimationView.setRenderMode(RenderMode.HARDWARE);
            tBLottieAnimationView.enableMergePathsForKitKatAndAbove(true);
            tBLottieAnimationView.setOnClickListener(new h(this, str2));
            tBLottieAnimationView.addAnimatorListener(new i(this));
            tBLottieAnimationView.playAnimation();
            j(b2, inflate);
        }
    }

    public final void j(Activity activity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, activity, view) == null) {
            PopupWindow popupWindow = new PopupWindow(activity);
            this.f21348a = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            this.f21348a.setWidth(l.k(activity));
            this.f21348a.setHeight(l.i(activity));
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f21348a.setContentView(view);
            this.f21349b.removeCallbacksAndMessages(null);
            this.f21349b.postDelayed(this.f21354g, 5000L);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("LIFE_CYCLE") == null && !this.f21351d.isAdded()) {
                fragmentManager.beginTransaction().add(this.f21351d, "LIFE_CYCLE").commitAllowingStateLoss();
            }
            this.f21348a.setOnDismissListener(new c(this));
            try {
                this.f21348a.showAtLocation(activity.getWindow().getDecorView(), 0, 0, 0);
                TiebaStatic.log(new StatisticItem("c13126"));
            } catch (Throwable unused) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21349b = new Handler();
        this.f21353f = new C0998a(this);
        this.f21354g = new b(this);
        this.f21350c = new c.a.r0.k3.m0.a();
        this.f21350c.a(new EasterEggBridge());
        this.f21351d = new ActivityLifeCycleListener();
    }
}
