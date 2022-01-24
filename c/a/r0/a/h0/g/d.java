package c.a.r0.a.h0.g;

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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.g;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.v0.c;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.fragment.BaseFragment;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlideInterceptor;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.anim.TimeFunctionConst;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class d extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean I0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public int B0;
    public o C0;
    public p D0;
    public boolean E0;
    public c.a.r0.a.h0.g.m.c F0;
    public double G0;
    public boolean H0;
    public final String f0;
    public Activity g0;
    public c.a.r0.a.m1.c h0;
    public View i0;
    public SwanAppActionBar k0;
    public c.a.r0.n.n q0;
    public SwanAppMenuHeaderView r0;
    public View s0;
    public TextView t0;
    public TextView u0;
    public Button v0;
    public AtomicBoolean w0;
    @Nullable
    public c.a.r0.a.a3.d.b x0;
    public boolean y0;
    public SlideHelper z0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6492e;

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
            this.f6492e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6492e.v1(c.a.r0.a.x1.a.a.E());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f6494f;

        public b(d dVar, boolean z) {
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
            this.f6494f = dVar;
            this.f6493e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f6494f;
                if (dVar.g0 == null || (swanAppActionBar = dVar.k0) == null) {
                    return;
                }
                if (this.f6493e) {
                    if (dVar.t0 == null) {
                        dVar.t0 = new TextView(this.f6494f.g0);
                    }
                    if (this.f6494f.t0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.f6494f.t0.setText(c.a.r0.a.h.aiapps_debug_open_cts);
                    d dVar2 = this.f6494f;
                    dVar2.t0.setTextColor(dVar2.D1().getColor(17170455));
                    d dVar3 = this.f6494f;
                    dVar3.k0.addView(dVar3.t0);
                    return;
                }
                TextView textView = dVar.t0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.f6494f.t0 = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6495e;

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
            this.f6495e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6495e.c2();
            }
        }
    }

    /* renamed from: c.a.r0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0372d implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6496e;

        public C0372d(d dVar) {
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
            this.f6496e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f6496e.z0.setRegionFactor(0.1d);
                    d dVar = this.f6496e;
                    dVar.G0 = 0.1d;
                    dVar.z0.setCanSlide(dVar.s1());
                    return;
                }
                d dVar2 = this.f6496e;
                dVar2.z0.setCanSlide(dVar2.s1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

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
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.y1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                View maskView = this.a.z0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f2);
                }
                this.a.f2(f2);
                if (this.a.D0 != null) {
                    this.a.D0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6497e;

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
            this.f6497e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.n1.h.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6498e;

        /* loaded from: classes.dex */
        public class a implements c.a.r0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.a.f6498e.b2();
                }
            }
        }

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
            this.f6498e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.r0.a.v0.a.b().c()) {
                    c.a.r0.a.v0.a.b().f(this.f6498e.g0, new a(this));
                } else {
                    this.f6498e.b2();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6499e;

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
            this.f6499e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f6499e.d2();
                c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
                fVar.f8122e = SupportMenuInflater.XML_MENU;
                if (c.a.r0.a.d2.e.a0() != null && c.a.r0.a.d2.e.a0().T().d("key_unread_counts_message", 0).intValue() > 0) {
                    fVar.f8124g = String.valueOf(1);
                }
                this.f6499e.u1(fVar);
                if (this.f6499e.C0 != null) {
                    this.f6499e.C0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6500e;

        /* loaded from: classes.dex */
        public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f6501e;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6501e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(c.a.r0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.r0.a.h2.c.d.h(iVar)) {
                        this.f6501e.f6500e.k2();
                    } else {
                        this.f6501e.f6500e.g2();
                    }
                }
            }
        }

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
            this.f6500e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f6500e.g0) != null && (activity instanceof SwanAppActivity)) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    if (c.a.r0.a.z2.j.f() && c.a.r0.q.k.i.m.a().d()) {
                        a0.d0().g(a0.x(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.f6500e.g2();
                        return;
                    }
                }
                this.f6500e.t1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements c.a.r0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public j(d dVar) {
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
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.a.t1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f6502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f6503f;

        public k(d dVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6503f = dVar;
            this.f6502e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || c.a.r0.a.l2.c.g()) {
                return;
            }
            this.f6503f.w1(this.f6502e, c.a.r0.a.l2.c.d(), c.a.r0.a.l2.c.f());
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f6506g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f6507h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f6508e;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6508e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f6508e.f6507h.i2();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f6509e;

            public b(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6509e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f6509e.f6507h.K2();
                }
            }
        }

        public l(d dVar, boolean z, boolean z2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Boolean.valueOf(z), Boolean.valueOf(z2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6507h = dVar;
            this.f6504e = z;
            this.f6505f = z2;
            this.f6506g = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f6504e || this.f6505f) {
                    d dVar = this.f6507h;
                    if (dVar.v0 == null) {
                        View view = this.f6506g;
                        if (view == null) {
                            c.a.r0.a.e0.d.b("SwanAppBaseFragment", "view为null");
                            return;
                        }
                        dVar.v0 = (Button) view.findViewById(c.a.r0.a.f.swanapp_obtain_stability_data_btn);
                    }
                    this.f6507h.v0.setVisibility(0);
                    if (this.f6504e) {
                        this.f6507h.v0.setOnClickListener(new a(this));
                    }
                    if (this.f6505f) {
                        this.f6507h.w0 = new AtomicBoolean(false);
                        this.f6507h.v0.setText(c.a.r0.a.h.swanapp_stability_profile_pause);
                        this.f6507h.v0.setOnClickListener(new b(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public m(d dVar) {
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
            this.a = dVar;
        }

        @Override // c.a.r0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f6510e;

        public n(d dVar) {
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
            this.f6510e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6510e.j2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f6511b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f6512c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f6513d;

        public o(d dVar, Runnable runnable) {
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
            this.f6513d = dVar;
            this.a = 0;
            this.f6511b = 0L;
            this.f6512c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f6511b > 1333) {
                    this.f6511b = currentTimeMillis;
                    this.a = 1;
                    return;
                }
                int i2 = this.a + 1;
                this.a = i2;
                if (i2 == 3) {
                    Runnable runnable = this.f6512c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.a = 0;
                    this.f6511b = 0L;
                    return;
                }
                this.f6511b = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1345034189, "Lc/a/r0/a/h0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1345034189, "Lc/a/r0/a/h0/g/d;");
                return;
            }
        }
        I0 = c.a.r0.a.k.a;
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
        this.f0 = UUID.randomUUID().toString();
        this.y0 = c.a.r0.a.a3.d.b.f5341i;
        this.A0 = 1;
        this.B0 = 1;
        this.E0 = false;
        this.G0 = -1.0d;
        this.H0 = false;
    }

    public c.a.r0.a.d2.n.g A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (c.a.r0.a.d2.n.g) invokeV.objValue;
    }

    public void A2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) && U1(d2)) {
            if (U1(this.G0)) {
                d2 = this.G0;
            }
            this.z0.setRegionFactor(d2);
        }
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(c.a.r0.a.d2.e.f0())) {
                return 0;
            }
            return c.a.r0.a.j0.b.a.n(c.a.r0.a.d2.e.f0()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public void B2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (activity = this.g0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    @Nullable
    public c.a.r0.a.a3.d.b C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.x0 : (c.a.r0.a.a3.d.b) invokeV.objValue;
    }

    public void C2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.k0.setRightExitViewVisibility(z);
        }
    }

    public final Resources D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (g0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void D2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k0.setRightZoneVisibility(z);
        }
    }

    public SwanAppActionBar E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k0 : (SwanAppActionBar) invokeV.objValue;
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.z0.setSlideListener(new e(this));
        }
    }

    public View F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i0 : (View) invokeV.objValue;
    }

    public boolean F2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            c.a.r0.a.d2.n.g A1 = A1();
            if (A1 != null) {
                A1.f5719e = i2;
                A1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final c.a.r0.a.h0.g.g G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Activity activity = this.g0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (c.a.r0.a.h0.g.g) invokeV.objValue;
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public c.a.r0.a.m1.c H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.h0 : (c.a.r0.a.m1.c) invokeV.objValue;
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public c.a.r0.n.n I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q0 : (c.a.r0.n.n) invokeV.objValue;
    }

    public final void I2(boolean z, float f2) {
        c.a.r0.a.h0.g.g G1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (G1 = G1()) == null || G1.k() < 2) {
            return;
        }
        d j2 = G1.j(G1.k() - 2);
        a2(f2, j2);
        if (z) {
            if (j2.H0) {
                J2(G1, f2);
                return;
            } else {
                G1.h().o(j2);
                return;
            }
        }
        G1.h().c(j2);
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.r0.a.f2.f.o0.a.f("backtohome", SupportMenuInflater.XML_MENU, c.a.r0.a.g1.f.U().g());
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.f8122e = "gohome";
            fVar.f8120c = SupportMenuInflater.XML_MENU;
            u1(fVar);
        }
    }

    public final void J2(c.a.r0.a.h0.g.g gVar, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048595, this, gVar, f2) == null) || gVar == null || gVar.k() < 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int k2 = gVar.k() - 3;
        while (true) {
            if (k2 < 0) {
                break;
            }
            d j2 = gVar.j(k2);
            if (j2.H0) {
                a2(f2, j2);
                arrayList.add(j2);
                k2--;
            } else {
                a2(f2, j2);
                arrayList.add(j2);
                break;
            }
        }
        gVar.h().p(arrayList);
    }

    public abstract boolean K();

    public void K1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            FloatButton c2 = c.a.r0.a.f2.f.h0.a.d().c();
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

    public final void K2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.v0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.w0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.w0.get();
        this.v0.setText(z ? c.a.r0.a.h.swanapp_stability_profile_resume : c.a.r0.a.h.swanapp_stability_profile_pause);
        c.a.r0.a.l2.c.j(z);
    }

    public void L1(boolean z) {
        c.a.r0.a.h0.g.g V;
        d j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (V = c.a.r0.a.g1.f.U().V()) == null) {
            return;
        }
        if (z) {
            j2 = V.m();
        } else {
            j2 = V.j(V.k() - 1);
        }
        if (j2 == null) {
            return;
        }
        K1(j2.W1());
    }

    public void L2(c.a.r0.a.h0.g.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.F0.e(aVar);
        }
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.r0.a.u1.k.i.c.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    public void N2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            c.a.r0.a.u1.k.i.c.e().d(new k(this, view), "updateStabilityDataView", false);
        }
    }

    public void O1(View view) {
        c.a.r0.a.d2.n.g f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view) == null) {
            P1(view);
            SwanAppConfigData s = c.a.r0.a.g1.f.U().s();
            if (s == null) {
                if (I0) {
                    String str = "config data is null. " + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            c.a.r0.a.m1.c cVar = this.h0;
            if (cVar == null) {
                f2 = s.f39371e;
            } else {
                f2 = c.a.r0.a.g1.f.U().f(c.a.r0.a.f2.f.o0.j.c(cVar.i(), s));
            }
            n2(f2.a);
            this.k0.setTitle(f2.f5716b);
            this.C0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                w2(SwanAppConfigData.t(f2.f5717c));
            }
            String str2 = f2.f5717c;
        }
    }

    public void P1(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, view) == null) || view == null) {
            return;
        }
        this.k0 = (SwanAppActionBar) view.findViewById(c.a.r0.a.f.ai_apps_title_bar);
        this.i0 = view.findViewById(c.a.r0.a.f.ai_apps_title_bar_root);
        this.s0 = view.findViewById(c.a.r0.a.f.title_shadow);
        this.k0.setLeftBackViewMinWidth(n0.f(this.g0, 38.0f));
        g gVar = new g(this);
        this.k0.setLeftBackViewClickListener(gVar);
        this.k0.setLeftFloatBackViewClickListener(gVar);
        this.k0.setRightMenuOnClickListener(new h(this));
        this.k0.setRightExitOnClickListener(new i(this));
    }

    public View Q1(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, view)) == null) {
            if (view == null) {
                return null;
            }
            if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(view.getTag())) {
                return view;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (BaseFragment.IMMERSION_LAYOUT_TAG.equals(viewGroup.getTag())) {
                    return viewGroup;
                }
                viewGroup.removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            R1(frameLayout, view);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View R1(FrameLayout frameLayout, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, frameLayout, view)) == null) {
            frameLayout.setTag(BaseFragment.IMMERSION_LAYOUT_TAG);
            frameLayout.addView(view);
            this.x0 = new c.a.r0.a.a3.d.b(this.g0, frameLayout);
            p1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            Activity activity = this.g0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.r0.a.h0.g.g G1 = G1();
            return G1 != null && G1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean U1(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.B0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean W1();

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(c.a.r0.a.d2.e.f0()) : invokeV.booleanValue;
    }

    public abstract boolean Y1();

    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.k0.setLeftHomeViewVisibility(0);
            this.k0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public final void a2(float f2, Fragment fragment) {
        View W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = n0.o(this.g0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment == null || (W = fragment.W()) == null) {
                return;
            }
            W.setX(f3);
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            Activity activity = this.g0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public abstract void d2();

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            I2(false, 1.0f);
        }
    }

    public void f2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048622, this, f2) == null) {
            I2(true, f2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            super.g1(z);
            if (z) {
                j2();
            }
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (c.a.r0.a.v0.a.b().c()) {
                c.a.r0.a.v0.a.b().f(this.g0, new j(this));
            } else if (c.a.r0.a.v0.c.c().h()) {
                t1();
            } else {
                c.a.r0.a.v0.b bVar = new c.a.r0.a.v0.b();
                bVar.h();
                if (bVar.j()) {
                    c.a.r0.a.v0.c.c().j(this.g0, bVar.f(), bVar.e(), bVar, z1());
                    return;
                }
                t1();
                c.a.r0.a.n1.h.e().g();
            }
        }
    }

    public void h2(c.a.r0.a.h0.g.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, aVar) == null) {
            this.F0.d(aVar);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            Button button = this.v0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.u0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (c.a.r0.a.l2.c.d()) {
                c.a.r0.a.l2.c.l(true);
            }
        }
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void j2() {
        c.a.r0.a.a3.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || this.H0 || !N1() || (bVar = this.x0) == null) {
            return;
        }
        bVar.l();
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            String C = c.a.r0.a.g1.f.U().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.c("closeBtn", hashMap));
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, c.a.r0.a.d2.e.f0());
            c.a.r0.a.g1.f.U().u(new c.a.r0.a.o0.d.d(hashMap));
            c.a.r0.a.e0.d.i("SwanAppBaseFragment", "onClose");
            c.a.r0.a.n2.s.f fVar = new c.a.r0.a.n2.s.f();
            fVar.f8122e = IntentConfig.CLOSE;
            u1(fVar);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void m2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048631, this, i2, str) == null) {
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
                    if (str.equals(TimeFunctionConst.Timing.LINEAR)) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.k0, AnimationProperty.OPACITY, 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            c.a.r0.a.a3.d.b bVar = this.x0;
            if (bVar == null || bVar.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.x0.e(), AnimationProperty.OPACITY, 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) ? o2(i2, false) : invokeI.booleanValue;
    }

    public boolean o2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar == null || this.s0 == null) {
                return false;
            }
            this.B0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            c.a.r0.a.d2.n.g A1 = A1();
            if (A1 != null) {
                A1.a = i2;
                A1.g(z);
            }
            if (N1()) {
                p1();
            }
            if (V1()) {
                this.s0.setVisibility(0);
                return true;
            }
            this.s0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!S1()) {
                n0.c(this.g0);
            }
            if (N1() && this.x0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                q0.f0(new n(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.F0.c();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.onResume();
            this.F0.b();
            boolean z = I0;
            if (U()) {
                j2();
            }
            M2();
            if (this.q0 != null) {
                boolean d2 = c.a.r0.a.c1.a.y0().d();
                c.a.r0.n.n nVar = this.q0;
                if (d2 != nVar.t) {
                    nVar.B();
                    this.q0.t = c.a.r0.a.c1.a.y0().d();
                }
            }
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || this.x0 == null) {
            return;
        }
        q1(this.B0);
    }

    @Nullable
    public boolean p2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) ? q2(str, false) : invokeL.booleanValue;
    }

    public void q1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i2) == null) || this.x0 == null) {
            return;
        }
        r1(i2, false);
    }

    public boolean q2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            c.a.r0.a.d2.n.g A1 = A1();
            if (A1 != null) {
                A1.f5716b = str;
                A1.g(z);
            }
            c.a.r0.a.e0.d.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void r1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.x0 == null) {
            return;
        }
        this.B0 = i2;
        int i3 = this.A0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = c.a.r0.a.z2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.x0.m(i2, z, z2);
    }

    public void r2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.k0.setLeftBackViewVisibility(z);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, context) == null) {
            boolean z = I0;
            this.F0 = new c.a.r0.a.h0.g.m.c();
            super.s0(context);
            this.g0 = getActivity();
            L1(true);
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? (D1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            c.a.r0.a.d2.n.g A1 = A1();
            if (A1 != null && (A1.l || A1.m)) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                if (a0 != null) {
                    a0.d0().g(a0.x(), "scope_disable_swipe_back", new C0372d(this));
                    return;
                } else {
                    this.z0.setCanSlide(s1());
                    return;
                }
            }
            this.z0.setCanSlide(s1());
        }
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || this.g0 == null) {
            return;
        }
        c.a.r0.a.g1.g.a().d(false);
        this.g0.moveTaskToBack(true);
        l2();
        ((SwanAppActivity) this.g0).handleSwanAppExit(1);
        y0.b().e(2);
    }

    public void t2(boolean z) {
        SlideHelper slideHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z) == null) || (slideHelper = this.z0) == null) {
            return;
        }
        slideHelper.setCanSlide(s1() && z);
    }

    public final void u1(c.a.r0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, fVar) == null) {
            Activity activity = this.g0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
            }
        }
    }

    public void u2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.E0 = z;
        }
    }

    public final void v1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            q0.e0(new b(this, z));
        }
    }

    public void v2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.k0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.s0 != null) {
                int i2 = 8;
                if (!z && V1()) {
                    i2 = 0;
                }
                this.s0.setVisibility(i2);
            }
        }
    }

    public void w1(View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            q0.e0(new l(this, z, z2, view));
        }
    }

    public boolean w2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048653, this, i2)) == null) ? x2(i2, "", false) : invokeI.booleanValue;
    }

    public View x1(View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048654, this, view, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.z0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
            this.z0.setFadeColor(0);
            s2();
            E2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean x2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.k0 == null) {
                return false;
            }
            C2(!this.E0);
            c.a.r0.a.d2.n.g A1 = A1();
            if (A1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    A1.f5717c = str;
                }
                A1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (N1() && i3 != this.A0) {
                this.A0 = i3;
                p1();
            }
            return this.k0.setActionBarFrontColor(i2, this.E0);
        }
        return invokeCommon.booleanValue;
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            c.a.r0.a.h0.g.g G1 = G1();
            if (G1 != null && G1.k() != 1) {
                c.a.r0.a.n2.i.f(UUID.randomUUID().toString(), 1);
                g.b i2 = G1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
                eVar.f8122e = com.alipay.sdk.widget.d.u;
                eVar.f8124g = T1() ? "1" : "0";
                eVar.f8119b = "gesture";
                c.a.r0.a.n2.d.a(eVar, c.a.r0.a.d2.d.J().r().V());
                c.a.r0.a.n2.d.c(eVar);
                return;
            }
            Activity activity = this.g0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                y0.b().e(1);
            }
        }
    }

    public boolean y2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048657, this, str, z)) == null) ? x2(SwanAppConfigData.t(str), str, z) : invokeLZ.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            boolean z = I0;
            this.g0 = null;
            L1(false);
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

    public final c.b z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? new m(this) : (c.b) invokeV.objValue;
    }

    public void z2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, pVar) == null) {
            this.D0 = pVar;
        }
    }
}
