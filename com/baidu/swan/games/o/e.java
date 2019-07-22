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
    private com.baidu.swan.games.e.b beU;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.beU = bVar;
        SG();
        SH();
    }

    private boolean SG() {
        return bf(com.baidu.swan.games.i.a.bd(com.baidu.swan.apps.w.e.GF().Go(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean SH() {
        String Go = com.baidu.swan.apps.w.e.GF().Go();
        String SK = f.SI().SK();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Go);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + SK);
        }
        return bf(Go, SK);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.beU.RF().RR();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.beU.RH().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bf(String str, String str2) {
        if (!f.SI().SJ() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.beU.RF().aV(str, str2);
        return true;
    }
}
