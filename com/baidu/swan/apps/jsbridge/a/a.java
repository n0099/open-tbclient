package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a clN;
    private com.baidu.swan.apps.jsbridge.a clO;
    private SwanAppUtilsJavaScriptInterface clP;
    private com.baidu.swan.apps.api.a clQ;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.clQ = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.clQ);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.clQ);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.clP = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.clP.setSource("swan_");
        aVar.addJavascriptInterface(this.clP, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.clP.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.clN = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.clN, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.clO = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.clO, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.clP = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.clP.setSource("swan_");
        aVar.addJavascriptInterface(this.clP, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void E(Activity activity) {
        if (this.clN != null) {
            this.clN.setActivityRef(activity);
        }
        if (this.clO != null) {
            this.clO.setActivityRef(activity);
        }
        if (this.clP != null) {
            this.clP.setActivity(activity);
        }
        if (this.clQ != null) {
            this.clQ.setActivityRef(activity);
        }
    }
}
