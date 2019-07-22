package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.recommend.a, a.InterfaceC0215a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b beU;
    private com.baidu.swan.games.view.recommend.d.b bmC;
    private com.baidu.swan.games.view.recommend.a.b bnh;
    private c bni;
    private int bnj;
    private RecommendButtonState bnk;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        com.baidu.swan.games.view.recommend.b AO;
        this.bni = new c();
        this.style = new d();
        this.beU = bVar;
        if (p(jsObject) && (AO = AO()) != null) {
            AO.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.bnk);
        }
        if (this.bnk == RecommendButtonState.IDLE) {
            this.bnk = RecommendButtonState.LOADING;
            e.a(this.bnj, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.d.d kf = com.baidu.swan.games.view.recommend.d.c.kf(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + kf.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.bnk != RecommendButtonState.DESTROYED) {
                        if (kf.isSuccess()) {
                            RecommendButtonApiProxy.this.bnk = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.bmC = com.baidu.swan.games.view.recommend.d.c.az(kf.data);
                            RecommendButtonApiProxy.this.bnh.a(RecommendButtonApiProxy.this.bmC);
                            RecommendButtonApiProxy.this.Uo();
                            return;
                        }
                        RecommendButtonApiProxy.this.bnk = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.ki(String.format("RecommendationButton.load failed,%s", kf.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.bnk != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.bnk = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.ki(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.bnk);
        }
        if (Un()) {
            this.bnk = RecommendButtonState.SHOW;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.bni.a(RecommendButtonApiProxy.this.bnj, RecommendButtonApiProxy.this.bmC);
                }
            });
            this.bnh.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.bnk);
        }
        if (Un()) {
            this.bnk = RecommendButtonState.HIDE;
            this.bnh.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        Um();
        com.baidu.swan.games.view.recommend.b AO = AO();
        if (AO != null) {
            AO.b(this);
        }
    }

    public void Um() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.bnk);
        }
        if (this.bnk != RecommendButtonState.DESTROYED) {
            this.bnk = RecommendButtonState.DESTROYED;
            if (this.bnh != null) {
                this.bnh.destroy();
            }
            this.bmC = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void iK(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bnk + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.bnk == RecommendButtonState.SHOW) {
            this.bnh.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0215a
    @UiThread
    public void fm(int i) {
        if (this.bmC != null && i >= 0 && i < this.bmC.bng.size()) {
            a(this.bmC.bng.get(i), "game");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0215a
    @UiThread
    public void Uf() {
        if (this.bmC != null) {
            a(this.bmC.bnf, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0215a
    @UiThread
    public void Ug() {
        this.bni.f(this.bnj, IntentConfig.LIST, c.bmJ);
    }

    public void by(boolean z) {
        if (Un()) {
            this.bnh.by(z);
        }
    }

    private com.baidu.swan.games.view.recommend.b AO() {
        com.baidu.swan.apps.core.d.e vJ;
        SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
        if (Gr == null || (vJ = Gr.vJ()) == null) {
            return null;
        }
        h hVar = (h) vJ.k(h.class);
        if (hVar != null) {
            return hVar.AO();
        }
        return null;
    }

    private boolean p(JsObject jsObject) {
        this.bnk = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (c(c, "type")) {
            this.bnj = kg(optString);
        } else {
            this.bnj = 1;
        }
        if (this.bnj == 0) {
            kh("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (c(c, UnitedSchemeConstants.UNITED_SCHEME_STYLE)) {
            JsObject iZ = c.iZ(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (iZ == null) {
                kh("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!q(iZ)) {
                kh("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.bnh = new com.baidu.swan.games.view.recommend.proxy.a(this.bnj, this.style, this);
        return true;
    }

    private boolean q(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            return true;
        }
        try {
            if (c(c, CustomDialogData.POS_LEFT)) {
                this.style.left = (float) c.getDouble(CustomDialogData.POS_LEFT);
            }
            if (c(c, "top")) {
                this.style.top = (float) c.getDouble("top");
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean c(com.baidu.swan.games.binding.model.c cVar, String str) {
        int iT = cVar != null ? cVar.iT(str) : 12;
        return (iT == 12 || iT == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int kg(@Nullable String str) {
        boolean z;
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.CHINA);
        switch (lowerCase.hashCode()) {
            case 2908512:
                if (lowerCase.equals("carousel")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 3322014:
                if (lowerCase.equals(IntentConfig.LIST)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return 1;
            case true:
                return 2;
            default:
                return 0;
        }
    }

    @UiThread
    private void a(com.baidu.swan.games.view.recommend.d.a aVar, String str) {
        if (aVar != null && !TextUtils.isEmpty(aVar.appKey) && !TextUtils.isEmpty(aVar.scheme)) {
            e.x(this.bnj, aVar.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.a.Tx(), Uri.parse(aVar.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.bni.f(this.bnj, str, aVar.appKey);
        }
    }

    private boolean Un() {
        return this.bnk == RecommendButtonState.HIDE || this.bnk == RecommendButtonState.SHOW;
    }

    private void kh(String str) {
        this.beU.throwJSException(JSExceptionType.Error, str);
        Um();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent("error", bVar));
    }

    /* loaded from: classes2.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.beU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.beU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
