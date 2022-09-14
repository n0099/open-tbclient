package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.e64;
import com.baidu.tieba.f64;
import com.baidu.tieba.fv1;
import com.baidu.tieba.g64;
import com.baidu.tieba.h64;
import com.baidu.tieba.hx3;
import com.baidu.tieba.i64;
import com.baidu.tieba.ia2;
import com.baidu.tieba.ij1;
import com.baidu.tieba.j64;
import com.baidu.tieba.n64;
import com.baidu.tieba.o64;
import com.baidu.tieba.p64;
import com.baidu.tieba.s54;
import com.baidu.tieba.sg3;
import com.baidu.tieba.v64;
import com.baidu.tieba.xh3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements i64.a, f64.b, e64, xh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public g64 a;
    public h64 b;
    public int c;
    public RecommendButtonState d;
    public n64 e;
    public ia2 f;
    @V8JavascriptField
    public final i64 style;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RecommendButtonState {
        public static final /* synthetic */ RecommendButtonState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RecommendButtonState DESTROYED;
        public static final RecommendButtonState HIDE;
        public static final RecommendButtonState IDLE;
        public static final RecommendButtonState LOADING;
        public static final RecommendButtonState SHOW;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225048470, "Lcom/baidu/swan/games/view/recommend/proxy/RecommendButtonApiProxy$RecommendButtonState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225048470, "Lcom/baidu/swan/games/view/recommend/proxy/RecommendButtonApiProxy$RecommendButtonState;");
                    return;
                }
            }
            IDLE = new RecommendButtonState("IDLE", 0);
            LOADING = new RecommendButtonState("LOADING", 1);
            HIDE = new RecommendButtonState("HIDE", 2);
            SHOW = new RecommendButtonState("SHOW", 3);
            RecommendButtonState recommendButtonState = new RecommendButtonState("DESTROYED", 4);
            DESTROYED = recommendButtonState;
            $VALUES = new RecommendButtonState[]{IDLE, LOADING, HIDE, SHOW, recommendButtonState};
        }

        public RecommendButtonState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RecommendButtonState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RecommendButtonState) Enum.valueOf(RecommendButtonState.class, str) : (RecommendButtonState) invokeL.objValue;
        }

        public static RecommendButtonState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RecommendButtonState[]) $VALUES.clone() : (RecommendButtonState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendButtonApiProxy b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendButtonApiProxy recommendButtonApiProxy) {
            super(recommendButtonApiProxy, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendButtonApiProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RecommendButtonApiProxy) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recommendButtonApiProxy;
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (RecommendButtonApiProxy.g) {
                    Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                }
                if (this.b.d == RecommendButtonState.DESTROYED) {
                    return;
                }
                this.b.d = RecommendButtonState.IDLE;
                this.b.I(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                p64 c = o64.c(str);
                if (RecommendButtonApiProxy.g) {
                    Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
                }
                if (this.b.d == RecommendButtonState.DESTROYED) {
                    return;
                }
                if (c.a()) {
                    this.b.d = RecommendButtonState.HIDE;
                    this.b.e = o64.b(c.c);
                    this.b.a.d(this.b.e);
                    this.b.J();
                    return;
                }
                this.b.d = RecommendButtonState.IDLE;
                this.b.I(String.format("RecommendationButton.load failed,%s", c.b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendButtonApiProxy a;

        public b(RecommendButtonApiProxy recommendButtonApiProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendButtonApiProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendButtonApiProxy;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.e(this.a.c, this.a.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendButtonApiProxy a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ c b;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b(this.a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Exception a;
            public final /* synthetic */ c b;

            public b(c cVar, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a(this.a.getMessage());
                }
            }
        }

        public c(RecommendButtonApiProxy recommendButtonApiProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendButtonApiProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recommendButtonApiProxy;
        }

        public abstract void a(String str);

        public abstract void b(String str);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: c */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                this.a.f.runOnJSThread(new a(this, str));
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.a.f.runOnJSThread(new b(this, exc));
            }
        }

        public /* synthetic */ c(RecommendButtonApiProxy recommendButtonApiProxy, a aVar) {
            this(recommendButtonApiProxy);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843338727, "Lcom/baidu/swan/games/view/recommend/proxy/RecommendButtonApiProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843338727, "Lcom/baidu/swan/games/view/recommend/proxy/RecommendButtonApiProxy;");
                return;
            }
        }
        g = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendButtonApiProxy(ia2 ia2Var, JsObject jsObject) {
        super(ia2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia2Var, jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new h64();
        this.style = new i64();
        this.f = ia2Var;
        if (N(jsObject)) {
            s54.c(this);
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            hx3 hx3Var = new hx3();
            hx3Var.errMsg = str;
            dispatchEvent(new JSEvent("error", hx3Var));
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dispatchEvent(new JSEvent("load"));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "destroy: state-" + this.d);
            }
            RecommendButtonState recommendButtonState = this.d;
            RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
            if (recommendButtonState == recommendButtonState2) {
                return;
            }
            this.d = recommendButtonState2;
            g64 g64Var = this.a;
            if (g64Var != null) {
                g64Var.destroy();
            }
            this.e = null;
        }
    }

    public final boolean L(fv1 fv1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fv1Var, str)) == null) {
            int type = fv1Var != null ? fv1Var.getType(str) : 12;
            return (type == 12 || type == 11) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecommendButtonState recommendButtonState = this.d;
            return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
        }
        return invokeV.booleanValue;
    }

    public final boolean N(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            this.d = RecommendButtonState.IDLE;
            this.style.b(this);
            fv1 F = fv1.F(jsObject);
            if (F == null) {
                F = new fv1();
            }
            String B = F.B("type");
            if (L(F, "type")) {
                this.c = R(B);
            } else {
                this.c = 1;
            }
            if (this.c == 0) {
                Q("createRecommendationButton failed,parameter error: the 'type' is invalid.");
                return false;
            }
            if (L(F, "style")) {
                fv1 w = F.w("style");
                if (w == null) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                } else if (!O(w)) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                }
            }
            if (g) {
                Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
            }
            this.a = new v64(this.c, this.style, this);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean O(fv1 fv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fv1Var)) == null) {
            if (fv1Var == null) {
                return true;
            }
            try {
                if (L(fv1Var, "left")) {
                    this.style.left = (float) fv1Var.c("left");
                }
                if (L(fv1Var, "top")) {
                    this.style.top = (float) fv1Var.c("top");
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public final void P(RecommendItemModel recommendItemModel, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, recommendItemModel, str) == null) || recommendItemModel == null || TextUtils.isEmpty(recommendItemModel.appKey) || TextUtils.isEmpty(recommendItemModel.scheme)) {
            return;
        }
        j64.d(this.c, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(s54.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.b.d(this.c, str, recommendItemModel.appKey);
    }

    public final void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f.throwJSException(JSExceptionType.Error, str);
            K();
        }
    }

    public final int R(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String lowerCase = str == null ? "" : str.toLowerCase(Locale.CHINA);
            char c2 = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != 2908512) {
                if (hashCode == 3322014 && lowerCase.equals("list")) {
                    c2 = 1;
                }
            } else if (lowerCase.equals("carousel")) {
                c2 = 0;
            }
            if (c2 != 0) {
                return c2 != 1 ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.f64.b
    @UiThread
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.d(this.c, "list", h64.b);
        }
    }

    @Override // com.baidu.tieba.e64
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            K();
            s54.e(this);
        }
    }

    @Override // com.baidu.tieba.xh3
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(false);
        }
    }

    @Override // com.baidu.tieba.e64
    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "hide: state-" + this.d);
            }
            if (this.d == RecommendButtonState.SHOW) {
                this.d = RecommendButtonState.HIDE;
                this.a.hide();
            }
        }
    }

    @Override // com.baidu.tieba.xh3
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m(true);
        }
    }

    @JavascriptInterface
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "load: state-" + this.d);
            }
            if (this.d != RecommendButtonState.IDLE) {
                return;
            }
            this.d = RecommendButtonState.LOADING;
            j64.b(this.c, new a(this));
        }
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && M()) {
            this.a.m(z);
        }
    }

    @Override // com.baidu.tieba.f64.b
    @UiThread
    public void o() {
        n64 n64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (n64Var = this.e) == null) {
            return;
        }
        P(n64Var.a, "game_center");
    }

    @Override // com.baidu.tieba.xh3
    public void onViewDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            K();
        }
    }

    @Override // com.baidu.tieba.e64
    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
            }
            if (this.d == RecommendButtonState.HIDE) {
                this.d = RecommendButtonState.SHOW;
                sg3.e0(new b(this));
                this.a.show();
            }
        }
    }

    @Override // com.baidu.tieba.f64.b
    @UiThread
    public void u(int i) {
        n64 n64Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (n64Var = this.e) == null || i < 0 || i >= n64Var.b.size()) {
            return;
        }
        P(this.e.b.get(i), "game");
    }
}
