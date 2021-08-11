package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k;
import c.a.n0.a.v2.q0;
import c.a.n0.h.o0.g.b.a;
import c.a.n0.h.o0.g.b.d;
import c.a.n0.h.o0.g.b.e;
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
/* loaded from: classes6.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d.a, a.b, c.a.n0.h.o0.g.a, c.a.n0.a.w2.c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.n0.h.o0.g.b.b f46902e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.h.o0.g.b.c f46903f;

    /* renamed from: g  reason: collision with root package name */
    public int f46904g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendButtonState f46905h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.n0.h.o0.g.e.a f46906i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.n0.a.l0.c f46907j;
    @V8JavascriptField
    public final d style;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f46908b;

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
            this.f46908b = recommendButtonApiProxy;
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (RecommendButtonApiProxy.k) {
                    String str2 = "load: onFail-" + str;
                }
                if (this.f46908b.f46905h == RecommendButtonState.DESTROYED) {
                    return;
                }
                this.f46908b.f46905h = RecommendButtonState.IDLE;
                this.f46908b.I(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                c.a.n0.h.o0.g.e.c c2 = c.a.n0.h.o0.g.e.b.c(str);
                if (RecommendButtonApiProxy.k) {
                    String str2 = "load: onSuccess-" + c2.a();
                }
                if (this.f46908b.f46905h == RecommendButtonState.DESTROYED) {
                    return;
                }
                if (c2.a()) {
                    this.f46908b.f46905h = RecommendButtonState.HIDE;
                    this.f46908b.f46906i = c.a.n0.h.o0.g.e.b.b(c2.f11207c);
                    this.f46908b.f46902e.e(this.f46908b.f46906i);
                    this.f46908b.J();
                    return;
                }
                this.f46908b.f46905h = RecommendButtonState.IDLE;
                this.f46908b.I(String.format("RecommendationButton.load failed,%s", c2.f11206b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f46909e;

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
            this.f46909e = recommendButtonApiProxy;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46909e.f46903f.e(this.f46909e.f46904g, this.f46909e.f46906i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public abstract class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendButtonApiProxy f46910a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46911e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f46912f;

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
                this.f46912f = cVar;
                this.f46911e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46912f.b(this.f46911e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f46913e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f46914f;

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
                this.f46914f = cVar;
                this.f46913e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f46914f.a(this.f46913e.getMessage());
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
            this.f46910a = recommendButtonApiProxy;
        }

        public abstract void a(String str);

        public abstract void b(String str);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: c */
        public void onSuccess(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
                this.f46910a.f46907j.runOnJSThread(new a(this, str));
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
                this.f46910a.f46907j.runOnJSThread(new b(this, exc));
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
        k = k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendButtonApiProxy(c.a.n0.a.l0.c cVar, JsObject jsObject) {
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
        this.f46903f = new c.a.n0.h.o0.g.b.c();
        this.style = new d();
        this.f46907j = cVar;
        if (N(jsObject)) {
            c.a.n0.h.o0.b.c(this);
        }
    }

    public final void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.n0.h.d.c.b bVar = new c.a.n0.h.d.c.b();
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
                String str = "destroy: state-" + this.f46905h;
            }
            RecommendButtonState recommendButtonState = this.f46905h;
            RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
            if (recommendButtonState == recommendButtonState2) {
                return;
            }
            this.f46905h = recommendButtonState2;
            c.a.n0.h.o0.g.b.b bVar = this.f46902e;
            if (bVar != null) {
                bVar.destroy();
            }
            this.f46906i = null;
        }
    }

    public final boolean L(c.a.n0.a.y.b.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, aVar, str)) == null) {
            int i2 = aVar != null ? aVar.i(str) : 12;
            return (i2 == 12 || i2 == 11) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecommendButtonState recommendButtonState = this.f46905h;
            return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
        }
        return invokeV.booleanValue;
    }

    public final boolean N(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            this.f46905h = RecommendButtonState.IDLE;
            this.style.b(this);
            c.a.n0.a.y.b.a G = c.a.n0.a.y.b.a.G(jsObject);
            if (G == null) {
                G = new c.a.n0.a.y.b.a();
            }
            String C = G.C("type");
            if (L(G, "type")) {
                this.f46904g = R(C);
            } else {
                this.f46904g = 1;
            }
            if (this.f46904g == 0) {
                Q("createRecommendationButton failed,parameter error: the 'type' is invalid.");
                return false;
            }
            if (L(G, "style")) {
                c.a.n0.a.y.b.a x = G.x("style");
                if (x == null) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                } else if (!O(x)) {
                    Q("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                }
            }
            if (k) {
                String str = "init: style-" + this.style;
            }
            this.f46902e = new c.a.n0.h.o0.g.g.a(this.f46904g, this.style, this);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean O(c.a.n0.a.y.b.a aVar) {
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
        e.d(this.f46904g, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(c.a.n0.h.o0.b.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.f46903f.d(this.f46904g, str, recommendItemModel.appKey);
    }

    public final void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f46907j.throwJSException(JSExceptionType.Error, str);
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

    @Override // c.a.n0.a.w2.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            K();
        }
    }

    @Override // c.a.n0.h.o0.g.b.a.b
    @UiThread
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f46903f.d(this.f46904g, "list", c.a.n0.h.o0.g.b.c.f11191b);
        }
    }

    @Override // c.a.n0.h.o0.g.a
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            K();
            c.a.n0.h.o0.b.e(this);
        }
    }

    @Override // c.a.n0.h.o0.g.a
    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (k) {
                String str = "hide: state-" + this.f46905h;
            }
            if (this.f46905h == RecommendButtonState.SHOW) {
                this.f46905h = RecommendButtonState.HIDE;
                this.f46902e.hide();
            }
        }
    }

    public final void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && M()) {
            this.f46902e.l(z);
        }
    }

    @JavascriptInterface
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (k) {
                String str = "load: state-" + this.f46905h;
            }
            if (this.f46905h != RecommendButtonState.IDLE) {
                return;
            }
            this.f46905h = RecommendButtonState.LOADING;
            e.b(this.f46904g, new a(this));
        }
    }

    @Override // c.a.n0.a.w2.c
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            l(true);
        }
    }

    @Override // c.a.n0.h.o0.g.b.a.b
    @UiThread
    public void o() {
        c.a.n0.h.o0.g.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f46906i) == null) {
            return;
        }
        P(aVar.f11203a, "game_center");
    }

    @Override // c.a.n0.a.w2.c
    public void onViewBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            l(false);
        }
    }

    @Override // c.a.n0.h.o0.g.a
    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                String str = "show: state-" + this.f46905h;
            }
            if (this.f46905h == RecommendButtonState.HIDE) {
                this.f46905h = RecommendButtonState.SHOW;
                q0.b0(new b(this));
                this.f46902e.show();
            }
        }
    }

    @Override // c.a.n0.h.o0.g.b.a.b
    @UiThread
    public void u(int i2) {
        c.a.n0.h.o0.g.e.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (aVar = this.f46906i) == null || i2 < 0 || i2 >= aVar.f11204b.size()) {
            return;
        }
        P(this.f46906i.f11204b.get(i2), "game");
    }
}
