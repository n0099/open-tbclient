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
/* loaded from: classes10.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a btQ;
    private com.baidu.swan.apps.jsbridge.a btR;
    private SwanAppUtilsJavaScriptInterface btS;
    private com.baidu.swan.apps.api.a btT;

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
        this.btS = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.btS.setSource("swan_");
        aVar.addJavascriptInterface(this.btS, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.btS.setForceShareLight(true);
    }

    private void b(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        this.btQ = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.btQ, "Bdbox_android_jsbridge");
        this.btR = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.btR, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.btT = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
        this.btT.a(aVar);
    }

    private void c(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context) {
        this.btS = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.btS.setSource("swan_");
        aVar.addJavascriptInterface(this.btS, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void G(Activity activity) {
        if (this.btQ != null) {
            this.btQ.setActivityRef(activity);
        }
        if (this.btR != null) {
            this.btR.setActivityRef(activity);
        }
        if (this.btS != null) {
            this.btS.setActivity(activity);
        }
        if (this.btT != null) {
            this.btT.setActivityRef(activity);
        }
    }
}
