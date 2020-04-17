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
    private com.baidu.swan.apps.jsbridge.a bWt;
    private com.baidu.swan.apps.jsbridge.a bWu;
    private SwanAppUtilsJavaScriptInterface bWv;
    private com.baidu.swan.apps.api.a bWw;

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
        this.bWv = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bWv.setSource("swan_");
        aVar.addJavascriptInterface(this.bWv, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.bWv.setForceShareLight(true);
    }

    private void b(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        this.bWt = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.bWt, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bWu = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.bWu, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.bWw = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
        this.bWw.a(aVar);
    }

    private void c(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context) {
        this.bWv = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.bWv.setSource("swan_");
        aVar.addJavascriptInterface(this.bWv, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    public void D(Activity activity) {
        if (this.bWt != null) {
            this.bWt.setActivityRef(activity);
        }
        if (this.bWu != null) {
            this.bWu.setActivityRef(activity);
        }
        if (this.bWv != null) {
            this.bWv.setActivity(activity);
        }
        if (this.bWw != null) {
            this.bWw.setActivityRef(activity);
        }
    }
}
