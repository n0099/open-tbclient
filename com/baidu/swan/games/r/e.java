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
    private com.baidu.swan.games.f.b cTU;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.f.b bVar) {
        this.cTU = bVar;
        aBg();
        aBh();
    }

    private boolean aBg() {
        return cx(this.cTU.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aBh() {
        String ahC = com.baidu.swan.apps.w.f.ahV().ahC();
        String aBk = f.aBi().aBk();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + ahC);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aBk);
        }
        return cx(ahC, aBk);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cTU.azz().azL();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cTU.azC().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cx(String str, String str2) {
        if (!f.aBi().aBj() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cTU.azz().ck(str, str2);
        return true;
    }
}
