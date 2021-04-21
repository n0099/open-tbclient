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
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.g.k0.i.b.a;
import d.b.h0.g.k0.i.b.d;
import d.b.h0.g.k0.i.b.e;
import java.util.Locale;
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements d.a, a.b, d.b.h0.g.k0.i.a, d.b.h0.g.k0.a {
    public static final boolean k = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.g.k0.i.b.b f12605e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.k0.i.b.c f12606f;

    /* renamed from: g  reason: collision with root package name */
    public int f12607g;

    /* renamed from: h  reason: collision with root package name */
    public RecommendButtonState f12608h;
    public d.b.h0.g.k0.i.e.a i;
    public d.b.h0.g.i.b j;
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
            if (RecommendButtonApiProxy.this.f12608h == RecommendButtonState.DESTROYED) {
                return;
            }
            RecommendButtonApiProxy.this.f12608h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.L(String.format("RecommendationButton.load failed,%s", str));
        }

        @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.c
        public void b(String str) {
            d.b.h0.g.k0.i.e.c c2 = d.b.h0.g.k0.i.e.b.c(str);
            if (RecommendButtonApiProxy.k) {
                Log.d("RecommendButtonApiProxy", "load: onSuccess-" + c2.a());
            }
            if (RecommendButtonApiProxy.this.f12608h == RecommendButtonState.DESTROYED) {
                return;
            }
            if (c2.a()) {
                RecommendButtonApiProxy.this.f12608h = RecommendButtonState.HIDE;
                RecommendButtonApiProxy.this.i = d.b.h0.g.k0.i.e.b.b(c2.f49027c);
                RecommendButtonApiProxy.this.f12605e.h(RecommendButtonApiProxy.this.i);
                RecommendButtonApiProxy.this.M();
                return;
            }
            RecommendButtonApiProxy.this.f12608h = RecommendButtonState.IDLE;
            RecommendButtonApiProxy.this.L(String.format("RecommendationButton.load failed,%s", c2.f49026b));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecommendButtonApiProxy.this.f12606f.e(RecommendButtonApiProxy.this.f12607g, RecommendButtonApiProxy.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class c extends StringResponseCallback {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f12612e;

            public a(String str) {
                this.f12612e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(this.f12612e);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Exception f12614e;

            public b(Exception exc) {
                this.f12614e = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.f12614e.getMessage());
            }
        }

        public c() {
        }

        public abstract void a(String str);

        public abstract void b(String str);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: c */
        public void onSuccess(String str, int i) {
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

    public RecommendButtonApiProxy(d.b.h0.g.i.b bVar, JsObject jsObject) {
        super(bVar);
        this.f12606f = new d.b.h0.g.k0.i.b.c();
        this.style = new d();
        this.j = bVar;
        if (Q(jsObject)) {
            d.b.h0.g.k0.c.c(this);
        }
    }

    public final void L(String str) {
        d.b.h0.g.e.d.b bVar = new d.b.h0.g.e.d.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent("error", bVar));
    }

    public final void M() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    public final void N() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.f12608h);
        }
        RecommendButtonState recommendButtonState = this.f12608h;
        RecommendButtonState recommendButtonState2 = RecommendButtonState.DESTROYED;
        if (recommendButtonState == recommendButtonState2) {
            return;
        }
        this.f12608h = recommendButtonState2;
        d.b.h0.g.k0.i.b.b bVar = this.f12605e;
        if (bVar != null) {
            bVar.destroy();
        }
        this.i = null;
    }

    public final boolean O(d.b.h0.g.e.d.c cVar, String str) {
        int i = cVar != null ? cVar.i(str) : 12;
        return (i == 12 || i == 11) ? false : true;
    }

    public final boolean P() {
        RecommendButtonState recommendButtonState = this.f12608h;
        return recommendButtonState == RecommendButtonState.HIDE || recommendButtonState == RecommendButtonState.SHOW;
    }

    public final boolean Q(JsObject jsObject) {
        this.f12608h = RecommendButtonState.IDLE;
        this.style.b(this);
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (F == null) {
            F = new d.b.h0.g.e.d.c();
        }
        String B = F.B("type");
        if (O(F, "type")) {
            this.f12607g = U(B);
        } else {
            this.f12607g = 1;
        }
        if (this.f12607g == 0) {
            T("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (O(F, "style")) {
            d.b.h0.g.e.d.c w = F.w("style");
            if (w == null) {
                T("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!R(w)) {
                T("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (k) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.f12605e = new d.b.h0.g.k0.i.g.a(this.f12607g, this.style, this);
        return true;
    }

    public final boolean R(d.b.h0.g.e.d.c cVar) {
        if (cVar == null) {
            return true;
        }
        try {
            if (O(cVar, CustomDialogData.POS_LEFT)) {
                this.style.left = (float) cVar.c(CustomDialogData.POS_LEFT);
            }
            if (O(cVar, "top")) {
                this.style.top = (float) cVar.c("top");
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @UiThread
    public final void S(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel == null || TextUtils.isEmpty(recommendItemModel.appKey) || TextUtils.isEmpty(recommendItemModel.scheme)) {
            return;
        }
        e.d(this.f12607g, recommendItemModel.appKey);
        SchemeRouter.invokeScheme(d.b.h0.g.k0.c.b(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
        this.f12606f.d(this.f12607g, str, recommendItemModel.appKey);
    }

    public final void T(String str) {
        this.j.throwJSException(JSExceptionType.Error, str);
        N();
    }

    public final int U(@Nullable String str) {
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

    @Override // d.b.h0.g.k0.i.b.a.b
    @UiThread
    public void c() {
        d.b.h0.g.k0.i.e.a aVar = this.i;
        if (aVar != null) {
            S(aVar.f49023a, "game_center");
        }
    }

    @Override // d.b.h0.g.k0.i.b.a.b
    @UiThread
    public void d() {
        this.f12606f.d(this.f12607g, "list", d.b.h0.g.k0.i.b.c.f49011b);
    }

    @Override // d.b.h0.g.k0.i.a
    @JavascriptInterface
    public void destroy() {
        N();
        d.b.h0.g.k0.c.e(this);
    }

    @Override // d.b.h0.g.k0.a
    public void f() {
        z(false);
    }

    @Override // d.b.h0.g.k0.i.a
    @JavascriptInterface
    public void hide() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.f12608h);
        }
        if (this.f12608h == RecommendButtonState.SHOW) {
            this.f12608h = RecommendButtonState.HIDE;
            this.f12605e.hide();
        }
    }

    @Override // d.b.h0.g.k0.a
    public void k() {
        N();
    }

    @JavascriptInterface
    public void load() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.f12608h);
        }
        if (this.f12608h != RecommendButtonState.IDLE) {
            return;
        }
        this.f12608h = RecommendButtonState.LOADING;
        e.b(this.f12607g, new a());
    }

    @Override // d.b.h0.g.k0.a
    public void q() {
        z(true);
    }

    @Override // d.b.h0.g.k0.i.b.a.b
    @UiThread
    public void s(int i) {
        d.b.h0.g.k0.i.e.a aVar = this.i;
        if (aVar == null || i < 0 || i >= aVar.f49024b.size()) {
            return;
        }
        S(this.i.f49024b.get(i), "game");
    }

    @Override // d.b.h0.g.k0.i.a
    @JavascriptInterface
    public void show() {
        if (k) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.f12608h);
        }
        if (this.f12608h == RecommendButtonState.HIDE) {
            this.f12608h = RecommendButtonState.SHOW;
            k0.X(new b());
            this.f12605e.show();
        }
    }

    public final void z(boolean z) {
        if (P()) {
            this.f12605e.z(z);
        }
    }
}
