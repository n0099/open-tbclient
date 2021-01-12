package com.baidu.swan.games.view.webview;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.webview.b;
/* loaded from: classes8.dex */
public class a extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g elW;
    private C0534a elX;
    private volatile String mCurrentUrl;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            u(BdStatsConstant.StatsType.ERROR, ds(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("url", null);
        if (!xt(optString)) {
            u(BdStatsConstant.StatsType.ERROR, ds(optString, PayHelper.STATUS_SUCC));
        } else if (!com.baidu.swan.apps.af.a.b.rE(optString)) {
            u(BdStatsConstant.StatsType.ERROR, ds(optString, PayHelper.STATUS_FAIL));
        } else {
            if (DEBUG) {
                Log.i("GameWebViewApi", "open:" + optString);
            }
            this.mCurrentUrl = optString;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.elW == null) {
                        a.this.aZS();
                    }
                    if (!a.this.elW.aip()) {
                        a.this.elW.aiF();
                    }
                    a.this.elW.loadUrl(optString);
                    a.this.u("open", new b.a(optString));
                }
            });
        }
    }

    @JavascriptInterface
    public void close() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.elW != null && a.this.elW.aip()) {
                    a.this.elW.aiG();
                    a.this.elW.destroy();
                    a.this.elW = null;
                    a.this.u("close", new b.a(a.this.mCurrentUrl));
                }
            }
        });
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            u(BdStatsConstant.StatsType.ERROR, ds(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("setCloseViewVisibility", null);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.elW != null) {
                    if (TextUtils.equals("1", optString)) {
                        a.this.elW.eL(true);
                    } else {
                        a.this.elW.eL(false);
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            String optString = e.optString("gameId");
            String optString2 = e.optString("gameName");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                com.baidu.swan.games.utils.b.a(e, false, null);
                return;
            }
            this.elX = new C0534a(optString, optString2, System.currentTimeMillis());
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.elX);
            }
            com.baidu.swan.games.utils.b.a(e, true, null);
        }
    }

    public void onGameLoadingFinish() {
        if (this.elX == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        e aIs = e.aIs();
        if (aIs == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.elX.emc = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.elX);
        }
        c.a(aIs, this.elX);
        this.elX = null;
    }

    private boolean xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZS() {
        if (this.elW == null) {
            this.elW = d.arG().arH().cm(com.baidu.swan.apps.t.a.awy());
            this.elW.setOnCloseListener(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.close();
                }
            });
        }
    }

    private b.C0535b ds(String str, @NonNull String str2) {
        char c = 65535;
        switch (str2.hashCode()) {
            case 1507424:
                if (str2.equals(PayHelper.STATUS_SUCC)) {
                    c = 0;
                    break;
                }
                break;
            case 1507425:
                if (str2.equals(PayHelper.STATUS_FAIL)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new b.C0535b(str, str2, "open:url is invalid");
            case 1:
                return new b.C0535b(str, str2, "open:host not in white list");
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public static a aZT() {
        com.baidu.swan.games.f.a aWp = com.baidu.swan.games.j.a.aWo().aWp();
        if (aWp == null) {
            return null;
        }
        EventTarget aVN = aWp.aVN();
        if (aVN instanceof com.baidu.swan.games.binding.c) {
            return ((com.baidu.swan.games.binding.c) aVN).getWebViewManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0534a {
        String ema;
        long emb;
        long emc;
        String mGameId;

        private C0534a(String str, String str2, long j) {
            this.mGameId = str;
            this.ema = str2;
            this.emb = j;
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.mGameId + "', mGameName='" + this.ema + "', mStartLoadingTimestamp=" + this.emb + ", mFinishLoadingTimestamp=" + this.emc + '}';
        }
    }
}
