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
import com.baidu.tieba.a02;
import com.baidu.tieba.ab4;
import com.baidu.tieba.bb4;
import com.baidu.tieba.c24;
import com.baidu.tieba.cb4;
import com.baidu.tieba.db4;
import com.baidu.tieba.df2;
import com.baidu.tieba.do1;
import com.baidu.tieba.eb4;
import com.baidu.tieba.ib4;
import com.baidu.tieba.jb4;
import com.baidu.tieba.kb4;
import com.baidu.tieba.na4;
import com.baidu.tieba.nl3;
import com.baidu.tieba.qb4;
import com.baidu.tieba.sm3;
import com.baidu.tieba.za4;
import java.util.Locale;
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements db4.a, ab4.b, za4, sm3 {
    public static final boolean g = do1.a;
    public bb4 a;
    public cb4 b;
    public int c;
    public RecommendButtonState d;
    public ib4 e;
    public df2 f;
    @V8JavascriptField
    public final db4 style;

    /* loaded from: classes3.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    /* loaded from: classes3.dex */
    public abstract class c extends StringResponseCallback {
        public abstract void a(String str);

        public abstract void b(String str);

        /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
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
        /* renamed from: c */
        public void onSuccess(String str, int i) {
            RecommendButtonApiProxy.this.f.runOnJSThread(new a(str));
        }
    }

    /* loaded from: classes3.dex */
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
                RecommendButtonApiProxy.this.I(String.format("RecommendationButton.load failed,%s", str));
            }
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            kb4 c = jb4.c(str);
            if (RecommendButtonApiProxy.g) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c.a());
            }
            if (RecommendButtonApiProxy.this.d == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c.a()) {
                RecommendButtonApiProxy.this.d = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.e = jb4.b(c.c);
                RecommendButtonApiProxy.this.a.d(RecommendButtonApiProxy.this.e);
                RecommendButtonApiProxy.this.J();
                return;
            }
            RecommendButtonApiProxy.this.d = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.I(String.format("RecommendationButton.load failed,%s", c.b));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendButtonApiProxy.this.b.e(RecommendButtonApiProxy.this.c, RecommendButtonApiProxy.this.e);
        }
    }

    public final void J() {
        dispatchEvent(new JSEvent("load"));
    }

    public final void K() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.d);
        }
        RecommendButtonState recommendButtonState = this.d;
        RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
        if (recommendButtonState == recommendButtonState2) {
            return;
        }
        this.d = recommendButtonState2;
        bb4 bb4Var = this.a;
        if (bb4Var != null) {
            bb4Var.destroy();
        }
        this.e = null;
    }

    public final boolean M() {
        RecommendButtonState recommendButtonState = this.d;
        if (recommendButtonState != RecommendButtonState.HIDE && recommendButtonState != RecommendButtonState.SHOW) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.ab4.b
    @UiThread
    public void b() {
        this.b.d(this.c, "list", cb4.b);
    }

    @Override // com.baidu.tieba.za4
    @JavascriptInterface
    public void destroy() {
        K();
        na4.e(this);
    }

    @Override // com.baidu.tieba.sm3
    public void e() {
        m(false);
    }

    @Override // com.baidu.tieba.za4
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

    @Override // com.baidu.tieba.sm3
    public void l() {
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
        eb4.b(this.c, new a());
    }

    @Override // com.baidu.tieba.ab4.b
    @UiThread
    public void o() {
        ib4 ib4Var = this.e;
        if (ib4Var != null) {
            P(ib4Var.a, "game_center");
        }
    }

    @Override // com.baidu.tieba.sm3
    public void onViewDestroy() {
        K();
    }

    public RecommendButtonApiProxy(df2 df2Var, JsObject jsObject) {
        super(df2Var);
        this.b = new cb4();
        this.style = new db4();
        this.f = df2Var;
        if (N(jsObject)) {
            na4.c(this);
        }
    }

    public final boolean L(a02 a02Var, String str) {
        int i;
        if (a02Var != null) {
            i = a02Var.getType(str);
        } else {
            i = 12;
        }
        if (i != 12 && i != 11) {
            return true;
        }
        return false;
    }

    public final void I(String str) {
        c24 c24Var = new c24();
        c24Var.errMsg = str;
        dispatchEvent(new JSEvent("error", c24Var));
    }

    public final boolean O(a02 a02Var) {
        if (a02Var == null) {
            return true;
        }
        try {
            if (L(a02Var, "left")) {
                this.style.left = (float) a02Var.c("left");
            }
            if (L(a02Var, "top")) {
                this.style.top = (float) a02Var.c("top");
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void Q(String str) {
        this.f.throwJSException(JSExceptionType.Error, str);
        K();
    }

    public final void m(boolean z) {
        if (M()) {
            this.a.m(z);
        }
    }

    @Override // com.baidu.tieba.ab4.b
    @UiThread
    public void u(int i) {
        ib4 ib4Var = this.e;
        if (ib4Var != null && i >= 0 && i < ib4Var.b.size()) {
            P(this.e.b.get(i), "game");
        }
    }

    public final boolean N(JsObject jsObject) {
        this.d = RecommendButtonState.IDLE;
        this.style.b(this);
        a02 F = a02.F(jsObject);
        if (F == null) {
            F = new a02();
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
            a02 w = F.w("style");
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
        this.a = new qb4(this.c, this.style, this);
        return true;
    }

    @UiThread
    public final void P(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            eb4.d(this.c, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(na4.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.b.d(this.c, str, recommendItemModel.appKey);
        }
    }

    public final int R(@Nullable String str) {
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

    @Override // com.baidu.tieba.za4
    @JavascriptInterface
    public void show() {
        if (g) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.d);
        }
        if (this.d == RecommendButtonState.HIDE) {
            this.d = RecommendButtonState.SHOW;
            nl3.e0(new b());
            this.a.show();
        }
    }
}
