package com.baidu.swan.mini.master;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.b;
import com.baidu.swan.mini.a.a.c;
@Keep
/* loaded from: classes7.dex */
public class SwanMiniMasterJsInterface {
    private static final boolean DEBUG = b.DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "___NA_SWAN_MINI___";
    private String mInstanceId;
    private com.baidu.swan.mini.a mMiniRuntime;

    public SwanMiniMasterJsInterface(@NonNull com.baidu.swan.mini.a aVar, @NonNull String str) {
        this.mMiniRuntime = aVar;
        this.mInstanceId = str;
    }

    @JavascriptInterface
    public void printLog(String str) {
        if (DEBUG) {
            Log.v("SwanMiniRuntime", "Master == printLog(" + str + ")");
        }
        this.mMiniRuntime.b(true, this.mInstanceId, str);
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2) {
        if (DEBUG) {
            Log.v("SwanMiniRuntime", "Master == sendMessage(" + str + ", " + str2 + ")");
        }
        this.mMiniRuntime.cL(str, str2);
    }

    @JavascriptInterface
    public c request(JsObject jsObject) {
        c cVar = null;
        if (DEBUG) {
            Log.v("SwanMiniRuntime", "Master == request(jsObj) called");
        }
        if (jsObject == null) {
            if (DEBUG) {
                Log.e("SwanMiniRuntime", "Master == request: null param");
            }
        } else {
            a uf = this.mMiniRuntime.uf(this.mInstanceId);
            if (uf == null) {
                if (DEBUG) {
                    Log.e("SwanMiniRuntime", "Master == request: null master");
                }
            } else {
                com.baidu.swan.games.f.a v8Engine = uf.getV8Engine();
                if (v8Engine == null) {
                    if (DEBUG) {
                        Log.e("SwanMiniRuntime", "Master == request: master type error");
                    }
                } else {
                    cVar = new c(v8Engine, com.baidu.swan.games.binding.model.c.e(jsObject));
                    cVar.start();
                    if (DEBUG) {
                        Log.v("SwanMiniRuntime", "Master == request stated");
                    }
                }
            }
        }
        return cVar;
    }
}
