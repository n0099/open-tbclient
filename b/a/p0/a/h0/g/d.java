package b.a.p0.a.h0.g;

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
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.v0.c;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x0;
import b.a.p0.k.n;
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
    public b.a.p0.a.h0.g.l.c A0;
    public Activity k0;
    public b.a.p0.a.l1.c l0;
    public View m0;
    public SwanAppActionBar n0;
    public n o0;
    public SwanAppMenuHeaderView p0;
    public View q0;
    public TextView r0;
    @Nullable
    public b.a.p0.a.w2.d.b s0;
    public boolean t0;
    public SlideHelper u0;
    public int v0;
    public int w0;
    public l x0;
    public m y0;
    public boolean z0;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5240e;

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
            this.f5240e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f5240e.u0.setRegionFactor(0.1d);
                    d dVar = this.f5240e;
                    dVar.u0.setCanSlide(dVar.q1());
                    return;
                }
                d dVar2 = this.f5240e;
                dVar2.u0.setCanSlide(dVar2.q1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5241a;

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
            this.f5241a = dVar;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5241a.Z1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f5241a.v1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                View maskView = this.f5241a.u0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f2);
                }
                this.f5241a.a2(f2);
                if (this.f5241a.y0 != null) {
                    this.f5241a.y0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.m1.g.d();
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0207d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5242e;

        /* renamed from: b.a.p0.a.h0.g.d$d$a */
        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View$OnClickListenerC0207d f5243a;

            public a(View$OnClickListenerC0207d view$OnClickListenerC0207d) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view$OnClickListenerC0207d};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5243a = view$OnClickListenerC0207d;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f5243a.f5242e.W1();
                }
            }
        }

        public View$OnClickListenerC0207d(d dVar) {
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
            this.f5242e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (b.a.p0.a.v0.a.b().c()) {
                    b.a.p0.a.v0.a.b().f(this.f5242e.k0, new a(this));
                } else {
                    this.f5242e.W1();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5244e;

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
            this.f5244e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5244e.Y1();
                b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
                fVar.f6387e = SupportMenuInflater.XML_MENU;
                if (b.a.p0.a.a2.e.P() != null && b.a.p0.a.a2.e.P().I().d("key_unread_counts_message", 0).intValue() > 0) {
                    fVar.f6389g = String.valueOf(1);
                }
                this.f5244e.s1(fVar);
                if (this.f5244e.x0 != null) {
                    this.f5244e.x0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5245e;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f5246a;

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
                this.f5246a = fVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f5246a.f5245e.r1();
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
            this.f5245e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5245e.k0) != null && (activity instanceof SwanAppActivity)) {
                if (b.a.p0.a.a2.e.i() == null || b.a.p0.a.a2.e.U() == null) {
                    this.f5245e.r1();
                } else if (b.a.p0.a.v0.a.b().c()) {
                    b.a.p0.a.v0.a.b().f(this.f5245e.k0, new a(this));
                } else if (b.a.p0.a.v0.c.c().h()) {
                    this.f5245e.r1();
                } else {
                    b.a.p0.a.v0.b bVar = new b.a.p0.a.v0.b();
                    bVar.h();
                    if (!bVar.k()) {
                        this.f5245e.r1();
                        b.a.p0.a.m1.g.f().i();
                        return;
                    }
                    String f2 = bVar.f();
                    String e2 = bVar.e();
                    b.a.p0.a.v0.c c2 = b.a.p0.a.v0.c.c();
                    d dVar = this.f5245e;
                    c2.j(dVar.k0, f2, e2, bVar, dVar.w1());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5247a;

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
            this.f5247a = dVar;
        }

        @Override // b.a.p0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5247a.r1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5248e;

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
            this.f5248e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5248e.c2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5249e;

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
            this.f5249e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5249e.t1(b.a.p0.a.u1.a.a.D());
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5251f;

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
            this.f5251f = dVar;
            this.f5250e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f5251f;
                if (dVar.k0 == null || (swanAppActionBar = dVar.n0) == null) {
                    return;
                }
                if (this.f5250e) {
                    if (dVar.r0 == null) {
                        dVar.r0 = new TextView(this.f5251f.k0);
                    }
                    if (this.f5251f.r0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.f5251f.r0.setText(b.a.p0.a.h.aiapps_debug_open_cts);
                    d dVar2 = this.f5251f;
                    dVar2.r0.setTextColor(dVar2.A1().getColor(17170455));
                    d dVar3 = this.f5251f;
                    dVar3.n0.addView(dVar3.r0);
                    return;
                }
                TextView textView = dVar.r0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.f5251f.r0 = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5252e;

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
            this.f5252e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5252e.X1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f5253a;

        /* renamed from: b  reason: collision with root package name */
        public long f5254b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f5255c;

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
            this.f5253a = 0;
            this.f5254b = 0L;
            this.f5255c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f5254b > 1333) {
                    this.f5254b = currentTimeMillis;
                    this.f5253a = 1;
                    return;
                }
                int i2 = this.f5253a + 1;
                this.f5253a = i2;
                if (i2 == 3) {
                    Runnable runnable = this.f5255c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.f5253a = 0;
                    this.f5254b = 0L;
                    return;
                }
                this.f5254b = currentTimeMillis;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597402928, "Lb/a/p0/a/h0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597402928, "Lb/a/p0/a/h0/g/d;");
                return;
            }
        }
        B0 = b.a.p0.a.k.f6397a;
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
        this.t0 = b.a.p0.a.w2.d.b.f8845i;
        this.v0 = 1;
        this.w0 = 1;
        this.z0 = false;
    }

    public final Resources A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (k0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.a.r1.k.i.b.e().f(new i(this), "updateCtsView");
        }
    }

    public SwanAppActionBar B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n0 : (SwanAppActionBar) invokeV.objValue;
    }

    public View C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m0 : (View) invokeV.objValue;
    }

    public final b.a.p0.a.h0.g.g D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity activity = this.k0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (b.a.p0.a.h0.g.g) invokeV.objValue;
    }

    public b.a.p0.a.l1.c E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l0 : (b.a.p0.a.l1.c) invokeV.objValue;
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b.a.p0.a.c2.f.p0.a.f("backtohome", SupportMenuInflater.XML_MENU, b.a.p0.a.g1.f.T().f());
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = "gohome";
            fVar.f6385c = SupportMenuInflater.XML_MENU;
            s1(fVar);
        }
    }

    public void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            FloatButton c2 = b.a.p0.a.c2.f.i0.a.d().c();
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

    public void H1(boolean z) {
        b.a.p0.a.h0.g.g U;
        d j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (U = b.a.p0.a.g1.f.T().U()) == null) {
            return;
        }
        if (z) {
            j2 = U.m();
        } else {
            j2 = U.j(U.k() - 1);
        }
        if (j2 == null) {
            return;
        }
        G1(j2.R1());
    }

    public abstract boolean I();

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public void K1(View view) {
        b.a.p0.a.a2.n.g e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            L1(view);
            SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
            if (r == null) {
                if (B0) {
                    String str = "config data is null. " + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            b.a.p0.a.l1.c cVar = this.l0;
            if (cVar == null) {
                e2 = r.f44232e;
            } else {
                e2 = b.a.p0.a.g1.f.T().e(b.a.p0.a.c2.f.p0.j.c(cVar.g(), r));
            }
            f2(e2.f4004a);
            this.n0.setTitle(e2.f4005b);
            this.x0 = new l(this, new c(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                n2(SwanAppConfigData.s(e2.f4006c));
            }
            String str2 = e2.f4006c;
        }
    }

    public void L1(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || view == null) {
            return;
        }
        this.n0 = (SwanAppActionBar) view.findViewById(b.a.p0.a.f.ai_apps_title_bar);
        this.m0 = view.findViewById(b.a.p0.a.f.ai_apps_title_bar_root);
        this.q0 = view.findViewById(b.a.p0.a.f.title_shadow);
        this.n0.setLeftBackViewMinWidth(n0.f(this.k0, 38.0f));
        View$OnClickListenerC0207d view$OnClickListenerC0207d = new View$OnClickListenerC0207d(this);
        this.n0.setLeftBackViewClickListener(view$OnClickListenerC0207d);
        this.n0.setLeftFloatBackViewClickListener(view$OnClickListenerC0207d);
        this.n0.setRightMenuOnClickListener(new e(this));
        this.n0.setRightExitOnClickListener(new f(this));
    }

    public View M1(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) {
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
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            N1(frameLayout, view);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View N1(FrameLayout frameLayout, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, frameLayout, view)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view);
            this.s0 = new b.a.p0.a.w2.d.b(this.k0, frameLayout);
            n1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Activity activity = this.k0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            b.a.p0.a.h0.g.g D1 = D1();
            return D1 != null && D1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.w0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean R1();

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(b.a.p0.a.a2.e.U()) : invokeV.booleanValue;
    }

    public abstract boolean T1();

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.n0.setLeftHomeViewVisibility(0);
            this.n0.setLeftHomeViewClickListener(new k(this));
        }
    }

    public final void V1(float f2, Fragment fragment) {
        View c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o = n0.o(this.k0) >> 2;
            float f3 = (f2 * o) - o;
            if (fragment == null || (c0 = fragment.c0()) == null) {
                return;
            }
            c0.setX(f3);
        }
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public abstract void Y1();

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            y2(false, 1.0f);
        }
    }

    public void a2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
            y2(true, f2);
        }
    }

    public void b2(b.a.p0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) {
            this.A0.c(aVar);
        }
    }

    public void c2() {
        b.a.p0.a.w2.d.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && J1() && (bVar = this.s0) != null) {
            bVar.l();
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, b.a.p0.a.a2.e.U());
            b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.c(hashMap));
            b.a.p0.a.e0.d.g("SwanAppBaseFragment", "onClose");
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = IntentConfig.CLOSE;
            s1(fVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void e2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i2, str) == null) {
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
                    if (str.equals(Easing.LINEAR_NAME)) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.n0, Key.ALPHA, 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            b.a.p0.a.w2.d.b bVar = this.s0;
            if (bVar == null || bVar.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s0.e(), Key.ALPHA, 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean f2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) ? g2(i2, false) : invokeI.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            super.g1(z);
            if (z) {
                c2();
            }
        }
    }

    public boolean g2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null || this.q0 == null) {
                return false;
            }
            this.w0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            b.a.p0.a.a2.n.g x1 = x1();
            if (x1 != null) {
                x1.f4004a = i2;
                x1.g(z);
            }
            if (J1()) {
                n1();
            }
            if (Q1()) {
                this.q0.setVisibility(0);
                return true;
            }
            this.q0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Nullable
    public boolean h2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) ? i2(str, false) : invokeL.booleanValue;
    }

    public boolean i2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048613, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            b.a.p0.a.a2.n.g x1 = x1();
            if (x1 != null) {
                x1.f4005b = str;
                x1.g(z);
            }
            b.a.p0.a.e0.d.g("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.n0.setLeftBackViewVisibility(z);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            b.a.p0.a.a2.n.g x1 = x1();
            if (x1 != null && (x1.l || x1.m)) {
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P != null) {
                    P.S().g(P.x(), "scope_disable_swipe_back", new a(this));
                    return;
                } else {
                    this.u0.setCanSlide(q1());
                    return;
                }
            }
            this.u0.setCanSlide(q1());
        }
    }

    public void l2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.z0 = z;
        }
    }

    public void m2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.q0 != null) {
                int i2 = 8;
                if (!z && Q1()) {
                    i2 = 0;
                }
                this.q0.setVisibility(i2);
            }
        }
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || this.s0 == null) {
            return;
        }
        o1(this.w0);
    }

    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) ? o2(i2, "", false) : invokeI.booleanValue;
    }

    public void o1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || this.s0 == null) {
            return;
        }
        p1(i2, false);
    }

    public boolean o2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.n0 == null) {
                return false;
            }
            s2(!this.z0);
            b.a.p0.a.a2.n.g x1 = x1();
            if (x1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    x1.f4006c = str;
                }
                x1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (J1() && i3 != this.v0) {
                this.v0 = i3;
                n1();
            }
            return this.n0.setActionBarFrontColor(i2, this.z0);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            n0.c(this.k0);
            if (J1() && this.s0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                q0.c0(new h(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.A0.b();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onResume();
            this.A0.a();
            boolean z = B0;
            if (a0()) {
                c2();
            }
            A2();
        }
    }

    public void p1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.s0 == null) {
            return;
        }
        this.w0 = i2;
        int i3 = this.v0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = b.a.p0.a.v2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.s0.m(i2, z, z2);
    }

    public boolean p2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048627, this, str, z)) == null) ? o2(SwanAppConfigData.s(str), str, z) : invokeLZ.booleanValue;
    }

    public final boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? (A1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public void q2(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, mVar) == null) {
            this.y0 = mVar;
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || this.k0 == null) {
            return;
        }
        b.a.p0.a.g1.g.a().d(false);
        this.k0.moveTaskToBack(true);
        d2();
        ((SwanAppActivity) this.k0).handleSwanAppExit(1);
        x0.b().e(2);
    }

    public void r2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || (activity = this.k0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, context) == null) {
            boolean z = B0;
            this.A0 = new b.a.p0.a.h0.g.l.c();
            super.s0(context);
            this.k0 = getActivity();
            H1(true);
        }
    }

    public final void s1(b.a.p0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, fVar) == null) {
            Activity activity = this.k0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
            }
        }
    }

    public void s2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.n0.setRightExitViewVisibility(z);
        }
    }

    public final void t1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            q0.b0(new j(this, z));
        }
    }

    public void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.n0.setRightZoneVisibility(z);
        }
    }

    public View u1(View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, view, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.u0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
            this.u0.setFadeColor(0);
            k2();
            u2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.u0.setSlideListener(new b(this));
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            b.a.p0.a.h0.g.g D1 = D1();
            if (D1 != null && D1.k() != 1) {
                g.b i2 = D1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
                eVar.f6387e = com.alipay.sdk.widget.d.u;
                eVar.f6389g = P1() ? "1" : "0";
                eVar.f6384b = "gesture";
                b.a.p0.a.j2.d.a(eVar, b.a.p0.a.a2.d.g().r().K());
                b.a.p0.a.j2.d.c(eVar);
                return;
            }
            Activity activity = this.k0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                x0.b().e(1);
            }
        }
    }

    public boolean v2(FrameLayout frameLayout, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048640, this, frameLayout, i2)) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            b.a.p0.a.a2.n.g x1 = x1();
            if (x1 != null) {
                x1.f4008e = i2;
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final c.b w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? new g(this) : (c.b) invokeV.objValue;
    }

    public void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
        }
    }

    public b.a.p0.a.a2.n.g x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return null;
        }
        return (b.a.p0.a.a2.n.g) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.n0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public int y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (TextUtils.isEmpty(b.a.p0.a.a2.e.U())) {
                return 0;
            }
            return b.a.p0.a.j0.b.a.n(b.a.p0.a.a2.e.U()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public final void y2(boolean z, float f2) {
        b.a.p0.a.h0.g.g D1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (D1 = D1()) == null || D1.k() < 2) {
            return;
        }
        d j2 = D1.j(D1.k() - 2);
        V1(f2, j2);
        if (z) {
            D1.h().o(j2);
        } else {
            D1.h().c(j2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            boolean z = B0;
            this.k0 = null;
            H1(false);
            super.z0();
            try {
                Field declaredField = Fragment.class.getDeclaredField("y");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Nullable
    public b.a.p0.a.w2.d.b z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.s0 : (b.a.p0.a.w2.d.b) invokeV.objValue;
    }

    public void z2(b.a.p0.a.h0.g.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, aVar) == null) {
            this.A0.d(aVar);
        }
    }
}
