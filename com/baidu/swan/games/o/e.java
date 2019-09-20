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
    private com.baidu.swan.games.e.b bft;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.bft = bVar;
        SK();
        SL();
    }

    private boolean SK() {
        return bf(com.baidu.swan.games.i.a.bd(com.baidu.swan.apps.w.e.GJ().Gs(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean SL() {
        String Gs = com.baidu.swan.apps.w.e.GJ().Gs();
        String SO = f.SM().SO();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Gs);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + SO);
        }
        return bf(Gs, SO);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.bft.RJ().RV();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.bft.RL().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bf(String str, String str2) {
        if (!f.SM().SN() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.bft.RJ().aV(str, str2);
        return true;
    }
}
