package com.baidu.swan.apps.jsbridge.a;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.swan.apps.jsbridge.a dfC;
    private com.baidu.swan.apps.jsbridge.a dfD;
    private SwanAppUtilsJavaScriptInterface dfE;
    private com.baidu.swan.apps.api.a dfF;

    public void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            this.dfF = new com.baidu.swan.apps.api.a(context, callbackHandler, aVar);
            a(aVar, context, callbackHandler, unitedSchemeMainDispatcher, this.dfF);
            if (aVar instanceof com.baidu.swan.games.f.b) {
                a(aVar, context, this.dfF);
            } else {
                e(aVar);
            }
        }
    }

    public void a(Context context, com.baidu.swan.apps.core.container.a aVar) {
        this.dfE = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.dfE.setSource("swan_");
        aVar.addJavascriptInterface(this.dfE, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.dfE.setForceShareLight(true);
    }

    private void a(com.baidu.swan.apps.core.container.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.dfC = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.dfC, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.dfD = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        aVar.addJavascriptInterface(this.dfD, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    private void e(com.baidu.swan.apps.core.container.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    private void a(@NonNull com.baidu.swan.apps.core.container.a aVar, Context context, @NonNull com.baidu.swan.apps.api.a aVar2) {
        this.dfE = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.dfE.setSource("swan_");
        aVar.addJavascriptInterface(this.dfE, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.c(aVar);
    }

    public void y(Activity activity) {
        if (this.dfC != null) {
            this.dfC.setActivityRef(activity);
        }
        if (this.dfD != null) {
            this.dfD.setActivityRef(activity);
        }
        if (this.dfE != null) {
            this.dfE.setActivity(activity);
        }
        if (this.dfF != null) {
            this.dfF.setActivityRef(activity);
        }
    }
}
