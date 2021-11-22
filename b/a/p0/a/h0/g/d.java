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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.v0.c;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q0;
import b.a.p0.a.z2.y0;
import com.baidu.android.imsdk.internal.Constants;
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
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class d extends Fragment implements SlideInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean H0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public o B0;
    public p C0;
    public boolean D0;
    public b.a.p0.a.h0.g.m.c E0;
    public double F0;
    public boolean G0;
    public final String k0;
    public Activity l0;
    public b.a.p0.a.m1.c m0;
    public View n0;
    public SwanAppActionBar o0;
    public b.a.p0.n.n p0;
    public SwanAppMenuHeaderView q0;
    public View r0;
    public TextView s0;
    public TextView t0;
    public Button u0;
    public AtomicBoolean v0;
    @Nullable
    public b.a.p0.a.a3.d.b w0;
    public boolean x0;
    public SlideHelper y0;
    public int z0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5422e;

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
            this.f5422e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5422e.y1(b.a.p0.a.x1.a.a.E());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5424f;

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
            this.f5424f = dVar;
            this.f5423e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActionBar swanAppActionBar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f5424f;
                if (dVar.l0 == null || (swanAppActionBar = dVar.o0) == null) {
                    return;
                }
                if (this.f5423e) {
                    if (dVar.s0 == null) {
                        dVar.s0 = new TextView(this.f5424f.l0);
                    }
                    if (this.f5424f.s0.getParent() instanceof SwanAppActionBar) {
                        return;
                    }
                    this.f5424f.s0.setText(b.a.p0.a.h.aiapps_debug_open_cts);
                    d dVar2 = this.f5424f;
                    dVar2.s0.setTextColor(dVar2.G1().getColor(17170455));
                    d dVar3 = this.f5424f;
                    dVar3.o0.addView(dVar3.s0);
                    return;
                }
                TextView textView = dVar.s0;
                if (textView != null) {
                    swanAppActionBar.removeView(textView);
                    this.f5424f.s0 = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5425e;

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
            this.f5425e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5425e.f2();
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0214d implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5426e;

        public C0214d(d dVar) {
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
            this.f5426e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    this.f5426e.y0.setRegionFactor(0.1d);
                    d dVar = this.f5426e;
                    dVar.F0 = 0.1d;
                    dVar.y0.setCanSlide(dVar.v1());
                    return;
                }
                d dVar2 = this.f5426e;
                dVar2.y0.setCanSlide(dVar2.v1());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements SlidingPaneLayout.PanelSlideListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5427a;

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
            this.f5427a = dVar;
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5427a.h2();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f5427a.B1();
            }
        }

        @Override // com.baidu.searchbox.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, view, f2) == null) {
                View maskView = this.f5427a.y0.getMaskView();
                if (maskView != null) {
                    maskView.setAlpha(1.0f - f2);
                }
                this.f5427a.i2(f2);
                if (this.f5427a.C0 != null) {
                    this.f5427a.C0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n1.h.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5428e;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.h0.j.b<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f5429a;

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
                this.f5429a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.h0.j.b
            /* renamed from: b */
            public void a(Boolean bool) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                    this.f5429a.f5428e.e2();
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
            this.f5428e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (b.a.p0.a.v0.a.b().c()) {
                    b.a.p0.a.v0.a.b().f(this.f5428e.l0, new a(this));
                } else {
                    this.f5428e.e2();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5430e;

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
            this.f5430e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5430e.g2();
                b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
                fVar.f7383e = SupportMenuInflater.XML_MENU;
                if (b.a.p0.a.d2.e.a0() != null && b.a.p0.a.d2.e.a0().T().d("key_unread_counts_message", 0).intValue() > 0) {
                    fVar.f7385g = String.valueOf(1);
                }
                this.f5430e.x1(fVar);
                if (this.f5430e.B0 != null) {
                    this.f5430e.B0.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5431e;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f5432e;

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
                this.f5432e = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(b.a.p0.a.h2.c.i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (b.a.p0.a.h2.c.d.h(iVar)) {
                        this.f5432e.f5431e.n2();
                    } else {
                        this.f5432e.f5431e.j2();
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
            this.f5431e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (activity = this.f5431e.l0) != null && (activity instanceof SwanAppActivity)) {
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    if (b.a.p0.a.z2.j.f() && b.a.p0.q.k.i.m.a().d()) {
                        a0.d0().g(a0.x(), "mapp_emit_app_close", new a(this));
                        return;
                    } else {
                        this.f5431e.j2();
                        return;
                    }
                }
                this.f5431e.w1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements b.a.p0.a.h0.j.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5433a;

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
            this.f5433a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && bool.booleanValue()) {
                this.f5433a.w1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f5434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5435f;

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
            this.f5435f = dVar;
            this.f5434e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || b.a.p0.a.l2.c.g()) {
                return;
            }
            this.f5435f.z1(this.f5434e, b.a.p0.a.l2.c.d(), b.a.p0.a.l2.c.f());
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f5438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5439h;

        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f5440e;

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
                this.f5440e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f5440e.f5439h.l2();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ l f5441e;

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
                this.f5441e = lVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f5441e.f5439h.N2();
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
            this.f5439h = dVar;
            this.f5436e = z;
            this.f5437f = z2;
            this.f5438g = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5436e || this.f5437f) {
                    d dVar = this.f5439h;
                    if (dVar.u0 == null) {
                        View view = this.f5438g;
                        if (view == null) {
                            b.a.p0.a.e0.d.b("SwanAppBaseFragment", "view为null");
                            return;
                        }
                        dVar.u0 = (Button) view.findViewById(b.a.p0.a.f.swanapp_obtain_stability_data_btn);
                    }
                    this.f5439h.u0.setVisibility(0);
                    if (this.f5436e) {
                        this.f5439h.u0.setOnClickListener(new a(this));
                    }
                    if (this.f5437f) {
                        this.f5439h.v0 = new AtomicBoolean(false);
                        this.f5439h.u0.setText(b.a.p0.a.h.swanapp_stability_profile_pause);
                        this.f5439h.u0.setOnClickListener(new b(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5442a;

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
            this.f5442a = dVar;
        }

        @Override // b.a.p0.a.v0.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5442a.w1();
            }
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f5443e;

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
            this.f5443e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5443e.m2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f5444a;

        /* renamed from: b  reason: collision with root package name */
        public long f5445b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f5446c;

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
            this.f5444a = 0;
            this.f5445b = 0L;
            this.f5446c = runnable;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f5445b > 1333) {
                    this.f5445b = currentTimeMillis;
                    this.f5444a = 1;
                    return;
                }
                int i2 = this.f5444a + 1;
                this.f5444a = i2;
                if (i2 == 3) {
                    Runnable runnable = this.f5446c;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.f5444a = 0;
                    this.f5445b = 0L;
                    return;
                }
                this.f5445b = currentTimeMillis;
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
        H0 = b.a.p0.a.k.f6863a;
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
        this.k0 = UUID.randomUUID().toString();
        this.x0 = b.a.p0.a.a3.d.b.f4066i;
        this.z0 = 1;
        this.A0 = 1;
        this.D0 = false;
        this.F0 = -1.0d;
        this.G0 = false;
    }

    public View A1(View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, slideInterceptor)) == null) {
            SlideHelper slideHelper = new SlideHelper();
            this.y0 = slideHelper;
            View wrapSlideView = slideHelper.wrapSlideView(view.getContext(), view, slideInterceptor);
            this.y0.setFadeColor(0);
            v2();
            H2();
            return wrapSlideView;
        }
        return (View) invokeLL.objValue;
    }

    public boolean A2(@ColorInt int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            if (this.o0 == null) {
                return false;
            }
            F2(!this.D0);
            b.a.p0.a.d2.n.g D1 = D1();
            if (D1 != null) {
                if (!TextUtils.isEmpty(str)) {
                    D1.f4519c = str;
                }
                D1.g(z);
            }
            int i3 = i2 != -16777216 ? -1 : -16777216;
            if (Q1() && i3 != this.z0) {
                this.z0 = i3;
                s1();
            }
            return this.o0.setActionBarFrontColor(i2, this.D0);
        }
        return invokeCommon.booleanValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.a.h0.g.g J1 = J1();
            if (J1 != null && J1.k() != 1) {
                b.a.p0.a.n2.i.f(UUID.randomUUID().toString(), 1);
                g.b i2 = J1.i("navigateBack");
                i2.n(0, 0);
                i2.g();
                i2.a();
                b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
                eVar.f7383e = com.alipay.sdk.widget.d.u;
                eVar.f7385g = W1() ? "1" : "0";
                eVar.f7380b = "gesture";
                b.a.p0.a.n2.d.a(eVar, b.a.p0.a.d2.d.J().r().V());
                b.a.p0.a.n2.d.c(eVar);
                return;
            }
            Activity activity = this.l0;
            if (activity != null) {
                activity.moveTaskToBack(true);
                y0.b().e(1);
            }
        }
    }

    public boolean B2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) ? A2(SwanAppConfigData.t(str), str, z) : invokeLZ.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean z = H0;
            this.l0 = null;
            O1(false);
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

    public final c.b C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new m(this) : (c.b) invokeV.objValue;
    }

    public void C2(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) {
            this.C0 = pVar;
        }
    }

    public b.a.p0.a.d2.n.g D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (b.a.p0.a.d2.n.g) invokeV.objValue;
    }

    public void D2(double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) && X1(d2)) {
            if (X1(this.F0)) {
                d2 = this.F0;
            }
            this.y0.setRegionFactor(d2);
        }
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TextUtils.isEmpty(b.a.p0.a.d2.e.f0())) {
                return 0;
            }
            return b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.e.f0()) ? 2 : 1;
        }
        return invokeV.intValue;
    }

    public void E2(int i2) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (activity = this.l0) == null) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }

    @Nullable
    public b.a.p0.a.a3.d.b F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w0 : (b.a.p0.a.a3.d.b) invokeV.objValue;
    }

    public void F2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o0.setRightExitViewVisibility(z);
        }
    }

    public final Resources G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (n0()) {
                return getResources();
            }
            return AppRuntime.getAppContext().getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public void G2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o0.setRightZoneVisibility(z);
        }
    }

    public SwanAppActionBar H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.o0 : (SwanAppActionBar) invokeV.objValue;
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.y0.setSlideListener(new e(this));
        }
    }

    public View I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n0 : (View) invokeV.objValue;
    }

    public boolean I2(FrameLayout frameLayout, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{frameLayout, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (frameLayout == null) {
                return false;
            }
            frameLayout.setBackgroundColor(i2);
            b.a.p0.a.d2.n.g D1 = D1();
            if (D1 != null) {
                D1.f4521e = i2;
                D1.p = z;
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final b.a.p0.a.h0.g.g J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Activity activity = this.l0;
            if (activity == null) {
                return null;
            }
            return ((SwanAppActivity) activity).getSwanAppFragmentManager();
        }
        return (b.a.p0.a.h0.g.g) invokeV.objValue;
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public abstract boolean K();

    public b.a.p0.a.m1.c K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m0 : (b.a.p0.a.m1.c) invokeV.objValue;
    }

    public boolean K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public b.a.p0.n.n L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p0 : (b.a.p0.n.n) invokeV.objValue;
    }

    public final void L2(boolean z, float f2) {
        b.a.p0.a.h0.g.g J1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) || (J1 = J1()) == null || J1.k() < 2) {
            return;
        }
        d j2 = J1.j(J1.k() - 2);
        d2(f2, j2);
        if (z) {
            if (j2.G0) {
                M2(J1, f2);
                return;
            } else {
                J1.h().o(j2);
                return;
            }
        }
        J1.h().c(j2);
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            b.a.p0.a.f2.f.o0.a.f("backtohome", SupportMenuInflater.XML_MENU, b.a.p0.a.g1.f.U().f());
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7383e = "gohome";
            fVar.f7381c = SupportMenuInflater.XML_MENU;
            x1(fVar);
        }
    }

    public final void M2(b.a.p0.a.h0.g.g gVar, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048603, this, gVar, f2) == null) || gVar == null || gVar.k() < 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int k2 = gVar.k() - 3;
        while (true) {
            if (k2 < 0) {
                break;
            }
            d j2 = gVar.j(k2);
            if (j2.G0) {
                d2(f2, j2);
                arrayList.add(j2);
                k2--;
            } else {
                d2(f2, j2);
                arrayList.add(j2);
                break;
            }
        }
        gVar.h().p(arrayList);
    }

    public void N1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            FloatButton c2 = b.a.p0.a.f2.f.h0.a.d().c();
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

    public final void N2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.u0 == null) {
            return;
        }
        AtomicBoolean atomicBoolean = this.v0;
        atomicBoolean.set(!atomicBoolean.get());
        boolean z = this.v0.get();
        this.u0.setText(z ? b.a.p0.a.h.swanapp_stability_profile_resume : b.a.p0.a.h.swanapp_stability_profile_pause);
        b.a.p0.a.l2.c.j(z);
    }

    public void O1(boolean z) {
        b.a.p0.a.h0.g.g V;
        d j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (V = b.a.p0.a.g1.f.U().V()) == null) {
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
        N1(j2.Z1());
    }

    public void O2(b.a.p0.a.h0.g.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) {
            this.E0.e(aVar);
        }
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.showLoadingProgressBar(false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            b.a.p0.a.u1.k.i.c.e().d(new a(this), "updateCtsView", false);
        }
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.x0 : invokeV.booleanValue;
    }

    public void Q2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            b.a.p0.a.u1.k.i.c.e().d(new k(this, view), "updateStabilityDataView", false);
        }
    }

    public void R1(View view) {
        b.a.p0.a.d2.n.g e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
            S1(view);
            SwanAppConfigData r = b.a.p0.a.g1.f.U().r();
            if (r == null) {
                if (H0) {
                    String str = "config data is null. " + Log.getStackTraceString(new Exception());
                    return;
                }
                return;
            }
            b.a.p0.a.m1.c cVar = this.m0;
            if (cVar == null) {
                e2 = r.f45030e;
            } else {
                e2 = b.a.p0.a.g1.f.U().e(b.a.p0.a.f2.f.o0.j.c(cVar.i(), r));
            }
            q2(e2.f4517a);
            this.o0.setTitle(e2.f4518b);
            this.B0 = new o(this, new f(this));
            if (!(this instanceof SwanAppAdLandingFragment)) {
                z2(SwanAppConfigData.t(e2.f4519c));
            }
            String str2 = e2.f4519c;
        }
    }

    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, view) == null) || view == null) {
            return;
        }
        this.o0 = (SwanAppActionBar) view.findViewById(b.a.p0.a.f.ai_apps_title_bar);
        this.n0 = view.findViewById(b.a.p0.a.f.ai_apps_title_bar_root);
        this.r0 = view.findViewById(b.a.p0.a.f.title_shadow);
        this.o0.setLeftBackViewMinWidth(n0.f(this.l0, 38.0f));
        g gVar = new g(this);
        this.o0.setLeftBackViewClickListener(gVar);
        this.o0.setLeftFloatBackViewClickListener(gVar);
        this.o0.setRightMenuOnClickListener(new h(this));
        this.o0.setRightExitOnClickListener(new i(this));
    }

    public View T1(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view)) == null) {
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
            U1(frameLayout, view);
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public View U1(FrameLayout frameLayout, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, frameLayout, view)) == null) {
            frameLayout.setTag("IMMERSION_LAYOUT_TAG");
            frameLayout.addView(view);
            this.w0 = new b.a.p0.a.a3.d.b(this.l0, frameLayout);
            s1();
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            Activity activity = this.l0;
            return (activity instanceof SwanAppActivity) && ((SwanAppActivity) activity).getFrameType() == 1;
        }
        return invokeV.booleanValue;
    }

    public final boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            b.a.p0.a.h0.g.g J1 = J1();
            return J1 != null && J1.k() > 1;
        }
        return invokeV.booleanValue;
    }

    public boolean X1(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Double.valueOf(d2)})) == null) ? d2 >= 0.0d && d2 <= 1.0d : invokeCommon.booleanValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.A0 == -1 : invokeV.booleanValue;
    }

    public abstract boolean Z1();

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u".equals(b.a.p0.a.d2.e.f0()) : invokeV.booleanValue;
    }

    public abstract boolean b2();

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.o0.setLeftHomeViewVisibility(0);
            this.o0.setLeftHomeViewClickListener(new c(this));
        }
    }

    public final void d2(float f2, Fragment fragment) {
        View d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f2), fragment}) == null) {
            float o2 = n0.o(this.l0) >> 2;
            float f3 = (f2 * o2) - o2;
            if (fragment == null || (d0 = fragment.d0()) == null) {
                return;
            }
            d0.setX(f3);
        }
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            Activity activity = this.l0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).onBackPressed(2);
            } else if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public abstract void g2();

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            L2(false, 1.0f);
        }
    }

    public void i2(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048629, this, f2) == null) {
            L2(true, f2);
        }
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            super.j1(z);
            if (z) {
                m2();
            }
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (b.a.p0.a.v0.a.b().c()) {
                b.a.p0.a.v0.a.b().f(this.l0, new j(this));
            } else if (b.a.p0.a.v0.c.c().h()) {
                w1();
            } else {
                b.a.p0.a.v0.b bVar = new b.a.p0.a.v0.b();
                bVar.h();
                if (bVar.j()) {
                    b.a.p0.a.v0.c.c().j(this.l0, bVar.f(), bVar.e(), bVar, C1());
                    return;
                }
                w1();
                b.a.p0.a.n1.h.e().g();
            }
        }
    }

    public void k2(b.a.p0.a.h0.g.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, aVar) == null) {
            this.E0.d(aVar);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            Button button = this.u0;
            if (button != null) {
                button.setVisibility(8);
            }
            TextView textView = this.t0;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (b.a.p0.a.l2.c.d()) {
                b.a.p0.a.l2.c.l(true);
            }
        }
    }

    public void m2() {
        b.a.p0.a.a3.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || this.G0 || !Q1() || (bVar = this.w0) == null) {
            return;
        }
        bVar.l();
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            String C = b.a.p0.a.g1.f.U().C();
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, C);
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("closeBtn", hashMap));
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onClose");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, b.a.p0.a.d2.e.f0());
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.d(hashMap));
            b.a.p0.a.e0.d.i("SwanAppBaseFragment", "onClose");
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7383e = IntentConfig.CLOSE;
            x1(fVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (!V1()) {
                n0.c(this.l0);
            }
            if (Q1() && this.w0 != null && configuration.orientation == 1) {
                getActivity().getWindow().clearFlags(1024);
                q0.f0(new n(this), 200L);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.E0.c();
            super.onPause();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            super.onResume();
            this.E0.b();
            boolean z = H0;
            if (c0()) {
                m2();
            }
            P2();
            if (this.p0 != null) {
                boolean d2 = b.a.p0.a.c1.a.y0().d();
                b.a.p0.n.n nVar = this.p0;
                if (d2 != nVar.t) {
                    nVar.x();
                    this.p0.t = b.a.p0.a.c1.a.y0().d();
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void p2(int i2, String str) {
        char c2;
        TimeInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048641, this, i2, str) == null) {
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o0, "alpha", 0.0f, 1.0f);
            long j2 = i2;
            ofFloat.setDuration(j2);
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.start();
            b.a.p0.a.a3.d.b bVar = this.w0;
            if (bVar == null || bVar.e() == null) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w0.e(), "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(j2);
            ofFloat2.setInterpolator(linearInterpolator);
            ofFloat2.start();
        }
    }

    public boolean q2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i2)) == null) ? r2(i2, false) : invokeI.booleanValue;
    }

    public boolean r2(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar == null || this.r0 == null) {
                return false;
            }
            this.A0 = i2;
            swanAppActionBar.setBackgroundColor(i2);
            b.a.p0.a.d2.n.g D1 = D1();
            if (D1 != null) {
                D1.f4517a = i2;
                D1.g(z);
            }
            if (Q1()) {
                s1();
            }
            if (Y1()) {
                this.r0.setVisibility(0);
                return true;
            }
            this.r0.setVisibility(8);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void s1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || this.w0 == null) {
            return;
        }
        t1(this.A0);
    }

    @Nullable
    public boolean s2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) ? t2(str, false) : invokeL.booleanValue;
    }

    public void t1(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048646, this, i2) == null) || this.w0 == null) {
            return;
        }
        u1(i2, false);
    }

    public boolean t2(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048647, this, str, z)) == null) {
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar == null) {
                return false;
            }
            swanAppActionBar.setTitle(str);
            b.a.p0.a.d2.n.g D1 = D1();
            if (D1 != null) {
                D1.f4518b = str;
                D1.g(z);
            }
            b.a.p0.a.e0.d.i("SwanAppBaseFragment", "page title: " + str);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void u1(@ColorInt int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.w0 == null) {
            return;
        }
        this.A0 = i2;
        int i3 = this.z0;
        boolean z2 = true;
        if (i3 == 1) {
            z2 = b.a.p0.a.z2.i.a(i2);
        } else if (i3 != -16777216) {
            z2 = false;
        }
        this.w0.m(i2, z, z2);
    }

    public void u2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.o0.setLeftBackViewVisibility(z);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, context) == null) {
            boolean z = H0;
            this.E0 = new b.a.p0.a.h0.g.m.c();
            super.v0(context);
            this.l0 = getActivity();
            O1(true);
        }
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? (G1().getConfiguration().orientation == 2 || Build.VERSION.SDK_INT == 26) ? false : true : invokeV.booleanValue;
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            b.a.p0.a.d2.n.g D1 = D1();
            if (D1 != null && (D1.l || D1.m)) {
                b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
                if (a0 != null) {
                    a0.d0().g(a0.x(), "scope_disable_swipe_back", new C0214d(this));
                    return;
                } else {
                    this.y0.setCanSlide(v1());
                    return;
                }
            }
            this.y0.setCanSlide(v1());
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || this.l0 == null) {
            return;
        }
        b.a.p0.a.g1.g.a().d(false);
        this.l0.moveTaskToBack(true);
        o2();
        ((SwanAppActivity) this.l0).handleSwanAppExit(1);
        y0.b().e(2);
    }

    public void w2(boolean z) {
        SlideHelper slideHelper;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048654, this, z) == null) || (slideHelper = this.y0) == null) {
            return;
        }
        slideHelper.setCanSlide(v1() && z);
    }

    public final void x1(b.a.p0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, fVar) == null) {
            Activity activity = this.l0;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).doUBCEventStatistic(fVar);
            }
        }
    }

    public void x2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.D0 = z;
        }
    }

    public final void y1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            q0.e0(new b(this, z));
        }
    }

    public void y2(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SwanAppActionBar swanAppActionBar = this.o0;
            if (swanAppActionBar != null) {
                swanAppActionBar.setActionBarCustom(z, z2);
            }
            if (this.r0 != null) {
                int i2 = 8;
                if (!z && Y1()) {
                    i2 = 0;
                }
                this.r0.setVisibility(i2);
            }
        }
    }

    public void z1(View view, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            q0.e0(new l(this, z, z2, view));
        }
    }

    public boolean z2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048660, this, i2)) == null) ? A2(i2, "", false) : invokeI.booleanValue;
    }
}
