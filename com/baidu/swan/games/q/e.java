package com.baidu.swan.games.q;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.e.b cfI;

    public e(com.baidu.swan.games.e.b bVar) {
        this.cfI = bVar;
        amr();
        ams();
    }

    private boolean amr() {
        return bI(this.cfI.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean ams() {
        String TN = com.baidu.swan.apps.y.f.Uf().TN();
        String amv = f.amt().amv();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + TN);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + amv);
        }
        return bI(TN, amv);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cfI.akL().akY();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cfI.akO().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bI(String str, String str2) {
        if (!f.amt().amu() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cfI.akL().bv(str, str2);
        return true;
    }
}
