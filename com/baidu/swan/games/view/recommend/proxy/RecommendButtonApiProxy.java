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
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import d.a.i0.h.o0.g.b.a;
import d.a.i0.h.o0.g.b.d;
import d.a.i0.h.o0.g.b.e;
import java.util.Locale;
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d.a, a.b, d.a.i0.h.o0.g.a, d.a.i0.a.w2.c {
    public static final boolean k = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.h.o0.g.b.b f11844e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.h.o0.g.b.c f11845f;

    /* renamed from: g  reason: collision with root package name */
    public int f11846g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendButtonState f11847h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.h.o0.g.e.a f11848i;
    public d.a.i0.a.l0.c j;
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
            if (RecommendButtonApiProxy.this.f11847h == RecommendButtonState.DESTROYED) {
                return;
            }
            RecommendButtonApiProxy.this.f11847h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.K(String.format("RecommendationButton.load failed,%s", str));
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            d.a.i0.h.o0.g.e.c c2 = d.a.i0.h.o0.g.e.b.c(str);
            if (RecommendButtonApiProxy.k) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c2.a());
            }
            if (RecommendButtonApiProxy.this.f11847h == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c2.a()) {
                RecommendButtonApiProxy.this.f11847h = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.f11848i = d.a.i0.h.o0.g.e.b.b(c2.f47434c);
                RecommendButtonApiProxy.this.f11844e.d(RecommendButtonApiProxy.this.f11848i);
                RecommendButtonApiProxy.this.L();
                return;
            }
            RecommendButtonApiProxy.this.f11847h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.K(String.format("RecommendationButton.load failed,%s", c2.f47433b));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendButtonApiProxy.this.f11845f.e(RecommendButtonApiProxy.this.f11846g, RecommendButtonApiProxy.this.f11848i);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c extends StringResponseCallback {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11852e;

            public a(String str) {
                this.f11852e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(this.f11852e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f11854e;

            public b(Exception exc) {
                this.f11854e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f11854e.getMessage());
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

    public RecommendButtonApiProxy(d.a.i0.a.l0.c cVar, JsObject jsObject) {
        super(cVar);
        this.f11845f = new d.a.i0.h.o0.g.b.c();
        this.style = new d();
        this.j = cVar;
        if (P(jsObject)) {
            d.a.i0.h.o0.b.c(this);
        }
    }

    public final void K(String str) {
        d.a.i0.h.d.c.b bVar = new d.a.i0.h.d.c.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent("error", bVar));
    }

    public final void L() {
        dispatchEvent(new JSEvent("load"));
    }

    public final void M() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.f11847h);
        }
        RecommendButtonState recommendButtonState = this.f11847h;
        RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
        if (recommendButtonState == recommendButtonState2) {
            return;
        }
        this.f11847h = recommendButtonState2;
        d.a.i0.h.o0.g.b.b bVar = this.f11844e;
        if (bVar != null) {
            bVar.destroy();
        }
        this.f11848i = null;
    }

    public final boolean N(d.a.i0.a.y.b.a aVar, String str) {
        int i2 = aVar != null ? aVar.i(str) : 12;
        return (i2 == 12 || i2 == 11) ? false : true;
    }

    public final boolean O() {
        RecommendButtonState recommendButtonState = this.f11847h;
        return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
    }

    public final boolean P(JsObject jsObject) {
        this.f11847h = RecommendButtonState.IDLE;
        this.style.b(this);
        d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
        if (G == null) {
            G = new d.a.i0.a.y.b.a();
        }
        String C = G.C("type");
        if (N(G, "type")) {
            this.f11846g = T(C);
        } else {
            this.f11846g = 1;
        }
        if (this.f11846g == 0) {
            S("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (N(G, "style")) {
            d.a.i0.a.y.b.a x = G.x("style");
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
        this.f11844e = new d.a.i0.h.o0.g.g.a(this.f11846g, this.style, this);
        return true;
    }

    public final boolean Q(d.a.i0.a.y.b.a aVar) {
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
        e.d(this.f11846g, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(d.a.i0.h.o0.b.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.f11845f.d(this.f11846g, str, recommendItemModel.appKey);
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

    @Override // d.a.i0.h.o0.g.b.a.b
    @UiThread
    public void b() {
        this.f11845f.d(this.f11846g, "list", d.a.i0.h.o0.g.b.c.f47418b);
    }

    @Override // d.a.i0.h.o0.g.a
    @JavascriptInterface
    public void destroy() {
        M();
        d.a.i0.h.o0.b.e(this);
    }

    @Override // d.a.i0.a.w2.c
    public void f() {
        m(false);
    }

    @Override // d.a.i0.h.o0.g.a
    @JavascriptInterface
    public void hide() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.f11847h);
        }
        if (this.f11847h == RecommendButtonState.SHOW) {
            this.f11847h = RecommendButtonState.HIDE;
            this.f11844e.hide();
        }
    }

    @Override // d.a.i0.a.w2.c
    public void k() {
        M();
    }

    @JavascriptInterface
    public void load() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.f11847h);
        }
        if (this.f11847h != RecommendButtonState.IDLE) {
            return;
        }
        this.f11847h = RecommendButtonState.LOADING;
        e.b(this.f11846g, new a());
    }

    public final void m(boolean z) {
        if (O()) {
            this.f11844e.m(z);
        }
    }

    @Override // d.a.i0.a.w2.c
    public void n() {
        m(true);
    }

    @Override // d.a.i0.h.o0.g.b.a.b
    @UiThread
    public void p() {
        d.a.i0.h.o0.g.e.a aVar = this.f11848i;
        if (aVar != null) {
            R(aVar.f47430a, "game_center");
        }
    }

    @Override // d.a.i0.h.o0.g.a
    @JavascriptInterface
    public void show() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.f11847h);
        }
        if (this.f11847h == RecommendButtonState.HIDE) {
            this.f11847h = RecommendButtonState.SHOW;
            q0.b0(new b());
            this.f11844e.show();
        }
    }

    @Override // d.a.i0.h.o0.g.b.a.b
    @UiThread
    public void v(int i2) {
        d.a.i0.h.o0.g.e.a aVar = this.f11848i;
        if (aVar == null || i2 < 0 || i2 >= aVar.f47431b.size()) {
            return;
        }
        R(this.f11848i.f47431b.get(i2), "game");
    }
}
