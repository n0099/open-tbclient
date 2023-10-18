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
import com.baidu.tieba.a94;
import com.baidu.tieba.am1;
import com.baidu.tieba.e94;
import com.baidu.tieba.f94;
import com.baidu.tieba.g94;
import com.baidu.tieba.j84;
import com.baidu.tieba.jj3;
import com.baidu.tieba.m94;
import com.baidu.tieba.ok3;
import com.baidu.tieba.v84;
import com.baidu.tieba.w84;
import com.baidu.tieba.x84;
import com.baidu.tieba.xx1;
import com.baidu.tieba.y84;
import com.baidu.tieba.yz3;
import com.baidu.tieba.z84;
import com.baidu.tieba.zc2;
import java.util.Locale;
/* loaded from: classes4.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements z84.a, w84.b, v84, ok3 {
    public static final boolean g = am1.a;
    public x84 a;
    public y84 b;
    public int c;
    public RecommendButtonState d;
    public e94 e;
    public zc2 f;
    @V8JavascriptField
    public final z84 style;

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
            g94 c = f94.c(str);
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
            }
            if (RecommendButtonApiProxy.this.d == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c.a()) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.e = f94.b(c.c);
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
        x84 x84Var = this.a;
        if (x84Var != null) {
            x84Var.destroy();
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

    @Override // com.baidu.tieba.w84.b
    @UiThread
    public void b() {
        this.b.d(this.c, "list", y84.b);
    }

    @Override // com.baidu.tieba.ok3
    public void d() {
        m(false);
    }

    @Override // com.baidu.tieba.v84
    @JavascriptInterface
    public void destroy() {
        J();
        j84.e(this);
    }

    @Override // com.baidu.tieba.v84
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

    @Override // com.baidu.tieba.ok3
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
        a94.b(this.c, new a());
    }

    @Override // com.baidu.tieba.w84.b
    @UiThread
    public void o() {
        e94 e94Var = this.e;
        if (e94Var != null) {
            O(e94Var.a, "game_center");
        }
    }

    @Override // com.baidu.tieba.ok3
    public void onViewDestroy() {
        J();
    }

    public RecommendButtonApiProxy(zc2 zc2Var, JsObject jsObject) {
        super(zc2Var);
        this.b = new y84();
        this.style = new z84();
        this.f = zc2Var;
        if (M(jsObject)) {
            j84.c(this);
        }
    }

    public final boolean K(xx1 xx1Var, String str) {
        int i;
        if (xx1Var != null) {
            i = xx1Var.i(str);
        } else {
            i = 12;
        }
        if (i != 12 && i != 11) {
            return true;
        }
        return false;
    }

    public final void H(String str) {
        yz3 yz3Var = new yz3();
        yz3Var.errMsg = str;
        dispatchEvent(new JSEvent("error", yz3Var));
    }

    public final boolean N(xx1 xx1Var) {
        if (xx1Var == null) {
            return true;
        }
        try {
            if (K(xx1Var, "left")) {
                this.style.left = (float) xx1Var.c("left");
            }
            if (K(xx1Var, "top")) {
                this.style.top = (float) xx1Var.c("top");
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

    @Override // com.baidu.tieba.w84.b
    @UiThread
    public void u(int i) {
        e94 e94Var = this.e;
        if (e94Var != null && i >= 0 && i < e94Var.b.size()) {
            O(this.e.b.get(i), "game");
        }
    }

    public final boolean M(JsObject jsObject) {
        this.d = RecommendButtonState.IDLE;
        this.style.b(this);
        xx1 G = xx1.G(jsObject);
        if (G == null) {
            G = new xx1();
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
            xx1 x = G.x("style");
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
        this.a = new m94(this.c, this.style, this);
        return true;
    }

    @UiThread
    public final void O(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            a94.d(this.c, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(j84.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
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

    @Override // com.baidu.tieba.v84
    @JavascriptInterface
    public void show() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
        }
        if (this.d == RecommendButtonState.HIDE) {
            this.d = RecommendButtonState.SHOW;
            jj3.e0(new b());
            this.a.show();
        }
    }
}
