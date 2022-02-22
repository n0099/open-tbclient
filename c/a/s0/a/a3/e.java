package c.a.s0.a.a3;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.i;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.z2.f0;
import c.a.s0.a.z2.n0;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.t;
import c.a.s0.a.z2.y0;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.swan.apps.view.loading.SwanLoadingTips;
import com.baidu.swan.apps.view.loading.SwanLoadingTipsView;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static View A;
    public static boolean B;
    public static final boolean y;
    @SuppressLint({"StaticFieldLeak"})
    public static View z;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f5450b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f5451c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5452d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f5453e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f5454f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f5455g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f5456h;

    /* renamed from: i  reason: collision with root package name */
    public BdBaseImageView f5457i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f5458j;
    public View k;
    public c.a.s0.a.t.a l;
    public SwanAppActivity m;
    public View n;
    public SwanLoadingTipsView o;
    public SwanLoadingTips p;
    public TextView q;
    public ValueAnimator r;
    public float s;
    public float t;
    public float u;
    public k v;
    public String w;
    public c.a.s0.a.h0.i.h.a x;

    /* loaded from: classes.dex */
    public class a implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // c.a.s0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            e loadingView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || (x = c.a.s0.a.d2.d.J().x()) == null || x.isDestroyed() || (loadingView = x.getLoadingView()) == null || !TextUtils.equals(this.a, c.a.s0.a.d2.d.J().getAppId())) {
                return;
            }
            loadingView.J(bitmap);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f5459e;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5459e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.y(this.f5459e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5460e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5460e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f5460e.m);
                if (!f0.q(this.f5460e.m, this.f5460e.k) || this.f5460e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5460e.k.getLayoutParams();
                layoutParams.topMargin = this.f5460e.k.getTop() + e2;
                this.f5460e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5461e;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5461e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5461e.q == null) {
                return;
            }
            this.f5461e.q.setVisibility(0);
        }
    }

    /* renamed from: c.a.s0.a.a3.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0286e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5462e;

        public RunnableC0286e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5462e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f5462e.m);
                if (!f0.q(this.f5462e.m, this.f5462e.k) || this.f5462e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5462e.k.getLayoutParams();
                layoutParams.topMargin = this.f5462e.k.getTop() + e2;
                this.f5462e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5463e;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5463e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f5463e.D();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5464e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5464e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f5464e.D();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5465e;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5465e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f5465e.m == null || this.f5465e.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = c.a.s0.a.u1.h.m();
            if (m != null) {
                m.D("exitType", String.valueOf(3));
                m.E("value", QueryResponse.Options.CANCEL);
                m.n();
            }
            this.f5465e.m.moveTaskToBack(true);
            y0.b().e(2);
            this.f5465e.q();
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f5466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f5467f;

        public i(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5467f = eVar;
            this.f5466e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    c.a.s0.a.u1.h.o().F(new UbcFlowEvent("first_anim_end"));
                    c.a.s0.a.m2.a.d().i("first_anim_end");
                    if (this.f5467f.l != null) {
                        this.f5467f.l.l(this.f5467f.m, this.f5466e);
                    }
                    boolean unused = e.B = false;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f5468e;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5468e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue > 0.9f || floatValue - this.f5468e.t > 0.05d) {
                    this.f5468e.t = floatValue;
                    this.f5468e.M();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5469e;

        /* renamed from: f  reason: collision with root package name */
        public final String f5470f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5471g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5472h;

        /* renamed from: i  reason: collision with root package name */
        public final c.a.s0.a.d2.b f5473i;

        /* renamed from: j  reason: collision with root package name */
        public int f5474j;
        public int k;
        public boolean l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f5475e;

            public a(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5475e = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                    this.f5475e.k = aVar.i("KEY_PRELOAD_STATE");
                    this.f5475e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f5476e;

            public d(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5476e = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                    this.f5476e.l = true;
                    this.f5476e.e();
                }
            }
        }

        /* renamed from: c.a.s0.a.a3.e$k$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0287e implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0287e(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                }
            }
        }

        /* loaded from: classes.dex */
        public class f implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f5477e;

            public f(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5477e = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                    this.f5477e.f5474j = aVar.j("KEY_PKG_STATE", -1);
                    this.f5477e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class g implements c.a.s0.a.z2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ k f5478e;

            public g(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5478e = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.y;
                    this.f5478e.f5474j = aVar.j("KEY_PKG_STATE", -1);
                    this.f5478e.e();
                }
            }
        }

        public k(e eVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = eVar;
            this.f5471g = false;
            this.f5472h = false;
            this.f5474j = -1;
            this.f5470f = str;
            this.f5469e = z;
            c.a.s0.a.d2.b bVar = new c.a.s0.a.d2.b();
            bVar.e(new g(this, eVar), "event_pms_check_start");
            bVar.e(new f(this, eVar), "event_pms_check_finish");
            bVar.e(new C0287e(this, eVar), "event_pkg_download_start");
            bVar.e(new d(this, eVar), "event_pkg_download_finish");
            bVar.e(new c(this, eVar), "event_preload_start");
            bVar.e(new b(this, eVar), "event_preload_error");
            bVar.e(new a(this, eVar), "event_preload_finish");
            this.f5473i = bVar;
            c.a.s0.a.d2.d.J().v(this.f5473i);
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j2 = j();
                boolean g2 = g();
                boolean i2 = i();
                if (e.y) {
                    String str = "checkAndUpdateProgress: runtimeLoading " + j2;
                    String str2 = "checkAndUpdateProgress: checkingUpdate " + g2;
                    String str3 = "checkAndUpdateProgress: preloadFinish " + i2;
                }
                if (j2 || g2 || !i2) {
                    this.m.M();
                }
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (e.y) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewStarter exec : post = ");
                    sb.append(z);
                    sb.append(" trace = ");
                    sb.append(z ? "post" : Log.getStackTraceString(new Exception()));
                    sb.toString();
                }
                this.f5472h = true;
                boolean z2 = this.f5469e;
                if (z2) {
                    this.m.x(z2, this.f5471g);
                } else {
                    this.m.w(z2, this.f5471g);
                }
            }
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                boolean h2 = h();
                boolean i2 = i();
                boolean z = h2 && i2;
                if (e.y) {
                    String str = "isCheckingUpdate: overMaxAge " + h2;
                    String str2 = "isCheckingUpdate: preloadFinish " + i2;
                    String str3 = "isCheckingUpdate: " + z;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f5474j;
                boolean z = true;
                if (i2 != 3 && i2 != 1) {
                    z = false;
                }
                if (e.y) {
                    String str = "isOverMaxAge: isOverMaxAge " + z;
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean m0 = c.a.s0.a.h0.u.g.U().m0();
                if (e.y) {
                    String str = "isPreloadFinish: runtimeReady " + m0;
                }
                return m0;
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                boolean z = this.f5474j == 4;
                boolean i2 = i();
                if (e.y) {
                    String str = "isRuntimeLoading: isLocalPackage " + z;
                    String str2 = "isRuntimeLoading: preloadFinish " + i2;
                }
                return z && !i2;
            }
            return invokeV.booleanValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                boolean unused = e.y;
                c.a.s0.a.d2.d.J().p(this.f5473i);
            }
        }

        public k l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.f5471g = true;
                return this;
            }
            return (k) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                f(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(223091321, "Lc/a/s0/a/a3/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(223091321, "Lc/a/s0/a/a3/e;");
                return;
            }
        }
        y = c.a.s0.a.k.a;
        B = false;
    }

    public e(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.w = "";
        this.m = swanAppActivity;
        this.x = new c.a.s0.a.h0.i.h.a();
    }

    public static void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            z = null;
            A = null;
        }
    }

    public static View p(Context context, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, context, z2)) == null) {
            try {
                return LayoutInflater.from(context).inflate(z2 ? c.a.s0.a.g.ai_games_loading_fragment : c.a.s0.a.g.aiapps_loading_fragment_circle, (ViewGroup) null);
            } catch (Exception e2) {
                if (y) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (View) invokeLZ.objValue;
    }

    public static void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, context) == null) {
            if (z == null) {
                z = p(context, false);
            }
            if (A == null) {
                A = p(context, true);
            }
            if (y) {
                String str = "obtainPreloadContainer:  App=" + z + " Game=" + A;
            }
        }
    }

    public static void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            q0.f0(new b(context), 5000L);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f5455g.setOnClickListener(new h(this));
        }
    }

    public final void C(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.q == null || this.u > f2) {
            return;
        }
        this.u = f2;
        if (y) {
            String str = "setProgressText: " + this.u;
        }
        int i2 = (int) (1000.0f * f2);
        String str2 = ((i2 / 10) + (i2 % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.w.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str2);
        k kVar = this.v;
        if (kVar != null && !kVar.f5469e) {
            if (kVar.j()) {
                boolean z2 = y;
            } else if (!this.v.h() || this.u > 0.0f) {
                if (this.v.l && !this.v.i()) {
                    boolean z3 = y;
                    this.q.setVisibility(4);
                } else if (this.u >= 1.0f && !this.v.i()) {
                    boolean z4 = y;
                    this.q.setVisibility(4);
                } else {
                    this.q.setText(sb);
                }
            } else {
                boolean z5 = y;
                this.q.setVisibility(4);
            }
        } else {
            this.q.setText(sb);
        }
        if (f2 == 1.0f) {
            this.q.setVisibility(4);
        }
    }

    public final void D() {
        SwanLoadingTips swanLoadingTips;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.o == null || (swanLoadingTips = this.p) == null) {
            return;
        }
        this.o.startTipsAppearAnimation(swanLoadingTips.b());
    }

    public void E(boolean z2, boolean z3, @Nullable i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            this.x.f();
            String V = c.a.s0.a.d2.d.J().r().V().V();
            k kVar = this.v;
            boolean z4 = true;
            boolean z5 = kVar == null || (kVar.f5469e ^ z2) || TextUtils.isEmpty(V) || !TextUtils.equals(V, this.v.f5470f);
            if (y) {
                String str = "showSwanAppStartView: newLaunchId = " + V + " newIsGameLoading = " + z2 + " reCreateStarter = " + z5 + " mViewStarter = " + this.v;
            }
            Handler L = c.a.s0.a.d2.d.L();
            if (this.v != null) {
                if (y) {
                    String str2 = "showSwanAppStartView: oldLaunchId = " + this.v.f5470f + " oldIsGameLoading = " + this.v.f5469e;
                }
                L.removeCallbacks(this.v);
            }
            if (z5) {
                this.v = new k(this, V, z2);
            }
            if (this.v == null) {
                return;
            }
            z4 = (aVar == null || !aVar.e(" event_params_pkg_update", false)) ? false : false;
            k kVar2 = this.v;
            if (kVar2.f5472h) {
                if (y) {
                    String str3 = "showSwanAppStartView: return by executing pkgUpdating = " + z4 + " trace = " + Log.getStackTraceString(new Exception());
                }
                if (z4) {
                    N(z2, z4);
                    return;
                }
                return;
            }
            if (z4) {
                kVar2.l();
            }
            if (z3) {
                this.v.f(false);
                return;
            }
            if (y) {
                String str4 = "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable());
            }
            L.post(this.v);
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Handler L = c.a.s0.a.d2.d.L();
            k kVar = this.v;
            if (kVar != null) {
                L.removeCallbacks(kVar);
                this.v.k();
                this.v = null;
            }
            L.post(new i(this, i2));
        }
    }

    public void G(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r.removeAllUpdateListeners();
        }
        N(z2, z3);
        this.t = 0.0f;
        this.s = 0.0f;
        this.u = 0.0f;
        if (z2) {
            M();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.r = ofFloat;
            ofFloat.addUpdateListener(new j(this));
            this.r.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r.start();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (y) {
                String str = "stopAnimations: " + Log.getStackTraceString(new Exception());
            }
            Handler L = c.a.s0.a.d2.d.L();
            k kVar = this.v;
            if (kVar != null) {
                L.removeCallbacks(kVar);
                this.v.k();
                this.v = null;
            }
            synchronized (e.class) {
                if (this.l != null) {
                    this.l.n();
                }
                if (this.o != null) {
                    this.o.doDestroy();
                    this.o = null;
                }
                if (this.q != null) {
                    this.q.setVisibility(8);
                    this.q = null;
                    this.w = "";
                    this.t = 0.0f;
                    this.s = 0.0f;
                    this.u = 0.0f;
                }
                if (this.r != null) {
                    this.r.removeAllUpdateListeners();
                    this.r.cancel();
                    this.r = null;
                }
                B = false;
                if (this.v != null) {
                    this.v.k();
                    this.v = null;
                }
            }
        }
    }

    public void I(String str) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (y) {
                String str2 = "updateIcon: icon=" + str;
            }
            String appId = c.a.s0.a.d2.d.J().getAppId();
            if (!B || (swanAppRoundedImageView = this.f5451c) == null) {
                return;
            }
            swanAppRoundedImageView.setImageBitmap(q0.k(str, "SwanAppLoadingView", true, new a(this, appId)));
        }
    }

    public final void J(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || bitmap == null || (swanAppRoundedImageView = this.f5451c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void K(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || !B || TextUtils.isEmpty(str) || (textView = this.f5450b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void L(int i2) {
        View view;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view = this.a) == null || (relativeLayout = (RelativeLayout) view.findViewById(c.a.s0.a.f.guarantee_plan_rl)) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    public final void M() {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.q == null) {
            return;
        }
        float o = o(this.t, this.s);
        if (o > 1.0f) {
            o = 1.0f;
        }
        C(o);
        if (o <= 0.0f || c.a.s0.a.d2.d.J().l() == 1 || (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(c.a.s0.a.f.App_Launch_Circle_Animation_View)) == null) {
            return;
        }
        swanAppLaunchCircleAnimationView.updateDownloadingAnimation(o);
    }

    public final void N(boolean z2, boolean z3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (textView = this.q) == null) {
            return;
        }
        if (!z2) {
            this.w = textView.getContext().getString(c.a.s0.a.h.swan_loading_view_tag_downloading);
        } else {
            this.w = "";
        }
    }

    public final float o(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((1.0f - f2) * f3) + f2 : invokeCommon.floatValue;
    }

    public final void q() {
        b.a launchInfo;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (launchInfo = this.m.getLaunchInfo()) == null || (P = launchInfo.P()) == null) {
            return;
        }
        long j2 = P.getLong("page_display_flag_for_statistic");
        P.remove("page_display_flag_for_statistic");
        if (j2 <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - launchInfo.l("launch_time", 0L));
        c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
        fVar.f8219b = "launch";
        fVar.f8222e = "realcancel";
        fVar.q = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.G() == 1) {
            fVar.a("errorList", c.a.s0.a.c1.b.j().a());
        }
        this.m.doUBCEventStatistic(fVar);
        c.a.s0.a.n2.e.q(launchInfo);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.a.findViewById(c.a.s0.a.f.aigames_loading_game_tips);
            this.o = swanLoadingTipsView;
            swanLoadingTipsView.setTipsAnimationFinishCallback(new f(this));
            this.p = new SwanLoadingTips();
            this.a.addOnAttachStateChangeListener(new g(this));
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            n0.N(this.f5457i, this.f5458j, String.valueOf(i2));
        }
    }

    public final View t(Context context, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048593, this, context, z2)) == null) {
            View view = z2 ? A : z;
            if (z2) {
                A = null;
            } else {
                z = null;
            }
            boolean z3 = (view == null || view.isAttachedToWindow()) ? false : true;
            if (!z3) {
                view = p(context, z2);
            }
            if (y) {
                String str = "obtainPreloadContainer:  isLegalContainer= " + z3 + " game=" + z2 + " container=" + view;
            }
            return view;
        }
        return (View) invokeLZ.objValue;
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (y) {
                String str = "onDownloadProgressUpdate: " + f2 + " view: " + this.q;
            }
            this.x.d();
            if (this.q == null) {
                return;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.s = f2;
            M();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.cancel();
            this.r = null;
        }
        C(1.0f);
    }

    public final void w(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (e.class) {
                if (this.l == null) {
                    this.l = new c.a.s0.a.t.a();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, c.a.s0.a.c2.b.a.f5657b ? n0.t() : 0, 0, 0);
                } else {
                    r();
                }
                Handler L = c.a.s0.a.d2.d.L();
                b.a V = c.a.s0.a.d2.d.J().r().V();
                this.m.getFloatLayer().n(this.a);
                B = true;
                this.f5454f = (ImageView) this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_img);
                this.f5455g = (ImageView) this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_exit);
                this.k = this.a.findViewById(c.a.s0.a.f.titlebar_right_menu);
                if (z2) {
                    this.f5454f.setClickable(true);
                    this.f5454f.setImageResource(c.a.s0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f5455g.setImageResource(c.a.s0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(c.a.s0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(c.a.s0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new c(this));
                } else {
                    this.f5454f.setImageResource(c.a.s0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f5455g.setImageResource(c.a.s0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(c.a.s0.a.e.aiapps_action_bar_right_menu_bg);
                    L(V.p1());
                }
                this.q = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_loading_progress);
                L.postDelayed(new d(this), 2000L);
                G(z2, z3);
                TextView textView = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_title);
                this.f5450b = textView;
                textView.getPaint().setFakeBoldText(true);
                this.f5451c = (SwanAppRoundedImageView) this.a.findViewById(c.a.s0.a.f.aiapps_icon);
                this.f5457i = (BdBaseImageView) this.a.findViewById(c.a.s0.a.f.aiapps_label_bg);
                this.f5458j = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_label_tv);
                this.f5456h = (RelativeLayout) this.a.findViewById(c.a.s0.a.f.aiapps_icon_rl);
                K(V.K());
                I(V.Q());
                s(V.getType());
                this.l.j(this.m);
                B();
            }
        }
    }

    public final void x(boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (e.class) {
                if (this.l == null) {
                    this.l = new c.a.s0.a.t.a();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, c.a.s0.a.c2.b.a.f5657b ? n0.t() : 0, 0, 0);
                } else {
                    r();
                }
                this.q = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_loading_progress);
                b.a V = c.a.s0.a.d2.d.J().r().V();
                V.f0();
                G(z2, z3);
                this.m.getFloatLayer().n(this.a);
                B = true;
                this.f5450b = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_title);
                this.f5451c = (SwanAppRoundedImageView) this.a.findViewById(c.a.s0.a.f.aiapps_icon);
                this.f5457i = (BdBaseImageView) this.a.findViewById(c.a.s0.a.f.aiapps_label_bg);
                this.f5458j = (TextView) this.a.findViewById(c.a.s0.a.f.aiapps_label_tv);
                this.f5456h = (RelativeLayout) this.a.findViewById(c.a.s0.a.f.aiapps_icon_rl);
                K(V.K());
                I(V.Q());
                s(V.getType());
                this.f5452d = (ImageView) this.a.findViewById(c.a.s0.a.f.light_print);
                this.f5453e = (ImageView) this.a.findViewById(c.a.s0.a.f.dark_print);
                this.f5454f = (ImageView) this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_img);
                this.f5455g = (ImageView) this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_exit);
                this.k = this.a.findViewById(c.a.s0.a.f.titlebar_right_menu);
                if (z2) {
                    this.f5454f.setClickable(true);
                    this.f5454f.setImageResource(c.a.s0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f5455g.setImageResource(c.a.s0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(c.a.s0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.a.findViewById(c.a.s0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(c.a.s0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new RunnableC0286e(this));
                } else {
                    this.f5454f.setImageResource(c.a.s0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f5455g.setImageResource(c.a.s0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(c.a.s0.a.e.aiapps_action_bar_right_menu_bg);
                    L(V.p1());
                }
                this.f5453e.setAlpha(0.0f);
                this.l.m(this.m);
                B();
            }
        }
    }
}
