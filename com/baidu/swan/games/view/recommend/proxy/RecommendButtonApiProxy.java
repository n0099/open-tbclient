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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.recommend.a, a.InterfaceC0229a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b bft;
    private com.baidu.swan.games.view.recommend.a.b bnF;
    private c bnG;
    private int bnH;
    private RecommendButtonState bnI;
    private com.baidu.swan.games.view.recommend.d.b bna;
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
        com.baidu.swan.games.view.recommend.b AS;
        this.bnG = new c();
        this.style = new d();
        this.bft = bVar;
        if (p(jsObject) && (AS = AS()) != null) {
            AS.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.bnI);
        }
        if (this.bnI == RecommendButtonState.IDLE) {
            this.bnI = RecommendButtonState.LOADING;
            e.a(this.bnH, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.d.d kh = com.baidu.swan.games.view.recommend.d.c.kh(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + kh.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.bnI != RecommendButtonState.DESTROYED) {
                        if (kh.isSuccess()) {
                            RecommendButtonApiProxy.this.bnI = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.bna = com.baidu.swan.games.view.recommend.d.c.az(kh.data);
                            RecommendButtonApiProxy.this.bnF.a(RecommendButtonApiProxy.this.bna);
                            RecommendButtonApiProxy.this.Us();
                            return;
                        }
                        RecommendButtonApiProxy.this.bnI = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kk(String.format("RecommendationButton.load failed,%s", kh.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.bnI != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.bnI = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kk(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.bnI);
        }
        if (Ur()) {
            this.bnI = RecommendButtonState.SHOW;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.bnG.a(RecommendButtonApiProxy.this.bnH, RecommendButtonApiProxy.this.bna);
                }
            });
            this.bnF.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.bnI);
        }
        if (Ur()) {
            this.bnI = RecommendButtonState.HIDE;
            this.bnF.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        Uq();
        com.baidu.swan.games.view.recommend.b AS = AS();
        if (AS != null) {
            AS.b(this);
        }
    }

    public void Uq() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.bnI);
        }
        if (this.bnI != RecommendButtonState.DESTROYED) {
            this.bnI = RecommendButtonState.DESTROYED;
            if (this.bnF != null) {
                this.bnF.destroy();
            }
            this.bna = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void iM(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bnI + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.bnI == RecommendButtonState.SHOW) {
            this.bnF.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0229a
    @UiThread
    public void fn(int i) {
        if (this.bna != null && i >= 0 && i < this.bna.bnE.size()) {
            a(this.bna.bnE.get(i), "game");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0229a
    @UiThread
    public void Uj() {
        if (this.bna != null) {
            a(this.bna.bnD, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0229a
    @UiThread
    public void Uk() {
        this.bnG.g(this.bnH, IntentConfig.LIST, c.bnh);
    }

    public void by(boolean z) {
        if (Ur()) {
            this.bnF.by(z);
        }
    }

    private com.baidu.swan.games.view.recommend.b AS() {
        com.baidu.swan.apps.core.d.e vN;
        SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
        if (Gv == null || (vN = Gv.vN()) == null) {
            return null;
        }
        h hVar = (h) vN.k(h.class);
        if (hVar != null) {
            return hVar.AS();
        }
        return null;
    }

    private boolean p(JsObject jsObject) {
        this.bnI = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (c(c, "type")) {
            this.bnH = ki(optString);
        } else {
            this.bnH = 1;
        }
        if (this.bnH == 0) {
            kj("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (c(c, UnitedSchemeConstants.UNITED_SCHEME_STYLE)) {
            JsObject jb = c.jb(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (jb == null) {
                kj("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!q(jb)) {
                kj("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.bnF = new com.baidu.swan.games.view.recommend.proxy.a(this.bnH, this.style, this);
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
        int iV = cVar != null ? cVar.iV(str) : 12;
        return (iV == 12 || iV == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int ki(@Nullable String str) {
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
            e.x(this.bnH, aVar.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.a.TB(), Uri.parse(aVar.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.bnG.g(this.bnH, str, aVar.appKey);
        }
    }

    private boolean Ur() {
        return this.bnI == RecommendButtonState.HIDE || this.bnI == RecommendButtonState.SHOW;
    }

    private void kj(String str) {
        this.bft.throwJSException(JSExceptionType.Error, str);
        Uq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Us() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(String str) {
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
            RecommendButtonApiProxy.this.bft.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.bft.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
