package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b cYE;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.f.b bVar) {
        this.cYE = bVar;
        aCm();
        aCn();
    }

    private boolean aCm() {
        return cz(this.cYE.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aCn() {
        String aiI = com.baidu.swan.apps.w.f.ajb().aiI();
        String aCq = f.aCo().aCq();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + aiI);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aCq);
        }
        return cz(aiI, aCq);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cYE.aAF().aAR();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cYE.aAI().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cz(String str, String str2) {
        if (!f.aCo().aCp() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cYE.aAF().cm(str, str2);
        return true;
    }
}
