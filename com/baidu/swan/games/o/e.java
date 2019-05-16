package com.baidu.swan.games.o;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b beh;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.beh = bVar;
        RN();
        RO();
    }

    private boolean RN() {
        return bf(com.baidu.swan.games.i.a.bd(com.baidu.swan.apps.w.e.FV().FE(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean RO() {
        String FE = com.baidu.swan.apps.w.e.FV().FE();
        String RR = f.RP().RR();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + FE);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + RR);
        }
        return bf(FE, RR);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.beh.QM().QY();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.beh.QO().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bf(String str, String str2) {
        if (!f.RP().RQ() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.beh.QM().aV(str, str2);
        return true;
    }
}
