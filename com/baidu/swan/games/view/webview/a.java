package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.webview.b;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class a extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cUg;
    private C0384a cUh;
    private volatile String mCurrentUrl;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            t(BdStatsConstant.StatsType.ERROR, ci(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = c.optString("url", null);
        if (!rl(optString)) {
            t(BdStatsConstant.StatsType.ERROR, ci(optString, PayHelper.STATUS_SUCC));
        } else if (!com.baidu.swan.apps.aj.a.b.mt(optString)) {
            t(BdStatsConstant.StatsType.ERROR, ci(optString, PayHelper.STATUS_FAIL));
        } else {
            if (DEBUG) {
                Log.i("GameWebViewApi", "open:" + optString);
            }
            this.mCurrentUrl = optString;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cUg == null) {
                        a.this.azB();
                    }
                    if (!a.this.cUg.Qw()) {
                        a.this.cUg.QJ();
                    }
                    a.this.cUg.loadUrl(optString);
                    a.this.t("open", new b.a(optString));
                }
            });
        }
    }

    @JavascriptInterface
    public void close() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cUg != null && a.this.cUg.Qw()) {
                    a.this.cUg.QK();
                    a.this.cUg.destroy();
                    a.this.cUg = null;
                    a.this.t("close", new b.a(a.this.mCurrentUrl));
                }
            }
        });
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            t(BdStatsConstant.StatsType.ERROR, ci(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = c.optString("setCloseViewVisibility", null);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cUg != null) {
                    if (TextUtils.equals("1", optString)) {
                        a.this.cUg.cU(true);
                    } else {
                        a.this.cUg.cU(false);
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            String optString = c.optString("gameId");
            String optString2 = c.optString("gameName");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                com.baidu.swan.games.utils.b.a(c, false, null);
                return;
            }
            this.cUh = new C0384a(optString, optString2, System.currentTimeMillis());
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.cUh);
            }
            com.baidu.swan.games.utils.b.a(c, true, null);
        }
    }

    public void onGameLoadingFinish() {
        if (this.cUh == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        e akO = e.akO();
        if (akO == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.cUh.cUl = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.cUh);
        }
        c.a(akO, this.cUh);
        this.cUh = null;
    }

    private boolean rl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azB() {
        if (this.cUg == null) {
            this.cUg = d.Yo().Yp().bn(com.baidu.swan.apps.w.a.abO());
            this.cUg.d(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.close();
                }
            });
        }
    }

    private b.C0385b ci(String str, @NonNull String str2) {
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
                return new b.C0385b(str, str2, "open:url is invalid");
            case 1:
                return new b.C0385b(str, str2, "open:host not in white list");
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public static a azC() {
        com.baidu.swan.games.e.a awp = com.baidu.swan.games.i.a.awo().awp();
        if (awp == null) {
            return null;
        }
        EventTarget avM = awp.avM();
        if (avM instanceof com.baidu.swan.games.binding.c) {
            return ((com.baidu.swan.games.binding.c) avM).getWebViewManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0384a {
        long cUk;
        long cUl;
        String mGameId;
        String mGameName;

        private C0384a(String str, String str2, long j) {
            this.mGameId = str;
            this.mGameName = str2;
            this.cUk = j;
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.mGameId + "', mGameName='" + this.mGameName + "', mStartLoadingTimestamp=" + this.cUk + ", mFinishLoadingTimestamp=" + this.cUl + '}';
        }
    }
}
