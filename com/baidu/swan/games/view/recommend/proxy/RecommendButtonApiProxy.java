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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.h.o0.g.b.a;
import d.a.l0.h.o0.g.b.d;
import d.a.l0.h.o0.g.b.e;
import java.util.Locale;
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d.a, a.b, d.a.l0.h.o0.g.a, d.a.l0.a.w2.c {
    public static final boolean k = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.h.o0.g.b.b f11745e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.o0.g.b.c f11746f;

    /* renamed from: g  reason: collision with root package name */
    public int f11747g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendButtonState f11748h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.h.o0.g.e.a f11749i;
    public d.a.l0.a.l0.c j;
    @V8JavascriptField
    public final d style;

    /* loaded from: classes3.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    /* loaded from: classes3.dex */
    public class a extends c {
        public a() {
            super(RecommendButtonApiProxy.this, null);
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void a(String str) {
            if (RecommendButtonApiProxy.k) {
                Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
            }
            if (RecommendButtonApiProxy.this.f11748h == RecommendButtonState.DESTROYED) {
                return;
            }
            RecommendButtonApiProxy.this.f11748h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.K(String.format("RecommendationButton.load failed,%s", str));
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            d.a.l0.h.o0.g.e.c c2 = d.a.l0.h.o0.g.e.b.c(str);
            if (RecommendButtonApiProxy.k) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c2.a());
            }
            if (RecommendButtonApiProxy.this.f11748h == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c2.a()) {
                RecommendButtonApiProxy.this.f11748h = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.f11749i = d.a.l0.h.o0.g.e.b.b(c2.f47610c);
                RecommendButtonApiProxy.this.f11745e.d(RecommendButtonApiProxy.this.f11749i);
                RecommendButtonApiProxy.this.L();
                return;
            }
            RecommendButtonApiProxy.this.f11748h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.K(String.format("RecommendationButton.load failed,%s", c2.f47609b));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendButtonApiProxy.this.f11746f.e(RecommendButtonApiProxy.this.f11747g, RecommendButtonApiProxy.this.f11749i);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c extends StringResponseCallback {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11753e;

            public a(String str) {
                this.f11753e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(this.f11753e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f11755e;

            public b(Exception exc) {
                this.f11755e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f11755e.getMessage());
            }
        }

        public c() {
        }

        public abstract void a(String str);

        public abstract void b(String str);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: c */
        public void onSuccess(String str, int i2) {
            RecommendButtonApiProxy.this.j.runOnJSThread(new a(str));
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            RecommendButtonApiProxy.this.j.runOnJSThread(new b(exc));
        }

        public /* synthetic */ c(RecommendButtonApiProxy recommendButtonApiProxy, a aVar) {
            this();
        }
    }

    public RecommendButtonApiProxy(d.a.l0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        this.f11746f = new d.a.l0.h.o0.g.b.c();
        this.style = new d();
        this.j = cVar;
        if (P(jsObject)) {
            d.a.l0.h.o0.b.c(this);
        }
    }

    public final void K(String str) {
        d.a.l0.h.d.c.b bVar = new d.a.l0.h.d.c.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent("error", bVar));
    }

    public final void L() {
        dispatchEvent(new JSEvent("load"));
    }

    public final void M() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.f11748h);
        }
        RecommendButtonState recommendButtonState = this.f11748h;
        RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
        if (recommendButtonState == recommendButtonState2) {
            return;
        }
        this.f11748h = recommendButtonState2;
        d.a.l0.h.o0.g.b.b bVar = this.f11745e;
        if (bVar != null) {
            bVar.destroy();
        }
        this.f11749i = null;
    }

    public final boolean N(d.a.l0.a.y.b.a aVar, String str) {
        int i2 = aVar != null ? aVar.i(str) : 12;
        return (i2 == 12 || i2 == 11) ? false : true;
    }

    public final boolean O() {
        RecommendButtonState recommendButtonState = this.f11748h;
        return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
    }

    public final boolean P(JsObject jsObject) {
        this.f11748h = RecommendButtonState.IDLE;
        this.style.b(this);
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (G == null) {
            G = new d.a.l0.a.y.b.a();
        }
        String C = G.C("type");
        if (N(G, "type")) {
            this.f11747g = T(C);
        } else {
            this.f11747g = 1;
        }
        if (this.f11747g == 0) {
            S("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (N(G, "style")) {
            d.a.l0.a.y.b.a x = G.x("style");
            if (x == null) {
                S("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!Q(x)) {
                S("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (k) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.f11745e = new d.a.l0.h.o0.g.g.a(this.f11747g, this.style, this);
        return true;
    }

    public final boolean Q(d.a.l0.a.y.b.a aVar) {
        if (aVar == null) {
            return true;
        }
        try {
            if (N(aVar, CustomDialogData.POS_LEFT)) {
                this.style.left = (float) aVar.c(CustomDialogData.POS_LEFT);
            }
            if (N(aVar, "top")) {
                this.style.top = (float) aVar.c("top");
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @UiThread
    public final void R(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel == null || TextUtils.isEmpty(recommendItemModel.appKey) || TextUtils.isEmpty(recommendItemModel.scheme)) {
            return;
        }
        e.d(this.f11747g, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(d.a.l0.h.o0.b.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.f11746f.d(this.f11747g, str, recommendItemModel.appKey);
    }

    public final void S(String str) {
        this.j.throwJSException(JSExceptionType.Error, str);
        M();
    }

    public final int T(@Nullable String str) {
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

    @Override // d.a.l0.h.o0.g.b.a.b
    @UiThread
    public void b() {
        this.f11746f.d(this.f11747g, "list", d.a.l0.h.o0.g.b.c.f47594b);
    }

    @Override // d.a.l0.h.o0.g.a
    @JavascriptInterface
    public void destroy() {
        M();
        d.a.l0.h.o0.b.e(this);
    }

    @Override // d.a.l0.a.w2.c
    public void f() {
        m(false);
    }

    @Override // d.a.l0.h.o0.g.a
    @JavascriptInterface
    public void hide() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.f11748h);
        }
        if (this.f11748h == RecommendButtonState.SHOW) {
            this.f11748h = RecommendButtonState.HIDE;
            this.f11745e.hide();
        }
    }

    @Override // d.a.l0.a.w2.c
    public void k() {
        M();
    }

    @JavascriptInterface
    public void load() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.f11748h);
        }
        if (this.f11748h != RecommendButtonState.IDLE) {
            return;
        }
        this.f11748h = RecommendButtonState.LOADING;
        e.b(this.f11747g, new a());
    }

    public final void m(boolean z) {
        if (O()) {
            this.f11745e.m(z);
        }
    }

    @Override // d.a.l0.a.w2.c
    public void n() {
        m(true);
    }

    @Override // d.a.l0.h.o0.g.b.a.b
    @UiThread
    public void p() {
        d.a.l0.h.o0.g.e.a aVar = this.f11749i;
        if (aVar != null) {
            R(aVar.f47606a, "game_center");
        }
    }

    @Override // d.a.l0.h.o0.g.a
    @JavascriptInterface
    public void show() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.f11748h);
        }
        if (this.f11748h == RecommendButtonState.HIDE) {
            this.f11748h = RecommendButtonState.SHOW;
            q0.b0(new b());
            this.f11745e.show();
        }
    }

    @Override // d.a.l0.h.o0.g.b.a.b
    @UiThread
    public void v(int i2) {
        d.a.l0.h.o0.g.e.a aVar = this.f11749i;
        if (aVar == null || i2 < 0 || i2 >= aVar.f47607b.size()) {
            return;
        }
        R(this.f11749i.f47607b.get(i2), "game");
    }
}
