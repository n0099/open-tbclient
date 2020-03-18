package com.baidu.swan.games.q;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.e.b ckm;

    public e(com.baidu.swan.games.e.b bVar) {
        this.ckm = bVar;
        apc();
        apd();
    }

    private boolean apc() {
        return bR(this.ckm.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean apd() {
        String WD = com.baidu.swan.apps.y.f.WV().WD();
        String apg = f.ape().apg();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + WD);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + apg);
        }
        return bR(WD, apg);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.ckm.anx().anJ();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.ckm.anA().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bR(String str, String str2) {
        if (!f.ape().apf() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.ckm.anx().bE(str, str2);
        return true;
    }
}
