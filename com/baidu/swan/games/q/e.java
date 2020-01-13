package com.baidu.swan.games.q;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.e.b cfV;

    public e(com.baidu.swan.games.e.b bVar) {
        this.cfV = bVar;
        amK();
        amL();
    }

    private boolean amK() {
        return bJ(this.cfV.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean amL() {
        String Uk = com.baidu.swan.apps.y.f.UC().Uk();
        String amO = f.amM().amO();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Uk);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + amO);
        }
        return bJ(Uk, amO);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cfV.ale().alr();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cfV.alh().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bJ(String str, String str2) {
        if (!f.amM().amN() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cfV.ale().bw(str, str2);
        return true;
    }
}
