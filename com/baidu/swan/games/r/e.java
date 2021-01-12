package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b eaw;

    public e(com.baidu.swan.games.f.b bVar) {
        this.eaw = bVar;
        aXw();
        aXx();
    }

    private boolean aXw() {
        return dm(this.eaw.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aXx() {
        String azu = com.baidu.swan.apps.v.f.azN().azu();
        String aXA = f.aXy().aXA();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + azu);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aXA);
        }
        return dm(azu, aXA);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.eaw.aVL().aVX();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.eaw.aVO().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dm(String str, String str2) {
        if (!f.aXy().aXz() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.eaw.aVL().cZ(str, str2);
        return true;
    }
}
