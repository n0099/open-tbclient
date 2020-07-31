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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.webview.b;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public class a extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dpT;
    private C0464a dpU;
    private volatile String mCurrentUrl;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            w(BdStatsConstant.StatsType.ERROR, cI(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("url", null);
        if (!ua(optString)) {
            w(BdStatsConstant.StatsType.ERROR, cI(optString, PayHelper.STATUS_SUCC));
        } else if (!com.baidu.swan.apps.ah.a.b.oG(optString)) {
            w(BdStatsConstant.StatsType.ERROR, cI(optString, PayHelper.STATUS_FAIL));
        } else {
            if (DEBUG) {
                Log.i("GameWebViewApi", "open:" + optString);
            }
            this.mCurrentUrl = optString;
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dpT == null) {
                        a.this.aIq();
                    }
                    if (!a.this.dpT.UG()) {
                        a.this.dpT.UU();
                    }
                    a.this.dpT.loadUrl(optString);
                    a.this.w("open", new b.a(optString));
                }
            });
        }
    }

    @JavascriptInterface
    public void close() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpT != null && a.this.dpT.UG()) {
                    a.this.dpT.UV();
                    a.this.dpT.destroy();
                    a.this.dpT = null;
                    a.this.w("close", new b.a(a.this.mCurrentUrl));
                }
            }
        });
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            w(BdStatsConstant.StatsType.ERROR, cI(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("setCloseViewVisibility", null);
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dpT != null) {
                    if (TextUtils.equals("1", optString)) {
                        a.this.dpT.dp(true);
                    } else {
                        a.this.dpT.dp(false);
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
            this.dpU = new C0464a(optString, optString2, System.currentTimeMillis());
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.dpU);
            }
            com.baidu.swan.games.utils.b.a(e, true, null);
        }
    }

    public void onGameLoadingFinish() {
        if (this.dpU == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        e arw = e.arw();
        if (arw == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.dpU.dpY = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.dpU);
        }
        c.a(arw, this.dpU);
        this.dpU = null;
    }

    private boolean ua(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIq() {
        if (this.dpT == null) {
            this.dpT = d.adw().adx().bo(com.baidu.swan.apps.t.a.ahj());
            this.dpT.d(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.close();
                }
            });
        }
    }

    private b.C0465b cI(String str, @NonNull String str2) {
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
                return new b.C0465b(str, str2, "open:url is invalid");
            case 1:
                return new b.C0465b(str, str2, "open:host not in white list");
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public static a aIr() {
        com.baidu.swan.games.f.a aEP = com.baidu.swan.games.j.a.aEO().aEP();
        if (aEP == null) {
            return null;
        }
        EventTarget aEm = aEP.aEm();
        if (aEm instanceof com.baidu.swan.games.binding.c) {
            return ((com.baidu.swan.games.binding.c) aEm).getWebViewManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0464a {
        long dpX;
        long dpY;
        String mGameId;
        String mGameName;

        private C0464a(String str, String str2, long j) {
            this.mGameId = str;
            this.mGameName = str2;
            this.dpX = j;
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.mGameId + "', mGameName='" + this.mGameName + "', mStartLoadingTimestamp=" + this.dpX + ", mFinishLoadingTimestamp=" + this.dpY + '}';
        }
    }
}
