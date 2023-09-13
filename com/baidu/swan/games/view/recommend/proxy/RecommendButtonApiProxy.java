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
import com.baidu.tieba.be4;
import com.baidu.tieba.bp3;
import com.baidu.tieba.ef4;
import com.baidu.tieba.gq3;
import com.baidu.tieba.ne4;
import com.baidu.tieba.o32;
import com.baidu.tieba.oe4;
import com.baidu.tieba.pe4;
import com.baidu.tieba.q54;
import com.baidu.tieba.qe4;
import com.baidu.tieba.re4;
import com.baidu.tieba.ri2;
import com.baidu.tieba.rr1;
import com.baidu.tieba.se4;
import com.baidu.tieba.we4;
import com.baidu.tieba.xe4;
import com.baidu.tieba.ye4;
import java.util.Locale;
/* loaded from: classes4.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements re4.a, oe4.b, ne4, gq3 {
    public static final boolean g = rr1.a;
    public pe4 a;
    public qe4 b;
    public int c;
    public RecommendButtonState d;
    public we4 e;
    public ri2 f;
    @V8JavascriptField
    public final re4 style;

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
            ye4 c = xe4.c(str);
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
            }
            if (RecommendButtonApiProxy.this.d == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c.a()) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.e = xe4.b(c.c);
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
        pe4 pe4Var = this.a;
        if (pe4Var != null) {
            pe4Var.destroy();
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

    @Override // com.baidu.tieba.oe4.b
    @UiThread
    public void b() {
        this.b.d(this.c, "list", qe4.b);
    }

    @Override // com.baidu.tieba.gq3
    public void d() {
        m(false);
    }

    @Override // com.baidu.tieba.ne4
    @JavascriptInterface
    public void destroy() {
        J();
        be4.e(this);
    }

    @Override // com.baidu.tieba.ne4
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

    @Override // com.baidu.tieba.gq3
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
        se4.b(this.c, new a());
    }

    @Override // com.baidu.tieba.oe4.b
    @UiThread
    public void o() {
        we4 we4Var = this.e;
        if (we4Var != null) {
            O(we4Var.a, "game_center");
        }
    }

    @Override // com.baidu.tieba.gq3
    public void onViewDestroy() {
        J();
    }

    public RecommendButtonApiProxy(ri2 ri2Var, JsObject jsObject) {
        super(ri2Var);
        this.b = new qe4();
        this.style = new re4();
        this.f = ri2Var;
        if (M(jsObject)) {
            be4.c(this);
        }
    }

    public final boolean K(o32 o32Var, String str) {
        int i;
        if (o32Var != null) {
            i = o32Var.getType(str);
        } else {
            i = 12;
        }
        if (i != 12 && i != 11) {
            return true;
        }
        return false;
    }

    public final void H(String str) {
        q54 q54Var = new q54();
        q54Var.errMsg = str;
        dispatchEvent(new JSEvent("error", q54Var));
    }

    public final boolean N(o32 o32Var) {
        if (o32Var == null) {
            return true;
        }
        try {
            if (K(o32Var, "left")) {
                this.style.left = (float) o32Var.c("left");
            }
            if (K(o32Var, "top")) {
                this.style.top = (float) o32Var.c("top");
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

    @Override // com.baidu.tieba.oe4.b
    @UiThread
    public void u(int i) {
        we4 we4Var = this.e;
        if (we4Var != null && i >= 0 && i < we4Var.b.size()) {
            O(this.e.b.get(i), "game");
        }
    }

    public final boolean M(JsObject jsObject) {
        this.d = RecommendButtonState.IDLE;
        this.style.b(this);
        o32 F = o32.F(jsObject);
        if (F == null) {
            F = new o32();
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
            o32 w = F.w("style");
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
        this.a = new ef4(this.c, this.style, this);
        return true;
    }

    @UiThread
    public final void O(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            se4.d(this.c, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(be4.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
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

    @Override // com.baidu.tieba.ne4
    @JavascriptInterface
    public void show() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
        }
        if (this.d == RecommendButtonState.HIDE) {
            this.d = RecommendButtonState.SHOW;
            bp3.e0(new b());
            this.a.show();
        }
    }
}
