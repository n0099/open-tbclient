package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
import b.a.p0.j.p0.g.b.a;
import b.a.p0.j.p0.g.b.d;
import b.a.p0.j.p0.g.b.e;
import com.baidu.adp.widget.VerticalTranslateLayout;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes8.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d.a, a.b, b.a.p0.j.p0.g.a, b.a.p0.a.a3.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.j.p0.g.b.b f45572e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.j.p0.g.b.c f45573f;

    /* renamed from: g  reason: collision with root package name */
    public int f45574g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendButtonState f45575h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.p0.j.p0.g.e.a f45576i;
    public b.a.p0.a.l0.c j;
    @V8JavascriptField
    public final d style;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public RecommendButtonState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes8.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f45577b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RecommendButtonApiProxy recommendButtonApiProxy) {
            super(recommendButtonApiProxy, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendButtonApiProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((RecommendButtonApiProxy) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45577b = recommendButtonApiProxy;
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (RecommendButtonApiProxy.k) {
                    String str2 = "load: onFail-" + str;
                }
                if (this.f45577b.f45575h == RecommendButtonState.DESTROYED) {
                    return;
                }
                this.f45577b.f45575h = RecommendButtonState.IDLE;
                this.f45577b.I(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                b.a.p0.j.p0.g.e.c c2 = b.a.p0.j.p0.g.e.b.c(str);
                if (RecommendButtonApiProxy.k) {
                    String str2 = "load: onSuccess-" + c2.a();
                }
                if (this.f45577b.f45575h == RecommendButtonState.DESTROYED) {
                    return;
                }
                if (c2.a()) {
                    this.f45577b.f45575h = RecommendButtonState.HIDE;
                    this.f45577b.f45576i = b.a.p0.j.p0.g.e.b.b(c2.f11397c);
                    this.f45577b.f45572e.e(this.f45577b.f45576i);
                    this.f45577b.J();
                    return;
                }
                this.f45577b.f45575h = RecommendButtonState.IDLE;
                this.f45577b.I(String.format("RecommendationButton.load failed,%s", c2.f11396b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f45578e;

        public b(RecommendButtonApiProxy recommendButtonApiProxy) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recommendButtonApiProxy};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45578e = recommendButtonApiProxy;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45578e.f45573f.e(this.f45578e.f45574g, this.f45578e.f45576i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public abstract class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f45579a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f45580e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f45581f;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45581f = cVar;
                this.f45580e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45581f.b(this.f45580e);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f45582e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f45583f;

            public b(c cVar, Exception exc) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, exc};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45583f = cVar;
                this.f45582e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45583f.a(this.f45582e.getMessage());
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45579a = recommendButtonApiProxy;
        }

        public abstract void a(String str);

        public abstract void b(String str);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: c */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f45579a.j.runOnJSThread(new a(this, str));
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.f45579a.j.runOnJSThread(new b(this, exc));
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
        k = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendButtonApiProxy(b.a.p0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45573f = new b.a.p0.j.p0.g.b.c();
        this.style = new d();
        this.j = cVar;
        if (N(jsObject)) {
            b.a.p0.j.p0.b.c(this);
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b.a.p0.j.d.c.b bVar = new b.a.p0.j.d.c.b();
            bVar.errMsg = str;
            dispatchEvent(new JSEvent("error", bVar));
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
            if (k) {
                String str = "destroy: state-" + this.f45575h;
            }
            RecommendButtonState recommendButtonState = this.f45575h;
            RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
            if (recommendButtonState == recommendButtonState2) {
                return;
            }
            this.f45575h = recommendButtonState2;
            b.a.p0.j.p0.g.b.b bVar = this.f45572e;
            if (bVar != null) {
                bVar.destroy();
            }
            this.f45576i = null;
        }
    }

    public final boolean L(b.a.p0.a.y.b.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, str)) == null) {
            int type = aVar != null ? aVar.getType(str) : 12;
            return (type == 12 || type == 11) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecommendButtonState recommendButtonState = this.f45575h;
            return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
        }
        return invokeV.booleanValue;
    }

    public final boolean N(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            this.f45575h = RecommendButtonState.IDLE;
            this.style.b(this);
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            if (F == null) {
                F = new b.a.p0.a.y.b.a();
            }
            String B = F.B("type");
            if (L(F, "type")) {
                this.f45574g = R(B);
            } else {
                this.f45574g = 1;
            }
            if (this.f45574g == 0) {
                Q("createRecommendationButton failed,parameter error: the 'type' is invalid.");
                return false;
            }
            if (L(F, "style")) {
                b.a.p0.a.y.b.a w = F.w("style");
                if (w == null) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                } else if (!O(w)) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                }
            }
            if (k) {
                String str = "init: style-" + this.style;
            }
            this.f45572e = new b.a.p0.j.p0.g.g.a(this.f45574g, this.style, this);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean O(b.a.p0.a.y.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            if (aVar == null) {
                return true;
            }
            try {
                if (L(aVar, "left")) {
                    this.style.left = (float) aVar.c("left");
                }
                if (L(aVar, VerticalTranslateLayout.TOP)) {
                    this.style.top = (float) aVar.c(VerticalTranslateLayout.TOP);
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
        e.d(this.f45574g, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(b.a.p0.j.p0.b.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.f45573f.d(this.f45574g, str, recommendItemModel.appKey);
    }

    public final void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j.throwJSException(JSExceptionType.Error, str);
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

    @Override // b.a.p0.a.a3.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            K();
        }
    }

    @Override // b.a.p0.j.p0.g.b.a.b
    @UiThread
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f45573f.d(this.f45574g, "list", b.a.p0.j.p0.g.b.c.f11381b);
        }
    }

    @Override // b.a.p0.j.p0.g.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            K();
            b.a.p0.j.p0.b.e(this);
        }
    }

    @Override // b.a.p0.j.p0.g.a
    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (k) {
                String str = "hide: state-" + this.f45575h;
            }
            if (this.f45575h == RecommendButtonState.SHOW) {
                this.f45575h = RecommendButtonState.HIDE;
                this.f45572e.hide();
            }
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && M()) {
            this.f45572e.l(z);
        }
    }

    @JavascriptInterface
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (k) {
                String str = "load: state-" + this.f45575h;
            }
            if (this.f45575h != RecommendButtonState.IDLE) {
                return;
            }
            this.f45575h = RecommendButtonState.LOADING;
            e.b(this.f45574g, new a(this));
        }
    }

    @Override // b.a.p0.a.a3.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            l(true);
        }
    }

    @Override // b.a.p0.j.p0.g.b.a.b
    @UiThread
    public void o() {
        b.a.p0.j.p0.g.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f45576i) == null) {
            return;
        }
        P(aVar.f11393a, "game_center");
    }

    @Override // b.a.p0.a.a3.c
    public void onViewBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            l(false);
        }
    }

    @Override // b.a.p0.j.p0.g.a
    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                String str = "show: state-" + this.f45575h;
            }
            if (this.f45575h == RecommendButtonState.HIDE) {
                this.f45575h = RecommendButtonState.SHOW;
                q0.e0(new b(this));
                this.f45572e.show();
            }
        }
    }

    @Override // b.a.p0.j.p0.g.b.a.b
    @UiThread
    public void u(int i2) {
        b.a.p0.j.p0.g.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (aVar = this.f45576i) == null || i2 < 0 || i2 >= aVar.f11394b.size()) {
            return;
        }
        P(this.f45576i.f11394b.get(i2), "game");
    }
}
