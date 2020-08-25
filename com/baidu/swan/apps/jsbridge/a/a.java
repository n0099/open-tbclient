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
/* loaded from: classes8.dex */
public class a {
    private SwanAppUtilsJavaScriptInterface cvA;
    private com.baidu.swan.apps.api.a cvB;
    private com.baidu.swan.apps.jsbridge.a cvy;
    private com.baidu.swan.apps.jsbridge.a cvz;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.cvB = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.cvB);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.cvB);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.cvA = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cvA.setSource("swan_");
        aVar.addJavascriptInterface(this.cvA, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.cvA.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cvy = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cvy, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.cvz = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cvz, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cvA = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cvA.setSource("swan_");
        aVar.addJavascriptInterface(this.cvA, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void E(Activity activity) {
        if (this.cvy != null) {
            this.cvy.setActivityRef(activity);
        }
        if (this.cvz != null) {
            this.cvz.setActivityRef(activity);
        }
        if (this.cvA != null) {
            this.cvA.setActivity(activity);
        }
        if (this.cvB != null) {
            this.cvB.setActivityRef(activity);
        }
    }
}
