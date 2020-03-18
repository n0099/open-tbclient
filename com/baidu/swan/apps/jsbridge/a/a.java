package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a byn;
    private com.baidu.swan.apps.jsbridge.a byo;
    private SwanAppUtilsJavaScriptInterface byp;
    private com.baidu.swan.apps.api.a byq;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            b(aVar, context, callbackHandler, unitedSchemeMainDispatcher);
            if (aVar instanceof com.baidu.swan.games.e.b) {
                a(aVar, context);
            } else {
                c(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.byp = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.byp.setSource("swan_");
        aVar.addJavascriptInterface(this.byp, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.byp.setForceShareLight(true);
    }

    private void b(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        this.byn = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.byn, "Bdbox_android_jsbridge");
        this.byo = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.byo, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.byq = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
        this.byq.a(aVar);
    }

    private void c(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context) {
        this.byp = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.byp.setSource("swan_");
        aVar.addJavascriptInterface(this.byp, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void H(Activity activity) {
        if (this.byn != null) {
            this.byn.setActivityRef(activity);
        }
        if (this.byo != null) {
            this.byo.setActivityRef(activity);
        }
        if (this.byp != null) {
            this.byp.setActivity(activity);
        }
        if (this.byq != null) {
            this.byq.setActivityRef(activity);
        }
    }
}
