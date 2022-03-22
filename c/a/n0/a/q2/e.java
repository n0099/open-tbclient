package c.a.n0.a.q2;

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
import c.a.n0.a.p2.f0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.t;
import c.a.n0.a.p2.y0;
import c.a.n0.a.t1.i;
import c.a.n0.a.v0.e.b;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public TextView f6020b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f6021c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f6022d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f6023e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f6024f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f6025g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f6026h;
    public BdBaseImageView i;
    public TextView j;
    public View k;
    public c.a.n0.a.j.a l;
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
    public c.a.n0.a.x.i.h.a x;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // c.a.n0.a.p2.t.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            e loadingView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || (x = c.a.n0.a.t1.d.J().x()) == null || x.isDestroyed() || (loadingView = x.getLoadingView()) == null || !TextUtils.equals(this.a, c.a.n0.a.t1.d.J().getAppId())) {
                return;
            }
            loadingView.J(bitmap);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.y(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.a.m);
                if (!f0.q(this.a.m, this.a.k) || this.a.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.k.getLayoutParams();
                layoutParams.topMargin = this.a.k.getTop() + e2;
                this.a.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.q == null) {
                return;
            }
            this.a.q.setVisibility(0);
        }
    }

    /* renamed from: c.a.n0.a.q2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0428e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public RunnableC0428e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.a.m);
                if (!f0.q(this.a.m, this.a.k) || this.a.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.k.getLayoutParams();
                layoutParams.topMargin = this.a.k.getTop() + e2;
                this.a.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.D();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.D();
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
        public final /* synthetic */ e a;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.m == null || this.a.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = c.a.n0.a.k1.h.m();
            if (m != null) {
                m.D("exitType", String.valueOf(3));
                m.E("value", "cancel");
                m.n();
            }
            this.a.m.moveTaskToBack(true);
            y0.b().e(2);
            this.a.q();
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f6027b;

        public i(e eVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6027b = eVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    c.a.n0.a.k1.h.o().F(new UbcFlowEvent("first_anim_end"));
                    c.a.n0.a.c2.a.d().i("first_anim_end");
                    if (this.f6027b.l != null) {
                        this.f6027b.l.l(this.f6027b.m, this.a);
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
        public final /* synthetic */ e a;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue > 0.9f || floatValue - this.a.t > 0.05d) {
                    this.a.t = floatValue;
                    this.a.M();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6028b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6029c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6030d;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.n0.a.t1.b f6031e;

        /* renamed from: f  reason: collision with root package name */
        public int f6032f;

        /* renamed from: g  reason: collision with root package name */
        public int f6033g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6034h;
        public final /* synthetic */ e i;

        /* loaded from: classes.dex */
        public class a implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    if (e.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_FINISH");
                    }
                    this.a.f6033g = aVar.i("KEY_PRELOAD_STATE");
                    this.a.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && e.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_ERROR");
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && e.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PRELOAD_START");
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public d(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    if (e.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_FINISH");
                    }
                    this.a.f6034h = true;
                    this.a.e();
                }
            }
        }

        /* renamed from: c.a.n0.a.q2.e$k$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0429e implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0429e(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && e.y) {
                    Log.i("SwanAppLoadingView", "onCallback: EVENT_PKG_DOWNLOAD_START");
                }
            }
        }

        /* loaded from: classes.dex */
        public class f implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public f(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    if (e.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_FINISH");
                    }
                    this.a.f6032f = aVar.j("KEY_PKG_STATE", -1);
                    this.a.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class g implements c.a.n0.a.p2.g1.c<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public g(k kVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    if (e.y) {
                        Log.i("SwanAppLoadingView", "onCallback: EVENT_PMS_CHECK_START");
                    }
                    this.a.f6032f = aVar.j("KEY_PKG_STATE", -1);
                    this.a.e();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = eVar;
            this.f6029c = false;
            this.f6030d = false;
            this.f6032f = -1;
            this.f6028b = str;
            this.a = z;
            c.a.n0.a.t1.b bVar = new c.a.n0.a.t1.b();
            bVar.e(new g(this, eVar), "event_pms_check_start");
            bVar.e(new f(this, eVar), "event_pms_check_finish");
            bVar.e(new C0429e(this, eVar), "event_pkg_download_start");
            bVar.e(new d(this, eVar), "event_pkg_download_finish");
            bVar.e(new c(this, eVar), "event_preload_start");
            bVar.e(new b(this, eVar), "event_preload_error");
            bVar.e(new a(this, eVar), "event_preload_finish");
            this.f6031e = bVar;
            c.a.n0.a.t1.d.J().v(this.f6031e);
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j = j();
                boolean g2 = g();
                boolean i = i();
                if (e.y) {
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: runtimeLoading " + j);
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: checkingUpdate " + g2);
                    Log.i("SwanAppLoadingView", "checkAndUpdateProgress: preloadFinish " + i);
                }
                if (j || g2 || !i) {
                    this.i.M();
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
                    Log.i("SwanAppLoadingView", sb.toString());
                }
                this.f6030d = true;
                boolean z2 = this.a;
                if (z2) {
                    this.i.x(z2, this.f6029c);
                } else {
                    this.i.w(z2, this.f6029c);
                }
            }
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                boolean h2 = h();
                boolean i = i();
                boolean z = h2 && i;
                if (e.y) {
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: overMaxAge " + h2);
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: preloadFinish " + i);
                    Log.i("SwanAppLoadingView", "isCheckingUpdate: " + z);
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.f6032f;
                boolean z = true;
                if (i != 3 && i != 1) {
                    z = false;
                }
                if (e.y) {
                    Log.i("SwanAppLoadingView", "isOverMaxAge: isOverMaxAge " + z);
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                boolean m0 = c.a.n0.a.x.u.g.U().m0();
                if (e.y) {
                    Log.i("SwanAppLoadingView", "isPreloadFinish: runtimeReady " + m0);
                }
                return m0;
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                boolean z = this.f6032f == 4;
                boolean i = i();
                if (e.y) {
                    Log.i("SwanAppLoadingView", "isRuntimeLoading: isLocalPackage " + z);
                    Log.i("SwanAppLoadingView", "isRuntimeLoading: preloadFinish " + i);
                }
                return z && !i;
            }
            return invokeV.booleanValue;
        }

        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (e.y) {
                    Log.i("SwanAppLoadingView", "onDestroy: ");
                }
                c.a.n0.a.t1.d.J().p(this.f6031e);
            }
        }

        public k l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.f6029c = true;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1220405391, "Lc/a/n0/a/q2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1220405391, "Lc/a/n0/a/q2/e;");
                return;
            }
        }
        y = c.a.n0.a.a.a;
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
        this.x = new c.a.n0.a.x.i.h.a();
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
                return LayoutInflater.from(context).inflate(z2 ? R.layout.obfuscated_res_0x7f0d008f : R.layout.obfuscated_res_0x7f0d00bc, (ViewGroup) null);
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
                Log.i("SwanAppLoadingView", "obtainPreloadContainer:  App=" + z + " Game=" + A);
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
            this.f6025g.setOnClickListener(new h(this));
        }
    }

    public final void C(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.q == null || this.u > f2) {
            return;
        }
        this.u = f2;
        if (y) {
            Log.i("SwanAppLoadingView", "setProgressText: " + this.u);
        }
        int i2 = (int) (1000.0f * f2);
        String str = ((i2 / 10) + (i2 % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.w.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str);
        k kVar = this.v;
        if (kVar != null && !kVar.a) {
            if (kVar.j()) {
                if (y) {
                    Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                }
            } else if (!this.v.h() || this.u > 0.0f) {
                if (this.v.f6034h && !this.v.i()) {
                    if (y) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.q.setVisibility(4);
                } else if (this.u >= 1.0f && !this.v.i()) {
                    if (y) {
                        Log.i("SwanAppLoadingView", "setProgressText: Framework loading");
                    }
                    this.q.setVisibility(4);
                } else {
                    this.q.setText(sb);
                }
            } else {
                if (y) {
                    Log.i("SwanAppLoadingView", "setProgressText: checking update");
                }
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
        this.o.e(swanLoadingTips.b());
    }

    public void E(boolean z2, boolean z3, @Nullable i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), aVar}) == null) {
            this.x.f();
            String V = c.a.n0.a.t1.d.J().r().V().V();
            k kVar = this.v;
            boolean z4 = true;
            boolean z5 = kVar == null || (kVar.a ^ z2) || TextUtils.isEmpty(V) || !TextUtils.equals(V, this.v.f6028b);
            if (y) {
                Log.i("SwanAppLoadingView", "showSwanAppStartView: newLaunchId = " + V + " newIsGameLoading = " + z2 + " reCreateStarter = " + z5 + " mViewStarter = " + this.v);
            }
            Handler L = c.a.n0.a.t1.d.L();
            if (this.v != null) {
                if (y) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: oldLaunchId = " + this.v.f6028b + " oldIsGameLoading = " + this.v.a);
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
            if (kVar2.f6030d) {
                if (y) {
                    Log.i("SwanAppLoadingView", "showSwanAppStartView: return by executing pkgUpdating = " + z4 + " trace = " + Log.getStackTraceString(new Exception()));
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
                Log.i("SwanAppLoadingView", "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable()));
            }
            L.post(this.v);
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Handler L = c.a.n0.a.t1.d.L();
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
                Log.i("SwanAppLoadingView", "stopAnimations: " + Log.getStackTraceString(new Exception()));
            }
            Handler L = c.a.n0.a.t1.d.L();
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
                    this.o.c();
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
                Log.i("SwanAppLoadingView", "updateIcon: icon=" + str);
            }
            String appId = c.a.n0.a.t1.d.J().getAppId();
            if (!B || (swanAppRoundedImageView = this.f6021c) == null) {
                return;
            }
            swanAppRoundedImageView.setImageBitmap(q0.k(str, "SwanAppLoadingView", true, new a(this, appId)));
        }
    }

    public final void J(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) || bitmap == null || (swanAppRoundedImageView = this.f6021c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void K(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || !B || TextUtils.isEmpty(str) || (textView = this.f6020b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void L(int i2) {
        View view;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view = this.a) == null || (relativeLayout = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090cfb)) == null) {
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
        if (o <= 0.0f || c.a.n0.a.t1.d.J().l() == 1 || (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(R.id.obfuscated_res_0x7f090001)) == null) {
            return;
        }
        swanAppLaunchCircleAnimationView.j(o);
    }

    public final void N(boolean z2, boolean z3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || (textView = this.q) == null) {
            return;
        }
        if (!z2) {
            this.w = textView.getContext().getString(R.string.obfuscated_res_0x7f0f1242);
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
        c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
        fVar.f4188b = "launch";
        fVar.f4191e = "realcancel";
        fVar.q = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.G() == 1) {
            fVar.a("errorList", c.a.n0.a.s0.b.j().a());
        }
        this.m.doUBCEventStatistic(fVar);
        c.a.n0.a.d2.e.q(launchInfo);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.a.findViewById(R.id.obfuscated_res_0x7f0901ad);
            this.o = swanLoadingTipsView;
            swanLoadingTipsView.setTipsAnimationFinishCallback(new f(this));
            this.p = new SwanLoadingTips();
            this.a.addOnAttachStateChangeListener(new g(this));
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            n0.M(this.i, this.j, String.valueOf(i2));
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
                Log.i("SwanAppLoadingView", "obtainPreloadContainer:  isLegalContainer= " + z3 + " game=" + z2 + " container=" + view);
            }
            return view;
        }
        return (View) invokeLZ.objValue;
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            if (y) {
                Log.i("SwanAppLoadingView", "onDownloadProgressUpdate: " + f2 + " view: " + this.q);
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
                    this.l = new c.a.n0.a.j.a();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, c.a.n0.a.s1.b.a.f6178b ? n0.t() : 0, 0, 0);
                } else {
                    r();
                }
                Handler L = c.a.n0.a.t1.d.L();
                b.a V = c.a.n0.a.t1.d.J().r().V();
                this.m.getFloatLayer().n(this.a);
                B = true;
                this.f6024f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092072);
                this.f6025g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092071);
                this.k = this.a.findViewById(R.id.obfuscated_res_0x7f092070);
                if (z2) {
                    this.f6024f.setClickable(true);
                    this.f6024f.setImageResource(R.drawable.obfuscated_res_0x7f080124);
                    this.f6025g.setImageResource(R.drawable.obfuscated_res_0x7f08010f);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f080120);
                    View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f092073);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(R.color.obfuscated_res_0x7f060377);
                    this.k.post(new c(this));
                } else {
                    this.f6024f.setImageResource(R.drawable.obfuscated_res_0x7f080118);
                    this.f6025g.setImageResource(R.drawable.obfuscated_res_0x7f08010c);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011f);
                    L(V.p1());
                }
                this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019f);
                L.postDelayed(new d(this), 2000L);
                G(z2, z3);
                TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901a9);
                this.f6020b = textView;
                textView.getPaint().setFakeBoldText(true);
                this.f6021c = (SwanAppRoundedImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09019a);
                this.i = (BdBaseImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09019d);
                this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019e);
                this.f6026h = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09019b);
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
                    this.l = new c.a.n0.a.j.a();
                }
                View t = t(this.m, z2);
                this.a = t;
                if (!z2) {
                    t.setPadding(0, c.a.n0.a.s1.b.a.f6178b ? n0.t() : 0, 0, 0);
                } else {
                    r();
                }
                this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019f);
                b.a V = c.a.n0.a.t1.d.J().r().V();
                V.f0();
                G(z2, z3);
                this.m.getFloatLayer().n(this.a);
                B = true;
                this.f6020b = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0901a9);
                this.f6021c = (SwanAppRoundedImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09019a);
                this.i = (BdBaseImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09019d);
                this.j = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09019e);
                this.f6026h = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09019b);
                K(V.K());
                I(V.Q());
                s(V.getType());
                this.f6022d = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09124a);
                this.f6023e = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090756);
                this.f6024f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092072);
                this.f6025g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092071);
                this.k = this.a.findViewById(R.id.obfuscated_res_0x7f092070);
                if (z2) {
                    this.f6024f.setClickable(true);
                    this.f6024f.setImageResource(R.drawable.obfuscated_res_0x7f080124);
                    this.f6025g.setImageResource(R.drawable.obfuscated_res_0x7f08010f);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f080120);
                    View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f092073);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(R.color.obfuscated_res_0x7f060377);
                    this.k.post(new RunnableC0428e(this));
                } else {
                    this.f6024f.setImageResource(R.drawable.obfuscated_res_0x7f080118);
                    this.f6025g.setImageResource(R.drawable.obfuscated_res_0x7f08010c);
                    this.k.setBackgroundResource(R.drawable.obfuscated_res_0x7f08011f);
                    L(V.p1());
                }
                this.f6023e.setAlpha(0.0f);
                this.l.m(this.m);
                B();
            }
        }
    }
}
