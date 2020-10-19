package com.baidu.swan.games.r;

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
    private com.baidu.swan.games.f.b dCG;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dCG = bVar;
        aSe();
        aSf();
    }

    private boolean aSe() {
        return db(this.dCG.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aSf() {
        String avb = com.baidu.swan.apps.v.f.avu().avb();
        String aSi = f.aSg().aSi();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + avb);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aSi);
        }
        return db(avb, aSi);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dCG.aQt().aQF();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dCG.aQw().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean db(String str, String str2) {
        if (!f.aSg().aSh() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dCG.aQt().cO(str, str2);
        return true;
    }
}
