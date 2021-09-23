package c.a.p0.a.w2;

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
import c.a.p0.a.a2.i;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.v2.f0;
import c.a.p0.a.v2.n0;
import c.a.p0.a.v2.q0;
import c.a.p0.a.v2.t;
import c.a.p0.a.v2.x0;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
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
    public static final boolean C;
    @SuppressLint({"StaticFieldLeak"})
    public static View D;
    @SuppressLint({"StaticFieldLeak"})
    public static View E;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public View f9614a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9615b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f9616c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f9617d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9618e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f9619f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f9620g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f9621h;

    /* renamed from: i  reason: collision with root package name */
    public BdBaseImageView f9622i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f9623j;
    public View k;
    public c.a.p0.a.t.a l;
    public SwanAppActivity m;
    public View n;
    public SwanLoadingTipsView o;
    public SwanLoadingTips p;
    public TextView q;
    public ValueAnimator r;
    public boolean s;
    public float t;
    public float u;
    public float v;
    public long w;
    public m x;
    public String y;
    public boolean z;

    /* loaded from: classes.dex */
    public class a implements SwanAppNetworkUtils.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
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
                }
            }
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    c.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：正常");
                    c.a.p0.a.h0.i.f.d("pms_downloadPkg", "good");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else if (i2 == 2) {
                    c.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：弱网");
                    c.a.p0.a.h0.i.f.d("pms_downloadPkg", "bad");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_get_pkg_poor_net);
                } else if (i2 != 3) {
                    c.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：未知");
                    c.a.p0.a.h0.i.f.d("pms_downloadPkg", "unknown");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else {
                    c.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：离线");
                    c.a.p0.a.h0.i.f.d("pms_downloadPkg", "offline");
                    c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_get_pkg_poor_net);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9624e;

        public b(e eVar) {
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
            this.f9624e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue > 0.9f || floatValue - this.f9624e.u > 0.05d) {
                    this.f9624e.u = floatValue;
                    this.f9624e.O();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9625a;

        public c(e eVar, String str) {
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
            this.f9625a = str;
        }

        @Override // c.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            e loadingView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || (x = c.a.p0.a.a2.d.g().x()) == null || x.isDestroyed() || (loadingView = x.getLoadingView()) == null || !TextUtils.equals(this.f9625a, c.a.p0.a.a2.d.g().getAppId())) {
                return;
            }
            loadingView.L(bitmap);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9626e;

        public d(Context context) {
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
            this.f9626e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.z(this.f9626e);
            }
        }
    }

    /* renamed from: c.a.p0.a.w2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0449e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9627e;

        public RunnableC0449e(e eVar) {
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
            this.f9627e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f9627e.m);
                if (!f0.q(this.f9627e.m, this.f9627e.k) || this.f9627e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9627e.k.getLayoutParams();
                layoutParams.topMargin = this.f9627e.k.getTop() + e2;
                this.f9627e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9628e;

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
            this.f9628e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9628e.q == null) {
                return;
            }
            this.f9628e.q.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9629e;

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
            this.f9629e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9629e.A == null) {
                return;
            }
            this.f9629e.A.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9630e;

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
            this.f9630e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f9630e.m);
                if (!f0.q(this.f9630e.m, this.f9630e.k) || this.f9630e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9630e.k.getLayoutParams();
                layoutParams.topMargin = this.f9630e.k.getTop() + e2;
                this.f9630e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9631e;

        public i(e eVar) {
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
            this.f9631e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f9631e.E();
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9632e;

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
            this.f9632e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9632e.E();
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
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9633e;

        public k(e eVar) {
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
            this.f9633e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f9633e.m == null || this.f9633e.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = c.a.p0.a.r1.h.m();
            if (m != null) {
                m.A("exitType", String.valueOf(3));
                m.B("value", QueryResponse.Options.CANCEL);
                m.l();
            }
            this.f9633e.m.moveTaskToBack(true);
            x0.b().e(2);
            this.f9633e.r();
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f9635f;

        public l(e eVar, int i2) {
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
            this.f9635f = eVar;
            this.f9634e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    c.a.p0.a.r1.h.o().C(new UbcFlowEvent("first_anim_end"));
                    c.a.p0.a.i2.a.d().i("first_anim_end");
                    if (this.f9635f.l != null) {
                        this.f9635f.l.n(this.f9635f.m, this.f9634e);
                    }
                    this.f9635f.s = false;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9636e;

        /* renamed from: f  reason: collision with root package name */
        public final String f9637f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9638g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f9639h;

        /* renamed from: i  reason: collision with root package name */
        public final c.a.p0.a.a2.b f9640i;

        /* renamed from: j  reason: collision with root package name */
        public int f9641j;
        public int k;
        public boolean l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f9642e;

            public a(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9642e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f9642e.k = aVar.i("KEY_PRELOAD_STATE");
                    this.f9642e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
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
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
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
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f9643e;

            public d(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9643e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f9643e.l = true;
                    this.f9643e.e();
                }
            }
        }

        /* renamed from: c.a.p0.a.w2.e$m$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0450e implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0450e(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
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
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class f implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f9644e;

            public f(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9644e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f9644e.f9641j = aVar.j("KEY_PKG_STATE", -1);
                    this.f9644e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class g implements c.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f9645e;

            public g(m mVar, e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9645e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f9645e.f9641j = aVar.j("KEY_PKG_STATE", -1);
                    this.f9645e.e();
                }
            }
        }

        public m(e eVar, String str, boolean z) {
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
            this.f9638g = false;
            this.f9639h = false;
            this.f9641j = -1;
            this.f9637f = str;
            this.f9636e = z;
            c.a.p0.a.a2.b bVar = new c.a.p0.a.a2.b();
            bVar.e(new g(this, eVar), "event_pms_check_start");
            bVar.e(new f(this, eVar), "event_pms_check_finish");
            bVar.e(new C0450e(this, eVar), "event_pkg_download_start");
            bVar.e(new d(this, eVar), "event_pkg_download_finish");
            bVar.e(new c(this, eVar), "event_preload_start");
            bVar.e(new b(this, eVar), "event_preload_error");
            bVar.e(new a(this, eVar), "event_preload_finish");
            this.f9640i = bVar;
            c.a.p0.a.a2.d.g().v(this.f9640i);
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j2 = j();
                boolean g2 = g();
                boolean i2 = i();
                if (e.C) {
                    String str = "checkAndUpdateProgress: runtimeLoading " + j2;
                    String str2 = "checkAndUpdateProgress: checkingUpdate " + g2;
                    String str3 = "checkAndUpdateProgress: preloadFinish " + i2;
                }
                if (j2 || g2 || !i2) {
                    this.m.O();
                }
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (e.C) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewStarter exec : post = ");
                    sb.append(z);
                    sb.append(" trace = ");
                    sb.append(z ? "post" : Log.getStackTraceString(new Exception()));
                    sb.toString();
                }
                this.f9639h = true;
                boolean z2 = this.f9636e;
                if (z2) {
                    this.m.y(z2, this.f9638g);
                    return;
                }
                int d2 = c.a.p0.a.r1.l.b.d();
                if (d2 == 0) {
                    this.m.y(this.f9636e, this.f9638g);
                } else if (d2 == 1) {
                    this.m.x(this.f9636e, this.f9638g, true);
                } else if (d2 == 2) {
                    this.m.x(this.f9636e, this.f9638g, false);
                } else if (d2 != 3) {
                    if (e.C) {
                        String str = "ViewStarter exec : invalid animationType = " + c.a.p0.a.r1.l.b.d();
                    }
                } else {
                    this.m.x(this.f9636e, this.f9638g, true);
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
                if (e.C) {
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
                int i2 = this.f9641j;
                boolean z = true;
                if (i2 != 3 && i2 != 1) {
                    z = false;
                }
                if (e.C) {
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
                boolean c0 = c.a.p0.a.h0.u.g.N().c0();
                if (e.C) {
                    String str = "isPreloadFinish: runtimeReady " + c0;
                }
                return c0;
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                boolean z = this.f9641j == 4;
                boolean i2 = i();
                if (e.C) {
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
                boolean unused = e.C;
                c.a.p0.a.a2.d.g().p(this.f9640i);
            }
        }

        public m l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.f9638g = true;
                return this;
            }
            return (m) invokeV.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832919507, "Lc/a/p0/a/w2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832919507, "Lc/a/p0/a/w2/e;");
                return;
            }
        }
        C = c.a.p0.a.k.f7085a;
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
        this.s = false;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.x = null;
        this.y = "";
        this.m = swanAppActivity;
    }

    public static void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            q0.c0(new d(context), 5000L);
        }
    }

    public static void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            D = null;
            E = null;
        }
    }

    public static View q(Context context, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65555, null, context, z)) != null) {
            return (View) invokeLZ.objValue;
        }
        int i3 = z ? c.a.p0.a.g.ai_games_loading_fragment : c.a.p0.a.g.aiapps_loading_fragment;
        try {
            if (c.a.p0.a.r1.l.b.d() != 1 && c.a.p0.a.r1.l.b.d() != 3) {
                if (c.a.p0.a.r1.l.b.d() == 2) {
                    i2 = z ? c.a.p0.a.g.ai_games_loading_fragment : c.a.p0.a.g.aiapps_loading_fragment_shimmer;
                }
                return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
            }
            i2 = z ? c.a.p0.a.g.ai_games_loading_fragment : c.a.p0.a.g.aiapps_loading_fragment_circle;
            return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
        } catch (Exception e2) {
            if (C) {
                e2.printStackTrace();
            }
            return null;
        }
        i3 = i2;
    }

    public static void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, context) == null) {
            if (D == null) {
                D = q(context, false);
            }
            if (E == null) {
                E = q(context, true);
            }
            if (C) {
                String str = "obtainPreloadContainer:  App=" + D + " Game=" + E;
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f9620g.setOnClickListener(new k(this));
        }
    }

    public final void D(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) || this.q == null || this.v > f2) {
            return;
        }
        this.v = f2;
        if (C) {
            String str = "setProgressText: " + this.v;
        }
        int i2 = (int) (1000.0f * f2);
        String str2 = ((i2 / 10) + (i2 % 10 >= 5 ? 1 : 0)) + "%";
        String trim = this.y.trim();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(trim)) {
            sb.append(trim);
            sb.append(" ");
        }
        sb.append(str2);
        m mVar = this.x;
        if (mVar != null && !mVar.f9636e) {
            if (mVar.j()) {
                boolean z = C;
                if (this.B == 0) {
                    TextView textView = this.q;
                    textView.setText(textView.getContext().getString(c.a.p0.a.h.swanapp_swan_loading_runtime_loading));
                    this.q.setVisibility(0);
                }
            } else if (!this.x.h() || this.v > 0.0f) {
                if (this.x.l && !this.x.i()) {
                    boolean z2 = C;
                    if (this.B == 0) {
                        this.q.setVisibility(0);
                        TextView textView2 = this.q;
                        textView2.setText(textView2.getContext().getString(c.a.p0.a.h.swanapp_swan_loading_runtime_loading));
                    }
                    int i3 = this.B;
                    if (i3 == 1 || i3 == 3) {
                        this.q.setVisibility(4);
                    }
                } else if (this.v >= 1.0f && !this.x.i()) {
                    boolean z3 = C;
                    if (this.B == 0) {
                        this.q.setVisibility(0);
                        TextView textView3 = this.q;
                        textView3.setText(textView3.getContext().getString(c.a.p0.a.h.swanapp_swan_loading_runtime_loading));
                    }
                    int i4 = this.B;
                    if (i4 == 1 || i4 == 3) {
                        this.q.setVisibility(4);
                    }
                } else {
                    this.q.setText(sb);
                }
            } else {
                boolean z4 = C;
                if (this.B == 0) {
                    this.q.setVisibility(0);
                    TextView textView4 = this.q;
                    textView4.setText(textView4.getContext().getString(c.a.p0.a.h.swanapp_swan_check_update_text));
                }
                int i5 = this.B;
                if (i5 == 1 || i5 == 3) {
                    this.q.setVisibility(4);
                }
            }
        } else {
            this.q.setText(sb);
        }
        if (f2 > 0.0f && this.B == 0) {
            this.q.setVisibility(0);
        }
        if (f2 == 1.0f) {
            int i6 = this.B;
            if (i6 == 1 || i6 == 3) {
                this.q.setVisibility(4);
            }
        }
    }

    public final void E() {
        SwanLoadingTips swanLoadingTips;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.o == null || (swanLoadingTips = this.p) == null) {
            return;
        }
        this.o.startTipsAppearAnimation(swanLoadingTips.b());
    }

    public void F(boolean z, boolean z2, @Nullable i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), aVar}) == null) {
            boolean z3 = true;
            this.z = c.a.p0.a.a2.d.g().l() != 1;
            this.w = 0L;
            String V = c.a.p0.a.a2.d.g().r().L().V();
            this.B = c.a.p0.a.r1.l.b.d();
            m mVar = this.x;
            boolean z4 = mVar == null || (mVar.f9636e ^ z) || TextUtils.isEmpty(V) || !TextUtils.equals(V, this.x.f9637f);
            if (C) {
                String str = "showSwanAppStartView: newLaunchId = " + V + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.x;
            }
            Handler i2 = c.a.p0.a.a2.d.i();
            if (this.x != null) {
                if (C) {
                    String str2 = "showSwanAppStartView: oldLaunchId = " + this.x.f9637f + " oldIsGameLoading = " + this.x.f9636e;
                }
                i2.removeCallbacks(this.x);
            }
            if (z4) {
                this.x = new m(this, V, z);
            }
            if (this.x == null) {
                return;
            }
            z3 = (aVar == null || !aVar.e(" event_params_pkg_update", false)) ? false : false;
            m mVar2 = this.x;
            if (mVar2.f9639h) {
                if (C) {
                    String str3 = "showSwanAppStartView: return by executing pkgUpdating = " + z3 + " trace = " + Log.getStackTraceString(new Exception());
                }
                if (z3) {
                    P(z, z3);
                    return;
                }
                return;
            }
            if (z3) {
                mVar2.l();
            }
            if (z2) {
                this.x.f(false);
                return;
            }
            if (C) {
                String str4 = "showSwanAppStartView: post starter trace = " + Log.getStackTraceString(new Throwable());
            }
            i2.post(this.x);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SwanAppNetworkUtils.b(new a(this));
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            Handler i3 = c.a.p0.a.a2.d.i();
            m mVar = this.x;
            if (mVar != null) {
                i3.removeCallbacks(mVar);
                this.x.k();
                this.x = null;
            }
            i3.post(new l(this, i2));
        }
    }

    public void I(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.r.removeAllUpdateListeners();
        }
        P(z, z2);
        this.u = 0.0f;
        this.t = 0.0f;
        this.v = 0.0f;
        if (z) {
            O();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.r = ofFloat;
            ofFloat.addUpdateListener(new b(this));
            this.r.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.r.start();
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (C) {
                String str = "stopAnimations: " + Log.getStackTraceString(new Exception());
            }
            Handler i2 = c.a.p0.a.a2.d.i();
            m mVar = this.x;
            if (mVar != null) {
                i2.removeCallbacks(mVar);
                this.x.k();
                this.x = null;
            }
            synchronized (e.class) {
                if (this.l != null) {
                    this.l.q();
                }
                if (this.o != null) {
                    this.o.doDestroy();
                    this.o = null;
                }
                if (this.q != null) {
                    this.q.setVisibility(8);
                    this.q = null;
                    this.y = "";
                    this.u = 0.0f;
                    this.t = 0.0f;
                    this.v = 0.0f;
                }
                if (this.r != null) {
                    this.r.removeAllUpdateListeners();
                    this.r.cancel();
                    this.r = null;
                }
                this.s = false;
                if (this.x != null) {
                    this.x.k();
                    this.x = null;
                }
            }
        }
    }

    public void K(String str) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (C) {
                String str2 = "updateIcon: icon=" + str;
            }
            String appId = c.a.p0.a.a2.d.g().getAppId();
            if (!this.s || (swanAppRoundedImageView = this.f9616c) == null) {
                return;
            }
            swanAppRoundedImageView.setImageBitmap(q0.k(str, "SwanAppLoadingView", true, new c(this, appId)));
        }
    }

    public final void L(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) || bitmap == null || (swanAppRoundedImageView = this.f9616c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void M(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || !this.s || TextUtils.isEmpty(str) || (textView = this.f9615b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void N(int i2) {
        View view;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view = this.f9614a) == null || (relativeLayout = (RelativeLayout) view.findViewById(c.a.p0.a.f.guarantee_plan_rl)) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    public final void O() {
        SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.q == null) {
            return;
        }
        float p = p(this.u, this.t);
        if (p > 1.0f) {
            p = 1.0f;
        }
        D(p);
        int i2 = this.B;
        if ((i2 == 1 || i2 == 3) && p > 0.0f && c.a.p0.a.a2.d.g().l() != 1 && (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(c.a.p0.a.f.App_Launch_Circle_Animation_View)) != null) {
            swanAppLaunchCircleAnimationView.updateDownloadingAnimation(p);
        }
    }

    public final void P(boolean z, boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (textView = this.q) == null) {
            return;
        }
        if (!z) {
            this.y = textView.getContext().getString(z2 ? c.a.p0.a.h.swan_loading_view_tag_updating : c.a.p0.a.h.swanapp_swan_loading_runtime_loading);
            int i2 = this.B;
            if (i2 == 1 || i2 == 3) {
                this.y = this.q.getContext().getString(c.a.p0.a.h.swan_loading_view_tag_downloading);
                return;
            }
            return;
        }
        this.y = "";
    }

    public final float p(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? ((1.0f - f2) * f3) + f2 : invokeCommon.floatValue;
    }

    public final void r() {
        b.a launchInfo;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (launchInfo = this.m.getLaunchInfo()) == null || (P = launchInfo.P()) == null) {
            return;
        }
        long j2 = P.getLong("page_display_flag_for_statistic");
        P.remove("page_display_flag_for_statistic");
        if (j2 <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - launchInfo.l("launch_time", 0L));
        c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
        fVar.f7072b = "launch";
        fVar.f7075e = "realcancel";
        fVar.q = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.G() == 1) {
            fVar.a("errorList", c.a.p0.a.c1.b.j().a());
        }
        this.m.doUBCEventStatistic(fVar);
        c.a.p0.a.j2.e.q(launchInfo);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.f9614a.findViewById(c.a.p0.a.f.aigames_loading_game_tips);
            this.o = swanLoadingTipsView;
            swanLoadingTipsView.setTipsAnimationFinishCallback(new i(this));
            this.p = new SwanLoadingTips();
            this.f9614a.addOnAttachStateChangeListener(new j(this));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            n0.J(this.f9622i, this.f9623j, String.valueOf(i2));
        }
    }

    public final View u(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, context, z)) == null) {
            View view = z ? E : D;
            if (z) {
                E = null;
            } else {
                D = null;
            }
            boolean z2 = (view == null || view.isAttachedToWindow()) ? false : true;
            if (!z2) {
                view = q(context, z);
            }
            if (C) {
                String str = "obtainPreloadContainer:  isLegalContainer= " + z2 + " game=" + z + " container=" + view;
            }
            return view;
        }
        return (View) invokeLZ.objValue;
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            if (C) {
                String str = "onDownloadProgressUpdate: " + f2 + " view: " + this.q;
            }
            if (this.q == null) {
                return;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.t = f2;
            O();
            if (this.z) {
                if (this.w == 0) {
                    this.w = System.currentTimeMillis();
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.w > 2000) {
                    G();
                    this.z = false;
                }
                this.w = currentTimeMillis;
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.q == null) {
            return;
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.r.cancel();
            this.r = null;
        }
        D(1.0f);
    }

    public final void x(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            synchronized (e.class) {
                if (this.l == null) {
                    this.l = new c.a.p0.a.t.a();
                }
                View u = u(this.m, z);
                this.f9614a = u;
                if (!z) {
                    u.setPadding(0, c.a.p0.a.z1.b.a.f9998b ? n0.u() : 0, 0, 0);
                } else {
                    s();
                }
                Handler i2 = c.a.p0.a.a2.d.i();
                b.a L = c.a.p0.a.a2.d.g().r().L();
                this.m.getFloatLayer().k(this.f9614a);
                this.s = true;
                this.f9619f = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_img);
                this.f9620g = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_exit);
                this.k = this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu);
                if (z) {
                    this.f9619f.setClickable(true);
                    this.f9619f.setImageResource(c.a.p0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f9620g.setImageResource(c.a.p0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(c.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(c.a.p0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new RunnableC0449e(this));
                } else {
                    this.f9619f.setImageResource(c.a.p0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f9620g.setImageResource(c.a.p0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(c.a.p0.a.e.aiapps_action_bar_right_menu_bg);
                    N(L.n1());
                }
                if (z3) {
                    this.q = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_loading_progress);
                    i2.postDelayed(new f(this), 2000L);
                    I(z, z2);
                    TextView textView = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_title);
                    this.f9615b = textView;
                    textView.getPaint().setFakeBoldText(true);
                    this.f9616c = (SwanAppRoundedImageView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_icon);
                    this.f9622i = (BdBaseImageView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_label_bg);
                    this.f9623j = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_label_tv);
                    this.f9621h = (RelativeLayout) this.f9614a.findViewById(c.a.p0.a.f.aiapps_icon_rl);
                    M(L.K());
                    K(L.Q());
                    t(L.t1());
                    this.l.l(this.m);
                } else {
                    this.A = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_loading_shimmer_poor_network_notice);
                    i2.postDelayed(new g(this), c.a.p0.a.r1.l.b.c());
                    this.l.p(this.m);
                }
                C();
            }
        }
    }

    public final void y(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (e.class) {
                if (this.l == null) {
                    this.l = new c.a.p0.a.t.a();
                }
                View u = u(this.m, z);
                this.f9614a = u;
                if (!z) {
                    u.setPadding(0, c.a.p0.a.z1.b.a.f9998b ? n0.u() : 0, 0, 0);
                } else {
                    s();
                }
                this.q = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_loading_progress);
                b.a L = c.a.p0.a.a2.d.g().r().L();
                L.f0();
                I(z, z2);
                this.m.getFloatLayer().k(this.f9614a);
                this.s = true;
                this.f9615b = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_title);
                this.f9616c = (SwanAppRoundedImageView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_icon);
                this.f9622i = (BdBaseImageView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_label_bg);
                this.f9623j = (TextView) this.f9614a.findViewById(c.a.p0.a.f.aiapps_label_tv);
                this.f9621h = (RelativeLayout) this.f9614a.findViewById(c.a.p0.a.f.aiapps_icon_rl);
                M(L.K());
                K(L.Q());
                t(L.t1());
                this.f9617d = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.light_print);
                this.f9618e = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.dark_print);
                this.f9619f = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_img);
                this.f9620g = (ImageView) this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_exit);
                this.k = this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu);
                if (z) {
                    this.f9619f.setClickable(true);
                    this.f9619f.setImageResource(c.a.p0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f9620g.setImageResource(c.a.p0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(c.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.f9614a.findViewById(c.a.p0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(c.a.p0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new h(this));
                } else {
                    this.f9619f.setImageResource(c.a.p0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f9620g.setImageResource(c.a.p0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(c.a.p0.a.e.aiapps_action_bar_right_menu_bg);
                    N(L.n1());
                }
                this.f9618e.setAlpha(0.0f);
                this.l.o(this.m);
                C();
            }
        }
    }
}
