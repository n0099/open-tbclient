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
/* loaded from: classes3.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a cxD;
    private com.baidu.swan.apps.jsbridge.a cxE;
    private SwanAppUtilsJavaScriptInterface cxF;
    private com.baidu.swan.apps.api.a cxG;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.cxG = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.cxG);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.cxG);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.cxF = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cxF.setSource("swan_");
        aVar.addJavascriptInterface(this.cxF, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.cxF.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cxD = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cxD, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.cxE = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.cxE, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.cxF = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.cxF.setSource("swan_");
        aVar.addJavascriptInterface(this.cxF, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void F(Activity activity) {
        if (this.cxD != null) {
            this.cxD.setActivityRef(activity);
        }
        if (this.cxE != null) {
            this.cxE.setActivityRef(activity);
        }
        if (this.cxF != null) {
            this.cxF.setActivity(activity);
        }
        if (this.cxG != null) {
            this.cxG.setActivityRef(activity);
        }
    }
}
