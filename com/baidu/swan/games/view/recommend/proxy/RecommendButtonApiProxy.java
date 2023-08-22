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
import com.baidu.tieba.af4;
import com.baidu.tieba.cq3;
import com.baidu.tieba.je4;
import com.baidu.tieba.k32;
import com.baidu.tieba.ke4;
import com.baidu.tieba.le4;
import com.baidu.tieba.m54;
import com.baidu.tieba.me4;
import com.baidu.tieba.ne4;
import com.baidu.tieba.ni2;
import com.baidu.tieba.nr1;
import com.baidu.tieba.oe4;
import com.baidu.tieba.se4;
import com.baidu.tieba.te4;
import com.baidu.tieba.ue4;
import com.baidu.tieba.xd4;
import com.baidu.tieba.xo3;
import java.util.Locale;
/* loaded from: classes4.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements ne4.a, ke4.b, je4, cq3 {
    public static final boolean g = nr1.a;
    public le4 a;
    public me4 b;
    public int c;
    public RecommendButtonState d;
    public se4 e;
    public ni2 f;
    @V8JavascriptField
    public final ne4 style;

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
            ue4 c = te4.c(str);
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
            }
            if (RecommendButtonApiProxy.this.d == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c.a()) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.e = te4.b(c.c);
                RecommendButtonApiProxy.this.a.d(RecommendButtonApiProxy.this.e);
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
        le4 le4Var = this.a;
        if (le4Var != null) {
            le4Var.destroy();
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

    @Override // com.baidu.tieba.ke4.b
    @UiThread
    public void b() {
        this.b.d(this.c, "list", me4.b);
    }

    @Override // com.baidu.tieba.je4
    @JavascriptInterface
    public void destroy() {
        J();
        xd4.e(this);
    }

    @Override // com.baidu.tieba.cq3
    public void e() {
        m(false);
    }

    @Override // com.baidu.tieba.je4
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

    @Override // com.baidu.tieba.cq3
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
        oe4.b(this.c, new a());
    }

    @Override // com.baidu.tieba.ke4.b
    @UiThread
    public void o() {
        se4 se4Var = this.e;
        if (se4Var != null) {
            O(se4Var.a, "game_center");
        }
    }

    @Override // com.baidu.tieba.cq3
    public void onViewDestroy() {
        J();
    }

    public RecommendButtonApiProxy(ni2 ni2Var, JsObject jsObject) {
        super(ni2Var);
        this.b = new me4();
        this.style = new ne4();
        this.f = ni2Var;
        if (M(jsObject)) {
            xd4.c(this);
        }
    }

    public final boolean K(k32 k32Var, String str) {
        int i;
        if (k32Var != null) {
            i = k32Var.getType(str);
        } else {
            i = 12;
        }
        if (i != 12 && i != 11) {
            return true;
        }
        return false;
    }

    public final void H(String str) {
        m54 m54Var = new m54();
        m54Var.errMsg = str;
        dispatchEvent(new JSEvent("error", m54Var));
    }

    public final boolean N(k32 k32Var) {
        if (k32Var == null) {
            return true;
        }
        try {
            if (K(k32Var, "left")) {
                this.style.left = (float) k32Var.c("left");
            }
            if (K(k32Var, "top")) {
                this.style.top = (float) k32Var.c("top");
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

    @Override // com.baidu.tieba.ke4.b
    @UiThread
    public void u(int i) {
        se4 se4Var = this.e;
        if (se4Var != null && i >= 0 && i < se4Var.b.size()) {
            O(this.e.b.get(i), "game");
        }
    }

    public final boolean M(JsObject jsObject) {
        this.d = RecommendButtonState.IDLE;
        this.style.b(this);
        k32 F = k32.F(jsObject);
        if (F == null) {
            F = new k32();
        }
        String B = F.B("type");
        if (K(F, "type")) {
            this.c = Q(B);
        } else {
            this.c = 1;
        }
        if (this.c == 0) {
            P("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (K(F, "style")) {
            k32 w = F.w("style");
            if (w == null) {
                P("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!N(w)) {
                P("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (g) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.a = new af4(this.c, this.style, this);
        return true;
    }

    @UiThread
    public final void O(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            oe4.d(this.c, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(xd4.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
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

    @Override // com.baidu.tieba.je4
    @JavascriptInterface
    public void show() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
        }
        if (this.d == RecommendButtonState.HIDE) {
            this.d = RecommendButtonState.SHOW;
            xo3.e0(new b());
            this.a.show();
        }
    }
}
