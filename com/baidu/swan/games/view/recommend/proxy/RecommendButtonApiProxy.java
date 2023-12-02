package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.tieba.aa4;
import com.baidu.tieba.ba4;
import com.baidu.tieba.e94;
import com.baidu.tieba.ek3;
import com.baidu.tieba.ha4;
import com.baidu.tieba.jl3;
import com.baidu.tieba.q94;
import com.baidu.tieba.r94;
import com.baidu.tieba.s94;
import com.baidu.tieba.sy1;
import com.baidu.tieba.t04;
import com.baidu.tieba.t94;
import com.baidu.tieba.u94;
import com.baidu.tieba.ud2;
import com.baidu.tieba.v94;
import com.baidu.tieba.vm1;
import com.baidu.tieba.z94;
import java.util.Locale;
/* loaded from: classes4.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements u94.a, r94.b, q94, jl3 {
    public static final boolean g = vm1.a;
    public s94 a;
    public t94 b;
    public int c;
    public RecommendButtonState d;
    public z94 e;
    public ud2 f;
    @V8JavascriptField
    public final u94 style;

    /* loaded from: classes4.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    /* loaded from: classes4.dex */
    public abstract class c extends StringResponseCallback {
        public abstract void a(String str);

        public abstract void b(String str);

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(this.a);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public final /* synthetic */ Exception a;

            public b(Exception exc) {
                this.a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.a.getMessage());
            }
        }

        public c() {
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            RecommendButtonApiProxy.this.f.runOnJSThread(new b(exc));
        }

        public /* synthetic */ c(RecommendButtonApiProxy recommendButtonApiProxy, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            RecommendButtonApiProxy.this.f.runOnJSThread(new a(str));
        }
    }

    /* loaded from: classes4.dex */
    public class a extends c {
        public a() {
            super(RecommendButtonApiProxy.this, null);
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void a(String str) {
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
            }
            if (RecommendButtonApiProxy.this.d != RecommendButtonState.DESTROYED) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.IDLE;
                RecommendButtonApiProxy.this.H(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            ba4 c = aa4.c(str);
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
            }
            if (RecommendButtonApiProxy.this.d == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c.a()) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.e = aa4.b(c.c);
                RecommendButtonApiProxy.this.a.e(RecommendButtonApiProxy.this.e);
                RecommendButtonApiProxy.this.I();
                return;
            }
            RecommendButtonApiProxy.this.d = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.H(String.format("RecommendationButton.load failed,%s", c.b));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendButtonApiProxy.this.b.e(RecommendButtonApiProxy.this.c, RecommendButtonApiProxy.this.e);
        }
    }

    public final void I() {
        dispatchEvent(new JSEvent("load"));
    }

    public final void J() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.d);
        }
        RecommendButtonState recommendButtonState = this.d;
        RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
        if (recommendButtonState == recommendButtonState2) {
            return;
        }
        this.d = recommendButtonState2;
        s94 s94Var = this.a;
        if (s94Var != null) {
            s94Var.destroy();
        }
        this.e = null;
    }

    public final boolean L() {
        RecommendButtonState recommendButtonState = this.d;
        if (recommendButtonState != RecommendButtonState.HIDE && recommendButtonState != RecommendButtonState.SHOW) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.r94.b
    @UiThread
    public void b() {
        this.b.d(this.c, "list", t94.b);
    }

    @Override // com.baidu.tieba.jl3
    public void d() {
        m(false);
    }

    @Override // com.baidu.tieba.q94
    @JavascriptInterface
    public void destroy() {
        J();
        e94.e(this);
    }

    @Override // com.baidu.tieba.q94
    @JavascriptInterface
    public void hide() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.d);
        }
        if (this.d == RecommendButtonState.SHOW) {
            this.d = RecommendButtonState.HIDE;
            this.a.hide();
        }
    }

    @Override // com.baidu.tieba.jl3
    public void k() {
        m(true);
    }

    @JavascriptInterface
    public void load() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.d);
        }
        if (this.d != RecommendButtonState.IDLE) {
            return;
        }
        this.d = RecommendButtonState.LOADING;
        v94.b(this.c, new a());
    }

    @Override // com.baidu.tieba.r94.b
    @UiThread
    public void o() {
        z94 z94Var = this.e;
        if (z94Var != null) {
            O(z94Var.a, "game_center");
        }
    }

    @Override // com.baidu.tieba.jl3
    public void onViewDestroy() {
        J();
    }

    public RecommendButtonApiProxy(ud2 ud2Var, JsObject jsObject) {
        super(ud2Var);
        this.b = new t94();
        this.style = new u94();
        this.f = ud2Var;
        if (M(jsObject)) {
            e94.c(this);
        }
    }

    public final boolean K(sy1 sy1Var, String str) {
        int i;
        if (sy1Var != null) {
            i = sy1Var.i(str);
        } else {
            i = 12;
        }
        if (i != 12 && i != 11) {
            return true;
        }
        return false;
    }

    public final void H(String str) {
        t04 t04Var = new t04();
        t04Var.errMsg = str;
        dispatchEvent(new JSEvent("error", t04Var));
    }

    public final boolean N(sy1 sy1Var) {
        if (sy1Var == null) {
            return true;
        }
        try {
            if (K(sy1Var, "left")) {
                this.style.left = (float) sy1Var.c("left");
            }
            if (K(sy1Var, "top")) {
                this.style.top = (float) sy1Var.c("top");
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void P(String str) {
        this.f.throwJSException(JSExceptionType.Error, str);
        J();
    }

    public final void m(boolean z) {
        if (L()) {
            this.a.m(z);
        }
    }

    @Override // com.baidu.tieba.r94.b
    @UiThread
    public void u(int i) {
        z94 z94Var = this.e;
        if (z94Var != null && i >= 0 && i < z94Var.b.size()) {
            O(this.e.b.get(i), "game");
        }
    }

    public final boolean M(JsObject jsObject) {
        this.d = RecommendButtonState.IDLE;
        this.style.b(this);
        sy1 G = sy1.G(jsObject);
        if (G == null) {
            G = new sy1();
        }
        String C = G.C("type");
        if (K(G, "type")) {
            this.c = Q(C);
        } else {
            this.c = 1;
        }
        if (this.c == 0) {
            P("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (K(G, "style")) {
            sy1 x = G.x("style");
            if (x == null) {
                P("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!N(x)) {
                P("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (g) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.a = new ha4(this.c, this.style, this);
        return true;
    }

    @UiThread
    public final void O(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            v94.d(this.c, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(e94.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.b.d(this.c, str, recommendItemModel.appKey);
        }
    }

    public final int Q(@Nullable String str) {
        String lowerCase;
        if (str == null) {
            lowerCase = "";
        } else {
            lowerCase = str.toLowerCase(Locale.CHINA);
        }
        char c2 = 65535;
        int hashCode = lowerCase.hashCode();
        if (hashCode != 2908512) {
            if (hashCode == 3322014 && lowerCase.equals("list")) {
                c2 = 1;
            }
        } else if (lowerCase.equals("carousel")) {
            c2 = 0;
        }
        if (c2 == 0) {
            return 1;
        }
        if (c2 != 1) {
            return 0;
        }
        return 2;
    }

    @Override // com.baidu.tieba.q94
    @JavascriptInterface
    public void show() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
        }
        if (this.d == RecommendButtonState.HIDE) {
            this.d = RecommendButtonState.SHOW;
            ek3.e0(new b());
            this.a.show();
        }
    }
}
