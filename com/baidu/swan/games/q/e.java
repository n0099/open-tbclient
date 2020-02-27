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
    private com.baidu.swan.games.e.b cjZ;

    public e(com.baidu.swan.games.e.b bVar) {
        this.cjZ = bVar;
        aoX();
        aoY();
    }

    private boolean aoX() {
        return bS(this.cjZ.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aoY() {
        String Wy = com.baidu.swan.apps.y.f.WQ().Wy();
        String apb = f.aoZ().apb();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Wy);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + apb);
        }
        return bS(Wy, apb);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cjZ.ans().anE();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cjZ.anv().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bS(String str, String str2) {
        if (!f.aoZ().apa() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cjZ.ans().bF(str, str2);
        return true;
    }
}
