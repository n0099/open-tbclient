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
    private com.baidu.swan.apps.jsbridge.a bWA;
    private SwanAppUtilsJavaScriptInterface bWB;
    private com.baidu.swan.apps.api.a bWC;
    private com.baidu.swan.apps.jsbridge.a bWz;

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
        this.bWB = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bWB.setSource("swan_");
        aVar.addJavascriptInterface(this.bWB, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.bWB.setForceShareLight(true);
    }

    private void b(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        this.bWz = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.bWz, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bWA = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.bWA, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bWC = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
        this.bWC.a(aVar);
    }

    private void c(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context) {
        this.bWB = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bWB.setSource("swan_");
        aVar.addJavascriptInterface(this.bWB, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void D(Activity activity) {
        if (this.bWz != null) {
            this.bWz.setActivityRef(activity);
        }
        if (this.bWA != null) {
            this.bWA.setActivityRef(activity);
        }
        if (this.bWB != null) {
            this.bWB.setActivity(activity);
        }
        if (this.bWC != null) {
            this.bWC.setActivityRef(activity);
        }
    }
}
