package com.baidu.swan.games.n;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b bad;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.bad = bVar;
        OI();
        OJ();
    }

    private boolean OI() {
        return bd(com.baidu.swan.games.i.a.ba(com.baidu.swan.apps.w.e.Ea().DJ(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean OJ() {
        String DJ = com.baidu.swan.apps.w.e.Ea().DJ();
        String ON = f.OK().ON();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + DJ);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + ON);
        }
        return bd(DJ, ON);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.bad.NS().Od();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.bad.NU().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bd(String str, String str2) {
        if (!f.OK().OL() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.bad.NS().aS(str, str2);
        return true;
    }
}
