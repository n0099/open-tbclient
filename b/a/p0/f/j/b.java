package b.a.p0.f.j;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.v2.f0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.t;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.game.guide.dialog.CoinClickDialog;
import com.baidu.swan.game.guide.view.GameGuideView;
import com.baidu.swan.game.guide.view.GameGuideViewContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f9924a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f9925b = false;

    /* renamed from: c  reason: collision with root package name */
    public static long f9926c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static GameGuideConfigInfo f9927d = null;

    /* renamed from: e  reason: collision with root package name */
    public static GameGuideView f9928e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f9929f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f9930g = "";

    /* renamed from: h  reason: collision with root package name */
    public static int f9931h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static GameGuideViewContainer f9932i = null;
    public static String j = null;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = true;
    public static b.a.p0.a.w2.c n;
    public static final b o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            String string;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                if (bundle != null && (string = bundle.getString("type", "")) != null) {
                    switch (string.hashCode()) {
                        case -1261832223:
                            if (string.equals("addCoins")) {
                                int i3 = bundle.getInt("coinsNum", 0);
                                b bVar = b.o;
                                b.f9931h += i3;
                                GameGuideConfigInfo z = b.o.z();
                                if (z != null) {
                                    b bVar2 = b.o;
                                    int i4 = b.f9931h;
                                    int i5 = z.maxNums;
                                    if (i4 > i5) {
                                        b bVar3 = b.o;
                                        b.f9931h = i5;
                                    }
                                }
                                b.o.S(b.f9931h);
                                break;
                            }
                            break;
                        case -977015124:
                            if (string.equals("setHasShowedTips")) {
                                b.o.X(true);
                                break;
                            }
                            break;
                        case -426887517:
                            if (string.equals("setPlayTime")) {
                                b.o.Z(bundle.getLong("playTime", 0L));
                                break;
                            }
                            break;
                        case -338307689:
                            if (string.equals("getPlayTime")) {
                                b bVar4 = b.o;
                                bundle2.putLong("playTime", b.f9924a);
                                break;
                            }
                            break;
                        case 45198779:
                            if (string.equals("onGameTimeUsed")) {
                                b.o.d0();
                                break;
                            }
                            break;
                        case 142663368:
                            if (string.equals("initGameGuideInfo")) {
                                long F = b.o.F();
                                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                                    b bVar5 = b.o;
                                    b.f9924a = F;
                                }
                                int J = b.o.J();
                                GameGuideConfigInfo z2 = b.o.z();
                                if (z2 != null && J > (i2 = z2.maxNums)) {
                                    b.o.S(i2);
                                    J = i2;
                                }
                                b bVar6 = b.o;
                                b.f9931h = J;
                                break;
                            }
                            break;
                        case 854427704:
                            if (string.equals("getHasShowedTips")) {
                                bundle2.putBoolean("hasShowedTips", b.o.E());
                                break;
                            }
                            break;
                        case 1950665292:
                            if (string.equals("getCoins")) {
                                b bVar7 = b.o;
                                bundle2.putInt("coinsNum", b.f9931h);
                                break;
                            }
                            break;
                    }
                }
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* renamed from: b.a.p0.f.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class RunnableC0530b implements Runnable {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final RunnableC0530b f9933e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706225167, "Lb/a/p0/f/j/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1706225167, "Lb/a/p0/f/j/b$b;");
                    return;
                }
            }
            f9933e = new RunnableC0530b();
        }

        public RunnableC0530b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    boolean z = b.a.p0.a.k.f6397a;
                    b.a.p0.f.j.r.b.n().a("小游戏非法");
                    b.o.a0(false);
                    return;
                }
                String cacheConfig = b.a.p0.f.j.a.c().e(P.k());
                if (TextUtils.isEmpty(cacheConfig)) {
                    b.a.p0.f.j.r.b n = b.a.p0.f.j.r.b.n();
                    b bVar = b.o;
                    n.d("start", b.k, "");
                    b.o.R();
                    return;
                }
                if (b.a.p0.a.k.f6397a) {
                    String str = "展示缓存数据， 小游戏为  " + P.N();
                }
                b bVar2 = b.o;
                b.k = true;
                b.a.p0.f.j.r.b n2 = b.a.p0.f.j.r.b.n();
                b bVar3 = b.o;
                n2.d("start", b.k, "");
                b bVar4 = b.o;
                Intrinsics.checkNotNullExpressionValue(cacheConfig, "cacheConfig");
                bVar4.O(cacheConfig);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c<T> implements LottieListener<LottieComposition> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameGuideConfigInfo f9934a;

        public c(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9934a = gameGuideConfigInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                GameGuideConfigInfo.ViewInfo viewInfo = this.f9934a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconDoneLottie = lottieComposition;
                }
                b.o.y(this.f9934a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d<T> implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f9935a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706225105, "Lb/a/p0/f/j/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1706225105, "Lb/a/p0/f/j/b$d;");
                    return;
                }
            }
            f9935a = new d();
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public final void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                b.o.a0(false);
                b.a.p0.f.j.r.b n = b.a.p0.f.j.r.b.n();
                b bVar = b.o;
                n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "下发配置中导流view的资源不可用");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameGuideConfigInfo f9936a;

        /* loaded from: classes4.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f9937e;

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
                        return;
                    }
                }
                this.f9937e = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.o.c0(this.f9937e.f9936a);
                }
            }
        }

        public e(GameGuideConfigInfo gameGuideConfigInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameGuideConfigInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9936a = gameGuideConfigInfo;
        }

        @Override // b.a.p0.a.v2.t.b
        public final void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (bitmap == null) {
                    b.o.a0(false);
                    if (b.a.p0.a.k.f6397a) {
                        String str2 = "下载导流view的图片失败， url = " + str;
                    }
                    b.a.p0.f.j.r.b n = b.a.p0.f.j.r.b.n();
                    b bVar = b.o;
                    n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "下发配置中导流view的资源不可用");
                    return;
                }
                bitmap.setDensity(480);
                GameGuideConfigInfo.ViewInfo viewInfo = this.f9936a.viewInfo;
                if (viewInfo != null) {
                    viewInfo.iconNormalImg = bitmap;
                }
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    b.o.a0(false);
                    b.a.p0.f.j.r.b n2 = b.a.p0.f.j.r.b.n();
                    b bVar2 = b.o;
                    n2.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "小游戏非法");
                    return;
                }
                SwanAppActivity x = P.x();
                Intrinsics.checkNotNullExpressionValue(x, "swanApp.swanActivity");
                if (x.isDestroyed()) {
                    b.o.a0(false);
                    b.a.p0.f.j.r.b n3 = b.a.p0.f.j.r.b.n();
                    b bVar3 = b.o;
                    n3.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "小游戏非法");
                    return;
                }
                b.o.a0(true);
                b.o.T(this.f9936a);
                b.o.K();
                q0.b0(new a(this));
                b bVar4 = b.o;
                String str3 = b.j;
                if (str3 != null) {
                    b bVar5 = b.o;
                    if (b.k || this.f9936a.expirationTime <= 0) {
                        return;
                    }
                    b.a.p0.f.j.a.c().a(P.k(), str3, SystemClock.elapsedRealtime() + this.f9936a.expirationTime);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (str == null || str.length() == 0) {
                    if (b.a.p0.a.k.f6397a) {
                        String str2 = "配置信息下发异常，code = " + i2 + ",  response = " + str;
                    }
                    b.o.a0(false);
                    b.a.p0.f.j.r.b n = b.a.p0.f.j.r.b.n();
                    b bVar = b.o;
                    n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "下发数据非法");
                    return;
                }
                if (b.a.p0.a.k.f6397a) {
                    String str3 = "配置信息 =   " + str;
                }
                b.o.O(str);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (b.a.p0.a.k.f6397a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("请求配置信息失败，err = ");
                    sb.append(exc != null ? exc.getMessage() : null);
                    sb.toString();
                }
                b.o.a0(false);
                b.a.p0.f.j.r.b n = b.a.p0.f.j.r.b.n();
                b bVar = b.o;
                n.d(com.baidu.pass.biometrics.face.liveness.b.a.g0, b.k, "网络请求失败");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final g f9938e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1706225012, "Lb/a/p0/f/j/b$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1706225012, "Lb/a/p0/f/j/b$g;");
                    return;
                }
            }
            f9938e = new g();
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.o.N();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h implements b.a.p0.a.w2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.w2.c
        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.f.j.s.a.f10027f.j();
                b bVar = b.o;
                GameGuideView gameGuideView = b.f9928e;
                if (gameGuideView != null) {
                    gameGuideView.startTime(b.a.p0.f.j.s.a.f10027f.f());
                }
                b.a.p0.a.g1.f.T().b();
                if (b.o.C()) {
                    b.o.Q();
                }
            }
        }

        @Override // b.a.p0.a.w2.c
        public void onViewBackground() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b bVar = b.o;
                GameGuideView gameGuideView = b.f9928e;
                if (gameGuideView != null) {
                    gameGuideView.stopTime();
                }
                b.a.p0.f.j.s.a.f10027f.k();
            }
        }

        @Override // b.a.p0.a.w2.c
        public void onViewDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.o.P();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922444817, "Lb/a/p0/f/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-922444817, "Lb/a/p0/f/j/b;");
                return;
            }
        }
        o = new b();
        n = new h();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return f9924a;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getPlayTime");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getLong("playTime", 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final GameGuideViewContainer B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f9932i : (GameGuideViewContainer) invokeV.objValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = b.a.p0.a.k2.g.h.a().getBoolean("hasChoiceNotShow", false);
            l = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = b.a.p0.a.k2.g.h.a().getBoolean("hasInstallResult", true);
            m = z;
            return z;
        }
        return invokeV.booleanValue;
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.a.k2.g.h.a().getBoolean("key_gt_ths", false) : invokeV.booleanValue;
    }

    public final long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b.a.p0.a.k2.g.h.a().getLong("key_l_gt", 0L) : invokeV.longValue;
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return f9931h;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getCoins");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                return callOnMainWithContentProvider.mResult.getInt("coinsNum", 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f9930g : (String) invokeV.objValue;
    }

    public final String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? f9929f : (String) invokeV.objValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? b.a.p0.a.k2.g.h.a().getInt("coinsNum", 0) : invokeV.intValue;
    }

    public final void K() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                long F = F();
                if (0 <= F && SapiWebView.DEFAULT_TIMEOUT_MILLIS >= F) {
                    f9924a = F;
                }
                int J = J();
                GameGuideConfigInfo gameGuideConfigInfo = f9927d;
                if (gameGuideConfigInfo != null && J > (i2 = gameGuideConfigInfo.maxNums)) {
                    o.S(i2);
                    J = i2;
                }
                f9931h = J;
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "initGameGuideInfo");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (f9925b) {
                return true;
            }
            if (ProcessUtils.isMainProcess()) {
                boolean E = E();
                f9925b = E;
                return E;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "getHasShowedTips");
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
            Intrinsics.checkNotNullExpressionValue(callOnMainWithContentProvider, "DelegateUtils.callOnMain…tion::class.java, bundle)");
            if (callOnMainWithContentProvider.isOk()) {
                boolean z = callOnMainWithContentProvider.mResult.getBoolean("hasShowedTips", false);
                f9925b = z;
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (ProcessUtils.isMainProcess()) {
                d0();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "onGameTimeUsed");
            Intrinsics.checkNotNullExpressionValue(DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle), "DelegateUtils.callOnMain…tion::class.java, bundle)");
        }
    }

    public final void N() {
        GameGuideConfigInfo gameGuideConfigInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (gameGuideConfigInfo = f9927d) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f9926c < 500) {
            boolean z = b.a.p0.a.k.f6397a;
            return;
        }
        b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
        if (P != null) {
            f9926c = currentTimeMillis;
            long f2 = b.a.p0.f.j.s.a.f10027f.f() / 30000;
            if (f2 <= 0) {
                boolean z2 = b.a.p0.a.k.f6397a;
            } else if (!SwanAppNetworkUtils.i(AppRuntime.getAppContext())) {
                boolean z3 = b.a.p0.a.k.f6397a;
                b.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "网络异常，请稍后重试").F();
            } else {
                int i2 = (int) f2;
                b.a.p0.f.j.r.b.n().i(i2);
                int i3 = gameGuideConfigInfo.perCoinNum * i2;
                int G = G();
                boolean z4 = G >= gameGuideConfigInfo.maxNums;
                if (b.a.p0.a.k.f6397a) {
                    String str = "before    expectedRewardCoins = " + i3 + " , currentRewardCoinsNum = " + G + ",  isMax = " + z4;
                }
                int i4 = i3 + G;
                int i5 = gameGuideConfigInfo.maxNums;
                if (i4 > i5) {
                    i3 = i5 - G;
                }
                if (b.a.p0.a.k.f6397a) {
                    String str2 = "after    realRewardCoins = " + i3;
                }
                if (!z4) {
                    b.a.p0.f.j.s.a.f10027f.h();
                    GameGuideView gameGuideView = f9928e;
                    if (gameGuideView != null) {
                        gameGuideView.updateStatusWhenClick();
                    }
                    v(i3);
                }
                b.a.p0.a.g1.f.T().o();
                Intent intent = new Intent(P.x(), CoinClickDialog.class);
                intent.putExtra(CoinClickDialog.KEY_IS_SHOW_MAX, z4);
                intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_THIS_TIME, i3);
                intent.putExtra(CoinClickDialog.KEY_COINS_REWARD_TOTAL, G + i3);
                P.x().startActivity(intent);
            }
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt != 0) {
                    if (b.a.p0.a.k.f6397a) {
                        String str2 = "返回结果异常，errNo = " + optInt + "， response = " + str;
                    }
                    b.a.p0.f.j.r.b.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
                    return;
                }
                GameGuideConfigInfo parseData = GameGuideConfigInfo.parseData(jSONObject.optJSONObject("data"));
                if (parseData == null) {
                    boolean z = b.a.p0.a.k.f6397a;
                    b.a.p0.f.j.r.b.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
                    return;
                }
                W(parseData.install_result);
                String str3 = parseData.targetAppPackageId;
                Intrinsics.checkNotNullExpressionValue(str3, "configInfo.targetAppPackageId");
                f9929f = str3;
                String str4 = parseData.targetAppDownloadUrl;
                Intrinsics.checkNotNullExpressionValue(str4, "configInfo.targetAppDownloadUrl");
                f9930g = str4;
                if (parseData.status == 0) {
                    boolean z2 = b.a.p0.a.k.f6397a;
                    b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                    if (!k && parseData.expirationTime > 0 && P != null) {
                        b.a.p0.f.j.a.c().a(P.k(), str, SystemClock.elapsedRealtime() + parseData.expirationTime);
                    }
                    b.a.p0.f.j.r.b.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "配置下发不展示");
                    return;
                }
                j = str;
                if (parseData.popupSelection == 2) {
                    f9927d = parseData;
                } else if (C()) {
                    b.a.p0.f.j.r.b.n().a("hasClosedWithNotShow");
                    f9927d = parseData;
                } else {
                    x(parseData);
                }
                b.a.p0.f.j.r.b.n().d("success", k, "");
            } catch (Throwable th) {
                if (b.a.p0.a.k.f6397a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("解析配置信息失败，err = ");
                    th.printStackTrace();
                    sb.append(Unit.INSTANCE);
                    sb.toString();
                }
                b.a.p0.f.j.r.b.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "下发数据非法");
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            f9928e = null;
            f9932i = null;
            k = false;
        }
    }

    public final void Q() {
        GameGuideViewContainer gameGuideViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (gameGuideViewContainer = f9932i) == null) {
            return;
        }
        b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
        Intrinsics.checkNotNullExpressionValue(T, "SwanAppController.getInstance()");
        T.W().f(n);
        b.a.p0.a.g1.f T2 = b.a.p0.a.g1.f.T();
        Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
        n W = T2.W();
        Intrinsics.checkNotNullExpressionValue(W, "SwanAppController.getIns…swanGameNARootViewManager");
        FrameLayout rootView = W.getRootView();
        if (rootView != null) {
            rootView.removeView(gameGuideViewContainer);
        }
        o.P();
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                b.a.p0.f.j.r.b.n().d(com.baidu.pass.biometrics.face.liveness.b.a.g0, k, "小游戏非法");
                return;
            }
            String i3 = b.a.p0.a.c1.a.a0().i(AppRuntime.getAppContext());
            if (i3 == null) {
                i3 = "";
            }
            String h2 = b.a.p0.a.m2.b.h(1);
            b.a.p0.a.e2.c.h a2 = b.a.p0.a.c1.a.p().a();
            Application b2 = b.a.p0.a.c1.a.b();
            Intrinsics.checkNotNullExpressionValue(b2, "SwanAppRuntime.getAppContext()");
            b.a K = i2.K();
            Intrinsics.checkNotNullExpressionValue(K, "swanApp.info");
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) i2.W().postFormRequest().url("https://gamecenter.baidu.com/api/minigame/get_flowout_config")).cookieManager(a2)).addParam("cuid", i3).addParam("appkey", i2.k()).addParam("host", b2.getPackageName()).addParam("from", K.S()).addParam("gamecore_version", h2).requestFrom(16)).requestSubFrom(1602)).build().executeAsync(new f());
        }
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            b.a.p0.a.k2.g.h.a().putInt("coinsNum", i2);
        }
    }

    public final void T(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gameGuideConfigInfo) == null) {
            f9927d = gameGuideConfigInfo;
        }
    }

    public final void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            if (ProcessUtils.isMainProcess()) {
                Z(j2);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "setPlayTime");
            bundle.putLong("playTime", j2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            l = z;
            b.a.p0.a.k2.g.h.a().putBoolean("hasChoiceNotShow", z);
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            m = z;
            b.a.p0.a.k2.g.h.a().putBoolean("hasInstallResult", z);
        }
    }

    public final void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            b.a.p0.a.k2.g.h.a().putBoolean("key_gt_ths", z);
        }
    }

    public final void Y(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            b.a.p0.a.k2.g.h.a().putLong("key_l_gt", j2);
        }
    }

    public final void Z(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            if (j2 < 0) {
                boolean z = b.a.p0.a.k.f6397a;
                return;
            }
            if (j2 > SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                j2 = 90000;
            }
            f9924a = j2;
            Y(j2);
        }
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || f9925b) {
            return;
        }
        f9925b = true;
        if (ProcessUtils.isMainProcess()) {
            X(true);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "setHasShowedTips");
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
    }

    public final void c0(GameGuideConfigInfo gameGuideConfigInfo) {
        GameGuideConfigInfo.ViewInfo viewInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, gameGuideConfigInfo) == null) || (viewInfo = gameGuideConfigInfo.viewInfo) == null) {
            return;
        }
        b.a.p0.f.j.r.b.n().l();
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
        Resources resources = appContext.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(b.a.p0.a.d.aiapps_action_bar_right_menu_bg_radius) + resources.getDimensionPixelSize(b.a.p0.a.d.aigames_action_bar_top_operation_margin) + n0.g(10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388613;
        b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
        if (P != null) {
            f9932i = new GameGuideViewContainer(b.a.p0.a.c1.a.b());
            int e2 = f0.e(P.x());
            if (f0.d()) {
                layoutParams.topMargin = dimensionPixelSize + e2;
            } else {
                layoutParams.topMargin = dimensionPixelSize;
            }
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            Intrinsics.checkNotNullExpressionValue(T, "SwanAppController.getInstance()");
            n W = T.W();
            Intrinsics.checkNotNullExpressionValue(W, "SwanAppController.getIns…swanGameNARootViewManager");
            W.getRootView().addView(f9932i, layoutParams);
            Context appContext2 = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext2, "AppRuntime.getAppContext()");
            LottieComposition lottieComposition = viewInfo.iconDoneLottie;
            Intrinsics.checkNotNullExpressionValue(lottieComposition, "it.iconDoneLottie");
            Bitmap bitmap = viewInfo.iconNormalImg;
            Intrinsics.checkNotNullExpressionValue(bitmap, "it.iconNormalImg");
            String str = viewInfo.progressColor;
            Intrinsics.checkNotNullExpressionValue(str, "it.progressColor");
            String str2 = viewInfo.tips;
            Intrinsics.checkNotNullExpressionValue(str2, "it.tips");
            GameGuideView gameGuideView = new GameGuideView(appContext2, lottieComposition, bitmap, str, str2);
            f9928e = gameGuideView;
            GameGuideViewContainer gameGuideViewContainer = f9932i;
            if (gameGuideViewContainer != null) {
                gameGuideViewContainer.addView(gameGuideView);
            }
            b.a.p0.a.g1.f T2 = b.a.p0.a.g1.f.T();
            Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
            T2.W().e(n);
            GameGuideView gameGuideView2 = f9928e;
            if (gameGuideView2 != null) {
                gameGuideView2.setOnClickListener(g.f9938e);
            }
            if (b.a.p0.f.j.s.a.f10027f.g()) {
                return;
            }
            b.a.p0.f.j.s.a.f10027f.j();
            GameGuideView gameGuideView3 = f9928e;
            if (gameGuideView3 != null) {
                gameGuideView3.startTime(b.a.p0.f.j.s.a.f10027f.f());
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            long j2 = f9924a;
            if (j2 < 30000) {
                return;
            }
            long j3 = j2 % 30000;
            f9924a = j3;
            Y(j3);
        }
    }

    public final void v(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (ProcessUtils.isMainProcess()) {
                int i4 = f9931h + i2;
                f9931h = i4;
                GameGuideConfigInfo gameGuideConfigInfo = f9927d;
                if (gameGuideConfigInfo != null && i4 > (i3 = gameGuideConfigInfo.maxNums)) {
                    f9931h = i3;
                }
                S(f9931h);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "addCoins");
            bundle.putInt("coinsNum", i2);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            q.j(RunnableC0530b.f9933e, "thread_gamenowGuideInitAndCheck");
        }
    }

    public final void x(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, gameGuideConfigInfo) == null) {
            Context appContext = AppRuntime.getAppContext();
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            LottieCompositionFactory.fromUrl(appContext, viewInfo != null ? viewInfo.iconDoneUrl : null).addListener(new c(gameGuideConfigInfo)).addFailureListener(d.f9935a);
        }
    }

    public final void y(GameGuideConfigInfo gameGuideConfigInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gameGuideConfigInfo) == null) {
            GameGuideConfigInfo.ViewInfo viewInfo = gameGuideConfigInfo.viewInfo;
            t.e(viewInfo != null ? viewInfo.iconNormalUrl : null, new e(gameGuideConfigInfo));
        }
    }

    public final GameGuideConfigInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? f9927d : (GameGuideConfigInfo) invokeV.objValue;
    }
}
