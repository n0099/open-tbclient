package b.a.p0.a.w2;

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
import b.a.p0.a.a2.i;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.v2.f0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.t;
import b.a.p0.a.v2.x0;
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
    public View f8854a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f8855b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppRoundedImageView f8856c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f8857d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f8858e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f8859f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f8860g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f8861h;

    /* renamed from: i  reason: collision with root package name */
    public BdBaseImageView f8862i;
    public TextView j;
    public View k;
    public b.a.p0.a.t.a l;
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
                    b.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：正常");
                    b.a.p0.a.h0.i.f.d("pms_downloadPkg", "good");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else if (i2 == 2) {
                    b.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：弱网");
                    b.a.p0.a.h0.i.f.d("pms_downloadPkg", "bad");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_get_pkg_poor_net);
                } else if (i2 != 3) {
                    b.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：未知");
                    b.a.p0.a.h0.i.f.d("pms_downloadPkg", "unknown");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_waiting_and_retry);
                } else {
                    b.a.p0.a.h0.i.i.i("包下载进度更新间隔超2秒; 网络：离线");
                    b.a.p0.a.h0.i.f.d("pms_downloadPkg", "offline");
                    b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_get_pkg_poor_net);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8863e;

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
            this.f8863e = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue > 0.9f || floatValue - this.f8863e.u > 0.05d) {
                    this.f8863e.u = floatValue;
                    this.f8863e.O();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8864a;

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
            this.f8864a = str;
        }

        @Override // b.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            SwanAppActivity x;
            e loadingView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || bitmap == null || (x = b.a.p0.a.a2.d.g().x()) == null || x.isDestroyed() || (loadingView = x.getLoadingView()) == null || !TextUtils.equals(this.f8864a, b.a.p0.a.a2.d.g().getAppId())) {
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
        public final /* synthetic */ Context f8865e;

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
            this.f8865e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.z(this.f8865e);
            }
        }
    }

    /* renamed from: b.a.p0.a.w2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0444e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8866e;

        public RunnableC0444e(e eVar) {
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
            this.f8866e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f8866e.m);
                if (!f0.q(this.f8866e.m, this.f8866e.k) || this.f8866e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8866e.k.getLayoutParams();
                layoutParams.topMargin = this.f8866e.k.getTop() + e2;
                this.f8866e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8867e;

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
            this.f8867e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8867e.q == null) {
                return;
            }
            this.f8867e.q.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8868e;

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
            this.f8868e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8868e.A == null) {
                return;
            }
            this.f8868e.A.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8869e;

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
            this.f8869e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = f0.e(this.f8869e.m);
                if (!f0.q(this.f8869e.m, this.f8869e.k) || this.f8869e.m.isLandScape()) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f8869e.k.getLayoutParams();
                layoutParams.topMargin = this.f8869e.k.getTop() + e2;
                this.f8869e.k.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f8870e;

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
            this.f8870e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f8870e.E();
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
        public final /* synthetic */ e f8871e;

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
            this.f8871e = eVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f8871e.E();
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
        public final /* synthetic */ e f8872e;

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
            this.f8872e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f8872e.m == null || this.f8872e.m.isFinishing()) {
                return;
            }
            HybridUbcFlow m = b.a.p0.a.r1.h.m();
            if (m != null) {
                m.A("exitType", String.valueOf(3));
                m.B("value", QueryResponse.Options.CANCEL);
                m.l();
            }
            this.f8872e.m.moveTaskToBack(true);
            x0.b().e(2);
            this.f8872e.r();
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f8874f;

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
            this.f8874f = eVar;
            this.f8873e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    b.a.p0.a.r1.h.o().C(new UbcFlowEvent("first_anim_end"));
                    b.a.p0.a.i2.a.d().i("first_anim_end");
                    if (this.f8874f.l != null) {
                        this.f8874f.l.n(this.f8874f.m, this.f8873e);
                    }
                    this.f8874f.s = false;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f8875e;

        /* renamed from: f  reason: collision with root package name */
        public final String f8876f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8877g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8878h;

        /* renamed from: i  reason: collision with root package name */
        public final b.a.p0.a.a2.b f8879i;
        public int j;
        public int k;
        public boolean l;
        public final /* synthetic */ e m;

        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f8880e;

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
                this.f8880e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f8880e.k = aVar.i("KEY_PRELOAD_STATE");
                    this.f8880e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements b.a.p0.a.v2.e1.b<i.a> {
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
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements b.a.p0.a.v2.e1.b<i.a> {
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
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f8881e;

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
                this.f8881e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f8881e.l = true;
                    this.f8881e.e();
                }
            }
        }

        /* renamed from: b.a.p0.a.w2.e$m$e  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0445e implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0445e(m mVar, e eVar) {
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
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                }
            }
        }

        /* loaded from: classes.dex */
        public class f implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f8882e;

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
                this.f8882e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f8882e.j = aVar.j("KEY_PKG_STATE", -1);
                    this.f8882e.e();
                }
            }
        }

        /* loaded from: classes.dex */
        public class g implements b.a.p0.a.v2.e1.b<i.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m f8883e;

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
                this.f8883e = mVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    boolean unused = e.C;
                    this.f8883e.j = aVar.j("KEY_PKG_STATE", -1);
                    this.f8883e.e();
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
            this.f8877g = false;
            this.f8878h = false;
            this.j = -1;
            this.f8876f = str;
            this.f8875e = z;
            b.a.p0.a.a2.b bVar = new b.a.p0.a.a2.b();
            bVar.e(new g(this, eVar), "event_pms_check_start");
            bVar.e(new f(this, eVar), "event_pms_check_finish");
            bVar.e(new C0445e(this, eVar), "event_pkg_download_start");
            bVar.e(new d(this, eVar), "event_pkg_download_finish");
            bVar.e(new c(this, eVar), "event_preload_start");
            bVar.e(new b(this, eVar), "event_preload_error");
            bVar.e(new a(this, eVar), "event_preload_finish");
            this.f8879i = bVar;
            b.a.p0.a.a2.d.g().v(this.f8879i);
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean j = j();
                boolean g2 = g();
                boolean i2 = i();
                if (e.C) {
                    String str = "checkAndUpdateProgress: runtimeLoading " + j;
                    String str2 = "checkAndUpdateProgress: checkingUpdate " + g2;
                    String str3 = "checkAndUpdateProgress: preloadFinish " + i2;
                }
                if (j || g2 || !i2) {
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
                this.f8878h = true;
                boolean z2 = this.f8875e;
                if (z2) {
                    this.m.y(z2, this.f8877g);
                    return;
                }
                int d2 = b.a.p0.a.r1.l.b.d();
                if (d2 == 0) {
                    this.m.y(this.f8875e, this.f8877g);
                } else if (d2 == 1) {
                    this.m.x(this.f8875e, this.f8877g, true);
                } else if (d2 == 2) {
                    this.m.x(this.f8875e, this.f8877g, false);
                } else if (d2 != 3) {
                    if (e.C) {
                        String str = "ViewStarter exec : invalid animationType = " + b.a.p0.a.r1.l.b.d();
                    }
                } else {
                    this.m.x(this.f8875e, this.f8877g, true);
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
                int i2 = this.j;
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
                boolean b0 = b.a.p0.a.h0.u.g.M().b0();
                if (e.C) {
                    String str = "isPreloadFinish: runtimeReady " + b0;
                }
                return b0;
            }
            return invokeV.booleanValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                boolean z = this.j == 4;
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
                b.a.p0.a.a2.d.g().p(this.f8879i);
            }
        }

        public m l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.f8877g = true;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1338478132, "Lb/a/p0/a/w2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1338478132, "Lb/a/p0/a/w2/e;");
                return;
            }
        }
        C = b.a.p0.a.k.f6397a;
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
        int i3 = z ? b.a.p0.a.g.ai_games_loading_fragment : b.a.p0.a.g.aiapps_loading_fragment;
        try {
            if (b.a.p0.a.r1.l.b.d() != 1 && b.a.p0.a.r1.l.b.d() != 3) {
                if (b.a.p0.a.r1.l.b.d() == 2) {
                    i2 = z ? b.a.p0.a.g.ai_games_loading_fragment : b.a.p0.a.g.aiapps_loading_fragment_shimmer;
                }
                return LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
            }
            i2 = z ? b.a.p0.a.g.ai_games_loading_fragment : b.a.p0.a.g.aiapps_loading_fragment_circle;
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
            this.f8860g.setOnClickListener(new k(this));
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
        if (mVar != null && !mVar.f8875e) {
            if (mVar.j()) {
                boolean z = C;
                if (this.B == 0) {
                    TextView textView = this.q;
                    textView.setText(textView.getContext().getString(b.a.p0.a.h.swanapp_swan_loading_runtime_loading));
                    this.q.setVisibility(0);
                }
            } else if (!this.x.h() || this.v > 0.0f) {
                if (this.x.l && !this.x.i()) {
                    boolean z2 = C;
                    if (this.B == 0) {
                        this.q.setVisibility(0);
                        TextView textView2 = this.q;
                        textView2.setText(textView2.getContext().getString(b.a.p0.a.h.swanapp_swan_loading_runtime_loading));
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
                        textView3.setText(textView3.getContext().getString(b.a.p0.a.h.swanapp_swan_loading_runtime_loading));
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
                    textView4.setText(textView4.getContext().getString(b.a.p0.a.h.swanapp_swan_check_update_text));
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
            this.z = b.a.p0.a.a2.d.g().l() != 1;
            this.w = 0L;
            String U = b.a.p0.a.a2.d.g().r().K().U();
            this.B = b.a.p0.a.r1.l.b.d();
            m mVar = this.x;
            boolean z4 = mVar == null || (mVar.f8875e ^ z) || TextUtils.isEmpty(U) || !TextUtils.equals(U, this.x.f8876f);
            if (C) {
                String str = "showSwanAppStartView: newLaunchId = " + U + " newIsGameLoading = " + z + " reCreateStarter = " + z4 + " mViewStarter = " + this.x;
            }
            Handler i2 = b.a.p0.a.a2.d.i();
            if (this.x != null) {
                if (C) {
                    String str2 = "showSwanAppStartView: oldLaunchId = " + this.x.f8876f + " oldIsGameLoading = " + this.x.f8875e;
                }
                i2.removeCallbacks(this.x);
            }
            if (z4) {
                this.x = new m(this, U, z);
            }
            if (this.x == null) {
                return;
            }
            z3 = (aVar == null || !aVar.e(" event_params_pkg_update", false)) ? false : false;
            m mVar2 = this.x;
            if (mVar2.f8878h) {
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
            Handler i3 = b.a.p0.a.a2.d.i();
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
            Handler i2 = b.a.p0.a.a2.d.i();
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
            String appId = b.a.p0.a.a2.d.g().getAppId();
            if (!this.s || (swanAppRoundedImageView = this.f8856c) == null) {
                return;
            }
            swanAppRoundedImageView.setImageBitmap(q0.k(str, "SwanAppLoadingView", true, new c(this, appId)));
        }
    }

    public final void L(Bitmap bitmap) {
        SwanAppRoundedImageView swanAppRoundedImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) || bitmap == null || (swanAppRoundedImageView = this.f8856c) == null || swanAppRoundedImageView == null) {
            return;
        }
        swanAppRoundedImageView.setImageBitmap(bitmap);
    }

    public void M(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || !this.s || TextUtils.isEmpty(str) || (textView = this.f8855b) == null) {
            return;
        }
        textView.setText(str);
    }

    public void N(int i2) {
        View view;
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 != PMSConstants.PayProtected.PAY_PROTECTED.type || (view = this.f8854a) == null || (relativeLayout = (RelativeLayout) view.findViewById(b.a.p0.a.f.guarantee_plan_rl)) == null) {
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
        if ((i2 == 1 || i2 == 3) && p > 0.0f && b.a.p0.a.a2.d.g().l() != 1 && (swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) this.m.findViewById(b.a.p0.a.f.App_Launch_Circle_Animation_View)) != null) {
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
            this.y = textView.getContext().getString(z2 ? b.a.p0.a.h.swan_loading_view_tag_updating : b.a.p0.a.h.swanapp_swan_loading_runtime_loading);
            int i2 = this.B;
            if (i2 == 1 || i2 == 3) {
                this.y = this.q.getContext().getString(b.a.p0.a.h.swan_loading_view_tag_downloading);
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
        Bundle O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (launchInfo = this.m.getLaunchInfo()) == null || (O = launchInfo.O()) == null) {
            return;
        }
        long j2 = O.getLong("page_display_flag_for_statistic");
        O.remove("page_display_flag_for_statistic");
        if (j2 <= 0) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() - launchInfo.l("launch_time", 0L));
        b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
        fVar.f6384b = "launch";
        fVar.f6387e = "realcancel";
        fVar.q = valueOf;
        fVar.a("reason", IntentConfig.CLOSE);
        if (launchInfo.F() == 1) {
            fVar.a("errorList", b.a.p0.a.c1.b.j().a());
        }
        this.m.doUBCEventStatistic(fVar);
        b.a.p0.a.j2.e.q(launchInfo);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            SwanLoadingTipsView swanLoadingTipsView = (SwanLoadingTipsView) this.f8854a.findViewById(b.a.p0.a.f.aigames_loading_game_tips);
            this.o = swanLoadingTipsView;
            swanLoadingTipsView.setTipsAnimationFinishCallback(new i(this));
            this.p = new SwanLoadingTips();
            this.f8854a.addOnAttachStateChangeListener(new j(this));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            n0.J(this.f8862i, this.j, String.valueOf(i2));
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
                    this.l = new b.a.p0.a.t.a();
                }
                View u = u(this.m, z);
                this.f8854a = u;
                if (!z) {
                    u.setPadding(0, b.a.p0.a.z1.b.a.f9227b ? n0.u() : 0, 0, 0);
                } else {
                    s();
                }
                Handler i2 = b.a.p0.a.a2.d.i();
                b.a K = b.a.p0.a.a2.d.g().r().K();
                this.m.getFloatLayer().j(this.f8854a);
                this.s = true;
                this.f8859f = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_img);
                this.f8860g = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_exit);
                this.k = this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu);
                if (z) {
                    this.f8859f.setClickable(true);
                    this.f8859f.setImageResource(b.a.p0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f8860g.setImageResource(b.a.p0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(b.a.p0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new RunnableC0444e(this));
                } else {
                    this.f8859f.setImageResource(b.a.p0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f8860g.setImageResource(b.a.p0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg);
                    N(K.m1());
                }
                if (z3) {
                    this.q = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_loading_progress);
                    i2.postDelayed(new f(this), 2000L);
                    I(z, z2);
                    TextView textView = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_title);
                    this.f8855b = textView;
                    textView.getPaint().setFakeBoldText(true);
                    this.f8856c = (SwanAppRoundedImageView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_icon);
                    this.f8862i = (BdBaseImageView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_label_bg);
                    this.j = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_label_tv);
                    this.f8861h = (RelativeLayout) this.f8854a.findViewById(b.a.p0.a.f.aiapps_icon_rl);
                    M(K.J());
                    K(K.P());
                    t(K.getType());
                    this.l.l(this.m);
                } else {
                    this.A = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_loading_shimmer_poor_network_notice);
                    i2.postDelayed(new g(this), b.a.p0.a.r1.l.b.c());
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
                    this.l = new b.a.p0.a.t.a();
                }
                View u = u(this.m, z);
                this.f8854a = u;
                if (!z) {
                    u.setPadding(0, b.a.p0.a.z1.b.a.f9227b ? n0.u() : 0, 0, 0);
                } else {
                    s();
                }
                this.q = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_loading_progress);
                b.a K = b.a.p0.a.a2.d.g().r().K();
                K.e0();
                I(z, z2);
                this.m.getFloatLayer().j(this.f8854a);
                this.s = true;
                this.f8855b = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_title);
                this.f8856c = (SwanAppRoundedImageView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_icon);
                this.f8862i = (BdBaseImageView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_label_bg);
                this.j = (TextView) this.f8854a.findViewById(b.a.p0.a.f.aiapps_label_tv);
                this.f8861h = (RelativeLayout) this.f8854a.findViewById(b.a.p0.a.f.aiapps_icon_rl);
                M(K.J());
                K(K.P());
                t(K.getType());
                this.f8857d = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.light_print);
                this.f8858e = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.dark_print);
                this.f8859f = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_img);
                this.f8860g = (ImageView) this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_exit);
                this.k = this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu);
                if (z) {
                    this.f8859f.setClickable(true);
                    this.f8859f.setImageResource(b.a.p0.a.e.aiapps_action_bar_single_menu_white_selector);
                    this.f8860g.setImageResource(b.a.p0.a.e.aiapps_action_bar_exit_white_selector);
                    this.k.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg_solid);
                    View findViewById = this.f8854a.findViewById(b.a.p0.a.f.titlebar_right_menu_line);
                    this.n = findViewById;
                    findViewById.setBackgroundResource(b.a.p0.a.c.aiapps_action_bar_menu_line_white);
                    this.k.post(new h(this));
                } else {
                    this.f8859f.setImageResource(b.a.p0.a.e.aiapps_action_bar_menu_black_selector);
                    this.f8860g.setImageResource(b.a.p0.a.e.aiapps_action_bar_exit_black_selector);
                    this.k.setBackgroundResource(b.a.p0.a.e.aiapps_action_bar_right_menu_bg);
                    N(K.m1());
                }
                this.f8858e.setAlpha(0.0f);
                this.l.o(this.m);
                C();
            }
        }
    }
}
