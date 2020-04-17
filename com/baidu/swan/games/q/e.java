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
    private com.baidu.swan.games.e.b cJh;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.cJh = bVar;
        axp();
        axq();
    }

    private boolean axp() {
        return cc(this.cJh.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean axq() {
        String aes = com.baidu.swan.apps.y.f.aeK().aes();
        String axt = f.axr().axt();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + aes);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + axt);
        }
        return cc(aes, axt);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cJh.avK().avW();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cJh.avN().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cc(String str, String str2) {
        if (!f.axr().axs() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cJh.avK().bP(str, str2);
        return true;
    }
}
