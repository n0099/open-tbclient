package c.a.o0.a.h0.g;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.h0.g.g;
import c.a.o0.a.v0.c;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q0;
import c.a.o0.a.v2.x0;
import c.a.o0.k.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.res.ui.FloatButton;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class d extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean B0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.a.h0.g.l.c A0;
    public Activity k0;
    public c.a.o0.a.l1.c l0;
    public View m0;
    public SwanAppActionBar n0;
    public n o0;
    public SwanAppMenuHeaderView p0;
    public View q0;
    public TextView r0;
    @Nullable
    public c.a.o0.a.w2.d.b s0;
    public boolean t0;
    public SlideHelper u0;
    public int v0;
    public int w0;
    public l x0;
    public m y0;
    public boolean z0;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5857e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5857e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.f5857e.u0.setRegionFactor(0.1d);
                    d dVar = this.f5857e;
                    dVar.u0.setCanSlide(dVar.u1());
                    return;
                }
                d dVar2 = this.f5857e;
                dVar2.u0.setCanSlide(dVar2.u1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5858a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5858a = dVar;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5858a.d2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f5858a.z1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                View maskView = this.f5858a.u0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f2);
                }
                this.f5858a.e2(f2);
                if (this.f5858a.y0 != null) {
                    this.f5858a.y0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5859e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5859e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.m1.g.d();
            }
        }
    }

    /* renamed from: c.a.o0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0210d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5860e;

        /* renamed from: c.a.o0.a.h0.g.d$d$a */
        /* loaded from: classes.dex */
        public class a implements c.a.o0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0210d f5861a;

            public a(View$OnClickListenerC0210d view$OnClickListenerC0210d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0210d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5861a = view$OnClickListenerC0210d;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f5861a.f5860e.a2();
                }
            }
        }

        public View$OnClickListenerC0210d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5860e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.o0.a.v0.a.b().c()) {
                    c.a.o0.a.v0.a.b().f(this.f5860e.k0, new a(this));
                } else {
                    this.f5860e.a2();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5862e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5862e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5862e.c2();
                c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
                fVar.f7039e = SupportMenuInflater.XML_MENU;
                if (c.a.o0.a.a2.e.Q() != null && c.a.o0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue() > 0) {
                    fVar.f7041g = String.valueOf(1);
                }
                this.f5862e.w1(fVar);
                if (this.f5862e.x0 != null) {
                    this.f5862e.x0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5863e;

        /* loaded from: classes.dex */
        public class a implements c.a.o0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f5864a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5864a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.o0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f5864a.f5863e.v1();
                }
            }
        }

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5863e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5863e.k0) != null && (activity instanceof SwanAppActivity)) {
                if (c.a.o0.a.a2.e.i() == null || c.a.o0.a.a2.e.V() == null) {
                    this.f5863e.v1();
                } else if (c.a.o0.a.v0.a.b().c()) {
                    c.a.o0.a.v0.a.b().f(this.f5863e.k0, new a(this));
                } else if (c.a.o0.a.v0.c.c().h()) {
                    this.f5863e.v1();
                } else {
                    c.a.o0.a.v0.b bVar = new c.a.o0.a.v0.b();
                    bVar.h();
                    if (!bVar.k()) {
                        this.f5863e.v1();
                        c.a.o0.a.m1.g.f().i();
                        return;
                    }
                    String f2 = bVar.f();
                    String e2 = bVar.e();
                    c.a.o0.a.v0.c c2 = c.a.o0.a.v0.c.c();
                    d dVar = this.f5863e;
                    c2.j(dVar.k0, f2, e2, bVar, dVar.A1());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5865a;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5865a = dVar;
        }

        @Override // c.a.o0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5865a.v1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5866e;

        public h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5866e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5866e.g2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5867e;

        public i(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5867e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5867e.x1(c.a.o0.a.u1.a.a.D());
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5868e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5869f;

        public j(d dVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5869f = dVar;
            this.f5868e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f5869f;
                if (dVar.k0 == null || (swanAppActionBar = dVar.n0) == null) {
                    return;
                }
                if (this.f5868e) {
                    if (dVar.r0 == null) {
                        dVar.r0 = new TextView(this.f5869f.k0);
                    }
                    if (this.f5869f.r0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.f5869f.r0.setText(c.a.o0.a.h.aiapps_debug_open_cts);
                    d dVar2 = this.f5869f;
                    dVar2.r0.setTextColor(dVar2.E1().getColor(17170455));
                    d dVar3 = this.f5869f;
                    dVar3.n0.addView(dVar3.r0);
                    return;
                }
                TextView textView = dVar.r0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.f5869f.r0 = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5870e;

        public k(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5870e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5870e.b2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f5871a;

        /* renamed from: b  reason: collision with root package name */
        public long f5872b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f5873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5874d;

        public l(d dVar, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5874d = dVar;
            this.f5871a = 0;
            this.f5872b = 0L;
            this.f5873c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f5872b > 1333) {
                    this.f5872b = currentTimeMillis;
                    this.f5871a = 1;
                    return;
                }
                int i2 = this.f5871a + 1;
                this.f5871a = i2;
                if (i2 == 3) {
                    Runnable runnable = this.f5873c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.f5871a = 0;
                    this.f5872b = 0L;
                    return;
                }
                this.f5872b = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957786032, "Lc/a/o0/a/h0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957786032, "Lc/a/o0/a/h0/g/d;");
                return;
            }
        }
        B0 = c.a.o0.a.k.f7049a;
    }

    public d() {
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
        this.t0 = c.a.o0.a.w2.d.b.f9568i;
        this.v0 = 1;
        this.w0 = 1;
        this.z0 = false;
    }

    public final c.b A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new g(this) : (c.b) invokeV.objValue;
    }

    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public c.a.o0.a.a2.n.g B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (c.a.o0.a.a2.n.g) invokeV.objValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = B0;
            this.k0 = null;
            L1(false);
            super.C0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("y");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(c.a.o0.a.a2.e.V())) {
                return 0;
            }
            return c.a.o0.a.j0.b.a.n(c.a.o0.a.a2.e.V()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public final void C2(boolean z, float f2) {
        c.a.o0.a.h0.g.g H1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (H1 = H1()) == null || H1.k() < 2) {
            return;
        }
        d j2 = H1.j(H1.k() - 2);
        Z1(f2, j2);
        if (z) {
            H1.h().o(j2);
        } else {
            H1.h().c(j2);
        }
    }

    @Nullable
    public c.a.o0.a.w2.d.b D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s0 : (c.a.o0.a.w2.d.b) invokeV.objValue;
    }

    public void D2(c.a.o0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.A0.d(aVar);
        }
    }

    public final Resources E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (n0()) {
                return z();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.o0.a.r1.k.i.b.e().f(new i(this), "updateCtsView");
        }
    }

    public SwanAppActionBar F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n0 : (SwanAppActionBar) invokeV.objValue;
    }

    public View G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m0 : (View) invokeV.objValue;
    }

    public final c.a.o0.a.h0.g.g H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Activity activity = this.k0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (c.a.o0.a.h0.g.g) invokeV.objValue;
    }

    public c.a.o0.a.l1.c I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.l0 : (c.a.o0.a.l1.c) invokeV.objValue;
    }

    public abstract boolean J();

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.o0.a.c2.f.p0.a.f("backtohome", SupportMenuInflater.XML_MENU, c.a.o0.a.g1.f.V().f());
            c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
            fVar.f7039e = "gohome";
            fVar.f7037c = SupportMenuInflater.XML_MENU;
            w1(fVar);
        }
    }

    public void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            FloatButton c2 = c.a.o0.a.c2.f.i0.a.d().c();
            if (!z) {
                if (c2 == null || c2.getVisibility() != 0) {
                    return;
                }
                c2.setVisibility(8);
            } else if (c2 == null || c2.getVisibility() == 0) {
            } else {
                c2.setVisibility(0);
            }
        }
    }

    public void L1(boolean z) {
        c.a.o0.a.h0.g.g W;
        d j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (W = c.a.o0.a.g1.f.V().W()) == null) {
            return;
        }
        if (z) {
            j2 = W.m();
        } else {
            j2 = W.j(W.k() - 1);
        }
        if (j2 == null) {
            return;
        }
        K1(j2.V1());
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public void O1(View view) {
        c.a.o0.a.a2.n.g e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            P1(view);
            SwanAppConfigData s = c.a.o0.a.g1.f.V().s();
            if (s == null) {
                if (B0) {
                    String str = "config data is null. " + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            c.a.o0.a.l1.c cVar = this.l0;
            if (cVar == null) {
                e2 = s.f46442e;
            } else {
                e2 = c.a.o0.a.g1.f.V().e(c.a.o0.a.c2.f.p0.j.c(cVar.g(), s));
            }
            j2(e2.f4575a);
            this.n0.setTitle(e2.f4576b);
            this.x0 = new l(this, new c(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                r2(SwanAppConfigData.s(e2.f4577c));
            }
            String str2 = e2.f4577c;
        }
    }

    public void P1(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, view) == null) || view == null) {
            return;
        }
        this.n0 = (SwanAppActionBar) view.findViewById(c.a.o0.a.f.ai_apps_title_bar);
        this.m0 = view.findViewById(c.a.o0.a.f.ai_apps_title_bar_root);
        this.q0 = view.findViewById(c.a.o0.a.f.title_shadow);
        this.n0.setLeftBackViewMinWidth(n0.f(this.k0, 38.0f));
        View$OnClickListenerC0210d view$OnClickListenerC0210d = new View$OnClickListenerC0210d(this);
        this.n0.setLeftBackViewClickListener(view$OnClickListenerC0210d);
        this.n0.setLeftFloatBackViewClickListener(view$OnClickListenerC0210d);
        this.n0.setRightMenuOnClickListener(new e(this));
        this.n0.setRightExitOnClickListener(new f(this));
    }

    public View Q1(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, view)) == null) {
            if (view == null) {
                return null;
            }
            if ("IMMERSION_LAYOUT_TAG".equals(view.getTag())) {
                return view;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if ("IMMERSION_LAYOUT_TAG".equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(q());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            R1(frameLayout, view);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View R1(FrameLayout frameLayout, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, frameLayout, view)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view);
            this.s0 = new c.a.o0.a.w2.d.b(this.k0, frameLayout);
            r1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Activity activity = this.k0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            c.a.o0.a.h0.g.g H1 = H1();
            return H1 != null && H1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.w0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean V1();

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(c.a.o0.a.a2.e.V()) : invokeV.booleanValue;
    }

    public abstract boolean X1();

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.n0.setLeftHomeViewVisibility(0);
            this.n0.setLeftHomeViewClickListener(new k(this));
        }
    }

    public final void Z1(float f2, Fragment fragment) {
        View f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o = n0.o(this.k0) >> 2;
            float f3 = (f2 * o) - o;
            if (fragment == null || (f0 = fragment.f0()) == null) {
                return;
            }
            f0.setX(f3);
        }
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    public abstract void c2();

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            C2(false, 1.0f);
        }
    }

    public void e2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            C2(true, f2);
        }
    }

    public void f2(c.a.o0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, aVar) == null) {
            this.A0.c(aVar);
        }
    }

    public void g2() {
        c.a.o0.a.w2.d.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && N1() && (bVar = this.s0) != null) {
            bVar.l();
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.o0.a.a2.e.V());
            c.a.o0.a.g1.f.V().v(new c.a.o0.a.o0.d.c(hashMap));
            c.a.o0.a.e0.d.g("SwanAppBaseFragment", "onClose");
            c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
            fVar.f7039e = IntentConfig.CLOSE;
            w1(fVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048617, this, i2, str) == null) {
            switch (str.hashCode()) {
                case -1965087616:
                    if (str.equals("easeOut")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1310316109:
                    if (str.equals("easeIn")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102672091:
                    if (str.equals("linear")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1330629787:
                    if (str.equals("easeInOut")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                linearInterpolator = new LinearInterpolator();
            } else if (c2 == 1) {
                linearInterpolator = new AccelerateInterpolator();
            } else if (c2 == 2) {
                linearInterpolator = new DecelerateInterpolator();
            } else if (c2 != 3) {
                linearInterpolator = new LinearInterpolator();
            } else {
                linearInterpolator = new AccelerateDecelerateInterpolator();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.n0, "alpha", 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            c.a.o0.a.w2.d.b bVar = this.s0;
            if (bVar == null || bVar.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s0.e(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean j2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? k2(i2, false) : invokeI.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            super.k1(z);
            if (z) {
                g2();
            }
        }
    }

    public boolean k2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null || this.q0 == null) {
                return false;
            }
            this.w0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            c.a.o0.a.a2.n.g B1 = B1();
            if (B1 != null) {
                B1.f4575a = i2;
                B1.g(z);
            }
            if (N1()) {
                r1();
            }
            if (U1()) {
                this.q0.setVisibility(0);
                return true;
            }
            this.q0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public boolean l2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) ? m2(str, false) : invokeL.booleanValue;
    }

    public boolean m2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048623, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            c.a.o0.a.a2.n.g B1 = B1();
            if (B1 != null) {
                B1.f4576b = str;
                B1.g(z);
            }
            c.a.o0.a.e0.d.g("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void n2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.n0.setLeftBackViewVisibility(z);
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            c.a.o0.a.a2.n.g B1 = B1();
            if (B1 != null && (B1.l || B1.m)) {
                c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
                if (Q != null) {
                    Q.T().g(Q.x(), "scope_disable_swipe_back", new a(this));
                    return;
                } else {
                    this.u0.setCanSlide(u1());
                    return;
                }
            }
            this.u0.setCanSlide(u1());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            n0.c(this.k0);
            if (N1() && this.s0 != null && configuration.orientation == 1) {
                h().getWindow().clearFlags(1024);
                q0.c0(new h(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.A0.b();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            this.A0.a();
            boolean z = B0;
            if (e0()) {
                g2();
            }
            E2();
        }
    }

    public void p2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.z0 = z;
        }
    }

    public void q2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.q0 != null) {
                int i2 = 8;
                if (!z && U1()) {
                    i2 = 0;
                }
                this.q0.setVisibility(i2);
            }
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || this.s0 == null) {
            return;
        }
        s1(this.w0);
    }

    public boolean r2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) ? s2(i2, "", false) : invokeI.booleanValue;
    }

    public void s1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || this.s0 == null) {
            return;
        }
        t1(i2, false);
    }

    public boolean s2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.n0 == null) {
                return false;
            }
            w2(!this.z0);
            c.a.o0.a.a2.n.g B1 = B1();
            if (B1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    B1.f4577c = str;
                }
                B1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (N1() && i3 != this.v0) {
                this.v0 = i3;
                r1();
            }
            return this.n0.setActionBarFrontColor(i2, this.z0);
        }
        return invokeCommon.booleanValue;
    }

    public void t1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.s0 == null) {
            return;
        }
        this.w0 = i2;
        int i3 = this.v0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = c.a.o0.a.v2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.s0.m(i2, z, z2);
    }

    public boolean t2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048636, this, str, z)) == null) ? s2(SwanAppConfigData.s(str), str, z) : invokeLZ.booleanValue;
    }

    public final boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? (E1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public void u2(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, mVar) == null) {
            this.y0 = mVar;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, context) == null) {
            boolean z = B0;
            this.A0 = new c.a.o0.a.h0.g.l.c();
            super.v0(context);
            this.k0 = h();
            L1(true);
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.k0 == null) {
            return;
        }
        c.a.o0.a.g1.g.a().d(false);
        this.k0.moveTaskToBack(true);
        h2();
        ((SwanAppActivity) this.k0).handleSwanAppExit(1);
        x0.b().e(2);
    }

    public void v2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048641, this, i2) == null) || (activity = this.k0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    public final void w1(c.a.o0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, fVar) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
            }
        }
    }

    public void w2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.n0.setRightExitViewVisibility(z);
        }
    }

    public final void x1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            q0.b0(new j(this, z));
        }
    }

    public void x2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.n0.setRightZoneVisibility(z);
        }
    }

    public View y1(View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048646, this, view, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.u0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
            this.u0.setFadeColor(0);
            o2();
            y2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.u0.setSlideListener(new b(this));
        }
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            c.a.o0.a.h0.g.g H1 = H1();
            if (H1 != null && H1.k() != 1) {
                g.b i2 = H1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                c.a.o0.a.j2.p.e eVar = new c.a.o0.a.j2.p.e();
                eVar.f7039e = com.alipay.sdk.widget.d.l;
                eVar.f7041g = T1() ? "1" : "0";
                eVar.f7036b = "gesture";
                c.a.o0.a.j2.d.a(eVar, c.a.o0.a.a2.d.g().r().L());
                c.a.o0.a.j2.d.c(eVar);
                return;
            }
            Activity activity = this.k0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                x0.b().e(1);
            }
        }
    }

    public boolean z2(FrameLayout frameLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048649, this, frameLayout, i2)) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            c.a.o0.a.a2.n.g B1 = B1();
            if (B1 != null) {
                B1.f4579e = i2;
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
