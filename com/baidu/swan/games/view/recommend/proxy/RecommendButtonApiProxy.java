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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a44;
import com.repackage.b44;
import com.repackage.bt1;
import com.repackage.c44;
import com.repackage.cv3;
import com.repackage.d44;
import com.repackage.e44;
import com.repackage.e82;
import com.repackage.eh1;
import com.repackage.i44;
import com.repackage.j44;
import com.repackage.k44;
import com.repackage.n34;
import com.repackage.oe3;
import com.repackage.q44;
import com.repackage.tf3;
import com.repackage.z34;
import java.util.Locale;
/* loaded from: classes2.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d44.a, a44.b, z34, tf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public b44 a;
    public c44 b;
    public int c;
    public RecommendButtonState d;
    public i44 e;
    public e82 f;
    @V8JavascriptField
    public final d44 style;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
                this.b.J(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                k44 c = j44.c(str);
                if (RecommendButtonApiProxy.g) {
                    Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
                }
                if (this.b.d == RecommendButtonState.DESTROYED) {
                    return;
                }
                if (c.a()) {
                    this.b.d = RecommendButtonState.HIDE;
                    this.b.e = j44.b(c.c);
                    this.b.a.e(this.b.e);
                    this.b.K();
                    return;
                }
                this.b.d = RecommendButtonState.IDLE;
                this.b.J(String.format("RecommendationButton.load failed,%s", c.b));
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public abstract class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecommendButtonApiProxy a;

        /* loaded from: classes2.dex */
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

        /* loaded from: classes2.dex */
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
        g = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendButtonApiProxy(e82 e82Var, JsObject jsObject) {
        super(e82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var, jsObject};
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
        this.b = new c44();
        this.style = new d44();
        this.f = e82Var;
        if (O(jsObject)) {
            n34.c(this);
        }
    }

    public final void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            cv3 cv3Var = new cv3();
            cv3Var.errMsg = str;
            dispatchEvent(new JSEvent("error", cv3Var));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dispatchEvent(new JSEvent("load"));
        }
    }

    public final void L() {
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
            b44 b44Var = this.a;
            if (b44Var != null) {
                b44Var.destroy();
            }
            this.e = null;
        }
    }

    public final boolean M(bt1 bt1Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bt1Var, str)) == null) {
            int type = bt1Var != null ? bt1Var.getType(str) : 12;
            return (type == 12 || type == 11) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RecommendButtonState recommendButtonState = this.d;
            return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
        }
        return invokeV.booleanValue;
    }

    public final boolean O(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            this.d = RecommendButtonState.IDLE;
            this.style.b(this);
            bt1 F = bt1.F(jsObject);
            if (F == null) {
                F = new bt1();
            }
            String B = F.B("type");
            if (M(F, "type")) {
                this.c = S(B);
            } else {
                this.c = 1;
            }
            if (this.c == 0) {
                R("createRecommendationButton failed,parameter error: the 'type' is invalid.");
                return false;
            }
            if (M(F, "style")) {
                bt1 w = F.w("style");
                if (w == null) {
                    R("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                } else if (!P(w)) {
                    R("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                    return false;
                }
            }
            if (g) {
                Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
            }
            this.a = new q44(this.c, this.style, this);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean P(bt1 bt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bt1Var)) == null) {
            if (bt1Var == null) {
                return true;
            }
            try {
                if (M(bt1Var, "left")) {
                    this.style.left = (float) bt1Var.c("left");
                }
                if (M(bt1Var, "top")) {
                    this.style.top = (float) bt1Var.c("top");
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public final void Q(RecommendItemModel recommendItemModel, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, recommendItemModel, str) == null) || recommendItemModel == null || TextUtils.isEmpty(recommendItemModel.appKey) || TextUtils.isEmpty(recommendItemModel.scheme)) {
            return;
        }
        e44.d(this.c, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(n34.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.b.d(this.c, str, recommendItemModel.appKey);
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f.throwJSException(JSExceptionType.Error, str);
            L();
        }
    }

    public final int S(@Nullable String str) {
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

    @Override // com.repackage.tf3
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            L();
        }
    }

    @Override // com.repackage.a44.b
    @UiThread
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.d(this.c, "list", c44.b);
        }
    }

    @Override // com.repackage.z34
    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            L();
            n34.e(this);
        }
    }

    @Override // com.repackage.tf3
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m(false);
        }
    }

    @Override // com.repackage.z34
    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "hide: state-" + this.d);
            }
            if (this.d == RecommendButtonState.SHOW) {
                this.d = RecommendButtonState.HIDE;
                this.a.hide();
            }
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
            e44.b(this.c, new a(this));
        }
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && N()) {
            this.a.m(z);
        }
    }

    @Override // com.repackage.tf3
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            m(true);
        }
    }

    @Override // com.repackage.a44.b
    @UiThread
    public void p() {
        i44 i44Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (i44Var = this.e) == null) {
            return;
        }
        Q(i44Var.a, "game_center");
    }

    @Override // com.repackage.z34
    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (g) {
                Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
            }
            if (this.d == RecommendButtonState.HIDE) {
                this.d = RecommendButtonState.SHOW;
                oe3.e0(new b(this));
                this.a.show();
            }
        }
    }

    @Override // com.repackage.a44.b
    @UiThread
    public void v(int i) {
        i44 i44Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || (i44Var = this.e) == null || i < 0 || i >= i44Var.b.size()) {
            return;
        }
        Q(this.e.b.get(i), "game");
    }
}
